package org.eclipse.stem.adapters.file;

import java.io.IOException;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.stem.core.common.Identifiable;



public class FileAdapter extends AdapterImpl implements File {

	public XMIResource getResource() {
		// Override
		return null;
	}

	public void delete() throws IOException {
		// override
	}

	public void rename(String newname) throws IOException {
		// override
	}

	public Identifiable getIdentifiable() {
		// override
		return null;
	}
	
}
