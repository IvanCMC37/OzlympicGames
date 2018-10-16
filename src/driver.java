import java.util.*;

public class driver {
	
	static int input = 0;	//initialise input name and type
	static boolean error = false;	//in order to keep the menu recalling
	static int totalMatchCount = 0;	//Sum of finished matches
	static int rng1 = 0;	//choose how many athletes from normal athletes
	static int rng2 = 0;	//choose how many athletes from super athletes
	static String userBet ="";	//name of the user bet on
	static boolean newMatch = false;	//setup for preventing user to start match w/o choosing a game
	static int athleteEachMatch = 0;	//how many athlete is particpating the match
	static boolean userWin =  false;	//whether the user win his bet
	static boolean betConfirmed = false;	//whether the user placed the bet
	static int tempInput = 0;	//initialise input name and type for use later on
	static int winnerCount = 0;	//use to show winner position
	static int userbetWinPosition = 0;	//use to store the winnerCount for another operation
	
	public driver(){	
	}
	public static ArrayList<gameRecords> results = new ArrayList();	//list for the finished event with details
	public static ArrayList<Integer> rngNumberList1 =  new ArrayList();	//list for shuffling later
	public static ArrayList<Integer> rngNumberList2 =  new ArrayList();	//list for shuffling later
	public static ArrayList<String> selectAths =  new ArrayList();	//selected athletes for the upcoming match
	public static ArrayList<Integer> tempMatchResult = new ArrayList();	//store the match result, w/o allocation
	public static ArrayList<Integer> tempMatchResultAllocated = new ArrayList();	//store the match result, with allocation
	public static ArrayList<athletes> aths = new ArrayList();	//list for store all the athletes with details
	
	public static void menu(){		
		do{
			try{	
				printMainMenu();
				Scanner console=  new Scanner(System.in);
				input = console.nextInt();
				if (input<1 || input>6){
					System.out.println("Your input is invalid, try again!");
				}
				switch (input){
				case 1:
					case1();
					break;
				case 2:
					case2();
					break;
				case 3:
					case3();
					break;
				case 4:
					case4();
					break;
				case 5:
					case5();
					break;
				case 6:
					error = true;
					System.out.println("See you next time!");
					break;
				}
			} catch (Exception e){
				System.out.println("Invalid input, going back to main menu!  "+e);
			}
		}while (!error);	
	}
	
	public static void printMainMenu(){
		System.out.printf("\nOzlympic Game\n");
		System.out.printf("==========================================\n");
		System.out.printf("1. Select a game to run\n");
		System.out.printf("2. Predict the winner of the game\n");
		System.out.printf("3. Start the game\n");
		System.out.printf("4. Display the final results of all games\n");
		System.out.printf("5. Display the points of all athletes\n");
		System.out.printf("6. Exit\n\n");
		System.out.printf("Your Choice : ");
	}
	
	public static void menuChoice1(){
		System.out.printf("\nSelect a type to run\n");
		System.out.printf("1. Swimming\n");
		System.out.printf("2. Cycling\n");
		System.out.printf("3. Running\n");
		System.out.printf("4. Back to previous menu\n");
		System.out.printf("Your Choice : ");
	}
	
	public static void case1(){	//1. Select a game to run
		menuChoice1();
		tempInput = 0;
		Scanner console =  new Scanner(System.in);
		int input_1 = console.nextInt();
		if (input_1 == 1){	//user selected swimming
			tempInput = 1;
			rngSystem(1);
			gambleSystem();			
		}
		else if (input_1 == 2){	//user selected cycling
			tempInput = 2;
			rngSystem(2);
			gambleSystem();		
		}
		else if (input_1 == 3){	//user selected running
			tempInput = 3;
			rngSystem(3); 
			gambleSystem();			
		}
		else if (input_1 == 4){	//user wants to back to menu	
		}
		else System.out.println("Your input must within the range above, going back to main menu.");
		
	}

	public static void case2(){	//2.Predict the winner of the game
		if(newMatch == true){	//only allowing user to bet after choosing a game
			gambleSystem();
		}
		else{
			System.out.println("You haven't selected a game to run, going back to main menu!");
		}
	}
	
	public static void case3(){	//3.Start the game
		String betYN ="";
		winnerCount = 0;
		if (newMatch == true){	//only allowing user to start match after choosing a game
			if (betConfirmed == false){	//ask if the user want to bet since he didn't when choosing the game
				System.out.println("You Haven't placed your bet, do you wish to start the match anyway?");
				System.out.println("Y/N");
				System.out.println("Your Choice : ");
				Scanner console =  new Scanner(System.in);
				betYN = console.next();
			}
			if (betYN.equals("Y")|| betYN.equals("N")||betConfirmed==true){
				if (betYN.equals("Y")||betConfirmed ==true){	//if user already bet or wanted to start match w/o betting
					assignSystem();
					tempRecordSystem();
					recordWritingSystem();
					officials.winnerAnnouncer();
				}
				else	//user chose not to proceeed
					System.out.println("You chose not to proceed, going back to menu.");
			}
			else //throw exception when user input something wrong
				System.out.println("Input invalid, going back to menu.");
		}
		else
			System.out.println("Please select a game in order to start game, going back to menu.");
	}
	
	public static void case4(){	//4.	Display the final results of all games
		if(totalMatchCount <1 ){	//only usable after finished at least one game 
			System.out.println("Based on record, 0 match was successffully finished");
			System.out.println("Going back to menu\n");
		}
		else{
			System.out.printf("Total " +totalMatchCount+" match(es) found.\n");
			System.out.println(results.toString());
		}
	}
	
	public static void case5(){	//5.	Display the points of all athletes
		aths.clear();
		aths.addAll(ozlympic.swims);	//add all swimmers into full list
		aths.addAll(ozlympic.sprints);	//add all runners into full list
		aths.addAll(ozlympic.supers);	//add all superAthletes into full list
		aths.addAll(ozlympic.cycs);	//add all cyclists into full list
		Collections.sort(aths, new Comparator<athletes>(){	//use defined sorting to sort the full list based score
		     public int compare(athletes o1, athletes o2){
		         if(o1.getScore() == o2.getScore())
		             return 0;
		         return o1.getScore() < o2.getScore() ? -1 : 1;
		     }
		});
		System.out.printf("%-5s"+"%-25s"+"%-6s\n","Rank","Name","Score");
		for (int i=0;i<aths.size() ;i++){	//show all point for all the athletes
			System.out.printf("%-5s"+"%-25s"+"%-3d\n",i+1,aths.get(aths.size()-i-1).getName(),aths.get(aths.size()-i-1).getScore());
		}	
	}
	
	public static void rngSystem(int number){	//rng selecting participator
		newMatch = false;
		Random rand = new Random();	//setup for generating random number later on
		rng1 = rand.nextInt(8);	//generate random number within 0-8
		rng2 = rand.nextInt(8-rng1);	//generate random number 0-(8-rng1), since we only want 8 athletes maximum
		rngNumberList1.clear();
		rngNumberList2.clear();
		selectAths.clear();
		if ((rng1+rng2) >=4){	//only proceed if total participators is >=4
			rngSystem_setup();
			if (number == 1){	//if user selected to run swimming game previously		
				for (int i =0; i<rng1;i++){	//select numbers of normal athlete based on rng1
					selectAths.set(i, ozlympic.swims.get(rngNumberList1.get(i)).getName());	//store the selected athlete name
				}
			}
			else if (number == 2){	//if user selected to run cycling game previously					
				for (int i =0; i<rng1;i++){	//select numbers of normal athlete based on rng1
					selectAths.set(i, ozlympic.cycs.get(rngNumberList1.get(i)).getName());	//store the selected athlete name
				}
			}
			else{	//if user selected to run running game previously					
				for (int i =0; i<rng1;i++){	//select numbers of normal athlete based on rng1
					selectAths.set(i, ozlympic.sprints.get(rngNumberList1.get(i)).getName());	//store the selected athlete name
				}
			}
			for (int i =0; i<rng2;i++){	//select numbers of super athletes based on rng2
				selectAths.set((rng1+i), ozlympic.supers.get(rngNumberList2.get(i)).getName());//store the selected athlete name
			}
			newMatch = true;	//user now can proceed to place bet or start match
			athleteEachMatch = (rng1+rng2);
			rngSystem_print();
					
		}
		else if ((rng1+rng2) <4){	//go back to menu since number of participators not enough to start a game
			System.out.println("Less than 4 participators this time, going back to main menu\n");	
			newMatch = false;
		}	
	}
	
	public static void rngSystem_setup(){	//setup variables to support rngSystem()
		int q =0;
		while (q<8){	//make an array with 8 slots
			selectAths.add("--");
			q++;
		}
		for (int i =0; i<ozlympic.swims.size();i++){//all 3 sports have same size 18
			rngNumberList1.add(i);
		}
		for (int i =0;i<ozlympic.supers.size();i++){//superAthlete have size of 12
			rngNumberList2.add(i);
		}
		Collections.shuffle(rngNumberList1);	//shuffle 0-17
		Collections.shuffle(rngNumberList2);	//shuffle 0-11
	}
	
	public static void rngSystem_print(){
		System.out.println("\nList of participators:");
		for (int i =0; i<(rng1+rng2);i++){//show all the selected athletes	
			System.out.println((i+1)+". "+selectAths.get(i));
		}
//		System.out.println(selectAths);	//show all the selected athletes			
		System.out.println("Match found! You are now going to the gambling system.\n");
	}
	
	public static void assignSystem(){		//store the match details
			if (tempInput ==1){	//user selected to run a swimming game
				results.add(new gameRecords("Swim",totalMatchCount+1, ozlympic.offs.get(0).getName(), null, null, null, null, null, null, null, null, 0,0,0,0,0,0,0,0));
			}
			else if(tempInput ==2){	//user selected to run a cycling game
				results.add(new gameRecords("Cyc",totalMatchCount+1, ozlympic.offs.get(1).getName(), null, null, null, null, null, null, null, null,  0,0,0,0,0,0,0,0));
			}
			else if(tempInput ==3){	//user selected to run a running game
				results.add(new gameRecords("Run",totalMatchCount+1, ozlympic.offs.get(2).getName(), null, null, null, null, null, null, null, null,  0,0,0,0,0,0,0,0));
			}
			//storing participators name
			results.get(totalMatchCount).setPart1(selectAths.get(0));
			results.get(totalMatchCount).setPart2(selectAths.get(1));
			results.get(totalMatchCount).setPart3(selectAths.get(2));
			results.get(totalMatchCount).setPart4(selectAths.get(3));
			results.get(totalMatchCount).setPart5(selectAths.get(4));
			results.get(totalMatchCount).setPart6(selectAths.get(5));
			results.get(totalMatchCount).setPart7(selectAths.get(6));
			results.get(totalMatchCount).setPart8(selectAths.get(7));				
	}
	
	public static void gambleSystem(){	//the method of gambling system
		userWin = false;
		betConfirmed = false;
		int input_2 = 0;
		if (newMatch == true){	//only allow to bet after choosing a game		
			System.out.println("Select your bet:");
			for (int i =0; i< (rng1+rng2);i++){	//show whole list of the game participators
				System.out.println((i+1)+". "+selectAths.get(i));
			}
			System.out.printf("Your Choice : ");
			Scanner console =  new Scanner(System.in);
			input_2 = console.nextInt();
			if (input_2<(rng1+rng2) && input_2>0){	//make sure the input is what we needed
				userBet = selectAths.get(input_2);
				System.out.println("You selected : " + userBet);
				System.out.println("Note: You can still change your choice before game started.");
				betConfirmed = true;	//indicate the system that user placed a bet
			}
			else{	//if not throw an exception
				System.out.println("Your choice must be in range of above, going back to main menu");
			}
		}
	}
	
	public static void tempRecordSystem(){	//temporary store the match record with computation of complete()
		tempMatchResult.clear();
		tempMatchResultAllocated.clear();
		
		//call different complete() based on athlete type
		if (results.get(totalMatchCount).getGameType() == "Swim"){
			for (int i=0;i<rng1;i++){
				tempMatchResult.add(ozlympic.swims.get(rngNumberList1.get(i)).complete());
			}
		}
		else if (results.get(totalMatchCount).getGameType() == "Run"){
			for (int i=0;i<rng1;i++){
				tempMatchResult.add(ozlympic.sprints.get(rngNumberList1.get(i)).complete());
			}
		}
		else if (results.get(totalMatchCount).getGameType() == "Cyc"){
			for (int i=0;i<rng1;i++){
				tempMatchResult.add(ozlympic.cycs.get(rngNumberList1.get(i)).complete());
			}
		}
		for (int i=0;i<rng2;i++){
			tempMatchResult.add(ozlympic.supers.get(rngNumberList2.get(i)).complete());
		}
		for (int i =0; i<tempMatchResult.size();i++){	//store all participators result on this match
			tempMatchResultAllocated.add(tempMatchResult.get(i));
		}
		Collections.sort(tempMatchResultAllocated);	//allocate the result in order to find winner later
	}
	
	public static void recordWritingSystem(){	//write the result of this match to store in result array
		if (athleteEachMatch == 8){
			results.get(totalMatchCount).setResult1(tempMatchResult.get(0));
			results.get(totalMatchCount).setResult2(tempMatchResult.get(1));
			results.get(totalMatchCount).setResult3(tempMatchResult.get(2));
			results.get(totalMatchCount).setResult4(tempMatchResult.get(3));
			results.get(totalMatchCount).setResult5(tempMatchResult.get(4));
			results.get(totalMatchCount).setResult6(tempMatchResult.get(5));
			results.get(totalMatchCount).setResult7(tempMatchResult.get(6));
			results.get(totalMatchCount).setResult8(tempMatchResult.get(7));
		}
		else if (athleteEachMatch== 7){
			results.get(totalMatchCount).setResult1(tempMatchResult.get(0));
			results.get(totalMatchCount).setResult2(tempMatchResult.get(1));
			results.get(totalMatchCount).setResult3(tempMatchResult.get(2));
			results.get(totalMatchCount).setResult4(tempMatchResult.get(3));
			results.get(totalMatchCount).setResult5(tempMatchResult.get(4));
			results.get(totalMatchCount).setResult6(tempMatchResult.get(5));
			results.get(totalMatchCount).setResult7(tempMatchResult.get(6));
		}
		else if (athleteEachMatch== 6){
			results.get(totalMatchCount).setResult1(tempMatchResult.get(0));
			results.get(totalMatchCount).setResult2(tempMatchResult.get(1));
			results.get(totalMatchCount).setResult3(tempMatchResult.get(2));
			results.get(totalMatchCount).setResult4(tempMatchResult.get(3));
			results.get(totalMatchCount).setResult5(tempMatchResult.get(4));
			results.get(totalMatchCount).setResult6(tempMatchResult.get(5));
		}
		else if (athleteEachMatch== 5){
			results.get(totalMatchCount).setResult1(tempMatchResult.get(0));
			results.get(totalMatchCount).setResult2(tempMatchResult.get(1));
			results.get(totalMatchCount).setResult3(tempMatchResult.get(2));
			results.get(totalMatchCount).setResult4(tempMatchResult.get(3));
			results.get(totalMatchCount).setResult5(tempMatchResult.get(4));
		}
		else if (athleteEachMatch== 4){
			results.get(totalMatchCount).setResult1(tempMatchResult.get(0));
			results.get(totalMatchCount).setResult2(tempMatchResult.get(1));
			results.get(totalMatchCount).setResult3(tempMatchResult.get(2));
			results.get(totalMatchCount).setResult4(tempMatchResult.get(3));
		}		
	}

	public static void betCheck(){	//check if user win the bet
		System.out.println("==========================================");
		if (userWin==true &&betConfirmed==true)	//user bet and won
			System.out.println("Congratulations!!! The athlete that you bet on : "+ userBet + " just finished match with position No."+userbetWinPosition+ ".");
		else if(userWin==false&&betConfirmed == true)	//user bet but lost
			System.out.println("Match Finshed, unfortunately you lost the bet.");
		else	//match finished but user didn't bet
			System.out.println("Match finished, but you didn't place a bet.");
		
		System.out.println("==========================================\n");
		System.out.println("Going back to main menu...\n");
	}
	
	public static int getTotalMatchCount() {
		return totalMatchCount;
	}

	public static void setTotalMatchCount(int totalMatchCount) {
		driver.totalMatchCount = totalMatchCount;
	}
	
	
}
