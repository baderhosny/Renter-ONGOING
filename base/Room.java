// Room.java
// HouseID is address of the house!
import java.util.*;
import java.io.*;

public class Room

{
	protected String houseID;
	protected float price;
	protected static int nextID = 0;
	protected int id;
	protected String type;
	boolean isRented;
	
	public Room()		//my default constructer
	{
		id = nextID++ ;
		type = "room";
		price = 1500f;
		isRented = true;
		houseID = "";
	}

	public Room(String houseID, float price, boolean isRented)		//constructer passing in houseID, price and if it isRented
	{
		this.price  = price;
		this.isRented = isRented;
		this.id = nextID++;
		this.type = "t";
		this.houseID = houseID;
	}
	public Room(String houseID,int id,String type,float price, boolean isRented)
	{
		this.id = id;
		this.type = type;
		this.price = price;
		this.isRented = isRented;
		this.houseID = houseID;
	}
	public static void setNextID(int id)			// keeps the rooms in nextID, so when we run our program back that number wont reset so it keeps going
	{
		nextID = id;
	}
	public static int getNextID()		// gets the nextID of rooms
	{
		return nextID;
	}	
	public float getPrice()			// return the price of the room
	{
		return price;
	}
	public boolean getisRented()		// return if rented or not "true or false"
	{
		return isRented;
	}
	public String houseID()			// returns the houseID
	{
		return houseID;			// IT IS THE HOUSE ADDRESS DONT FORGET!!
	}
	public String commaFormat()
	{
		return String.format("%s,%d,%s,%.2f,%b",this.houseID,this.id,this.type,this.price,this.isRented);
	}
	
}		
