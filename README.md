# scala-spring-maven-boilerplate
barebones boilerplate for Scala springboot application with maven build, firebase integration included 
(see releases for more info)

1. download the project
2. go to firebase.google.com, create a project, go to db section, get your firebase credentials json
3. replace the contents in src/resources/firebasecred.json
4. set your firebase url in FirebaseDb file in method setDatabaseUrl()
5. run the project. 

*Result:* a server should be started and data entered to your firebase db.
