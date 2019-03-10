package net.devras.mods.hive.json;

public class Default {
	private int total_points;
	private String title;
	
	public Default() {
		this.total_points = 0;
		this.title = "";
	}
	
	public int getTotal_points() {
		return total_points;
	}
	public void setTotal_points(int total_points) {
		this.total_points = total_points;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
