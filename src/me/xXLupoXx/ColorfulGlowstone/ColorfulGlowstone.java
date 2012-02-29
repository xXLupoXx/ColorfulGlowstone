/*
 * Copyright (c) <2012> <xXLupoXx>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package me.xXLupoXx.ColorfulGlowstone;



import me.xXLupoXx.ColorfulGlowstone.Populators.OrePopulator;
import me.xXLupoXx.ColorfulGlowstone.Recipes.CraftingRec;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.plugin.java.JavaPlugin;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.player.FileManager;
import java.util.logging.Logger;


public class ColorfulGlowstone extends JavaPlugin {

    public static Logger log = Logger.getLogger("Minecraft");
    public Texture BlockTex;
    public String URL = "http://dl.dropbox.com/u/25304824";
    
    
    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {

        preloadTextures();

        loadTextures();

        BlockMap.loadStuff(this);

        new CraftingRec(this);
        populateWorlds();
        
        getCommand("test").setExecutor(new Test(this));


    }

    private void loadTextures()
    {
        BlockTex = new Texture(this,URL+"/Blocks.png",512,512,32);

    }

    private void preloadTextures()
    {
        FileManager fm = SpoutManager.getFileManager();
        fm.addToPreLoginCache(this, URL + "/Blocks.png");
        fm.addToPreLoginCache(this, URL + "/Crystals/amber.png");
        fm.addToPreLoginCache(this, URL + "/Crystals/amethyst.png");
        fm.addToPreLoginCache(this, URL + "/Crystals/blackopal.png");
        fm.addToPreLoginCache(this, URL + "/Crystals/citrine.png");
        fm.addToPreLoginCache(this, URL + "/Crystals/emerald.png");
        fm.addToPreLoginCache(this, URL + "/Crystals/quartz.png");
        fm.addToPreLoginCache(this, URL + "/Crystals/ruby.png");
        fm.addToPreLoginCache(this, URL + "/Crystals/sapphire.png");
    }

    public void populateWorlds() {
        for (World current : this.getServer().getWorlds()) {
            if (current.getEnvironment() == Environment.NORMAL) {
                current.getPopulators().add(new OrePopulator(this));
                log.info("Added Populators to World:" + current.getName());
            }
        }
    }
}
