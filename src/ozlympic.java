import  java.util.*;

public class ozlympic {

	public static ArrayList<officials> offs = new ArrayList();	//this array store all the officials details
	public static ArrayList<swimmers> swims = new ArrayList();	//this array store all the swimmers details
	public static ArrayList<cyclists> cycs = new ArrayList();	//this array store all the cyclists details
	public static ArrayList<sprinters> sprints = new ArrayList();	//this array store all the runner details
	public static ArrayList<superAthletes> supers = new ArrayList();	//this array store all the superathletes details
	

	public static void main (String args[]){
		//call methods to add hard coded data to related arrays
		addSwimmers();
		addSprinters();
		addCyclists();
		addSuperAthletes();
		addOfficials();
		
		driver.menu();	//call the menu class in order to do operations
				
	}

	public static void addSwimmers(){	//hard coded swimmer details here
		swims.add(new swimmers("swim001","Matt Abood", "19", "VIC", 0));
		swims.add(new swimmers("swim002","Jessica Ashwood", "25", "NSW", 0));
		swims.add(new swimmers("swim003","Bronte Barratt", "18", "TAS", 0));
		swims.add(new swimmers("swim004","Josh Beaver", "22", "SA", 0));
		swims.add(new swimmers("swim005","Georgia Bohl", "30", "QLD", 0));
		swims.add(new swimmers("swim006","Bronte Campbell", "34", "NT", 0));
		swims.add(new swimmers("swim007","Cate Campbell", "26", "ACT", 0));
		swims.add(new swimmers("swim008","Kyle Chalmers", "25", "VIC", 0));
		swims.add(new swimmers("swim009","Tamsin Cook", "23", "NSW", 0));
		swims.add(new swimmers("swim010","Alicia Coutts", "20", "TAS", 0));
		swims.add(new swimmers("swim011","Brittany Elmslie", "18", "VIC", 0));
		swims.add(new swimmers("swim012","Blair Evans", "29", "NT", 0));
		swims.add(new swimmers("swim013","Thomas Fraser-Holmes", "20", "TAS", 0));
		swims.add(new swimmers("swim014","Madeline Groves", "18", "VIC", 0));
		swims.add(new swimmers("swim015","Chelsea Lea Gubecka", "29", "NT", 0));
		swims.add(new swimmers("swim016","Jacob Hansford", "20", "TAS", 0));
		swims.add(new swimmers("swim017","Belinda Hocking", "18", "VIC", 0));
		swims.add(new swimmers("swim018","Mack Horton", "29", "NT", 0));
	}
	
	public static void addSprinters(){	//hard coded runner details here
		sprints.add(new sprinters("run001","David Andersen", "22", "NSW", 0));
		sprints.add(new sprinters("run002","Cameron Bairstow", "21", "NT", 0));
		sprints.add(new sprinters("run003","Aron Baynes", "25", "NT", 0));
		sprints.add(new sprinters("run004","Andrew Bogut", "24", "SA", 0));
		sprints.add(new sprinters("run005","Ryan Broekhoff", "22", "SA", 0));
		sprints.add(new sprinters("run006","Natalie Burton", "29", "VIC", 0));
		sprints.add(new sprinters("run007","Elizabeth Cambage", "24", "VIC", 0));
		sprints.add(new sprinters("run008","Matthew Dellavedova", "19", "TAS", 0));
		sprints.add(new sprinters("run009","Katie Rae Ebzery", "27", "TAS", 0));
		sprints.add(new sprinters("run010","Cayla George", "50", "ACT", 0));
		sprints.add(new sprinters("run011","Chris Goulding", "35", "ACT", 0));
		sprints.add(new sprinters("run012","Laura Hodges", "30", "QLD", 0));
		sprints.add(new sprinters("run013","Mathew Helm", "21", "ACT", 0));
		sprints.add(new sprinters("run014","Rebecca Manuel", "18", "ACT", 0));
		sprints.add(new sprinters("run015","Chantelle Newbery", "23", "QLD", 0));
		sprints.add(new sprinters("run016","Robert Newbery", "26", "ACT", 0));
		sprints.add(new sprinters("run017","Dean Pullar", "30", "ACT", 0));
		sprints.add(new sprinters("run018","Loudy Wiggins", "23", "QLD", 0));
	}
	
	public static void addCyclists(){	//hard coded cyclists details here
		cycs.add(new cyclists("cyc001","Ashlee Ankudinoff", "22", "NSW", 0));
		cycs.add(new cyclists("cyc002","Georgia Baker", "21", "NT", 0));
		cycs.add(new cyclists("cyc003","Jack Bobridge", "25", "NT", 0));
		cycs.add(new cyclists("cyc004","Scott Bowden", "24", "SA", 0));
		cycs.add(new cyclists("cyc005","Caroline Buchanan", "22", "SA", 0));
		cycs.add(new cyclists("cyc006","Simon Clarke", "29", "VIC", 0));
		cycs.add(new cyclists("cyc007","Patrick Constable", "24", "VIC", 0));
		cycs.add(new cyclists("cyc008","Amy Cure", "19", "TAS", 0));
		cycs.add(new cyclists("cyc009","Anthony Dean", "27", "TAS", 0));
		cycs.add(new cyclists("cyc010","Rohan Dennis", "50", "ACT", 0));
		cycs.add(new cyclists("cyc011","Alex Edmondson", "35", "ACT", 0));
		cycs.add(new cyclists("cyc012","Annette Edmondson", "30", "QLD", 0));
		cycs.add(new cyclists("cyc013","Lauren Reynolds", "50", "ACT", 0));
		cycs.add(new cyclists("cyc014","Callum Scotson", "35", "ACT", 0));
		cycs.add(new cyclists("cyc015","Amanda Spratt", "23", "QLD", 0));
		cycs.add(new cyclists("cyc016","Bodi Turner", "34", "ACT", 0));
		cycs.add(new cyclists("cyc017","Sam Welsford", "35", "ACT", 0));
		cycs.add(new cyclists("cyc018","Sam Willoughby", "29", "QLD", 0));
	}
	
	public static void addSuperAthletes(){	//hard coded super athletes details here
		supers.add(new superAthletes("super001","Nicole Hackett", "22", "NSW", 0));
		supers.add(new superAthletes("super002","Loretta Harrop", "21", "NT", 0));
		supers.add(new superAthletes("super003","Michellie Jones", "35", "NT", 0));
		supers.add(new superAthletes("super004","Peter Robertson", "44", "SA", 0));
		supers.add(new superAthletes("super005","Miles Stewart", "31", "SA", 0));
		supers.add(new superAthletes("super006","Craig Walton", "39", "VIC", 0));
		supers.add(new superAthletes("super007","John Millman", "24", "VIC", 0));
		supers.add(new superAthletes("super008","John Peers", "19", "TAS", 0));
		supers.add(new superAthletes("super009","Anastasia Rodionova", "37", "TAS", 0));
		supers.add(new superAthletes("super010","Arina Rodionova", "20", "ACT", 0));
		supers.add(new superAthletes("super011","Sam Stosur", "55", "ACT", 0));
		supers.add(new superAthletes("super012","Jordan Thompson", "70", "QLD", 0));
	}
	
	public static void addOfficials(){	//hard code officials details here
		offs.add(new officials("staff001", "Daniel Lewis", "18", "VIC"));
		offs.add(new officials("staff002", "Shelley Watts", "25", "QLD"));
		offs.add(new officials("staff003", "Jason Whateley", "23", "VIC"));
	}
}
