package net.devras.mods.hive.json;

public class SKY  {
	private String UUID;
	private int total_points;
	private int victories;
	private int gamesplayed;
	private int kills;
	private int deaths;
	private int most_points;
	private int timealive;
	private String title;
	
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public int getTotal_points() {
		return total_points;
	}
	public void setTotal_points(int total_points) {
		this.total_points = total_points;
	}
	public int getVictories() {
		return victories;
	}
	public void setVictories(int victories) {
		this.victories = victories;
	}
	public int getGamesplayed() {
		return gamesplayed;
	}
	public void setGamesplayed(int gamesplayed) {
		this.gamesplayed = gamesplayed;
	}
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
	public int getMost_points() {
		return most_points;
	}
	public void setMost_points(int most_points) {
		this.most_points = most_points;
	}
	public int getTimealive() {
		return timealive;
	}
	public void setTimealive(int timealive) {
		this.timealive = timealive;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
