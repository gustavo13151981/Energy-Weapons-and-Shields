package com.ews.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RubyOre extends BlockBase {

    public RubyOre(String name, Material material) {
        super(name, material);
        
        setSoundType(SoundType.STONE);
        setHardness(8.0F);
        setResistance(25.0F);
        setLightLevel(5);
        setHarvestLevel("pickaxe", 2);

    }
    
}