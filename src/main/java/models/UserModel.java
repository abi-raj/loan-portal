package models;

public class UserModel {
private int user_id=0;
public UserModel(String name, String email, int age, String password) {
	
	this.name = name;
	this.email = email;
	this.age = age;
	this.password = password;
}
private String name;
private String email;
private int age;
private String password;





public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
