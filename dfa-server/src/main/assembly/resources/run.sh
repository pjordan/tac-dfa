#!/bin/bash
#
# Usage
#   sh ./runServer.sh
#

TACSERVER_HOME=`pwd`
LIB=${TACSERVER_HOME}/lib
CLASSPATH=.
for i in $( ls ${LIB}/*.jar ); do
    CLASSPATH=${CLASSPATH}:$i
done


java -cp $CLASSPATH se.sics.tasim.sim.Main