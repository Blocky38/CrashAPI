package org.ctp.crashapi.config;

import java.io.File;
import java.util.List;

import org.ctp.crashapi.CrashAPIPlugin;
import org.ctp.crashapi.config.yaml.YamlConfig;
import org.ctp.crashapi.utils.ChatUtils;

public interface Configurable {

	public File getFile();

	public YamlConfig getConfig();

	public void save();

	public void reload();

	public String getString(String s);

	public int getInt(String s);

	public boolean getBoolean(String s);

	public double getDouble(String s);

	public List<String> getStringList(String s);

	public void updatePath(String s, Object value);

	public CrashAPIPlugin getPlugin();

	public ChatUtils getChat();

	public void repairConfig();
}
