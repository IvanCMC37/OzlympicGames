
public class gameRecords {
	private String gameType;
	private int matchNum = 0;
	
	//store name for referee and participators
	private String staff;
	private String part1;
	private String part2;
	private String part3;
	private String part4;
	private String part5;
	private String part6;
	private String part7;
	private String part8;
	
	//store match results related to participactors
	private int result1;
	private int result2;
	private int result3;
	private int result4;
	private int result5;
	private int result6;
	private int result7;
	private int result8;
	

	public gameRecords(String gameType, int matchNum, String staff, String part1, String part2, String part3,
			String part4, String part5, String part6, String part7, String part8, int result1, int result2, int result3,
			int result4, int result5, int result6, int result7, int result8) {
		super();
		this.gameType = gameType;
		this.matchNum = matchNum;
		this.staff = staff;
		this.part1 = part1;
		this.part2 = part2;
		this.part3 = part3;
		this.part4 = part4;
		this.part5 = part5;
		this.part6 = part6;
		this.part7 = part7;
		this.part8 = part8;
		this.result1 = result1;
		this.result2 = result2;
		this.result3 = result3;
		this.result4 = result4;
		this.result5 = result5;
		this.result6 = result6;
		this.result7 = result7;
		this.result8 = result8;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public int getMatchNum() {
		return matchNum;
	}

	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getPart1() {
		return part1;
	}

	public void setPart1(String part1) {
		this.part1 = part1;
	}

	public String getPart2() {
		return part2;
	}

	public void setPart2(String part2) {
		this.part2 = part2;
	}

	public String getPart3() {
		return part3;
	}

	public void setPart3(String part3) {
		this.part3 = part3;
	}

	public String getPart4() {
		return part4;
	}

	public void setPart4(String part4) {
		this.part4 = part4;
	}

	public String getPart5() {
		return part5;
	}

	public void setPart5(String part5) {
		this.part5 = part5;
	}

	public String getPart6() {
		return part6;
	}

	public void setPart6(String part6) {
		this.part6 = part6;
	}

	public String getPart7() {
		return part7;
	}

	public void setPart7(String part7) {
		this.part7 = part7;
	}

	public String getPart8() {
		return part8;
	}

	public void setPart8(String part8) {
		this.part8 = part8;
	}

	public int getResult1() {
		return result1;
	}

	public void setResult1(int result1) {
		this.result1 = result1;
	}

	public int getResult2() {
		return result2;
	}

	public void setResult2(int result2) {
		this.result2 = result2;
	}

	public int getResult3() {
		return result3;
	}

	public void setResult3(int result3) {
		this.result3 = result3;
	}

	public int getResult4() {
		return result4;
	}

	public void setResult4(int result4) {
		this.result4 = result4;
	}

	public int getResult5() {
		return result5;
	}

	public void setResult5(int result5) {
		this.result5 = result5;
	}

	public int getResult6() {
		return result6;
	}

	public void setResult6(int result6) {
		this.result6 = result6;
	}

	public int getResult7() {
		return result7;
	}

	public void setResult7(int result7) {
		this.result7 = result7;
	}

	public int getResult8() {
		return result8;
	}

	public void setResult8(int result8) {
		this.result8 = result8;
	}

	@Override
	public String toString() {	//for printing out the match record as menu option5
		return "\nMatchID: "+gameType+"00"+matchNum+"\n"
				+"Referee: "+staff+"\n"
				+"Participator 1: "+part1 +"   result: "+result1+"s\n"
				+"Participator 2: "+part2 +"   result: "+result2+"s\n"
				+"Participator 3: "+part3 +"   result: "+result3+"s\n"
				+"Participator 4: "+part4 +"   result: "+result4+"s\n"
				+"Participator 5: "+part5 +"   result: "+result5+"s\n"
				+"Participator 6: "+part6 +"   result: "+result6+"s\n"
				+"Participator 7: "+part7 +"   result: "+result7+"s\n"
				+"Participator 8: "+part8 +"   result: "+result8+"s\n\n";
	}

	
	
	
	
	
	
	
	
	
}
