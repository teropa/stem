/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.definitions.lattice.impl.SqrLatticeGeneratorImpl;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Square Lattice Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SquareLatticeGraphGeneratorImpl extends LatticeGraphGeneratorImpl implements SquareLatticeGraphGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SquareLatticeGraphGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR;
	}
	
	/**
	 * 
	 */
	@Override
	public Graph getGraph() {
		SqrLatticeGeneratorImpl slgi = new SqrLatticeGeneratorImpl();
		Graph g = slgi.getGraph(this.getXSize(), this.getYSize(), this.isUseNearestNeighbors(), this.isUseNextNearestNeighbors(), this.isPeriodicBoundaries());
		
//		System.out.println("graph built ..now save it");
		
//		String graphUriString = "platform:/resource/play/graphs/sqrLatticeGraph.graph";
//		g.setURI(URI.createURI(graphUriString));
//		URI outputURI = URI.createFileURI("/Users/jhkauf/Documents/runtime-stemMacOS.product/play/graphs/sqrLatticeGraph.graph");
		
//		try {
//			Utility.serializeIdentifiable(g, outputURI);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	
		return g;
		

	}
} //SquareLatticeGraphGeneratorImpl
