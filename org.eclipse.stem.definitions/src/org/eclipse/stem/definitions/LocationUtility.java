package org.eclipse.stem.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.definitions.labels.CommonBorderRelationshipLabelValue;
import org.eclipse.stem.definitions.labels.PhysicalRelationshipLabel;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabel;
import org.eclipse.stem.definitions.labels.RelativePhysicalRelationshipLabelValue;


/**
 * Utility to extract node keys from a project
 */
public class LocationUtility {

	static Map<String, Set<String>> [] treeISOKeyMaps = new Map[4];
	static Map<String, URI> isoKeyURIMap = new HashMap<String, URI>();
	static List<Model> processedModels = new ArrayList<Model>();
	
	static boolean loaded = false;
	
	public static void reset() {treeISOKeyMaps = new Map[4];isoKeyURIMap.clear();processedModels.clear();loaded=false;}

	public static Set<String> getKeys(IProject project, int level, String parent) {
		
		if(!loaded) {
			for(int i=0;i<4;++i) treeISOKeyMaps[i] = new HashMap<String, Set<String>>();
			IContainer modelFolder = project.getFolder("models");
			
			IResource[] models = null;
			try {
				models = modelFolder.members();
			} catch(Exception e) {
				e.printStackTrace();
			}
			for(IResource r:models) {
				// ignore system files
				if(r.getName().startsWith(".")) continue;
				
				try {
					URI uri = URI.createURI(r.getLocationURI().toString());
					Identifiable id = Utility.getIdentifiable(uri);
					if(id instanceof Model) processModel((Model)id);
						
				} catch(Exception e) {
					// Skip bad file
				}
		
			}	
		
			IContainer graphsFolder = project.getFolder("graphs");
			IResource[] graphs = null;
			try {
				graphs = graphsFolder.members();
			} catch(Exception e) {
				e.printStackTrace();
			}
			for(IResource r:graphs) {
				// ignore system files
				if(r.getName().startsWith(".")) continue;
				
				try {
					URI uri = URI.createURI(r.getLocationURI().toString());
					Identifiable id = Utility.getIdentifiable(uri);
					if(id instanceof Graph) processGraph((Graph)id);
						
				} catch(Exception e) {
					// Skip bad file
				}
		
			}	
			loaded = true;
		}
		
		Set<String>result = null;
		
		if(parent != null) result = treeISOKeyMaps[level-1].get(parent);
		else result = treeISOKeyMaps[level].keySet();
		if(result!= null) 
			return result;
		return new HashSet<String>(); // return empty array
	}
	
	private static void processModel(Model m) {
		processedModels.add(m);
		// First get sub models
		for(Model m2:m.getModels()) 
			if(!processedModels.contains(m2)) processModel(m2);
	
		// To the graphs in the model
		EList<Graph>graphs = m.getGraphs();
		for(Graph g:graphs) 
			processGraph(g);
	}
	
	private static void processGraph(Graph g) {
		// Do the edges first to get the hierarchy
		
		for(Edge e:g.getEdges().values()) {
			if(e.getLabel().getCurrentValue() instanceof RelativePhysicalRelationshipLabelValue) {
				
				int sourceLevel = Utility.keyLevel(e.getNodeAURI().lastSegment());
				int targetLevel = Utility.keyLevel(e.getNodeBURI().lastSegment());
				String sourceKey = e.getNodeAURI().lastSegment();
				String targetKey = e.getNodeBURI().lastSegment();
				
				if(treeISOKeyMaps[sourceLevel].containsKey(sourceKey))
					treeISOKeyMaps[sourceLevel].get(sourceKey).add(targetKey);
				else {
					SortedSet<String>nl = new TreeSet<String>();
					treeISOKeyMaps[sourceLevel].put(sourceKey, nl);
					nl.add(targetKey);
				}
 					
				if(!treeISOKeyMaps[targetLevel].containsKey(targetKey)) {
					// Add with empty child set
					TreeSet<String>nl = new TreeSet<String>();
					treeISOKeyMaps[targetLevel].put(targetKey, nl);
				}
				
				isoKeyURIMap.put(sourceKey, e.getNodeAURI());
				isoKeyURIMap.put(targetKey, e.getNodeBURI());
					
			}
		}
		
		// Now find dangling nodes
		EMap<URI, Node> map = g.getNodes();
		for(URI u:map.keySet()) {
			int l = Utility.keyLevel(u.lastSegment());
			if(l == -1) continue; // no world
			String key = u.lastSegment();
			if(!treeISOKeyMaps[l].containsKey(key)) {
				TreeSet<String>nl = new TreeSet<String>();
				treeISOKeyMaps[l].put(key, nl);
				isoKeyURIMap.put(key, u);
			}			
		}
	}
	
	
	/**
	 * Place the edges from the graph in a Map keyed by the URI of the edge.
	 * This avoids duplicates in case same graph exists in multiple models 
	 * @param project
	 * @return
	 */
	public static Set<Edge> getCommonBorderEdges(IProject project, URI location) {
	    Map<String,Edge> cbEdges = new HashMap<String,Edge>();
	
		IContainer modelFolder = project.getFolder("models");	
		IResource[] models = null;
		try {
			models = modelFolder.members();
		} catch(Exception e) {
			e.printStackTrace();
		}
		for(IResource r:models) {
			// ignore system files
			if(r.getName().startsWith(".")) continue;
			
			try {
				URI uri = URI.createURI(r.getLocationURI().toString());
				Identifiable id = Utility.getIdentifiable(uri);
				Graph g = ((Model)id).getCanonicalGraph(STEMURI.createURI(""), null, null);
				if(id instanceof Model) cbEdges.putAll(getGraphCommonBorderEdges(g, location));
					
			} catch(Exception e) {
				// Skip bad file
			}
	
		}	
	
		// Only do the edges in the graphs folder if the user hasn't specified a
		// location, since we need to resolve the URI's to support locations
		if(location == null || location.toString().trim().equals("")) {
			IContainer graphsFolder = project.getFolder("graphs");
			IResource[] graphs = null;
			try {
				graphs = graphsFolder.members();
			} catch(Exception e) {
				e.printStackTrace();
			}
			for(IResource r:graphs) {
				// ignore system files
				if(r.getName().startsWith(".")) continue;
				
				try {
					URI uri = URI.createURI(r.getLocationURI().toString());
					Identifiable id = Utility.getIdentifiable(uri);
					if(id instanceof Graph) cbEdges.putAll(getGraphCommonBorderEdges((Graph)id, location));
						
				} catch(Exception e) {
					// Skip bad file
				}
		
			}	
		}
		Set<Edge> retVal = new HashSet<Edge>();
		retVal.addAll(cbEdges.values());
		return retVal;
	}
	
	/***
	 * Place the edges from the graph in a Map keyed by the URI of the edge.
	 * This avoids duplicates in case same graph exists in multiple models
	 * @param g
	 */
	private static Map<String,Edge> getGraphCommonBorderEdges(Graph g, URI location) {
		
		Map<String,Edge> cbEdges = new HashMap<String,Edge>();
		for(Edge e:g.getEdges().values()) {
			if(e.getLabel().getCurrentValue() instanceof CommonBorderRelationshipLabelValue) {
				String uriKey = e.getURI().lastSegment();
				if(location != null && !location.toString().trim().equals("")  
						&& isSelfOrChild(e.getA(), location.lastSegment()) && isSelfOrChild(e.getB(), location.lastSegment()))
					cbEdges.put(uriKey,e);
				else if(location == null || location.toString().trim().equals(""))
					cbEdges.put(uriKey,e);
			}	
		}
		return cbEdges;
	}//getGraphCommonBorderEdges
	
	public static URI getURIFromISOKey(String key) {
		return isoKeyURIMap.get(key);
	}
	
	protected static boolean isSelfOrChild(Node  n, String parent) {
		if(n.getURI().lastSegment().equals(parent)) return true;
		return hasParent(n, parent);
	}
	
	protected static boolean hasParent(Node n, String key) {
		for(Edge e:n.getEdges()) {
			// Make sure it's a physical containment edge
			boolean phys = e.getLabel() instanceof RelativePhysicalRelationshipLabel;
			if(!phys) 
				continue;
			if(e.getA().getURI().lastSegment().equals(key)) return true;
			else if(Utility.keyLevel(e.getA().getURI().lastSegment()) < Utility.keyLevel(n.getURI().lastSegment()))
				return hasParent(e.getA(), key);
		}
		return false;
	}
	
}
