package com.ews.items.EnergyItems;

import java.util.List;

import com.ews.items.ItemBase;

import cofh.redstoneflux.api.IEnergyContainerItem;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.energy.CapabilityEnergy;

public class EnergyContainerItem extends ItemBase implements IEnergyContainerItem{
    
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new EnergyItemCapabilityProvider(stack, capacity);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
            tooltip.add(stack.getCapability(CapabilityEnergy.ENERGY, null).getEnergyStored() + "/" + stack.getCapability(CapabilityEnergy.ENERGY, null).getMaxEnergyStored() + " RF");
        }
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        if (!stack.hasCapability(CapabilityEnergy.ENERGY, null))
            return 1D;
        double damage = 1D - ((double) stack.getCapability(CapabilityEnergy.ENERGY, null).getEnergyStored() / (double) stack.getCapability(CapabilityEnergy.ENERGY, null).getMaxEnergyStored());
        return damage;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return true;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!isInCreativeTab(tab))
            return;

        ItemStack empty = new ItemStack(this);
        ItemStack full = new ItemStack(this);
        full.getCapability(CapabilityEnergy.ENERGY, null).receiveEnergy(full.getCapability(CapabilityEnergy.ENERGY, null).getMaxEnergyStored(), false);

        items.add(empty);
        items.add(full);
    }
    public static class EnergyItemCapabilityProvider<NBTBase> implements ICapabilitySerializable {

        final ItemStack stack;
        final IEnergyStorage energyCap;

        public EnergyItemCapabilityProvider(ItemStack stack, int capacity) {
            this.stack = stack;
            this.energyCap = new EnergyStorage(capacity);
        }

        @Override
        public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
            return capability == CapabilityEnergy.ENERGY;
        }

        @Override
        public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
            return CapabilityEnergy.ENERGY.cast(energyCap);
        }

        @Override
        public net.minecraft.nbt.NBTBase serializeNBT() {
            return CapabilityEnergy.ENERGY.getStorage().writeNBT(CapabilityEnergy.ENERGY, energyCap, null);
        }

        @Override
        public void deserializeNBT(net.minecraft.nbt.NBTBase nbt) {
            CapabilityEnergy.ENERGY.getStorage().readNBT(CapabilityEnergy.ENERGY, energyCap, null, nbt);
        }

    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        if (container.hasCapability(CapabilityEnergy.ENERGY, null))
            return container.getCapability(CapabilityEnergy.ENERGY, null).receiveEnergy(maxReceive, simulate);
        return 0;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        if (container.hasCapability(CapabilityEnergy.ENERGY, null))
            return container.getCapability(CapabilityEnergy.ENERGY, null).extractEnergy(maxExtract, simulate);
        return 0;
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        if (container.hasCapability(CapabilityEnergy.ENERGY, null))
            return container.getCapability(CapabilityEnergy.ENERGY, null).getEnergyStored();
        return 0;
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        if (container.hasCapability(CapabilityEnergy.ENERGY, null))
            return container.getCapability(CapabilityEnergy.ENERGY, null).getMaxEnergyStored();
        return 0;
    }





    public int capacity;

    public EnergyContainerItem(String name, int capacity){
    super(name);
    this.capacity = capacity;
    
    // wait whaaaat
    }
	
	
	






}