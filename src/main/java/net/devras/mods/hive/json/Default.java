package net.devras.mods.hive.json;

public class Default {
	private int total_points;
	private String title;
	
	public Default() {
		this.total_points = 0;
		this.title = "";
		this.kills = 0;
		this.deaths = 0;
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
	
	
	private int kills;
	private int deaths;

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
}
