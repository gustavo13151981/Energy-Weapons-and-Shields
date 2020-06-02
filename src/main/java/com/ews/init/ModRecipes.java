package com.ews.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init() {

        GameRegistry.addSmelting(ModBlocks.RUBY_ORE, new ItemStack(ModItems.RUBY, 1), 2.5f);
        GameRegistry.addSmelting(ModBlocks.TOPAZ_ORE, new ItemStack(ModItems.TOPAZ, 1), 3.5f);


    }
    
}