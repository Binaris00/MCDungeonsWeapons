package chronosacaria.mcdw.enums;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.bases.McdwShield;
import chronosacaria.mcdw.items.ItemsInit;

import java.util.EnumMap;
import java.util.HashMap;

public enum ShieldsID implements McdwWeaponID {
    SHIELD_ROYAL_GUARD,
    SHIELD_VANGUARD;

    public HashMap<ShieldsID, Boolean> getEnabledItems(){
        return Mcdw.CONFIG.mcdwEnableItemsConfig.shieldsEnabled;
    }

    public EnumMap<ShieldsID, McdwShield> getItemsEnum() {
        return ItemsInit.shieldItems;
    }

    public HashMap<ShieldsID, Float> getSpawnRates() {
        return Mcdw.CONFIG.mcdwNewlootConfig.shieldSpawnRates;
    }

    public Boolean isEnabled(){
        return getEnabledItems().get(this);
    }

    @Override
    public McdwShield getItem() {
        return getItemsEnum().get(this);
    }

    @Override
    public Float getItemSpawnRate() {
        return getSpawnRates().get(this);
    }
}
