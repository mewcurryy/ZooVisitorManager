package index;

import java.util.*;



public class Visitor {
	private String name, code;
	private Double balance;
	ArrayList<String> visit = new ArrayList<>();
	public Visitor(String name, String code, Double balance, ArrayList<String> visit) {
		super();
		this.name = name;
		this.code = code;
		this.balance = balance;
		this.visit = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public ArrayList<String> getVisit() {
		return visit;
	}
	public void setVisit(ArrayList<String> visit) {
		this.visit = visit;
	}
	
	
}
