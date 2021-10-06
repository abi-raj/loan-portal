package models;

public class LoanModel {
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getU_name() {
	return u_name;
}
public void setU_name(String u_name) {
	this.u_name = u_name;
}
public String getU_mail() {
	return u_mail;
}
public void setU_mail(String u_mail) {
	this.u_mail = u_mail;
}
public int getU_age() {
	return u_age;
}
public void setU_age(int u_age) {
	this.u_age = u_age;
}
public int getU_phone() {
	return u_phone;
}
public void setU_phone(int u_phone) {
	this.u_phone = u_phone;
}
public String getP_name() {
	return p_name;
}
public void setP_name(String p_name) {
	this.p_name = p_name;
}
public int getP_dur() {
	return p_dur;
}
public void setP_dur(int p_dur) {
	this.p_dur = p_dur;
}
public int getP_rate() {
	return p_rate;
}
public void setP_rate(int p_rate) {
	this.p_rate = p_rate;
}
private String pan;
public LoanModel(int id, String pan, int amount, String loan_type, String remarks, String status, String u_name,
		String u_mail, int u_age, int u_phone, String p_name, int p_dur, int p_rate) {
	super();
	this.id = id;
	this.pan = pan;
	this.amount = amount;
	this.loan_type = loan_type;
	this.remarks = remarks;
	this.status = status;
	this.u_name = u_name;
	this.u_mail = u_mail;
	this.u_age = u_age;
	this.u_phone = u_phone;
	this.p_name = p_name;
	this.p_dur = p_dur;
	this.p_rate = p_rate;
}
private int amount;
private String loan_type;
private String remarks;
private String status;
private String u_name;
private String u_mail;
private int u_age;
private int u_phone;
private String p_name;
private int p_dur;
private int p_rate;




}
