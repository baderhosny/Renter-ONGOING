import java.util.*;
import java.io.*;

public class Main
{
	public static House house;		//objects for classes
	public static Room room;	
	
	public static void readFromFile(ArrayList<House> houseList)		// reading from a file passing in the houseList
	{
		try
		{
			Scanner houseFile = new Scanner(new File("Houses.csv"));
			Scanner roomFile = new Scanner(new File("Rooms.csv"));
			ArrayList<Room> roomList = new ArrayList<Room>();
			houseFile.nextLine();
			while(houseFile.hasNextLine())
			{
				String line = houseFile.nextLine();
				String [] args = line.split(",");		// parsing out the commas, delimters
				houseList.add(new House(args[0],Float.parseFloat(args[1])));
			}
			int nextID = Integer.parseInt(roomFile.nextLine());	// the number of the room so it does not reset as it will keep going so if we made 20 rooms and we closed the program then it wont reset it will keep going 21, 22, 23
			Room.setNextID(nextID);
			roomFile.nextLine();			// i skip the nextLine and read everything else
			while(roomFile.hasNextLine())
			{
				String line = roomFile.nextLine();
				String [] args = line.split(",");
				roomList.add(new Room(args[0], Integer.parseInt(args[1]),args[2],Float.parseFloat(args[3]),Boolean.parseBoolean(args[4])));
			}
			for(Room r:roomList)		// going through all the rooms in roomList
			{
				String targetAddress = r.houseID();		// matching the room with the correct houseID and adding it
				for(House h:houseList)
				{
					if(targetAddress.equals(h.getAddress()))
					{
						h.addRoom(r);
					}
				}
			}
			houseFile.close();		// closing both files that i read from
			roomFile.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
	}

	public static void writeToFile(ArrayList<House> houseList)		// writing to files
	{
		try
		{
			PrintWriter houseFile = new PrintWriter("Houses.csv");
			PrintWriter roomFile = new PrintWriter("Rooms.csv");
			
			houseFile.println("houseID,Cost");
			roomFile.println(Room.getNextID());
			roomFile.println("houseID,roomID,type,price,isRented");
			for(House h: houseList)			// going through the arrayList of houses
			{
				houseFile.println(h.commaFormat());		// formatting it first one is address, second is cost
				for(Room r: h.getRooms())
				{
					roomFile.println(r.commaFormat());
				}
			}
			houseFile.close();		// closing the writing files after im done writing to it
			roomFile.close();			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}	
	}
	public static void main(String[] args)
	{	
		
		Scanner input= new Scanner(System.in);
		
		ArrayList<House> houseList = new ArrayList<House>();

		readFromFile(houseList);			// reading from files!


		System.out.println("/////////// WELCOME ////////////");		// my Main menu
		System.out.println("PLEASE CHOOSE AN OPTION! ");
		System.out.println("(1) Show Full Report : ");
		System.out.println("(2) Make a new house! ");
		System.out.println("(3) Select a house! ");
		String option = input.next();

		if(option.equals("1"))		// if else statements if they choose a number it will do what it says!
		{
			for(House h: houseList)
			{
				h.getReport();
			}
		}
		else if(option.equals("2"))
		{	
			System.out.println("Please Enter the address of the house");
			String address = input.next();
			address += input.nextLine();
			
			System.out.println("Please enter how much you pay for rent for the house!\n");
			float rc = input.nextFloat();
			
			System.out.println("How many rooms in your rented house?\n");
			int numberOfRooms = input.nextInt();		// rms is number of rooms in a house!
			ArrayList<Room> rooms = new ArrayList<Room>();
			for(int i = 0; i<numberOfRooms;i++)		// it will go through the same number of rooms the user inputted
			{		
				System.out.println("how much is room " + (i+1) +"?");
				float price = input.nextFloat();	
				System.out.println("is it Rented? Y/N?");		// if it is rented then it will add the profit, if not it will not add the money
				String choice = input.next();

				boolean isRented;
				if(choice.equals("Y")||choice.equals("y"))
				{
					isRented = true;
				}
				else if (choice.equals("N")||choice.equals("n"))
				{
					isRented = false;
				}
				else
				{
					System.out.println("Invalid output, assuming room is vacant...");
					isRented = false;
				} 


				rooms.add(new Room(address,price,isRented));
			}// end for loop
			House house= new House(address,rc,rooms);
			houseList.add(house);  // make a house instance with how many rooms the user inputted
			System.out.println(" Thank you for adding this new house!");		
			System.out.println("Current house status is !");
			System.out.println(address + "costs " + house.getCost() + " and is making " + " " + house.getProfit() + " $ " ); 	
		}
		else if(option.equals("3"))
		{	
			House currentHouse = null;
			System.out.println("Select a house! ");
			for(int i = 0; i < houseList.size(); i++)		// will output all houses available and will let you choose a house and will output how muc you making for the house you selected
			{
				System.out.println( i + ". " + houseList.get(i).getAddress());
				
			}
			int houseIndex = input.nextInt();
			currentHouse = houseList.get(houseIndex);

			currentHouse.getReport();
		}
		else
		{
			System.out.println("Invalid input");
		}
		writeToFile(houseList);
	}		
}

