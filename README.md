# MOWER

## Execute project : 
`mvn exec:java -Dexec.args="path/to/file.txt"`

or package with 
`mvn clean package spring-boot:repackage`
then execute with
`java -jar mower-1.0-SNAPSHOT.jar path/to/file.txt`

example file content :

5 5\
1 2 N\
GAGAGAGAA\
3 3 E\
AADAADADDA

first line is the lawn's top right corner coordinates
other lines are a set of mowers initialisations and instructions
