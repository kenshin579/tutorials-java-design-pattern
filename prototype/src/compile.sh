#!/bin/bash
# 작업이 필요함...
set classpath=.;mysql-connector-java-5.1.14-bin.jar
javac *.java
rmic ProtypeMaker
copy ProtypeMaker_Stub.class ..\client
start rmiregistry
java Server
