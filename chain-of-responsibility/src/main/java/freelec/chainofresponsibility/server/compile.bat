set classpath=.;mysql-connector-java-5.1.14-bin.jar
javac *.java
rmic MarketImpl
copy MarketImpl_Stub.class ..\client