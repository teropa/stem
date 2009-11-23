package org.eclipse.stem.core.tests;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.FileWriter;
import java.io.IOException;

public class TestLogPerformance {
	public static void main(String [] args) {
		try {
			TestLogPerformance test = new TestLogPerformance();
			test.test1();
			test.test2();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void test1()  throws IOException{
		// Create 100 files and write 
		// 4 columns, 10000 rows to each file
		
		FileWriter [] fileWriters = new FileWriter[200];
		
		long now = System.currentTimeMillis();
	
		for(int ind = 0;ind<fileWriters.length;++ind) {
			fileWriters[ind] = this.createFile("c:\\perftest\\test1_"+(ind)+".csv");
		}
		
		String data = "COL1,COL2,COL3,COL4";
		for(int i=0;i<10000;++i) {
			for(int ind = 0;ind<fileWriters.length;++ind) {
				fileWriters[ind].append(data);
				fileWriters[ind].append("\n");
				if(i % 50 == 0) fileWriters[ind].flush();
			}
		}
		for(FileWriter fw: fileWriters) {
			fw.flush();
			fw.close();
		}
		long then = System.currentTimeMillis();
		System.out.println("Test 1: "+(then - now));
	}
	
	private void test2() throws IOException {
		// Create 4 files and write 
		// 100 columns, 10000 rows to each file
		
		FileWriter [] fileWriters = new FileWriter[4];
		String data = "";
		for(int col=0;col<200;++col) data = data+"COL"+col+",";
		long now = System.currentTimeMillis();
	
		for(int ind = 0;ind<fileWriters.length;++ind) {
			fileWriters[ind] = this.createFile("c:\\perftest\\test2_"+(ind)+".csv");
		}
		
		
		for(int i=0;i<10000;++i) {
			for(int ind = 0;ind<fileWriters.length;++ind) {
				fileWriters[ind].append(data);
				fileWriters[ind].append("\n");
				if(i % 50 == 0) fileWriters[ind].flush();
			}
		}
		for(FileWriter fw: fileWriters) {
			fw.flush();
			fw.close();
		}
		long then = System.currentTimeMillis();
		System.out.println("Test 2: "+(then - now));
	}
	
	private FileWriter createFile(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		return fw;
	}
}
