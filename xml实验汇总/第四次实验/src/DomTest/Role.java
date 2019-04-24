package DomTest;

public class Role {
	private String role_name;
	private String role_gender;
	private int role_age;
	private String role_cv;
	public Role(String name) {
		setName(name);
	}

	public String getName() {
		return role_name;
	}
	public void setName(String name) {
		this.role_name = name;
	}
	
	public String getGender() {
		return role_gender;
	}
	public void setGender(String gender) {
		this.role_gender = gender;
	}
	
	public int getAge() {
		return role_age;
	}
	public void setAge(int age) {
		this.role_age = age;
	}

	public String getCV() {
		return role_cv;
	}
	public void setCV(String cv) {
		this.role_cv = cv;
	}

}
