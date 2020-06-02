package com.ews.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TopazBlock extends BlockBase {

    public TopazBlock(String name, Material material) {
        super(name, material);
        
        setSoundType(SoundType.METAL);
        setHardness(7.8F);
        setResistance(25.0F);
        setHarvestLevel("pickaxe", 3);

    }
    
}