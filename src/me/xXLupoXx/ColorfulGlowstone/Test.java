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

import me.xXLupoXx.ColorfulGlowstone.Blocks.Ores.AmberOre;
import me.xXLupoXx.ColorfulGlowstone.Blocks.Ores.RubyOre;
import me.xXLupoXx.ColorfulGlowstone.Blocks.Ores.SapphireOre;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.inventory.SpoutItemStack;

public class Test implements CommandExecutor
{                        
    ColorfulGlowstone gs;
    
    public Test(ColorfulGlowstone colorfulGlowstone)
    {
                         gs = colorfulGlowstone;
        
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
    {
        
        
        Player p = (Player)commandSender;

        RubyOre testo = new RubyOre(gs);
        AmberOre ambo = new AmberOre(gs);
        SapphireOre sapho = new SapphireOre(gs);

        p.getWorld().dropItemNaturally(p.getLocation(), new SpoutItemStack(testo.getBlockItem(), 1));
        p.getWorld().dropItemNaturally(p.getLocation(), new SpoutItemStack(ambo.getBlockItem(), 1));
        p.getWorld().dropItemNaturally(p.getLocation(), new SpoutItemStack(sapho.getBlockItem(), 1));
        p.getWorld().dropItemNaturally(p.getLocation(), new SpoutItemStack(ambo.getBlockItem(), 1));


        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
