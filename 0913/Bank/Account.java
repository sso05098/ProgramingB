package practice3;

public class Account {
	private String name;
	private String number;
	private int money;
	
	public Account(String name, String number, int money) {
		this.name = name;
		this.number = number;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void addMoney(int amount) {
		this.money += amount;
	}
	
	public void minusMoney(int amount) {
		this.money -= amount;
	}
}
