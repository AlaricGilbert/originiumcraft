package studio.baka.originiumcraft.item;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/* The class initializes all the items of OriginiumCraft mod. */
public class OCItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();
    /* Special Items */
    public static final Item ADVANCED_CERTIFICATE = new ItemBase("advanced_certificate");
    public static final Item QUALIFICATION_CERTIFICATE = new ItemBase("qualification_certificate");
    public static final Item PURCHASE_CERTIFICATE = new ItemBase("purchase_certificate");
    public static final Item CREDIT_POINT = new ItemBase("credit_point");
    public static final Item LONGMEN_COIN =  new ItemBase("longmen_coin");
    public static final Item ORIGINIUM = new ItemOriginium();
    public static final Item ARTIFICIAL_ORIGINIUM = new ItemBase("artificial_originium");
    public static final Item ORIGINIUM_FRAGMENT = new ItemBase("originium_fragment");
    public static final Item PURE_GOLD = new ItemBase("pure_gold");

    /* Reinforcement Materials */
    public static final Item CARBON = new ItemBase("carbon");
    public static final Item CARBON_ELEMENT = new ItemBase("carbon_element");
    public static final Item CARBON_GROUP = new ItemBase("carbon_group");
    public static final Item BASIC_REINFORCEMENT_MATERIAL = new ItemBase("basic_reinforcement_material");
    public static final Item ADVANCED_REINFORCEMENT_MATERIAL = new ItemBase("advanced_reinforcement_material");
    public static final Item HIGHLEVEL_REINFORCEMENT_MATERIAL = new ItemBase("highlevel_reinforcement_material");
    public static final Item KEEL = new ItemBase("keel");

    /* Promotion Materials */
    // Level 4 Materials
    public static final Item D32_STEEL = new ItemBase("d32_steel");
    public static final Item BIPOLAR_NANOSHEET = new ItemBase("bipolar_nanosheet");
    public static final Item POLYMERIZER = new ItemBase("polymerizer");
    // Manganeses
    public static final Item MANGANESE = new ItemBase("manganese");
    public static final Item MANGANESE_WITH_THREE_WATER=new ItemBase("manganese_with_tree_water");
    // Alcohols
    public static final Item ALCOHOL_BAIMA = new ItemBase("alcohol_baima");
    public static final Item ALCOHOL_REVERSED = new ItemBase("alcohol_reversed");
    // Grinding Stones
    public static final Item GRINDING_STONE = new ItemBase("grinding_stone");
    public static final Item GRINDING_STONE_WITH_FIVE_WATER = new ItemBase("grinding_stone_with_five_water");
    // RMAs
    public static final Item RMA7012 = new ItemBase("rma7012");
    public static final Item RMA7024 = new ItemBase("rma7024");
    // Devices
    public static final Item DEVICE_BROKEN = new ItemBase("device_broken");
    public static final Item DEVICE = new ItemBase("device");
    public static final Item DEVICE_BRANDNEW = new ItemBase("device_brandnew");
    public static final Item DEVICE_MODIFIED = new ItemBase("device_modified");
    // Ketones
    public static final Item DIKETONE = new ItemBase("diketone");
    public static final Item KETONE_AGGLUTINATED = new ItemBase("ketone_agglutinated");
    public static final Item KETONE_AGGLUTINATED_GROUP = new ItemBase("ketone_agglutinated_group");
    public static final Item KETONE_ARRAY = new ItemBase("ketone_array");
    // Irregular Irons
    public static final Item IRREGULAR_IRON = new ItemBase("irregular_iron");
    public static final Item IRREGULAR_IRON_FRAGMENT = new ItemBase("irregular_iron_fragment");
    public static final Item IRREGULAR_IRON_GROUP = new ItemBase("irregular_iron_group");
    public static final Item IRREGULAR_IRON_INGOT = new ItemBase("irregular_iron_ingot");
    // Esters
    public static final Item ESTER_MATERIAL = new ItemBase("ester_material");
    public static final Item POLYESTER = new ItemBase("polyester");
    public static final Item POLYESTER_GROUP = new ItemBase("polyester_group");
    public static final Item POLYESTER_INGOT = new ItemBase("polyester_ingot");
    // Sugars
    public static final Item SUGAR = new ItemBase("sugar");
    public static final Item SUGAR_SUBSTITUTE = new ItemBase("sugar_substitute");
    public static final Item SUGAR_GROUP = new ItemBase("sugar_group");
    public static final Item SUGAR_INGOT = new ItemBase("sugar_ingot");
    // Originum Stones
    public static final Item ORIGINIUM_STONE = new ItemBase("originium_stone");
    public static final Item ORIGINIUM_STONE_PURIFIED = new ItemBase("originium_stone_purified");
    public static final Item ORIGINIUM_STONE_SOLIFIED = new ItemBase("originium_stone_solified");
    public static final Item ORIGINIUM_STONE_SOLIFIED_GROUP= new ItemBase("originium_stone_solified_group");

    /* Records */
    public static final Item COMBAT_RECORD_ADVANCED = new ItemBase("combat_record_advanced");
    public static final Item COMBAT_RECORD_BASIC = new ItemBase("combat_record_basic");
    public static final Item COMBAT_RECORD_MEDIUM = new ItemBase("combat_record_medium");
    public static final Item COMBAT_RECORD_PRIMARY = new ItemBase("combat_record_primary");

    /* PRECLINICAL_ARTS */
    public static final Item PRECLINICAL_ARTS_1 = new ItemBase("preclinical_art_1");
    public static final Item PRECLINICAL_ARTS_2 = new ItemBase("preclinical_art_2");
    public static final Item PRECLINICAL_ARTS_3 = new ItemBase("preclinical_art_3");

    /* Chips Related */
    // CHIP_ADDITIVE
    public static final Item CHIP_ADDITIVE = new ItemBase("chip_additive");
    // Caster Chips
    public static final Item CASTER_CHIP = new ItemBase("caster_chip");
    public static final Item CASTER_CHIPSET = new ItemBase("caster_chipset");
    public static final Item CASTER_DUALCHIPSET = new ItemBase("caster_dualchipset");
    // Defender Chips
    public static final Item DEFENDER_CHIP = new ItemBase("defender_chip");
    public static final Item DEFENDER_CHIPSET = new ItemBase("defender_chipset");
    public static final Item DEFENDER_DUALCHIPSET = new ItemBase("defender_dualchipset");
    // Guard Chips
    public static final Item GUARD_CHIP = new ItemBase("guard_chip");
    public static final Item GUARD_CHIPSET = new ItemBase("guard_chipset");
    public static final Item GUARD_DUALCHIPSET = new ItemBase("guard_dualchipset");
    // Medic Chips
    public static final Item MEDIC_CHIP = new ItemBase("medic_chip");
    public static final Item MEDIC_CHIPSET = new ItemBase("medic_chipset");
    public static final Item MEDIC_DUALCHIPSET = new ItemBase("medic_dualchipset");
    // Sniper Chips
    public static final Item SNIPER_CHIP = new ItemBase("sniper_chip");
    public static final Item SNIPER_CHIPSET = new ItemBase("sniper_chipset");
    public static final Item SNIPER_DUALCHIPSET = new ItemBase("sniper_dualchipset");
    // Specialist Chips
    public static final Item SPECIALIST_CHIP = new ItemBase("specialist_chip");
    public static final Item SPECIALIST_CHIPSET = new ItemBase("specialist_chipset");
    public static final Item SPECIALIST_DUALCHIPSET = new ItemBase("specialist_dualchipset");
    // Supporter Chips
    public static final Item SUPPORTTER_CHIP = new ItemBase("supporter_chip");
    public static final Item SUPPORTTER_CHIPSET = new ItemBase("supporter_chipset");
    public static final Item SUPPORTTER_DUALCHIPSET = new ItemBase("supporter_dualchipset");
    // Vanguard Chips
    public static final Item VANGUARD_CHIP = new ItemBase("vanguard_chip");
    public static final Item VANGUARD_CHIPSET = new ItemBase("vanguard_chipset");
    public static final Item VANGUARD_DUALCHIPSET = new ItemBase("vanguard_dualchipset");
}

