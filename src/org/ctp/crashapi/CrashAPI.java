package org.ctp.crashapi;

import org.bukkit.Bukkit;
import org.ctp.crashapi.api.Configurations;
import org.ctp.crashapi.api.CrashBackup;
import org.ctp.crashapi.config.yaml.YamlConfig;
import org.ctp.crashapi.db.BackupDB;
import org.ctp.crashapi.item.ItemSerialization;
import org.ctp.crashapi.listeners.EquipListener;
import org.ctp.crashapi.utils.ChatUtils;
import org.ctp.crashapi.version.*;
import org.ctp.crashapi.version.Version.VersionType;

public class CrashAPI extends CrashAPIPlugin {

	private static CrashAPI PLUGIN;
	private static CrashBackup BACKUP;
	private boolean initializing = true;
	private Configurations config;
	private BukkitVersion bukkitVersion;
	private PluginVersion pluginVersion;
	private VersionCheck check;
	
	@Override
	public void onLoad() {
		PLUGIN = this;
		bukkitVersion = new BukkitVersion(this);
		pluginVersion = new PluginVersion(this, new Version(getDescription().getVersion(), VersionType.UNKNOWN));

		if (!getDataFolder().exists()) getDataFolder().mkdirs();
		
		BACKUP = new CrashBackup(PLUGIN);
		BACKUP.load();
		
		config = Configurations.getConfigurations();
		config.onEnable();
	}
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new EquipListener(), this);
		config.setLanguageDefaults();
		
		check = new VersionCheck(pluginVersion, "https://raw.githubusercontent.com/crashtheparty/CrashAPI/master/VersionHistory", 
				"", "https://github.com/crashtheparty/CrashAPI", 
				config.getConfig().getBoolean("get_latest_version"), false);
		Bukkit.getPluginManager().registerEvents(check, this);
		checkVersion();
		initializing = false;
	}
	
	private void checkVersion(){
		Bukkit.getScheduler().runTaskTimerAsynchronously(this, check, 20l, 20 * 60 * 60 * 4l);
    }
	
	public static CrashAPI getPlugin() {
		return PLUGIN;
	}

	public BukkitVersion getBukkitVersion() {
		return bukkitVersion;
	}

	@Override
	public PluginVersion getPluginVersion() {
		return pluginVersion;
	}
	
	@Override
	public String getStarter() {
		return getLanguageFile().getString("starter");
	}

	@Override
	public ChatUtils getChat() {
		return ChatUtils.getUtils(PLUGIN);
	}

	@Override
	public ItemSerialization getItemSerial() {
		return ItemSerialization.getItemSerial(PLUGIN);
	}

	@Override
	public Configurations getConfigurations() {
		return config;
	}

	@Override
	public YamlConfig getLanguageFile() {
		return config.getLanguage().getConfig();
	}

	@Override
	public boolean isInitializing() {
		return initializing;
	}

	public BackupDB getBackupDB() {
		return BACKUP;
	}
	
}