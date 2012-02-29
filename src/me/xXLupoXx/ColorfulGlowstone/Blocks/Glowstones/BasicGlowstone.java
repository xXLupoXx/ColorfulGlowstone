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

package me.xXLupoXx.ColorfulGlowstone.Blocks.Glowstones;

import me.xXLupoXx.ColorfulGlowstone.ColorfulGlowstone;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.craftbukkit.CraftChunk;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class BasicGlowstone extends GenericCustomBlock
{
    
    private int ColorID;
    
    public BasicGlowstone(ColorfulGlowstone plugin, String name, int id, int cid) {
        super(plugin, name, false, new GenericCubeBlockDesign(plugin, plugin.BlockTex, id));
        this.getBlockDesign().setMinBrightness(0.1F).setMaxBrightness(1F)
                .setBrightness(0);
        design.setRenderPass(1);
        ColorID = cid;
        this.setHardness(SpoutManager.getMaterialManager().getHardness(MaterialData.glass));
        this.setItemDrop(new SpoutItemStack(MaterialData.glowstoneDust, 4));
        setLightLevel(15);
    }


    public int getColorID()
    {
        return ColorID;
    }
    
    @Override
    public void onBlockDestroyed(World world, int x, int y, int z)
    {
        Chunk ch = world.getBlockAt(x,y,z).getChunk();

        ((CraftChunk)world.getChunkAt(ch.getX(),ch.getZ())).getHandle().initLighting();

        System.out.println("------CHUNK XC:"+ch.getX()+" ZC:"+ch.getZ()+"-----------------");

        for(int xc = ch.getX()-2;xc<ch.getX()+2;xc++)
        {
            for(int zc = ch.getZ()-2;zc<ch.getZ()+2;zc++)
            {

                System.out.println("---------XC:"+xc+" ZC:"+zc+"-----------------");

                ((CraftChunk)world.getChunkAt(xc,zc)).getHandle().initLighting();
            }
        }

    }


}
