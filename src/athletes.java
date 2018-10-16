
public abstract class athletes extends person {
	
	private int score = 0;
	
	public athletes(String iD, String name, String age, String state, int score) {
		super(iD, name, age, state);
		this.score =  score;
	}

	public abstract int complete();	//set up abstract method for polymorphism

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
