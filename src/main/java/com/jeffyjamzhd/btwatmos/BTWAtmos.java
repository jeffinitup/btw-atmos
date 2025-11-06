package com.jeffyjamzhd.btwatmos;

import btw.BTWAddon;
import eu.ha3.matmos.game.mod.LiteModMAtmos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BTWAtmos extends BTWAddon {
    public static final Logger LOGGER = LogManager.getLogger(BTWAtmos.class);
    public static BTWAtmos ADDON_INSTANCE;
    public static LiteModMAtmos MATMOS;

    public BTWAtmos() {
        super();
    }

    @Override
    public void initialize() {
        MATMOS = new LiteModMAtmos();
        LOGGER.info(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }
}