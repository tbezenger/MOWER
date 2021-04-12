# MOWER

## Execute project : 
`mvn exec:java -Dexec.args="path/to/file.txt"`

or package with 
`mvn clean package spring-boot:repackage`
then execute with
`java -jar mower-1.0-SNAPSHOT.jar path/to/file.txt`