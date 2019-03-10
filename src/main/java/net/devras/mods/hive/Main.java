package net.devras.mods.hive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import net.devras.mods.hive.json.BED;
import net.devras.mods.hive.json.BP;
import net.devras.mods.hive.json.Default;
import net.devras.mods.hive.json.Root;
import net.devras.mods.hive.json.SKY;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "HIVESTATS";
	public static final String VERSION = "2.3";
	public static int warningPoints = 100000;
	public static boolean autoCheck = true;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ClientCommandHandler.instance.registerCommand(new Command());
		//MinecraftForge.EVENT_BUS.register(this);
	}
	
	public static void getStatus(final EntityPlayer p, final String name) {
		final String path = String.format("http://api.hivemc.com/v1/player/%s", name);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Gson gson = new Gson();
					String json = "";
					URL url = new URL(path);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					
					con.setRequestMethod("GET");
					con.setRequestProperty("User-agent","Mozilla/5.0");
					con.setInstanceFollowRedirects(false);
					con.connect();
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
					String line;
					
					while ((line = reader.readLine()) != null) {
						json += line;
					}
					
					reader.close();
					con.disconnect();
					
					if (json.isEmpty()) {
						return;
					}
					
					Root root = gson.fromJson(json, Root.class);
					if (root == null) {
						return;
					}
					
					p.addChatMessage(new ChatComponentTranslation("§6---:-- [§6§lHIVE STATS§r§6] --:---"));
					p.addChatMessage(new ChatComponentTranslation("§eName§7: §6" + name));
					p.addChatMessage(new ChatComponentTranslation("§eUUID§7: §7" + root.getUUID()));
					p.addChatMessage(new ChatComponentTranslation("§eTokens§7: §e" + root.getTokens()));
					p.addChatMessage(new ChatComponentTranslation("§eCrates§7: §7" + root.getCrates()));
					
				} catch (Exception e) {
					e.printStackTrace();
					//p.addChatMessage(new ChatComponentTranslation(e.getMessage()));
				}
			}
		}).start();
	}
	
	public static Default getStatus(String name, String game) {
		final String path = String.format("http://api.hivemc.com/v1/player/%s/%s", name, game.toUpperCase());
		try {
			Gson gson = new Gson();
			String json = "";
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("User-agent","Mozilla/5.0");
			con.setInstanceFollowRedirects(false);
			con.connect();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line;
			
			while ((line = reader.readLine()) != null) {
				json += line;
			}
			
			reader.close();
			con.disconnect();
			
			if (json.isEmpty()) {
				return null;
			}
			if (game.equalsIgnoreCase("BED")){
				Default gm = gson.fromJson(json, Default.class);
				return gm;
			}
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation(e.toString()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation(e.toString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation(e.toString()));
		} catch (IOException e) {
			e.printStackTrace();
			//Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation(e.toString()));
		}
		
		return null;
		
	}

	public static void getStatus(final EntityPlayer p, final String name, final String game) {
		final String path = String.format("http://api.hivemc.com/v1/player/%s/%s", name, game.toUpperCase());
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Gson gson = new Gson();
					String json = "";
					URL url = new URL(path);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					
					con.setRequestMethod("GET");
					con.setRequestProperty("User-agent","Mozilla/5.0");
					con.setInstanceFollowRedirects(false);
					con.connect();
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
					String line;
					
					while ((line = reader.readLine()) != null) {
						json += line;
					}
					
					reader.close();
					con.disconnect();
					
					if (json.isEmpty()) {
						return;
					}
					
					if (game.equalsIgnoreCase("bed")) {
						BED bed = gson.fromJson(json, BED.class);
						if (bed == null) {
							return;
						}
						
						p.addChatMessage(new ChatComponentTranslation("§6---:-- [§6§lHIVE STATS§r§6] --:---"));
						p.addChatMessage(new ChatComponentTranslation("§6---:-- [ BED ] --:---"));
						p.addChatMessage(new ChatComponentTranslation("§eName§7: §6" + name));
						p.addChatMessage(new ChatComponentTranslation("§eUUID§7: §7" + bed.getUUID()));
						p.addChatMessage(new ChatComponentTranslation("§eTitle§7: §a" + bed.getTitle() +" §7/ §ePoints§7: §a" + bed.getTotal_points()));
						p.addChatMessage(new ChatComponentTranslation("§eKills§7: §a" + bed.getKills() + " §7/ §eDeaths§7: §a" + bed.getDeaths()));
						p.addChatMessage(new ChatComponentTranslation("§eBeds§7: §a" + bed.getBeds_destroyed()));
						p.addChatMessage(new ChatComponentTranslation("§ePlayed§7: §a" + bed.getGames_played()));
						p.addChatMessage(new ChatComponentTranslation("§eWins§7: §a" + bed.getVictories() + " §7/ §eStreak§7: §b" + bed.getWin_streak()));
						
						double kd = 1;
						if (bed.getKills() != 0 && bed.getDeaths() != 0) {
							double kdp = bed.getDeaths() + bed.getKills();
							kd = bed.getKills() / kdp;
						}
						
						p.addChatMessage(new ChatComponentTranslation("§eK/D§7: §c" + String.format("%.1f", (kd * 100)) + "§c%%"));
					}else if (game.equalsIgnoreCase("sky")) {
						SKY sky = gson.fromJson(json, SKY.class);
						if (sky == null) {
							return;
						}
						
						p.addChatMessage(new ChatComponentTranslation("§6---:-- [§6§lHIVE STATS§r§6] --:---"));
						p.addChatMessage(new ChatComponentTranslation("§6---:-- [ SKY ] --:---"));
						p.addChatMessage(new ChatComponentTranslation("§eName§7: §6" + name));
						p.addChatMessage(new ChatComponentTranslation("§eUUID§7: §7" + sky.getUUID()));
						p.addChatMessage(new ChatComponentTranslation("§eTitle§7: §a" + sky.getTitle() +" §7/ §ePoints§7: §a" + sky.getTotal_points()));
						p.addChatMessage(new ChatComponentTranslation("§eKills§7: §a" + sky.getKills() + " §7/ §eDeaths§7: §a" + sky.getDeaths()));
						p.addChatMessage(new ChatComponentTranslation("§eWins§7: §a" + sky.getVictories()));
					}else if (game.equalsIgnoreCase("bp")) {
						BP gm = gson.fromJson(json, BP.class);
						if (gm == null) {
							return;
						}
						
						p.addChatMessage(new ChatComponentTranslation("§6---:-- [§6§lHIVE STATS§r§6] --:---"));
						p.addChatMessage(new ChatComponentTranslation("§6---:-- [ BP ] --:---"));
						p.addChatMessage(new ChatComponentTranslation("§eName§7: §6" + name));
						p.addChatMessage(new ChatComponentTranslation("§eUUID§7: §7" + gm.getUUID()));
						p.addChatMessage(new ChatComponentTranslation("§eTitle§7: §a" + gm.getTitle() +" §7/ §ePoints§7: §a" + gm.getTotal_points()));
						p.addChatMessage(new ChatComponentTranslation("§eWins§7: §a" + gm.getVictories()));
					}else {
						Default gm = gson.fromJson(json, Default.class);
						if (gm == null) {
							return;
						}
						p.addChatMessage(new ChatComponentTranslation("§6---:-- [§6§lHIVE STATS§r§6] --:---"));
						p.addChatMessage(new ChatComponentTranslation("§6---:-- [ " + game.toUpperCase() + " ] --:---"));
						p.addChatMessage(new ChatComponentTranslation("§eName§7: §6" + name));
						p.addChatMessage(new ChatComponentTranslation("§eTitle§7: §a" + gm.getTitle() +" §7/ §ePoints§7: §a" + gm.getTotal_points()));
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					//p.addChatMessage(new ChatComponentTranslation(e.getMessage()));
				}
			}
		}).start();
	}
	
}
