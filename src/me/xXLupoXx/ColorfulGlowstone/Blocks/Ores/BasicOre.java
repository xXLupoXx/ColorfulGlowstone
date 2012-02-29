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

package me.xXLupoXx.ColorfulGlowstone.Blocks.Ores;

import me.xXLupoXx.ColorfulGlowstone.ColorfulGlowstone;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;


public class BasicOre extends GenericCubeCustomBlock {



        private int miny = 0, maxy = 126, frequency = 0, maxDump = 0;

        public BasicOre(ColorfulGlowstone plugin, String name, int id) {
            super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.BlockTex,
                    id));
            this.getBlockDesign().setMinBrightness(0.1F).setMaxBrightness(1).setBrightness(0);
        }

        public BasicOre(ColorfulGlowstone plugin, String name, int id, int miny, int maxy,
                     int fr, int maxD) {
            super(plugin, name, new GenericCubeBlockDesign(plugin, plugin.BlockTex,
                    id));
            this.getBlockDesign().setMinBrightness(0.1F).setMaxBrightness(1).setBrightness(0);
            this.miny = miny;
            this.maxy = maxy;
            this.frequency = fr;
            this.maxDump = maxD;
        }

        public void setMinY(int i) {
            this.miny = i;
        }

        public void setMaxY(int i) {
            this.maxy = i;
        }

        public int getMinY() {
            return this.miny;
        }

        public int getMaxY() {
            return this.maxy;
        }

        public void setFrequency(int i) {
            this.frequency = i;
        }

        public int getFrequency() {
            return this.frequency;
        }

        public void setMaxDump(int i) {
            this.maxDump = i;
        }

        public int getMaxDump() {
            return this.maxDump;
        }

        @Override
        public boolean isIndirectlyProvidingPowerTo(World arg0, int arg1, int arg2,
                                                    int arg3, BlockFace arg4) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isProvidingPowerTo(World arg0, int arg1, int arg2, int arg3,
                                          BlockFace arg4) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void onBlockClicked(World arg0, int arg1, int arg2, int arg3,
                                   SpoutPlayer arg4) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onBlockDestroyed(World arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onBlockInteract(World arg0, int arg1, int arg2, int arg3,
                                       SpoutPlayer arg4) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void onBlockPlace(World arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onBlockPlace(World arg0, int arg1, int arg2, int arg3,
                                 LivingEntity arg4) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onEntityMoveAt(World arg0, int arg1, int arg2, int arg3,
                                   Entity arg4) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onNeighborBlockChange(World arg0, int arg1, int arg2, int arg3,
                                          int arg4) {
            // TODO Auto-generated method stub

        }

    }


