set classpath=.;mysql-connector-java-5.1.14-bin.jar
javac *.java
rmic StockImpl
copy StockImpl_Stub.class ..\freelec.noobserver.client
start rmiregistry
start java JulyThread
start java StockServer

