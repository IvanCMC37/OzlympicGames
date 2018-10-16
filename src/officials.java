
public class officials extends person {
	final static int pt1ST = 5;	//setup rewarding score for the player finished match at 1st
	final static int pt2ND = 2;	//setup rewarding score for the player finished match at 2nd
	final static int pt3RD = 1;	//setup rewarding score for the player finished match at 3rd
	static int check = 0;	//for locating the winner

	public officials(String iD, String name, String age, String state) {
		super(iD, name, age, state);	
	}

	public static void winnerAnnouncer(){
		check = 0;
		System.out.println("Match is on going.....\n");
		System.out.println("The winners are :");
		//if had 3-1st
		if(driver.tempMatchResultAllocated.get(0)==driver.tempMatchResultAllocated.get(1)&&driver.tempMatchResultAllocated.get(0)==driver.tempMatchResultAllocated.get(3)){
			check1();
		}
		// if had 2-1st, so 0-2nd, 1-3rd
		else if (driver.tempMatchResultAllocated.get(0)==driver.tempMatchResultAllocated.get(1)){
			check2();
		}
		else{	// had 1-1st, so can be 2-2nd or 1-2ndwith 1/2-3rd
			check3();		
		}		
		driver.totalMatchCount++;
		driver.newMatch = false;	//ensure game won't start if the user didn't choose a game next round
		driver.betCheck();	//check if the user won the bet
	}
	
	public static void checkSubPart1(int PT){	//score athletes based on finishing position
		//find athlete based on gametype and change their score, as well as show the winner list
		if(driver.results.get(driver.totalMatchCount).getGameType()=="Swim"){
			ozlympic.swims.get(driver.rngNumberList1.get(check)).setScore(PT+ozlympic.swims.get(driver.rngNumberList1.get(check)).getScore());
			System.out.println((driver.winnerCount+1) +" "+ozlympic.swims.get(driver.rngNumberList1.get(check)).getName());
			if(driver.userBet.equals(ozlympic.swims.get(driver.rngNumberList1.get(check)).getName())){
				driver.userWin = true;	//indicate the betCheck() that user won a bet
			}
		}
		else if(driver.results.get(driver.totalMatchCount).getGameType()=="Run"){
			ozlympic.sprints.get(driver.rngNumberList1.get(check)).setScore(PT+ozlympic.sprints.get(driver.rngNumberList1.get(check)).getScore());
			System.out.println((driver.winnerCount+1) +" "+ozlympic.sprints.get(driver.rngNumberList1.get(check)).getName());
			if(driver.userBet.equals(ozlympic.sprints.get(driver.rngNumberList1.get(check)).getName())){
				driver.userWin = true;	//indicate the betCheck() that user won a bet
			}
		}
		else{
			ozlympic.cycs.get(driver.rngNumberList1.get(check)).setScore(PT+ozlympic.cycs.get(driver.rngNumberList1.get(check)).getScore());
			System.out.println((driver.winnerCount+1) +" "+ozlympic.cycs.get(driver.rngNumberList1.get(check)).getName());
			if(driver.userBet.equals(ozlympic.cycs.get(driver.rngNumberList1.get(check)).getName())){
				driver.userWin = true;	//indicate the betCheck() that user won a bet
			}
		}
		driver.userbetWinPosition = driver.winnerCount;	//used for telling the position of athlete that user bet on
		driver.winnerCount++;
	}
	
	public static void checkSubPart2(int PT){	//score super athletes based on finishing position
		ozlympic.supers.get(driver.rngNumberList2.get(check)).setScore(PT+ozlympic.supers.get(driver.rngNumberList2.get(check)).getScore());
		System.out.println((driver.winnerCount+1) +" "+ozlympic.supers.get(driver.rngNumberList2.get(check)).getName());
		if(driver.userBet.equals(ozlympic.supers.get(driver.rngNumberList2.get(check)).getName())){
			driver.userWin = true;	//indicate the betCheck() that user won a bet
		}
		driver.userbetWinPosition = driver.winnerCount;	//used for telling the position of athlete that user bet on
		driver.winnerCount++;
	}
	
	public static void check1(){	//method for scoring 3-1st
		for (int i=0; i<driver.athleteEachMatch;i++){
			if (i==driver.rng1){
				check =0;	//always set check to 0 when finishing checking within normal athletes
			}
			if (i<driver.rng1){	//check within normal athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(0)){
					checkSubPart1(pt1ST);//score the certain athlete with 5pts
				}
			}
			else if(i< (driver.rng1+driver.rng2)){	//check within super athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(0)){
					checkSubPart2(pt1ST);//score the certain athlete with 5pts
				}			
			}
			check++;
		}
		
	}
	
	public static void check2(){	//method for scoring 2-1st
		for (int i=0; i<driver.athleteEachMatch;i++){
			if (i==driver.rng1){
				check =0;//always set check to 0 when finishing checking within normal athletes
			}
			if (i<driver.rng1){	//check within normal athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(0)){
					checkSubPart1(pt1ST);//score the certain athlete with 5pts
				}
			}
			else if(i< (driver.rng1+driver.rng2)){	//check within super athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(0)){
					checkSubPart2(pt1ST);//score the certain athlete with 5pts
				}									
			}
			check++;
		}
		check = 0;//always set check to 0 when finished checking
		for (int i=0; i<driver.athleteEachMatch;i++){
			if (i==driver.rng1){
				check =0;//always set check to 0 when finishing checking within normal athletes
			}
			if (i<driver.rng1){	//check within normal athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(2)){
					checkSubPart1(pt3RD);//score the certain athlete with 1pts
				}
			}
			else if(i< (driver.rng1+driver.rng2)){	//check within super athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(2)){
					checkSubPart2(pt3RD);//score the certain athlete with 1pts
				}									
			}
			check++;
		}
	}
	
	public static void check3(){	//method for scoring 1-1st,1-2nd
		check3SubPart1();		
		check = 0;//always set check to 0 when finished checking
		if (driver.tempMatchResultAllocated.get(1) !=driver.tempMatchResultAllocated.get(2)){
			check3SubPart2_1();		
			check =0;//always set check to 0 when finished checking
			check3SubPart2_2();			
			check =0;//always set check to 0 when finished checking
		}
		else{
			check3SubPart3();
		}
		check = 0;//always set check to 0 when finished checking
	}
	
	public static void check3SubPart1(){
		for (int i=0; i<driver.athleteEachMatch;i++){
			if (i==driver.rng1){
				check =0;//always set check to 0 when finishing checking within normal athletes
			}
			if (i<driver.rng1){	//check within normal athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(0)){
					checkSubPart1(pt1ST);	//score certain normal athlete with 1pt
				}
			}
			else if(i< (driver.rng1+driver.rng2)){	//check within super athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(0)){
					checkSubPart2(pt1ST);	//score certain super athlete with 1pt
				}									
			}
			check++;
		}
	}
	
	public static void check3SubPart2_1(){
		for (int i=0; i<driver.athleteEachMatch;i++){
			if (i==driver.rng1){
				check =0;//always set check to 0 when finishing checking within normal athletes
			}
			if (i<driver.rng1){	//check within normal athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(1)){
					checkSubPart1(pt2ND);	//score certain normal athlete with 2pts
				}
			}
			else if(i< (driver.rng1+driver.rng2)){	//check within super athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(1)){
					checkSubPart2(pt2ND);	//score certain super athlete with 2pts
				}									
			}
			check++;
		}
	}
	public static void check3SubPart2_2(){
		for (int i=0; i<driver.athleteEachMatch;i++){
			if (i==driver.rng1){
				check =0;//always set check to 0 when finishing checking within normal athletes
			}
			if (i<driver.rng1){	//check within normal athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(2)){
					checkSubPart1(pt3RD);	// score certain normal athlete with 1pt
				}
			}
			else if(i< (driver.rng1+driver.rng2)){	//check within super athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(2)){
					checkSubPart2(pt3RD);	//score certain super athlete with 1pt
				}									
			}
			check++;
		}
	}

	public static void check3SubPart3(){
		for (int i=0; i<driver.athleteEachMatch;i++){
			if (i==driver.rng1){
				check =0;//always set check to 0 when finishing checking within normal athletes
			}
			if (i<driver.rng1){	//check within normal athletes
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(1)){
					checkSubPart1(pt2ND);	//score certain normal athlete with 2pts
				}
			}
			else if(i< (driver.rng1+driver.rng2)){	//check within super athletes 
				if(driver.tempMatchResult.get(i)==driver.tempMatchResultAllocated.get(1)){
					checkSubPart2(pt2ND);	//score certain super athlete with 2pts
				}									
			}
			check++;
		}
	}
}
