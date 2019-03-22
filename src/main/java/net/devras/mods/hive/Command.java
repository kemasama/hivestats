package net.devras.mods.hive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import net.devras.mods.hive.json.BED;
import net.devras.mods.hive.json.Default;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class Command implements ICommand {

	@Override
	public String getCommandName() {
		return "hive";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "Do stuff with it.";
	}

	@Override
	public List<String> getCommandAliases() {
		List<String> als = new ArrayList();
		als.add("hv");
		return als;
	}
	
	/**
	 * Player type
	 * hive -> Show bedwars score
	 * hive help -> Show help
	 * hive root -> Show main score
	 * hive root <player> -> Show main score
	 * hive <game> -> Show game score
	 * hive <game> <player> -> Show player score
	 * hive <game> warning -> Warning
	 * hive <game> warning <point> -> Warning
	 */

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		if (!(sender instanceof EntityPlayer)) {
			return;
		}
		final EntityPlayer p = (EntityPlayer) sender;
		final String game = (args.length > 0) ? args[0] : "BED";
		
		String name = p.getName();
		if (args.length > 0) {
			if (args[0].equalsIgnoreCase("root")) {
				Main.getStatus(p, ((args.length > 1) ? args[1] : name));
				return;
			}
			if (args[0].equalsIgnoreCase("help")) {
				p.addChatMessage(new ChatComponentTranslation("§6§l---*-- HIVE Stats is runnable! --*---"));
				p.addChatMessage(new ChatComponentTranslation("§aAuto Check   : " + Main.autoCheck));
				p.addChatMessage(new ChatComponentTranslation("§aWarning Point: " + Main.warningPoints));
				return;
			}
		}
		if (args.length > 1) {
			name = args[1];
			
			if (args[1].equalsIgnoreCase("setDefault")) {
				
				Main.defaultGame = name;
				
				return;
			}
			
			if (args[1].equalsIgnoreCase("kills")) {
				List<String> tmp = new ArrayList();
				for (EntityPlayer pl : Minecraft.getMinecraft().theWorld.playerEntities) {
					tmp.add(pl.getName());
				}
				
				final List<String> players = tmp;
				final int warnPoint = (args.length > 2) ? Integer.parseInt(args[2]) : Main.warningPoints;

				p.addChatMessage(new ChatComponentTranslation("§cWarning List Now loading..."));
				//p.addChatMessage(new ChatComponentTranslation("§cWarning point : " + warnPoint));
								
				new Thread(new Runnable() {
					@Override
					public void run() {
						HashMap<String, Default> Warn = new HashMap();
						for (String pl : players) {
							try {
								Default gm = Main.getStatus(pl, game);
								if (gm == null) {
									continue;
								}
								int totalPoints = gm.getKills();
								if (totalPoints >= warnPoint) {
									Warn.put(pl, gm);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
	
						p.addChatMessage(new ChatComponentTranslation("§c---:-- [§c§lWarning§r§c] --:---"));
						if (Warn.size() == 0) {
							p.addChatMessage(new ChatComponentTranslation("§aNot found warning!"));
						}else {
							p.addChatMessage(new ChatComponentTranslation("§cPLAYER / POINTS / KD / Kills / Deaths"));
							for (String key : Warn.keySet()) {
								Default gm = Warn.get(key);

								double kd = 1;
								if (gm.getKills() != 0 && gm.getDeaths() != 0) {
									double kdp = gm.getDeaths() + gm.getKills();
									kd = gm.getKills() / kdp;
								}
								
								p.addChatMessage(new ChatComponentTranslation("§c" + key + " §7/ §a" + gm.getTotal_points() + " §7/ §a" + String.format("%.1f", (kd * 100)) + " §7/ §a" + gm.getKills() + " §7/ §a" + gm.getDeaths()));
								
								//p.addChatMessage(new ChatComponentTranslation("§c" + key + " §7/ §a" + gm.getTotal_points() + " §7/ §b" + gm.getTitle()));
							}
						}
					}
				}).start();
				
				return;
			}
			
			
			if (args[1].equalsIgnoreCase("warning")) {
				List<String> tmp = new ArrayList();
				for (EntityPlayer pl : Minecraft.getMinecraft().theWorld.playerEntities) {
					tmp.add(pl.getName());
				}
				
				final List<String> players = tmp;
				final int warnPoint = (args.length > 2) ? Integer.parseInt(args[2]) : Main.warningPoints;

				p.addChatMessage(new ChatComponentTranslation("§cWarning List Now loading..."));
				//p.addChatMessage(new ChatComponentTranslation("§cWarning point : " + warnPoint));
								
				new Thread(new Runnable() {
					@Override
					public void run() {
						HashMap<String, Default> Warn = new HashMap();
						for (String pl : players) {
							try {
								Default gm = Main.getStatus(pl, game);
								if (gm == null) {
									continue;
								}
								int totalPoints = gm.getTotal_points();
								if (totalPoints >= warnPoint) {
									Warn.put(pl, gm);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
	
						p.addChatMessage(new ChatComponentTranslation("§c---:-- [§c§lWarning§r§c] --:---"));
						if (Warn.size() == 0) {
							p.addChatMessage(new ChatComponentTranslation("§aNot found warning!"));
						}else {
							p.addChatMessage(new ChatComponentTranslation("§cPLAYER / POINTS / TITLE"));
							for (String key : Warn.keySet()) {
								Default gm = Warn.get(key);
								p.addChatMessage(new ChatComponentTranslation("§c" + key + " §7/ §a" + gm.getTotal_points() + " §7/ §b" + gm.getTitle()));
							}
						}
					}
				}).start();
				
				return;
			}
		}

		Main.getStatus(p, name, game);
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

	@Override
	public int compareTo(ICommand o) {
		return 0;
	}

}
