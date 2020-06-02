package com.ews.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TopazOre extends BlockBase {

    public TopazOre(String name, Material material) {
        super(name, material);
        
        setSoundType(SoundType.STONE);
        setHardness(8.0F);
        setResistance(25.0F);
        setLightLevel(5);
        setHarvestLevel("pickaxe", 2);

    }
    
}