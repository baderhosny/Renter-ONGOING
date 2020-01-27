import java.util.*;
import java.io.*;

public class House
{
	private String address;
	private float cost;		// cost of the house rent
	//the array list of rooms
	ArrayList<Room> rooms;		// making an empty room ArrayList
	public House()
	{
		this.cost = 5000f;		// default value for a constructer	
		this.rooms = new ArrayList<Room>();
		this.address = "Default Address";
	}
	public House(String address,float cost,ArrayList<Room> rooms)
	{
		this.cost = cost;
		this.rooms = rooms;
		this.address = address;
	}
	public House(String address,float cost)
	{
		this.address = address;
		this.cost = cost;
		this.rooms = new ArrayList<Room>();
	}
	public void getReport()		// prints out the report for all the houses
	{
		System.out.println(" House " + this.address + " cost " + getCost() +  " and is making " + getProfit());
	}
	public float getProfit()	// prints out the profit of a house, also if a room was rented or not!
	{
		float total = 0f;
		for( Room r: rooms)
		{	
			if(r.isRented)
			{
				total += r.getPrice();
			}	
		}
		return total - this.cost;
	}
	public void addRoom(Room r)	// method to add a room to a house
	{
		rooms.add(r);	 
	}
	public String commaFormat()		// formats used in file IO
	{
		return String.format("%s,%.2f",this.address,this.cost);
	}
	public ArrayList<Room> getRooms()		// returns the rooms
	{
		return rooms;
	}
	public String getAddress()		// returns the address of the house
	{
		return address;
	}
	public float getCost()		// returns the cost of the house
	{
		return cost;
	}
}
