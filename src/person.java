
public abstract class person {

	private String ID;
	private String name;
	private String age;
	private String state;
	
	public person(String iD, String name, String age, String state) {
		ID = iD;
		this.name = name;
		this.age = age;
		this.state = state;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
