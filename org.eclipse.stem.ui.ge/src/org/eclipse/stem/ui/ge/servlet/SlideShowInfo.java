package org.eclipse.stem.ui.ge.servlet;
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
import java.io.File;
import java.util.Date;

/**
 * Class to hold information required by a 
 * SlideShowServlet session
 *
 */
public class SlideShowInfo {
   
	private String _key = "Key";
	
	private int _counter = 0;
	
	/**
	 * built in delay on requests
	 */
	private long _delay = 2000;
	
	private File[] _files = null;
	
	private boolean _waitForKML = false;
	
	private String _folderName = "";
	
	private boolean pause = false;
	
	private String[] insert = null;
	
	private String   _fileName = null;
	
	private String   _BBOX = null;
	/**
	 * use for cleanup - future
	 */
	private long timeLastUsed = 0;
	/**
	 * create an instance with the values pulled from URL
	 * 
	 * @param key  pseudo session key
	 * @param folder folder name containing KML files
	 * @param wait if true then wait for new KML when 
	 *        no more files in list.
	 * @param file Single file to be repeatably processed
	 * @param delay in seconds between request processing
	 */
	public SlideShowInfo(String key, String folder, boolean wait, 
			             String file, String delay) {
		_key = key;
		_counter = -1;  // so first file will be 0
		_files = null;
		_folderName = folder;
		_waitForKML = wait;
		_fileName = file;
		_delay = Long.parseLong(delay)*1000;
		timeLastUsed = new Date().getTime();
	}

	/**
	 * called to check if it should be expired and deleted
	 * from the map of outstanding entries
	 * 
	 * @return true if session should be expired
	 */
	public boolean isExpired() {
		long now = new Date().getTime();
		long timeToLive = 24*60*60*1000;  // 24 hours
		if ((now-timeLastUsed)>timeToLive) {
			return true;			
		}
		return false;		
	}
	/**
	 * @return the key used to store this info.
	 */
	public String getKey() {
		timeLastUsed = new Date().getTime();
		return _key;
	}
	/**
	 * @return the _counter
	 */
	public int getCounter() {
		
		timeLastUsed = new Date().getTime();
		
		return _counter;
	}
	/**
	 * Do a built in delay if needed
	 */
	public void delay() {
		long now = new Date().getTime();
		if (now < timeLastUsed+_delay) {
			try {
				Thread.sleep(_delay);
			} catch (InterruptedException e) {
				
			}			
		}
		timeLastUsed = new Date().getTime();		
		return ;
	}
	/**
	 * @param _counter the _counter to set
	 */
	public void setCounter(int _counter) {
		this._counter = _counter;
	}

	/**
	 * @return the _files
	 */
	public File[] getFiles() {
		return _files;
	}

	/**
	 * @param _files the _files to set
	 */
	public void setFiles(File[] _files) {
		this._files = _files;
	}

	/**
	 * @return the _folderName
	 */
	public String getFolderName() {
		return _folderName;
	}

	/**
	 * @param name the _folderName to set
	 */
	public void setFolderName(String name) {
		_folderName = name;
	}

	/**
	 * @return the _waitForKML
	 */
	public boolean isWaitForKML() {
		return _waitForKML;
	}

	/**
	 * @param forKML the _waitForKML to set
	 */
	public void setWaitForKML(boolean forKML) {
		_waitForKML = forKML;
	}

	/**
	 * @return the pause
	 */
	public boolean isPause() {
		return pause;
	}

	/**
	 * @param pause the pause to set
	 */
	public void setPause(boolean pause) {
		this.pause = pause;
	}

	/**
	 * @return the insert
	 */
	public String[] getInsert() {
		return insert;
	}

	/**
	 * @param insert the insert to set
	 */
	public void setInsert(String[] insert) {
		this.insert = insert;
	}

	/**
	 * @return the _fileName
	 */
	public String getFileName() {
		return _fileName;
	}

	/**
	 * @param name the _fileName to set
	 */
	public void setFileName(String name) {
		_fileName = name;
	}

	/**
	 * @return the _BBOX
	 */
	public String getBBOX() {
		return _BBOX;
	}

	/**
	 * @param bbox the _BBOX to set
	 */
	public void setBBOX(String bbox) {
		_BBOX = bbox;
	}
}
