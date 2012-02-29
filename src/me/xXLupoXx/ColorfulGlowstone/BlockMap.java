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


import me.xXLupoXx.ColorfulGlowstone.Blocks.Glowstones.*;
import me.xXLupoXx.ColorfulGlowstone.Blocks.Ores.*;
import me.xXLupoXx.ColorfulGlowstone.Items.Crystals.*;

import java.util.HashSet;
import java.util.Set;


public class BlockMap {

    public static Set<BasicOre> ores = new HashSet<BasicOre>();
    public static Set<BasicCrystal> crystals = new HashSet<BasicCrystal>();
    public static Set<BasicGlowstone> glowstones = new HashSet<BasicGlowstone>();

    public static void loadStuff(ColorfulGlowstone plugin)
    {

        //Add all Ores to list of known Ores
        ores.add(new RubyOre(plugin));
        ores.add(new SapphireOre(plugin));
        ores.add(new AmberOre(plugin));
        ores.add(new Black_OpalOre(plugin));
        ores.add(new CitrineOre(plugin));
        ores.add(new EmeraldOre(plugin));
        ores.add(new QuartzOre(plugin));
        ores.add(new AmethystOre(plugin));

        //Add all Crystals
        crystals.add(new Ruby(plugin));
        crystals.add(new Black_Opal(plugin));
        crystals.add(new Sapphire(plugin));
        crystals.add(new Emerald(plugin));
        crystals.add(new Amber(plugin));
        crystals.add(new Amethyst(plugin));
        crystals.add(new Quartz(plugin));
        crystals.add(new Citrine(plugin));




        //Add Glowstones
        glowstones.add(new RedGlowstone(plugin));
        glowstones.add(new BlackGlowstone(plugin));
        glowstones.add(new BlueGlowstone(plugin));
        glowstones.add(new GreenGlowstone(plugin));
        glowstones.add(new OrangeGlowstone(plugin));
        glowstones.add(new PurpleGlowstone(plugin));
        glowstones.add(new WhiteGlowstone(plugin));
        glowstones.add(new YellowGlowstone(plugin));

    }

}
