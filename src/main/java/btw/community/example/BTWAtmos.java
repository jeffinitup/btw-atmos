package btw.community.example;

import btw.BTWAddon;
import eu.ha3.matmos.game.mod.LiteModMAtmos;
import net.minecraft.src.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BTWAtmos extends BTWAddon {
    private static final Logger log = LogManager.getLogger(BTWAtmos.class);
    public static BTWAtmos instance;
    public static LiteModMAtmos mod_instance;

    public BTWAtmos() {
        super();
    }

    @Override
    public void initialize() {
        log.info(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        mod_instance = new LiteModMAtmos();
    }
}