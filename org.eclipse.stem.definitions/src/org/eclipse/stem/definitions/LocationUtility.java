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
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.definitions.labels.PhysicalRelationshipLabel;
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
	
	public static URI getURIFromISOKey(String key) {
		return isoKeyURIMap.get(key);
	}
}
