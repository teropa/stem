package org.eclipse.stem.adapters.file;

import java.io.IOException;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.stem.core.common.Identifiable;


public interface File  {

	public XMIResource getResource();
	
	public Identifiable getIdentifiable();
	
	public void delete() throws IOException;
	
	public void rename(String newname) throws IOException;
	
}
