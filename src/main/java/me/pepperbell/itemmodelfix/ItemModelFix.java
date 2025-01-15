package me.pepperbell.itemmodelfix;

import me.pepperbell.itemmodelfix.config.Config;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;

public class ItemModelFix {
    public static final String ID = "itemmodelfix";
    public static final Logger LOGGER = LogManager.getLogger("ItemModelFix");

    private static Config config;

    public static Config getConfig() {
        if (config == null) {
            loadConfig();
        }

        return config;
    }

    private static void loadConfig() {
        Path configPath = FabricLoader.getInstance().getConfigDir();
        File configFile = new File(configPath.toFile(), ID + ".json");
        config = new Config(configFile);
        config.load();
    }
}
