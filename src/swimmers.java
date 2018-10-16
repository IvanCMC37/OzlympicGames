import java.util.Random;

public class swimmers extends athletes {
	
	public swimmers(String ID, String name, String age, String state, int score) {
		super(ID, name, age, state, score);		
	}

	@Override
	public int complete() {
		int minTime = 100;
		int maxTime = 200;
		int resultTime = 0;
		
		Random rand = new Random();	//setup for generating random number later on
		resultTime = rand.nextInt(maxTime-minTime) + 1 + minTime;	//generate random number with desire range
		return resultTime;			
	}

}
