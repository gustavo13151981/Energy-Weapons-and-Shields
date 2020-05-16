package com.ews.energyweaponsandshields.items;

import com.ews.energyweaponsandshields.Main;
import com.ews.energyweaponsandshields.init.ModItems;
import com.ews.energyweaponsandshields.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{

	
	public ItemBase(String name){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}
	
	
	
	@Override
	public void registerModels(){
		
	Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
