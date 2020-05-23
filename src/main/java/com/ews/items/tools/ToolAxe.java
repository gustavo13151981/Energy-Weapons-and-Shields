package com.ews.items.tools;

import com.ews.Main;
import com.ews.init.ModItems;
import com.ews.util.IHasModel;
import net.minecraft.item.ItemAxe;



public class ToolAxe extends ItemAxe implements IHasModel{
    public ToolAxe(String name, ToolMaterial material){

        super(material, 6.5F, -3.2F);
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