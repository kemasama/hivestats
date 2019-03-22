package net.devras.mods.hive.json;

public class BP {
	private String UUID;
	private String title;
	private int games_played;
	private String selected_bling;
	private String selected_death_sound;
	private String selected_trail;
	private String selected_victory_sound;
	private int total_eliminations;
	private int total_placing;
	private int total_points;
	private int victories;
	
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getGames_played() {
		return games_played;
	}
	public void setGames_played(int games_played) {
		this.games_played = games_played;
	}
	public String getSelected_bling() {
		return selected_bling;
	}
	public void setSelected_bling(String selected_bling) {
		this.selected_bling = selected_bling;
	}
	public String getSelected_death_sound() {
		return selected_death_sound;
	}
	public void setSelected_death_sound(String selected_death_sound) {
		this.selected_death_sound = selected_death_sound;
	}
	public String getSelected_trail() {
		return selected_trail;
	}
	public void setSelected_trail(String selected_trail) {
		this.selected_trail = selected_trail;
	}
	public String getSelected_victory_sound() {
		return selected_victory_sound;
	}
	public void setSelected_victory_sound(String selected_victory_sound) {
		this.selected_victory_sound = selected_victory_sound;
	}
	public int getTotal_eliminations() {
		return total_eliminations;
	}
	public void setTotal_eliminations(int total_eliminations) {
		this.total_eliminations = total_eliminations;
	}
	public int getTotal_placing() {
		return total_placing;
	}
	public void setTotal_placing(int total_placing) {
		this.total_placing = total_placing;
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
}
