package net.devras.mods.hive.json;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

public class BED {
	@SerializedName("UUID")
	private String UUID;
	@SerializedName("total_points")
	private int total_points;
	@SerializedName("victories")
	private int victories;
	@SerializedName("games_played")
	private int games_played;
	@SerializedName("kills")
	private int kills;
	@SerializedName("deaths")
	private int deaths;
	@SerializedName("beds_destroyed")
	private int beds_destroyed;
	@SerializedName("teams_eliminated")
	private int teams_eliminated;
	@SerializedName("win_streak")
	private int win_streak;
	@SerializedName("title")
	private String title;
	
	public BED() {
		this.total_points = 0;
		this.victories = 0;
		this.games_played = 0;
		this.kills = 0;
		this.deaths = 0;
		this.beds_destroyed = 0;
		this.teams_eliminated = 0;
		this.win_streak = 0;
		this.title = "Sleepy 5";
		this.UUID = java.util.UUID.randomUUID().toString().replace("-", "");
	}
	
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
	public int getGames_played() {
		return games_played;
	}
	public void setGames_played(int games_played) {
		this.games_played = games_played;
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
	public int getBeds_destroyed() {
		return beds_destroyed;
	}
	public void setBeds_destroyed(int beds_destroyed) {
		this.beds_destroyed = beds_destroyed;
	}
	public int getTeams_eliminated() {
		return teams_eliminated;
	}
	public void setTeams_eliminated(int teams_eliminated) {
		this.teams_eliminated = teams_eliminated;
	}
	public int getWin_streak() {
		return win_streak;
	}
	public void setWin_streak(int win_streak) {
		this.win_streak = win_streak;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
