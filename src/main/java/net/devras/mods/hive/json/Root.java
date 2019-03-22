package net.devras.mods.hive.json;

public class Root {
	private String UUID;
	private String username;
	private String rankName;
	private int tokens;
	private int credits;
	private int crates;
	
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	public int getTokens() {
		return tokens;
	}
	public void setTokens(int tokens) {
		this.tokens = tokens;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getCrates() {
		return crates;
	}
	public void setCrates(int crates) {
		this.crates = crates;
	}
}
