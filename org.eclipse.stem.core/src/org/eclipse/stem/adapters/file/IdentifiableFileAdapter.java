package org.eclipse.stem.adapters.file;

import java.io.IOException;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.stem.core.common.Identifiable;

public class IdentifiableFileAdapter extends FileAdapter {

	@Override
	public XMIResource getResource() {
		Identifiable target = (Identifiable)this.getTarget();
		
		XMIResourceImpl xmi = (XMIResourceImpl)target.eResource();
		
		return xmi;
	}
	
	@Override
	public void delete() throws IOException {
		XMIResource r = this.getResource();
		r.delete(null);
		
	}

	@Override
	public void rename(String newname) throws IOException {
		// override
	}
	
	@Override
	public Identifiable getIdentifiable() {
		return (Identifiable)getTarget();
	}
}
