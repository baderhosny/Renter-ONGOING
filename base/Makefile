Main.class: Main.java House.class Room.class
	javac -g Main.java
House.class: House.java Room.class
	javac -g House.java

Room.class: Room.java
	javac -g Room.java

clean:
	rm *.class

run: Main.jar
	java -jar Main.jar
jar:
	jar cmf manifest.mf Main.jar Main.class House.class House.java Room.class Room.java
