package org.eclipse.stem.ui.ge.views;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.stem.ui.ge.GELog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 *  Let the user enter the info needed to display 
 *  on GoogleEarth the selected Admin area.
 *
 */
public class DisplayAreaDialog extends TitleAreaDialog {

	private Combo country = null;
	private Combo level = null;
	private Text  search = null;
	Button clearButton = null;;
	
	
	boolean rClear = false;
	
	/**
	 * @param parentShell
	 */
	public DisplayAreaDialog(Shell parentShell) {
		super(parentShell);
		
	}
    
	/**
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createContents(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent  parent
	 */	
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setMessage("Enter Admin Area info.");
		setTitle("DisplayArea");
		return contents;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		//composite.setLayout(new GridLayout(6,false));
		Group group1 = new Group(composite,SWT.SHADOW_IN);
		group1.setLayout(new RowLayout(SWT.HORIZONTAL));
		Label countryLabel = new Label(group1,SWT.NONE);
		countryLabel.setText("Country: ");
		country = new Combo(group1,SWT.DROP_DOWN);		
		country.setTextLimit(3);		
		String[] items = new String[] {"USA","CAN","MEX"};
		country.setItems(items);
		
		if (DisplayAreaData.rCountry != null) {
			country.setText(DisplayAreaData.rCountry);
		} else {
			country.select(0);
		}
		Label levelLabel = new Label(group1,SWT.NONE);
		levelLabel.setText("Level: ");
		level = new Combo(group1,SWT.DROP_DOWN+SWT.READ_ONLY);		
		items = new String[] {"0","1","2"};
		level.setTextLimit(1);		
		level.setItems(items);
		
		level.select(Integer.parseInt(DisplayAreaData.rLevel));
		
		Label searchLabel = new Label(composite,SWT.NONE);
		searchLabel.setText("Search text: ");
		search = new Text(composite,SWT.BORDER);
		search.setTextLimit(48);
	
		if (DisplayAreaData.rSearch != null) {
			String searcharg = DisplayAreaData.rSearch;
			if (searcharg.length() <10) 
				searcharg = searcharg+"         ";
			search.setText(searcharg);
		}			
		
		Group group2 = new Group(composite,SWT.SHADOW_IN);
		group2.setLayout(new RowLayout(SWT.HORIZONTAL));
		clearButton = new Button(group2,SWT.CHECK);
		clearButton.setText("Clear Map");
		return composite;
	}
	
	/**
	 * creates Apply, OK and Cancel buttons.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	public void createButtonsForButtonBar(Composite parent) {
		createButton(parent,IDialogConstants.PROCEED_ID,
				"Apply",false);
		createButton(parent,IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL,true);
		createButton(parent,IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL,false);
	}
	
	/**
	 * gets control when user presses Apply, OK or Cancel.
	 * It sets the rc to button id, calls close and returns.
	 * 
	 *  
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 * @param id for the button that was pressed
	 */
	protected void buttonPressed(int id) {
		setReturnCode(id);
		GELog.debug(this,""+id);
		//if ( id != IDialogConstants.PROCEED_ID)
		close();
		return;
	}
	/**
	 * This gets the values from the dialog and saves them 
	 * so that the caller of this dialog can get them later.
	 * 
	 * @return true if close dialog is OK
	 */
	public boolean close() {
		
		DisplayAreaData.rCountry = country.getText();
		DisplayAreaData.rLevel = level.getText();
		DisplayAreaData.rSearch = search.getText();
		rClear = clearButton.getSelection();
		return super.close();
	}
	/**
	 * @return name of file containing GML for area border
	 */
	public String getAdminFile() {
		String rCountry = DisplayAreaData.rCountry;
		GELog.debug(this,rCountry);
		String adminFile =rCountry+"/"+rCountry+"_"+
		   DisplayAreaData.rLevel+"_MAP.xml";
		return  adminFile;
	}
	
	/**
	 * 
	 * @return Search argument
	 */
	public String getSearch() {
		return DisplayAreaData.rSearch;
	}
	/**
	 * @return true if user wants to clear the existing map display
	 */
	public boolean isClear() {
		return rClear;
	}
	/**
	 * Simple class to store the dialogs last used values
	 *
	 */
	public static class DisplayAreaData {
		/** save admin level */
		public static String rLevel = "2";
		/** save country */
		public static String rCountry = "USA";
		/** save search text for admin area */
		public static String rSearch = null;
	}
}
