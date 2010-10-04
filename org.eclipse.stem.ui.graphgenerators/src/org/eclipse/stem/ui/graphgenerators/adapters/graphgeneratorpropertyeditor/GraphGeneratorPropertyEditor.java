package org.eclipse.stem.ui.graphgenerators.adapters.graphgeneratorpropertyeditor;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.definitions.lattice.impl.LatticeGeneratorUtilityImpl;
import org.eclipse.stem.graphgenerators.GraphGenerator;
import org.eclipse.stem.graphgenerators.GraphgeneratorsPackage;
import org.eclipse.stem.graphgenerators.LatticeGraphGenerator;
import org.eclipse.stem.graphgenerators.MigrationEdgeGraphGenerator;
import org.eclipse.stem.graphgenerators.PajekNetGraphGenerator;
import org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator;
import org.eclipse.stem.graphgenerators.SquareLatticeGraphGenerator;
import org.eclipse.stem.ui.graphgenerators.wizards.Messages;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class GraphGeneratorPropertyEditor extends org.eclipse.stem.ui.editors.GenericPropertyEditor {

	public GraphGeneratorPropertyEditor(Composite parent, int style, IProject project) {
		super(parent,style, project);
	}

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 * @param projectValidator
	 */
	public GraphGeneratorPropertyEditor(final Composite parent, final int style,
			final GraphGenerator graphGenerator,
			final ModifyListener projectValidator, IProject project) {
		super(parent, style, (Identifiable)graphGenerator, projectValidator, project);
	} // GraphGeneratorPropertyEditor



	/**
	 * @param graphGenerator
	 *            the {@link GraphGenerator} instance to populate.
	 */
	public Graph getGraph(final GraphGenerator graphGenerator) {
		for (final Map.Entry<EStructuralFeature, Text> entry : map.entrySet()) {
			if(entry.getKey().getEContainingClass().getClassifierID() == GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR ||
					entry.getKey().getEContainingClass().getClassifierID() == GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR) {
				switch (entry.getKey().getFeatureID()) {
					case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE:
						((SquareLatticeGraphGenerator)graphGenerator).setXSize(Integer.parseInt(entry.getValue().getText()));
						break;
					case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE:
						((SquareLatticeGraphGenerator)graphGenerator).setYSize(Integer.parseInt(entry.getValue().getText()));
						break;
					case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__AREA:
						((SquareLatticeGraphGenerator)graphGenerator).setArea(Double.parseDouble(entry.getValue().getText()));
						break;
				}
			} else if(entry.getKey().getEContainingClass().getClassifierID() == GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR) {
				switch (entry.getKey().getFeatureID()) {
					case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__ANGULAR_STEP:
						((PlateCarreeGlobeGraphGenerator)graphGenerator).setAngularStep(Integer.parseInt(entry.getValue().getText()));
						break;	
					case GraphgeneratorsPackage.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__RADIUS:
						((PlateCarreeGlobeGraphGenerator)graphGenerator).setRadius(Double.parseDouble(entry.getValue().getText()));
						break;	
					case GraphgeneratorsPackage.SQUARE_LATTICE_GRAPH_GENERATOR__AREA:
						((SquareLatticeGraphGenerator)graphGenerator).setArea(Double.parseDouble(entry.getValue().getText()));
						break;
				} // switch
			} else if(entry.getKey().getEContainingClass().getClassifierID() == GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR) {
				switch (entry.getKey().getFeatureID()) {
					case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__LOCATION:
						String loc = entry.getValue().getText();
						if(loc != null && !loc.trim().equals(""))
							((MigrationEdgeGraphGenerator)graphGenerator).setLocation(STEMURI.createURI(loc));
						break;
					case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__MIGRATION_RATE:
							((MigrationEdgeGraphGenerator)graphGenerator).setMigrationRate(Double.parseDouble(entry.getValue().getText()));
						break;
					case GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION:
						String pop = entry.getValue().getText();
						if(pop != null && !pop.trim().equals(""))
							((MigrationEdgeGraphGenerator)graphGenerator).setPopulation(pop);
						break;
						
				} // switch
			} else if(entry.getKey().getEContainingClass().getClassifierID() == GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR) {
				switch (entry.getKey().getFeatureID()) {
					case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET:
						String filename = entry.getValue().getText();
						if (filename != null && filename.trim().length() > 0) {
							((PajekNetGraphGenerator)graphGenerator).setDataFile_net(filename);
						}
						break;					
					case GraphgeneratorsPackage.PAJEK_NET_GRAPH_GENERATOR__AREA:
						((PajekNetGraphGenerator)graphGenerator).setArea(Double.parseDouble(entry.getValue().getText()));
						break;
				} // switch
			}
		}

		for (final Map.Entry<EStructuralFeature, Boolean> entry : booleanMap.entrySet()) {

			switch (entry.getKey().getFeatureID()) {
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEAREST_NEIGHBORS:
				((LatticeGraphGenerator)graphGenerator).setUseNearestNeighbors(entry.getValue().booleanValue());
				break;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__USE_NEXT_NEAREST_NEIGHBORS:
				((LatticeGraphGenerator)graphGenerator).setUseNextNearestNeighbors(entry.getValue().booleanValue());
				break;
			case GraphgeneratorsPackage.LATTICE_GRAPH_GENERATOR__PERIODIC_BOUNDARIES:
				((LatticeGraphGenerator)graphGenerator).setPeriodicBoundaries(entry.getValue().booleanValue());
				break;
			}
		}
 
	 if(graphGenerator.eClass().getClassifierID() == GraphgeneratorsPackage.MIGRATION_EDGE_GRAPH_GENERATOR) 
		 ((MigrationEdgeGraphGenerator)graphGenerator).setProject(project);
		// Do it!
		return graphGenerator.getGraph();
	} // populate

	/**
	 * @return <code>true</code> if the contents are valid, <code>false</code>
	 *         otherwise.
	 */
	@Override
	public boolean validate() {
		boolean retValue = true;
		if (retValue) {
			// Yes
			final Text text = map
					.get(GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = Messages
							.getString("NGGWizErr1"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidIntValue(text.getText(), 1);
					if (!retValue) {
						// No
						errorMessage = Messages
								.getString("NGGWizErr2"); //$NON-NLS-1$
					} // if
				}
			} // if text != null
		} // if Transmission Rate

		if (retValue) {
			// Yes
			final Text text = map
					.get(GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = Messages
							.getString("NGGWizErr3"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidIntValue(text.getText(), 1);
					if (!retValue) {
						// No
						errorMessage = Messages
								.getString("NGGWizErr4"); //$NON-NLS-1$
					} // if
				}
			} // if text != null
		} // 
		
		if (retValue) {
			// Yes
			final Text text = map
					.get(GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__AREA);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = Messages
							.getString("NGGWizErr8"); //$NON-NLS-1$
				} // if
				else {
					// No
					// Is it a valid value?
					retValue = isValidValue(text.getText(), 0);
					if (!retValue) {
						// No
						errorMessage = Messages
								.getString("NGGWizErr9"); //$NON-NLS-1$
					} // if
				}
			} // if text != null
		} // if Non-Linearity Coefficient


		if (retValue) {
			// Yes
			Text text = map
					.get(GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__XSIZE);
			if(text != null) {
				int xsize = Integer.parseInt(text.getText());
				text = map.get(GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__YSIZE);
				int ysize = Integer.parseInt(text.getText());
				text = map.get(GraphgeneratorsPackage.Literals.SQUARE_LATTICE_GRAPH_GENERATOR__AREA);
				double area = Double.parseDouble(text.getText());
				
				double scale = Math.sqrt(area);
				if(xsize * scale / LatticeGeneratorUtilityImpl.KM_PER_DEG_LON > 360.0 ||
					ysize * scale / LatticeGeneratorUtilityImpl.KM_PER_DEG_LAT > 180.0) {
					retValue = false;
					// Yes
					errorMessage = Messages
						.getString("NGGWizErr10"); //$NON-NLS-1$
				}
			}
		}
		if(retValue) {
			final Text text = map.get(GraphgeneratorsPackage.Literals.MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = Messages
						.getString("NGGWizErr5"); //$NON-NLS-1$
				} // if
			}
		}
		
		
		if(retValue) {
			final Text text = map.get(GraphgeneratorsPackage.Literals.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__ANGULAR_STEP);
			// Is it a valid value?
			if(text!=null) {
				retValue = isValidIntValue(text.getText(), 1);
				if (!retValue) {
					// No
					errorMessage = Messages
							.getString("NGGWizErr11"); //$NON-NLS-1$
				} // if
			}
		}
		if(retValue) {
			final Text text = map.get(GraphgeneratorsPackage.Literals.PLATE_CARREE_GLOBE_GRAPH_GENERATOR__RADIUS);
			// Is it a valid value?
			if(text!=null) {
				retValue = isValidDoubleValue(text.getText(), 1);
				if (!retValue) {
					// No
					errorMessage = Messages
							.getString("NGGWizErr12"); //$NON-NLS-1$
				} // if
			}
		}
		
		if(retValue) {
			final Text text = map.get(GraphgeneratorsPackage.Literals.MIGRATION_EDGE_GRAPH_GENERATOR__POPULATION);
			if (text != null) {
				// Yes
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = Messages
						.getString("NGGWizErr5"); //$NON-NLS-1$
				} // if
			}
		}
		if(retValue) {
			final Text text = map.get(GraphgeneratorsPackage.Literals.MIGRATION_EDGE_GRAPH_GENERATOR__MIGRATION_RATE);
			if (text != null) {
				// Yes
				try {
					double rate = Double.parseDouble(text.getText());
					if(rate < 0.0) {
						retValue = false;
						errorMessage = Messages
						.getString("NGGWizErr7");
					}
				} catch(Exception e) {
					retValue = false;
					errorMessage = Messages
					.getString("NGGWizErr6");
				}
				retValue = !text.getText().equals(""); //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					// Yes
					errorMessage = Messages
						.getString("NGGWizErr5"); //$NON-NLS-1$
				} // if
			}
		}
		if (retValue) {
			final Text text = map.get(GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__DATA_FILE_NET);
			if (text != null) {
				// Yes
		        File file = new File(text.getText());
		        retValue = file != null && !file.isDirectory() && file.exists();	
		        if (!retValue) errorMessage = Messages.getString("NGGWizErr13");
			}
		}
		if (retValue) {
			final Text text = map.get(GraphgeneratorsPackage.Literals.PAJEK_NET_GRAPH_GENERATOR__AREA);
			if (text != null) {
				retValue = text.getText().length() > 0; //$NON-NLS-1$
				// nothing?
				if (!retValue) {
					errorMessage = Messages.getString("NGGWizErr14"); //$NON-NLS-1$
				} // if
				else {
					try {
						double rate = Double.parseDouble(text.getText());
						if(rate < 0.0) {
							retValue = false;
							errorMessage = Messages.getString("NGGWizErr9");
						}
					} catch(Exception e) {
						retValue = false;
						errorMessage = Messages.getString("NGGWizErr9");
					}
				}
			}
		}
		return retValue;
	} // validate


	/**
	 * @param feature
	 * @return <code>true</code> if the feature is a dublin core feature that
	 *         is specified by a user.
	 */
	@Override
	protected boolean isUserSpecifiedProperty(final EStructuralFeature feature) {
		boolean retValue = false;
		final EClass containingClass = feature.getEContainingClass();
		if (containingClass.equals(GraphgeneratorsPackage.eINSTANCE.getGraphGenerator())
				|| containingClass.getEAllSuperTypes().contains(
						GraphgeneratorsPackage.eINSTANCE.getGraphGenerator())) {
			// Yes
			retValue = true;
		} // 
		return retValue;
	} // isUserSpecifiedGraphGeneratorProperty
	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents sub-classing of SWT components
	}

} // GraphGeneratorPropertyEditor
