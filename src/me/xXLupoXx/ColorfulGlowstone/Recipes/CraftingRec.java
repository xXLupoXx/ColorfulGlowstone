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

package me.xXLupoXx.ColorfulGlowstone.Recipes;

import me.xXLupoXx.ColorfulGlowstone.BlockMap;
import me.xXLupoXx.ColorfulGlowstone.Blocks.Glowstones.BasicGlowstone;
import me.xXLupoXx.ColorfulGlowstone.ColorfulGlowstone;
import me.xXLupoXx.ColorfulGlowstone.Items.Crystals.BasicCrystal;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;

import java.util.Iterator;

public class CraftingRec
{
    
    ColorfulGlowstone plugin;
    
    public CraftingRec(ColorfulGlowstone p)
    {
        plugin = p;
        registerGlowstoneRecipes();
    }

    private void registerGlowstoneRecipes()
    {

        Iterator<BasicGlowstone> GSIT = BlockMap.glowstones.iterator();
        Iterator<BasicCrystal> CRYIT;
        SpoutItemStack result;
        SpoutShapedRecipe recipe;

        while (GSIT.hasNext())
        {
            BasicGlowstone tempg = GSIT.next();
            CRYIT = BlockMap.crystals.iterator();

            while(CRYIT.hasNext())
            {
                BasicCrystal tempc = CRYIT.next();
                if(tempc.getColorID() == tempg.getColorID())
                {
                    System.out.println("---------------"+tempg.getName()+"-------------------");
                    System.out.println("---------------"+tempc.getName()+"-------------------");
                    result=new SpoutItemStack(tempg);
                    recipe = new SpoutShapedRecipe(result);
                    recipe.shape("XXX","XAX","XBX");
                    recipe.setIngredient('A', MaterialData.glowstoneBlock);
                    recipe.setIngredient('B',tempc);
                    SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
                    break;
                }
            }


        }

       /*
        result = new SpoutItemStack(new RedGlowstone(plugin));
        recipe = new SpoutShapedRecipe(result);
        recipe.shape("XXX","XAX","XBX");
        recipe.setIngredient('A', MaterialData.glowstoneBlock);
        recipe.setIngredient('B',new Ruby(plugin));
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);

        */

    }
    
}
