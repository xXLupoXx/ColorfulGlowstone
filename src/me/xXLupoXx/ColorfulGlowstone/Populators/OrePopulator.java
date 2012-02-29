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

package me.xXLupoXx.ColorfulGlowstone.Populators;

import me.xXLupoXx.ColorfulGlowstone.BlockMap;
import me.xXLupoXx.ColorfulGlowstone.Blocks.Ores.AmberOre;
import me.xXLupoXx.ColorfulGlowstone.Blocks.Ores.BasicOre;
import me.xXLupoXx.ColorfulGlowstone.ColorfulGlowstone;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.MaterialManager;

import java.util.Random;
import java.util.logging.Logger;

public class OrePopulator extends BlockPopulator
{

    int popcount = 0;
    
    private MaterialManager itm = SpoutManager.getMaterialManager();
    public static final Logger log = Logger.getLogger("Minecraft");

    ColorfulGlowstone plugin;

    public OrePopulator(ColorfulGlowstone colorfulGlowstone)
    {
        plugin = colorfulGlowstone;
    }

    @Override
    public void populate(World world, Random random, Chunk source)
    {
        for (BasicOre block: BlockMap.ores) {

            if(!(block instanceof AmberOre))
            {
                for (int j = 0; j < block.getFrequency(); j++) {
                    internal(source, random, random.nextInt(16),random.nextInt(block.getMaxY()), random.nextInt(16),block.getMaxDump(), block);
                }
                log.info("-----Pupolated:"+block.getName()+":"+popcount+"-------");
                popcount= 0;
            }
        }
    }
    private void internal(Chunk source, Random random, int originX,
                          int originY, int originZ, int amount, BasicOre type) {
        for (int i = 0; i < amount; i++) {
            int x = originX + random.nextInt(amount / 2) - amount / 4;
            int y = originY + random.nextInt(amount / 4) - amount / 8;
            int z = originZ + random.nextInt(amount / 2) - amount / 4;
            x &= 0xf;
            z &= 0xf;
            if (y > 127 || y < 0) {
                continue;
            }
            Block block = source.getBlock(x, y, z);
            if (block.getTypeId() == 1) {
                itm.overrideBlock(block,type);
                popcount++;
            }


        }
    }
}
