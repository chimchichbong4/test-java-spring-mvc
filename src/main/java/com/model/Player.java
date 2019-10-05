package com.model;

public class Player {
	private int id;
	private String name;
	private String clb;
	private String nation;
	private String position;
	private String image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClb() {
		return clb;
	}
	public void setClb(String clb) {
		this.clb = clb;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Player(int id, String name, String clb, String nation, String position, String image) {
		super();
		this.id = id;
		this.name = name;
		this.clb = clb;
		this.nation = nation;
		this.position = position;
		this.image=image;
	}
	public Player() {
		super();
	}
	

}
