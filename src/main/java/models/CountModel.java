package models;

public class CountModel {
	private int total;
	private int accepted;
	private int pending;
	private int rejected;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}

	public int getRejected() {
		return rejected;
	}

	public void setRejected(int rejected) {
		this.rejected = rejected;
	}

	public CountModel(int total, int accepted, int pending, int rejected) {
	
		this.total = total;
		this.accepted = accepted;
		this.pending = pending;
		this.rejected = rejected;
	}

}
