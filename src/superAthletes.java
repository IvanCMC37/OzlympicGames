import java.util.Random;

public class superAthletes extends athletes {

	public superAthletes(String ID, String name, String age, String state, int score) {
		super(ID, name, age, state, score);	
	}

	@Override
	public int complete() {//decide complete() method based on gameType
		if (driver.results.get(driver.getTotalMatchCount()).getGameType() == "Swim"){
			int minTime = 100;
			int maxTime = 200;
			int resultTime = 0;
			
			Random rand = new Random();	//setup for generating random number within range
			resultTime = rand.nextInt(maxTime-minTime) + 1 + minTime;	//generate random number
			return resultTime;	
		}
		else if (driver.results.get(driver.getTotalMatchCount()).getGameType() == "Run"){
			int minTime = 10;
			int maxTime = 20;
			int resultTime = 0;
			
			Random rand = new Random();	//setup for generating random number within range
			resultTime = rand.nextInt(maxTime-minTime) + 1 + minTime;	//generate random number
			return resultTime;	
		}
		else{
			int minTime = 500;
			int maxTime = 800;
			int resultTime = 0;
			
			Random rand = new Random();	//setup for generating random number within range
			resultTime = rand.nextInt(maxTime-minTime) + 1 + minTime;	//generate random number
			return resultTime;	
		}
	}

}
