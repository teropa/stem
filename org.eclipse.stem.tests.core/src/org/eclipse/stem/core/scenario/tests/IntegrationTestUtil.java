package org.eclipse.stem.core.scenario.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

/**
 * TestUtil
 * @author jhkauf
 *
 */
public class IntegrationTestUtil {
	
	
	protected static final String RUNTIME_WORKSPACE_PATH =  Platform.getLocation().toOSString();
	protected final static String REFERENCE_DIR = "./resources/"; //$NON-NLS-1$
	protected final static String sep = File.separator;
	
	
	/**
	 * This will create targetLocation if it does not already exist
	 * @param sourceDirectory source directory
	 * @param targetDirectory destination directory
	 * @throws IOException
	 * @throws CoreException 
	 */
    public static void copyDirectoryRecursive(File sourceDirectory , File targetDirectory)
    throws IOException, CoreException {
    	
        if (sourceDirectory.isDirectory()) {
            if (!targetDirectory.exists()) {
                targetDirectory.mkdir();
            }
            
            String[] children = sourceDirectory.list();
            for (int i=0; i<children.length; i++) {
                copyDirectoryRecursive(new File(sourceDirectory, children[i]),
                        new File(targetDirectory, children[i]));
            }
        } else {
            
            InputStream inputStream = new FileInputStream(sourceDirectory);
            OutputStream outputStream = new FileOutputStream(targetDirectory);
            
            // Copy the bits from instream to outstream
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            inputStream.close();
            outputStream.close();
        }
      
    }//copyDirectory
    
    
    /**
     * 
     * @param sourceDirectory
     * @param targetDirectory
     * @throws IOException
     * @throws CoreException
     */
    public static void importProject(File sourceDirectory , File targetDirectory)  throws IOException, CoreException {
    	 
        if(targetDirectory.exists()) return; // already exists
    	if (sourceDirectory.isDirectory()) {
          copyDirectoryRecursive(sourceDirectory, targetDirectory);
        } 
        
        // done copying. Now create the Eclipse OSGi Project   
        String pathSTR = targetDirectory.getAbsolutePath()+"/.project";//$NON-NLS-1$
        IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(new Path(pathSTR));
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
        project.create(description, null);
        project.open(null);
     }//copyDirectory
    
    /**
     * @param projectDirectory
     * @throws IOException
     * @throws CoreException
     */
    public static void refreshProject(File projectDirectory)  throws IOException, CoreException {
    	 // refresh the project
        String pathSTR = projectDirectory.getAbsolutePath()+"/.project";//$NON-NLS-1$
        IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(new Path(pathSTR));
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
        project.refreshLocal(IResource.DEPTH_INFINITE, null);
     }//copyDirectory
    
    /**
     * 
     * @param targetDirectory
     * @throws CoreException 
     * 
     */
    public static boolean removeDirectory(File targetDirectory) throws CoreException  {
    	
    	String pathSTR = targetDirectory.getAbsolutePath()+"/.project"; //$NON-NLS-1$
        IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(new Path(pathSTR));
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
    	project.delete(true, true, null);
    	if(targetDirectory.exists()) {
    		return targetDirectory.delete();
    	}
    	return true;
    }
    
    

}// TestUtil
