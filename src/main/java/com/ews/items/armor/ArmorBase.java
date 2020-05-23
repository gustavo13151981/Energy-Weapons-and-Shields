package com.ews.items.armor;

import com.ews.Main;
import com.ews.init.ModItems;
import com.ews.util.IHasModel;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel {

    public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.EWS_TAB);
		
		ModItems.ITEMS.add(this);
    }
    
	@Override
	public void registerModels(){
		
	Main.proxy.registerItemRenderer(this, 0, "inventory");
	}


}