import java.util.Random;

public class sprinters extends athletes{

	public sprinters(String ID, String name, String age, String state, int score) {
		super(ID, name, age, state, score);
	}

	@Override
	public int complete() {
		int minTime = 10;
		int maxTime = 20;
		int resultTime = 0;
		
		Random rand = new Random();	//setup for generating random number later on
		resultTime = rand.nextInt(maxTime-minTime) + 1 + minTime;	//generate random number within desire range
		return resultTime;	
		
	}

}
