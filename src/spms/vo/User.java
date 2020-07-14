package spms.vo;

/**
 * @author LHG
 *
 */
public class User {
	protected int no;
	protected String id;
	protected String password;
	protected String name;
	protected String gender;
	protected String email;
	protected int upoint;
	
	public int getNo() {
		return no;
	}
	public User setNo(int no) {
		this.no = no;
		return this;
	}
	
	public String getId() {
		return id;
	}
	public User setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getGender() {
		return gender;
	}
	public User setGender(String gender) {
		this.gender = gender;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public int getUpoint() {
		return upoint;
	}
	public User setUpoint(int upoint) {
		this.upoint = upoint;
		return this;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", email=" + email + ", upoint=" + upoint + "]";
	}
	
	
}
