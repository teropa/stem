This project serves as the repository for the release engineering components of the STEM project.  

The folders "3.3" and "3.4" contain the scripts and configuration files needed to build STEM for the 
Eclipse 3.3 and 3.4 platforms, respectively.  The folder "maps" contains the configuration files that
map the id's of the plugins and features to their repository locations.  This indirection allows the
exact repository version of a plugin to be altered without changing the rest of the build process.

The files that define the build process are in the "3.3/config" and "3.4/config" folders.  The files
in these two folders only differ slightly in the details that are different between versions 3.3 and 3.4
of Eclipse.  

	allElements.xml		This has to do with "feature" builds.
	build.bat			This is the script file that runs the build process.
	build.properties	Specification of the build process, such as the platforms to build on, the
						version number encoded in the build.
	customTargets.xml	The main top-level set of ant targets that are processed during the build.  This
							is modified to incorporate specific processing steps.  In the case of STEM,
							this includes:
								"postsetup" 		modified for internal.data
								"postgenerate" 	modified to include internal.data
								"postprocess" 	modified to run the ant scripts for internal.data and ge.view

The "resources" folder contains files that are useful for the entire project.

	codecleanupconfiguration.xml contains the specification of "source code cleanup"
	

Creating a Build
----------------
To start a build, run the "build.bat" file in either the "3.3/config" or "3.4/config" file.  This only
works on the windows platform.  In the future a "build.sh" file will likely be provided for builds on
unix/linux.  When creating a build for distribution the build.bat file needs to be edited to update two
variables that specify the version and qualifier.  The two lines in question are:

	set MAJOR_VERSION=0.2.2

	set QUALIFIER=I20080118-1200
	
The QUALIFIER variable specifies the date and time of the build, in the example above, January 18, 2008, at 1200.  
Likely the MAJOR_VERSION number would not change as frequently as the QUALIFIER.

Adding a new version of Eclipse
-------------------------------

When you install a new version of Eclipse, you need to also install the "eclipse RCP delta pack" for 
all platforms.  You'll find this distributed on the download page for the version of Eclipse.  For instance,
for Eclipse 3.4M4, the download page is at:

http://download.eclipse.org/eclipse/downloads/drops/S-3.4M4-200712131700/index.php

and the delta pack is named: eclipse-RCP-3.4M4-delta-pack.zip and is found listed under the "RCP SDK" 
section of the page.

The delta pack zip file contains a single top-level folder called "eclipse".  This folder is a "match"
for the top-level folder of the Eclipse installation.  To incorporate the contents of the delta pack,
the file is unzipped "over" the install folder.  Make sure that the you're not running Eclipse from
the installation you are overwriting.
 

 

