package com.ews.creativetabs;

import com.ews.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EwsTab extends CreativeTabs {

        public EwsTab() {
            super("ews");
            
            setBackgroundImageName("item_search.png");

	}
    
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.RUBY);
    }

    @Override
    public boolean hasSearchBar() {
    return true;
    }
}