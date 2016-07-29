package com.query;

public class Emp {
	private int id;
	private String liveName;
	private int area;
	private int money;
	private int cost;
	private String areaT;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		/* System.out.println(id); */
	}

	public String getliveName() {
		return liveName;
	}

	public void setliveName(String liveName) {
		this.liveName = liveName;
		/* System.out.println(liveName); */
	}

	public int getarea() {
		return area;
	}

	public void setarea(int area) {
		this.area = area;
	}

	public int getMoney() {
		/* System.out.println(money); */
		return money;
	}

	public void setmoney(int money) {
		this.money = money;
		/* System.out.println(money); */
	}

	public int getcost() {
		return cost;
	}

	public void setcost(int cost) {
		this.cost = cost;
	}

	public String getareaT() {
		return areaT;
	}

	public void setareaT(String areaT) {
		this.areaT = areaT;
	}

}
