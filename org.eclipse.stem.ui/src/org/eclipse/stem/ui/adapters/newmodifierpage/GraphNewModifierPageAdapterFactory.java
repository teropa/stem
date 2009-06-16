package org.eclipse.stem.ui.adapters.newmodifierpage;

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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.core.graph.EdgeLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.graph.StaticLabel;
import org.eclipse.stem.core.graph.util.GraphAdapterFactory;
import org.eclipse.stem.data.geography.Activator;
import org.eclipse.stem.ui.wizards.NewModifierPage;

/**
 * This class is an {@link NewModifierPageAdapterFactory} that adapts members of
 * the {@link Graph} model to {@link NewModifierPage}s.
 */
public class GraphNewModifierPageAdapterFactory extends GraphAdapterFactory
		implements NewModifierPageAdapterFactory {

	/**
	 * Default constructor
	 */
	public GraphNewModifierPageAdapterFactory() {
		super();
		NewModifierPageAdapterFactory.INSTANCE.addAdapterFactory(this);
	}

	/**
	 * @see org.eclipse.stem.core.graph.util.GraphAdapterFactory#isFactoryForType(java.lang.Object)
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return type == NewModifierPageAdapter.class
				|| super.isFactoryForType(type);
	}

	/**
	 * @see org.eclipse.stem.definitions.labels.util.LabelsAdapterFactory#createStaticLabelAdapter()
	 */
	@Override
	public Adapter createStaticLabelAdapter() {
		return new StaticLabelNewModifierPageAdapter();
	}

	/**
	 * @see org.eclipse.stem.core.graph.util.GraphAdapterFactory#createEdgeAdapter()
	 */
	@Override
	public Adapter createEdgeAdapter() {
		return new EdgeNewModifierPageAdapter();
	}

	/**
	 * This class is extended by classes that adapt {@link StaticLabel}s to
	 * {@link NewModifierPage}s.
	 */
	static public class StaticLabelNewModifierPageAdapter extends
			NewModifierPageAdapter {

		/**
		 * @see org.eclipse.stem.ui.adapters.newmodifierpage.NewModifierPageAdapter#createNewModifierPage()
		 */
		@Override
		public NewModifierPage createNewModifierPage() {
			return new StaticLabelNewModifierPage((Identifiable) getTarget());
		} // createNewModifierPage

	} // StaticLabelNewModifierPageAdapter

	/**
	 * {@link NewModifierPage} for {@link StaticLabel}s.
	 */
	static public class StaticLabelNewModifierPage extends NewModifierPage {
		/**
		 * @param target
		 */
		public StaticLabelNewModifierPage(Identifiable target) {
			super(target);
		}

		@Override
		protected boolean isUserSpecifiedProperty(
				final EStructuralFeature feature) {
			boolean retValue = super.isUserSpecifiedProperty(feature);
			retValue = retValue
					&& !feature.equals(GraphPackage.Literals.EDGE_LABEL__EDGE);
			retValue = retValue
					&& !feature.equals(GraphPackage.Literals.NODE_LABEL__NODE);
			retValue = retValue
					&& !feature
							.equals(GraphPackage.Literals.LABEL__URI_OF_IDENTIFIABLE_TO_BE_LABELED);

			return retValue;
		} // isUserSpecifiedProperty

	} // StaticLabelNewModifierPage

	/**
	 * This class is extended by classes that adapt {@link Edge}s to
	 * {@link NewModifierPage}s. In reality the {@link Edge} is not adapted,
	 * instead it adapts its label to a
	 * {@link StaticLabelNewModifierPageAdapter} and delegates to the adapter.
	 */
	static public class EdgeNewModifierPageAdapter extends NewModifierPageAdapter {

		StaticLabelNewModifierPageAdapter labelAdapter = null;

		/**
		 * @see org.eclipse.stem.ui.adapters.newmodifierpage.NewModifierPageAdapter
		 *      #createNewModifierPage()
		 */
		@Override
		public NewModifierPage createNewModifierPage() {
			NewModifierPage retValue = null;
			try {
				return getLabelAdapter().createNewModifierPage();
			} catch (NullPointerException npe) {
				Activator.logError("Can't create modifer for \"" + (((Edge) getTarget()).getLabel()).eClass().getName()+ "\"", null);
			}
			return retValue;
		} // createNewModifierPage

		private NewModifierPageAdapter getLabelAdapter() {
			if (labelAdapter == null) {
				final EdgeLabel edgeLabel = ((Edge) getTarget()).getLabel();
				labelAdapter = (StaticLabelNewModifierPageAdapter) NewModifierPageAdapterFactory.INSTANCE
						.adapt(edgeLabel, NewModifierPageAdapter.class);
			}
			return labelAdapter;
		}

	} // EdgeNewModifierPageAdapter
} // GraphNewModifierPageAdapterFactory
