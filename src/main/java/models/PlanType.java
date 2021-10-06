package models;

public class PlanType {

	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	private int plan_id=0;
	public PlanType(String name, int duration,int rate, int penalty) {
		super();
		this.name = name;
		this.duration = duration;
		this.rate = rate;
		this.penalty = penalty;
	}
	private String name;
	private int duration;
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	private int rate;
	private int penalty;
	
	
}
