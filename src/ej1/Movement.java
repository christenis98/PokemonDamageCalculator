package ej1;

public class Movement {
	private String name;
	private int power;
	
	public Movement(String n, int p) {
		this.name=n;
		this.power=p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}
