package org.eclipse.stem.ui.ge.views;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/ 

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.jobs.simulation.SimulationManager;
import org.eclipse.stem.ui.ge.Activator;
import org.eclipse.stem.ui.ge.GEInterface;
import org.eclipse.stem.ui.ge.GELog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;


/**
 * The class <code>GEViewTest</code> contains tests 
 * for the class   GEView.
 *
 * This will make a very hilevel test of the GEView class.
 * It will invoke the viewer and verify that it starts and 
 * will initially get nothing to list in the ListViewer.
 * 
 * Some of this was copied from the book 
 * Eclipse Building commercial quality plug-ins"
 * 
 * @pattern JUnit Test Case
 * 
 * Invoke this as a JUnit Plugin Test
 */
public class GEViewTest extends TestCase
{
	
	/** 
	 * must match the id in the GEView class
	 */
   private static final String VIEW_ID = 
	   Constants.ID_ROOT+".ui.views.ge";//$NON-NLS-1$ 
      

   /**
    * The object that is being tested.
    *
    * 
    */
   private GEView geView;

   /**
   /**
    * Construct new test instance.
    *
    * @param name the test name
    */
   public GEViewTest(String name) {
      super(name);
   }


   /**
    * Perform pre-test initialization.
    *
    * @throws Exception
    *
    * @see TestCase#setUp()
    */
   @Override
protected void setUp() throws Exception {
     super.setUp();
     GELog.DEBUG = true;
     try {
      // Initialize the test fixture for each test 
      // that is run.
      waitForJobs();
      geView = (GEView) 
         PlatformUI
            .getWorkbench()
            .getActiveWorkbenchWindow()
            .getActivePage()
            .showView(VIEW_ID);

      // Delay for 3 seconds so that 
      // the GE view can be seen.
      waitForJobs();
      delay(3000);
   } catch (RuntimeException e) {
	   Activator.logError("Unable to run GEViewTest in this environment", e);//$NON-NLS-1$ 
	}
      // Add additional setup code here.
   }

   /**
    * Perform post-test cleanup.
    *
    * @throws Exception
    *
    * @see TestCase#tearDown()
    */
   @Override
protected void tearDown() throws Exception {
      super.tearDown();
      // Dispose of test fixture.
      try {
		waitForJobs();
		  
		  PlatformUI
		     .getWorkbench()
		     .getActiveWorkbenchWindow()
		     .getActivePage()
		     .hideView(geView);
		  // Add additional teardown code here.
	} catch (RuntimeException e) {
		  Activator.logError("Unable to run GEViewTest in this environment", e);//$NON-NLS-1$ 
	}
   }

   
   
   /**
    * Run the view test.
    */
   public void testView() {
	  if (geView == null) 
		  return;
	  
	  GEInterface gei = new GEInterface(geView);
      ListViewer viewer = geView.getViewer();
      GEViewContentProvider contentProvider = new GEViewContentProvider(gei); 
		viewer.setContentProvider(contentProvider);
		//viewer.setLabelProvider(new GEViewLabelProvider());
		// define the instance that will be the parent 
		// passed to the getElements method
		viewer.setInput(SimulationManager.getManager());
		Object[] expectedContent = 
	         new Object[] { };
		
		Object[] actualContent = contentProvider.getElements(viewer.getInput());
		assertEquals(expectedContent,actualContent); 
		
   }

   /**
    * Process UI input but do not return for the 
    * specified time interval.
    * 
    * @param waitTimeMillis the number of milliseconds 
    */
   private void delay(long waitTimeMillis) {
      Display display = Display.getCurrent();
      
      // If this is the UI thread, 
      // then process input.
      if (display != null) {
         long endTimeMillis = 
            System.currentTimeMillis() + waitTimeMillis;
         while (System.currentTimeMillis() < endTimeMillis)
         {
            if (!display.readAndDispatch())
               display.sleep();
         }
         display.update();
      }
      
      // Otherwise, perform a simple sleep.
      else {
         try {
            Thread.sleep(waitTimeMillis);
         }
         catch (InterruptedException e) {
            // Ignored.
         }
      }
   }

   /**
    * Wait until all background tasks are complete.
    */
   public void waitForJobs() {
      while (Job.getJobManager().currentJob() != null)
         delay(10*1000);
   }

   /**
    * Assert that the two arrays are equal.
    * Throw an AssertionException if they are not.
    * 
    * @param expected first array
    * @param actual second array
    */
   private void assertEquals(Object[] expected, Object[] actual) {
      if (expected == null) {
         if (actual == null)
            return;
         throw new AssertionFailedError(
            "expected is null, but actual is not");  //$NON-NLS-1$  
      }
      
      //else {
         if (actual == null)
            throw new AssertionFailedError(
               "actual is null, but expected is not");//$NON-NLS-1$ 
      //}
      assertEquals(
         "expected.length "//$NON-NLS-1$ 
            + expected.length
            + ", but actual.length "//$NON-NLS-1$ 
            + actual.length,
         expected.length,
         actual.length);
      for (int i = 0; i < actual.length; i++)
         assertEquals(
            "expected[" + i + //$NON-NLS-1$ 
               "] is not equal to actual[" + //$NON-NLS-1$ 
               i + "]",//$NON-NLS-1$ 
            expected[i],
            actual[i]);
   }
}  // GEViewTest
