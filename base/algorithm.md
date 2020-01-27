/////////////////// FINAL PROJECT ///////////////////////
for my final project i will be making a program that will be let you add houses that you rent, and then rent these rooms to make profit, it is easy to remember if you only had 2-3 houses, but lets say you have 
around 20 houses that you manage and around 70 rooms, then it will hard to keep track of how much money you making ( or maybe losing ), i have chose to do this program as my brother does a similar thing to this
so i was inspired to make a program based of a real life issue that some people have!

i started out with making my UML , now my program UML is pretty straight forward as it only needed houses and rooms
a i made house class, and a room class, but the house HAS rooms, so it uses it, for my private/protected classes, i needed an arrayList of rooms, the cost, and the address of the house!, for my public classes, i had a default constructer, multiple construcer passing in address, and cost, i need a method to getProfit() for the house, a method to add rooms inside the house, and a method to getCost() for me to use to output statements

	Room.java

for my room class, i needed the price of the room, the houseID of that room, as each room will belong to a house, multiple rooms belong to a house, i also implemented a nextID method where i will list all the rooms of ALL the houses, as if i wanted to add more rooms it will just go up by one, and the number wont reset, as if it did then it will override some of the old rooms( and we dont want that) , i also know that not all the rooms will be rented, so i made a boolean isRented, for my public i had a get and setNextID ( to keep count of all rooms ) a getPrice() method, and getisRented() method, but i also needed a houseID method as rooms belong to a house

	Main.java
for my main.java this is where the fun part starts, i will have to make a menu for my user to use,i will let him  see options
to add a house, to view all the houses, or to just pick one house and see how it is doing!, that will just be a bunch of System.out.printkln statements and basic if else statements, probably one of the harder parts of my main menu was the file IO, even though we already did it once or twice, but it is still a fairly new concept for me, not just that i will be reading from 2 csv files and writing to 2 csv files. the first csv file is "Houses.csv" which includes my houseID and the price, for the "Rooms.csv" includes houseID( to keep track of which rooms belong to a house), roomID, type,price of the room, and if it is rented or not
now reading part was not so hard, but i had to keep in mind that my nextID for the rooms will have to keep counting up and never reset, so i have printed the total number of the rooms uptop of the file( i had to save it somewhere) so i have made my reading method to skip the first 2 lines, the first one being the room numbers, the second one being the titles ( so if a someone wanted to see what these number mean, it will display up top).
