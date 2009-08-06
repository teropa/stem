#!/bin/bash

# root of build tree
BUILD_ROOT=$(cd $(dirname $0); pwd)

BUILD=`date -u +I%Y%m%d`
sed -i -e s/QUALIFIER=.*/QUALIFIER=$BUILD/ local.sh

source $BUILD_ROOT/local.sh

echo Qualifier = $QUALIFIER

BUILD_HOME=$BUILD_ROOT/build

JAVA_VM_ARGS="-Xms1024M -Xmx1024M"

rm -r -f $BUILD_HOME
mkdir -p $BUILD_HOME/maps
cp $BUILD_ROOT/maps/stem.map $BUILD_HOME/maps/


# Feature build
#$JAVA_HOME/bin/java \
# -Xmx256m \
# -jar $ECLIPSE_HOME/plugins/org.eclipse.equinox.launcher_*.jar \
# -application org.eclipse.ant.core.antRunner \
# -buildfile $ECLIPSE_HOME/plugins/org.eclipse.pde.build_*/scripts/build.xml \
# -Dbase=$BUILD_ROOT \
# -DbaseLocation=$ECLIPSE_HOME \
# -Dbuilder=$BUILD_ROOT/config \
# -DforceContextQualifier=$QUALIFIER \
# -DmajorVersion=$MAJOR_VERSION \
# $*
 
# Product build
$JAVA_HOME/bin/java \
 $JAVA_VM_ARGS \
 -jar $ECLIPSE_HOME/plugins/org.eclipse.equinox.launcher_*.jar \
 -application org.eclipse.ant.core.antRunner \
 -buildfile $ECLIPSE_HOME/plugins/org.eclipse.pde.build_*/scripts/productBuild/productBuild.xml \
 -DtoPublish=$TO_PUBLISH \
 -Dusername=$ECLIPSE_DEVELOPER_USERNAME \
 -Dpassword=$ECLIPSE_DEVELOPER_PASSWORD \
 -DcheckoutDir=$BUILD_ROOT/checkout_dir \
 -Dbase=$BUILD_ROOT \
 -DbaseLocation=$ECLIPSE_HOME \
 -Dbuilder=$BUILD_ROOT/config \
 -DforceContextQualifier=$QUALIFIER \
 -DmajorVersion=$MAJOR_VERSION \
 $*


