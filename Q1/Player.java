public class Player{
	private String playername; //Defining all the needed variables crucial for the main application.
	private String playerID;
	private String team;
	private String teamID;
	private String scored;
	private String stadiumName;
	private String stadiumTown;
	private String stadiumStreet;
	private String stadiumPostcode;
	public Player(String inPlayerF, String inPlayerID, String inTeam, String inTeamID, String inScored, String stadiumInName, String stadiumInTown, String stadiumInStreet, String stadiumInPostcode){
		playername = inPlayerF;
		playerID = inPlayerID;
		team = inTeam ;
		teamID = inTeamID;
		scored = inScored ;
		stadiumName = stadiumInName;
		stadiumTown = stadiumInTown;
		stadiumStreet = stadiumInStreet;
		stadiumPostcode = stadiumInPostcode; //Main method.
	}
	public String getName(){
		return playername; //Getter for the player's name
	}
	public String getplayerID(){
		return playerID; //Getter for the player's ID
	}
	public String getTeam(){
		return team; //Getter for the player's Team
	}
	public String getTeamID(){
		return teamID;	//Getter for the player's TeamID
	}
	public String getScored(){
		return scored; //Getter for the player's score
	}
	public String getStadiumName2(){
		return stadiumName; //Getter for the stadium name.
	}
	public String getStadiumTown2(){
		return stadiumTown; //Getter for the stadium town
	}
	public String getStadiumStreet2(){
		return stadiumStreet; //Getter for the stadium street
	}
	public String getStadiumPostcode2(){
		return stadiumPostcode; //Getter for the stadium postcode
	}
	public String getStadiumName(){
		return stadiumName.toLowerCase(); //Getter for the stadium name in lower case, so it can be implemented in the main application
	}
	public String getStadiumTown(){
		return stadiumTown.toLowerCase();//Getter for the stadium town in lower case, so it can be implemented in the main application
	}
	public String getStadiumStreet(){
		return stadiumStreet.toLowerCase(); //Getter for the stadium street in lower case, so it can be implemented in the main application
	}
	public String getStadiumPostcode(){
		return stadiumPostcode.toLowerCase(); //Getter for the stadium postcode in lower case, so it can be implemented in the main application
	}
	public String toString(){
		String returning = playername + ","  + playerID + "," + team + "," + teamID + "," + scored + "," + stadiumName + "," + stadiumTown + "," + stadiumStreet + "," + stadiumPostcode;
		return returning; //The format all the players are being saved in the file.
	}

}		