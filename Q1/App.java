import java.util.Scanner;
import java.io.*;
import java.util.*;
public class App{
	public static void main( String[] args ){
	Vector<Player> players = new Vector<Player>(); //main vector used to store and load the data that is read from the file
	Vector<String> playerdetails = new Vector<String>();//vector used to add players into the file + adding the entries inside of the main vector
	Vector<Player> temp_vector = new Vector<Player>();//temporary vector used to display a certain entries of the loaded players.
	if (args.length != 1)
		{ // the program expects to have a file as an argument, if you dont have one it would create it by just giving a name as an argument of a text format file.
		System.err.println("One argument is expected that is the text file, if you dont have one - just type the name of the file as an argument and the program will create it for you");
		System.exit(1);
		}
	else{
	do // main menu loop
	{System.out.println("1 to add a new player into the file. "); 
	System.out.println("2 to load the players inside of the file and add them to the existing record of players");
	System.out.println("3 to display players in a specific team "); 
	System.out.println("4 to delete a specific player");
	System.out.println("5 to display a subset of players");
	System.out.println("6 to find stadium details "); 
	System.out.println("7 to save the updated list;");
	System.out.println("8 to quit "); 
	Scanner str = new Scanner(System.in);
	if(str.hasNextInt()){
	Integer choice = str.nextInt();
    switch(choice){
            case 1: // adding players into the text file
                Scanner myObj2 = new Scanner(System.in);
				System.out.println("Enter player's name: \t e.g. John Davids (Forename)+(Surrname) seperated by a spacebar"); 
				String name = myObj2.nextLine();
				if(name.matches("[a-zA-Z]+[\\s][a-zA-Z]+$")){name = name; playerdetails.add(name);}//Adds it into one of the vectors taking the name of the player, checking if it matches the regex. 																				
				else{System.out.println("Invalid name"); break;} 	
				System.out.println("Enter player's id: \t e.g. RFU23232 - RFU followed by 5 integers"); 
				String id = myObj2.nextLine();
				if(id.matches("[R][F][U][0-9]{5}$")){id = id; playerdetails.add(id);} //Adds it into one of the vectors taking the id of the player, checking if it matches the regex. 
				else{System.out.println("Invalid id"); break;}
				System.out.println("Enter player's team: \t e.g. Cardiff Blues"); 
				String team = myObj2.nextLine();
				if(team.matches("[\\s]*[a-zA-Z]+[\\s]*+[a-zA-Z\\s]*$")){team = team; playerdetails.add(team);} //Adds it into one of the vectors taking the Team of the player, checking if it matches the regex. 
				else{System.out.println("Invalid team name."); break;}
				System.out.println("Enter player's team id: \t e.g. CFB2424 - 3 Capital letters followed by 4 integers."); 
				String teamid = myObj2.nextLine();
				if(teamid.matches("[A-Z]{3}[0-9]{4}$")){teamid = teamid;playerdetails.add(teamid);} //Adds it into one of the vectors taking the TeamID of the player, checking if it matches the regex. 
				else{System.out.println("Invalid team id."); break;}
				System.out.println("How many tries did he score: \t e.g. 44 - just an integer"); 
				String score = myObj2.nextLine();
				if(score.matches("[0-9]+$")){score = score;playerdetails.add(score);} //Adds it into one of the vectors taking the score of the player, checking if it matches the regex. 
				else{System.out.println("Invalid input for tries."); break;}
				System.out.println("Enter player's stadium name: \t e.g. Principality "); 
				String stadiumname = myObj2.nextLine();
				if(stadiumname.matches("[\\s]*[a-zA-Z]+[\\s]*+[a-zA-Z\\s]*$")){stadiumname = stadiumname; playerdetails.add(stadiumname);} //Adds it into one of the vectors taking the stadium name, checking if it matches the regex. 
				else{System.out.println("Invalid name for a stadium name."); break;}
				System.out.println("Enter player's stadium town: \t e.g. Cardiff"); 
				String stadiumtown = myObj2.nextLine();
				if(stadiumtown.matches("[\\s]*[a-zA-Z]+[\\s]*+[a-zA-Z\\s]*$")){stadiumtown = stadiumtown; playerdetails.add(stadiumtown);}//Adds it into one of the vectors taking stadium town, checking if it matches the regex. 
				else{System.out.println("Invalid name for a stadium's town location. "); break;}
				System.out.println("Enter player's stadium street: \t e.g. Whatever street name you like"); 
				String stadiumstreet = myObj2.nextLine();
				if(stadiumstreet.matches("[a-zA-Z0-9\\s]+$")){stadiumstreet = stadiumstreet; playerdetails.add(stadiumstreet);}//Adds it into one of the vectors taking the stadium street, checking if it matches the regex. 
				else{System.out.println("Invalid name for a stadium's street."); break;}
				System.out.println("Enter player's stadium postcode: \t e.g. C4GHE - 1 character, followed by 1 integer, followed by 3 characters"); 
				String stadiumpc = myObj2.nextLine();
				if(stadiumpc.matches("[A-Z]{1}[0-9]{1}[A-Z]{3}$")){stadiumpc = stadiumpc; playerdetails.add(stadiumpc);}//Adds it into one of the vectors taking the stadium postcode, checking if it matches the regex. 
				else{System.out.println("Invalid name for a stadium's postcode."); break;}
				Player player = new Player(name, id, team, teamid, score, stadiumname, stadiumtown, stadiumstreet, stadiumpc);
				players.add(player);
				show_players(players);
				try {
		            FileWriter playerIN = new FileWriter(args[0], true); //Tries to add the created player into the text format file
		            PrintWriter out = new PrintWriter(playerIN);
		            out.println(player);
		            out.close();
		        }
		        catch ( Exception e ) {
		            System.out.println( e ); //Otherwise it gives the error, but it has never gone to that point, since in the beggining of the program, it checks for the file.
        		}
                break;

            case 2:
              	System.out.println("The players in the file:"); //Function loading the players from the file given as argument 	       
			        try {FileReader reader = new FileReader(args[0]);
		          		BufferedReader in = new BufferedReader(reader);
		             	String s;
		             	players.clear();
		             	while ( (s = in.readLine()) != null ) {
		               	String readplayers [] = s.split(",");
		               	playerdetails.addAll(Arrays.asList(readplayers));
		               	if (players.contains(playerdetails)){ System.out.println("You have already loaded the file.");} //for every lane it splits it by comas and appends the vector playerdetails, by which then we append the main vector - players.
		               	else{
                  	 	players.add(new Player(playerdetails.get(0), playerdetails.get(1), playerdetails.get(2), playerdetails.get(3), playerdetails.get(4), playerdetails.get(5), playerdetails.get(6), playerdetails.get(7), playerdetails.get(8)));
		         		playerdetails.clear();//clearing the vector as it is used for every line of the file just as a reading point appending the main vector.
		         }
		     }
		         		show_players(players);
		             	in.close();
		       	 		}
		        catch ( FileNotFoundException e ) { 
		            System.out.println("File not found.");
		         }
		        catch ( IOException e ) {  
		            System.out.println( e );
		         }
		         catch ( ArrayIndexOutOfBoundsException e) {
		         	System.out.println("The file is empty."); //catching the main errors given.
		         }
		         break;

            case 3:
            	temp_vector.clear(); //Clearing the temporary vector, since it could have some players inside, nonetheless.
		        System.out.println("Please give the program a team name:"); // Asks the user for a team name that would output the players playing in it 
		        Scanner ss = new Scanner(System.in);
             	String teamIN = ss.nextLine();
             	for (int i=0; i<players.size(); i++) //it iterates over the main vector
				 { 
			 	  if(players.get(i).getTeam().contains(teamIN)) { //checking if the input matches any of the teams that are loaded in the main vector. It is case sensetive, so it matters if its either "Cardiff Blues" or "cardiff blues".
			 	  	temp_vector.add(players.get(i)); //the temporary vector is appended by the players that play in that certain team given by the user
			 	  	show_players(temp_vector); //displaying the players
			 	  	temp_vector.clear(); //clearing the temporary vector, as I would need it later when displaying the players by entries.
			 	  }
				 } 
		         break;
			case 4:
				temp_vector.clear(); //Clearing the temporary vector, since it could have some players inside, nonetheless.
				temp_vector.addAll(players); //Loading all the players into the temporary vector.
				show_players(temp_vector); //Displaying the loaded players.
				System.out.println("Write the index of the player you want to delete: ");
				Scanner in_id = new Scanner(System.in);
				try{
				if (in_id.hasNextInt()) { //Checking if the input is integer
                	Integer choice_deletion = in_id.nextInt(); 
                    temp_vector.remove(choice_deletion - 1); //Deletes the player from the main vector, if changes want to be saved there is a case for that.
                    System.out.println("The updated list of players: ");
                    players.clear(); // Clearing the main vector
                    players.addAll(temp_vector); //Adding all of the players from the temporary vector to the main one.
                    temp_vector.clear(); //Clearing the temporary vector.
                    show_players(players);//Displaying the updated main vector.
                    }
	                break;}
                    catch (IndexOutOfBoundsException e) {
                     	System.out.println("This index doesn't exist, you may have not loaded a file.");} //If the user gives and input that is bigger than the main vector size.
                    break;

			case 5:
				temp_vector.clear();//Clearing the vector, since it could have some players inside, nonetheless.
				System.out.println("Give the program 2 entries: First and last entry, you want to display the players in between. \nTip: 1 per line, otherwise the indexes would not be read. The first entry you are entering is always the starting point: \nIt cannot be a number less than the last entry");
				Scanner first_entry = new Scanner(System.in); // First entry to display players by
				Scanner last_entry = new Scanner(System.in); // Second entry to display players by
				try{
				if (first_entry.hasNextInt() && last_entry.hasNextInt()){ //checking if they are both integers.
					Integer start_index = first_entry.nextInt(); // taking the input for both scanners.
					Integer last_index = last_entry.nextInt();
					if (last_index > players.size() || last_index < start_index) { //checking if the choice of the user is valid, since the main vector cannot be smaller than the last entry that the players are displayed by.
                            System.out.println("Please enter a valid option, you may have not loaded the players from the file.");
                            break;
                        } else {
                            List<Player> entries_list = players.subList(start_index-1, last_index); //A list of players taking a sublist of the mainvector to display. Starting from 0, that's why its -1.
							temp_vector.addAll(entries_list); //Adding the list to the temporary vector
							show_players(temp_vector); //Displaying the temporary vector, since the case can be called multiple times I do need to clear the vector afterwards.
                        	temp_vector.clear(); //Clearing the vector. If we dont clear it, the second time the case is called it would show 2 players with same credentials.
                        }
					}
                    else{
                    	System.out.println("Please enter a first and last entry. Both integers - 1 per line."); //Catching the error if the last entry is bigger than the size of the main vector
                    																							// or the first enrty is bigger than the last one.
                    }
                
				break;}
				catch (IndexOutOfBoundsException e) {
                     	System.out.println("This index doesn't exist, you may have not loaded a file.");} //The index may be out of the bouds for vector, catching the error.
				break;
			case 6:
				temp_vector.clear();
				System.out.println("Write any substring you would wish to search with"); 
				Scanner search_by = new Scanner(System.in); //Taking the substring that would display the stadium details.
             	String subset_search = search_by.nextLine();
             	for (int i=0; i<players.size(); i++) //Iterating over the main vector
				 { 
			 	  if(players.get(i).getStadiumName().contains(subset_search.toLowerCase()) || players.get(i).getStadiumTown().contains(subset_search.toLowerCase()) || players.get(i).getStadiumStreet().contains(subset_search.toLowerCase()) || players.get(i).getStadiumPostcode().contains(subset_search.toLowerCase())) {
			 	  	temp_vector.add(players.get(i)); //If the subset is contained in any of the following fields it would be printed. It is not case sensetive and writing for e.g. "c5GhE" as a postcode would be a valid option.
			 	  	show_players(temp_vector);
			 	  	temp_vector.clear();
			 	  }
				 } 
		         break;
		    case 7:	
		    	try{
		    		FileWriter players_saved = new FileWriter(args[0]);
		            PrintWriter out = new PrintWriter(players_saved); //Saving the main vector into the file given as an argument. Any changes made during the interface and the vector manipulation would alter the text file given.
		            for(Player player_to_save : players){
		            out.println(player_to_save);
		            out.close();}
		            System.out.println("Players saved into the file");
		        }
		        catch( Exception e ){
		        	System.out.println(e);
		        }
		        break;

		    case 8:
		    	 System.exit(0);//Quit function
					
}
 if(choice >=9){System.out.println("Invalid command");} //Checking over the choices of the user in the main menu
}

else{
	System.out.println("Invalid choice."); //Checking if the user has written one of the options as an integer. String are not allowed, the following line would be printed.
}
}
while(true); //The main loop that creates the main menu.
}
}
public static void show_players(Vector<Player> players){
  	for (Player x : players){
	System.out.println("###########################################");
	System.out.println("|" + "Player's Name:" + x.getName());
	System.out.println("|" + "Player's ID:" + x.getplayerID());
	System.out.println("|" + "Team:" + x.getTeam());
	System.out.println("|" + "Team ID:" + x.getTeamID());
	System.out.println("|" + "Scored " + x.getScored());
	System.out.println("|" + "Stadium Name:" + x.getStadiumName2());
	System.out.println("|" + "Stadium Street:" + x.getStadiumStreet2());
	System.out.println("|" + "Stadium Town:" + x.getStadiumTown2());
	System.out.println("|" + "Stadium Postcode:" + x.getStadiumPostcode2());
	System.out.println("###########################################"); //Main function. Getters from Player.java for every of the players in the main vector.
}
}}
//Student number & name.
//C1824840 && Andon Gribachev.