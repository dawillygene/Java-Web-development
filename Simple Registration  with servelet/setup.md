# Clean and compile
rm -rf ./build/classes/*
mkdir -p ./build/classes

javac -d ./build/classes \
      -cp "$CATALINA_HOME/lib/servlet-api.jar:/usr/share/java/mysql-connector-java-9.2.0.jar" \
      src/com/dawilly/*.java

# Deploy to Tomcat
mkdir -p "$CATALINA_HOME/webapps/registration-app/WEB-INF/classes/com/dawilly"
cp -r ./build/classes/* "$CATALINA_HOME/webapps/registration-app/WEB-INF/classes/"
cp -r ./web/* "$CATALINA_HOME/webapps/registration-app/"

# Restart Tomcat (if needed)
"$CATALINA_HOME/bin/shutdown.sh" 2>/dev/null || true
"$CATALINA_HOME/bin/startup.sh"






 java -cp ".:/usr/share/java/mysql-connector-java-9.2.0.jar" TestConnection
  javac -cp "/usr/share/java/mysql-connector-java-9.2.0.jar" TestConnection.java