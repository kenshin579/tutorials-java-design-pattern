set classpath=.;mysql-connector-java-5.1.14-bin.jar
javac *.java
rmic ClientImpl
copy ClientImpl_Stub.class ..\server