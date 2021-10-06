package models;

public class ApplicationModel {
private int app_id=0;
public int getApp_id() {
	return app_id;
}
public void setApp_id(int app_id) {
	this.app_id = app_id;
}
public int getPlan_id() {
	return plan_id;
}
public void setPlan_id(int plan_id) {
	this.plan_id = plan_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getPan() {
	return pan;
}
public void setPan(String pan) {
	this.pan = pan;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getLoan_type() {
	return loan_type;
}
public void setLoan_type(String loan_type) {
	this.loan_type = loan_type;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
private int plan_id;

public ApplicationModel(int plan_id, int user_id, String pan, int amount, String loan_type, String remarks,String status) {
	super();
	this.plan_id = plan_id;
	this.user_id = user_id;
	this.pan = pan;
	this.amount = amount;
	this.loan_type = loan_type;
	this.remarks = remarks;
	this.status = status;
}
private int user_id;
private String pan;
private int amount;
private String loan_type;
private String remarks;
private String status;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
	
}
