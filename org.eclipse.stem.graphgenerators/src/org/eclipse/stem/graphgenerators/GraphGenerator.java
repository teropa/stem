package org.eclipse.stem.graphgenerators;

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;

/**

* This interface is an EMF Model.

*

* @model

*/
public interface GraphGenerator extends Identifiable {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Graph getGraph();

}
