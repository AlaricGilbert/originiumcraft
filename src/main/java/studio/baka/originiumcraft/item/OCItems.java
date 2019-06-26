package studio.baka.originiumcraft.item;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/* The class initializes all the items of OriginiumCraft mod. */
public class OCItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item ADVANCED_CERTIFICATE = new ItemBase("advanced_certificate");
    public static final Item ARTIFICIAL_ORIGINIUM = new ItemBase("artificial_originium");
    public static final Item COMBAT_RECORD_ADVANCED = new ItemBase("combat_record_advanced");
    public static final Item COMBAT_RECORD_BASIC = new ItemBase("combat_record_basic");
    public static final Item COMBAT_RECORD_MEDIUM = new ItemBase("combat_record_medium");
    public static final Item COMBAT_RECORD_PRIMARY = new ItemBase("combat_record_primary");
    public static final Item LONGMEN_COIN =  new ItemBase("longmen_coin");
    public static final Item ORIGINIUM = new ItemOriginium();
    public static final Item PRECLINICAL_ARTS_1 = new ItemBase("preclinical_art_1");
    public static final Item PRECLINICAL_ARTS_2 = new ItemBase("preclinical_art_2");
    public static final Item PRECLINICAL_ARTS_3 = new ItemBase("preclinical_art_3");
    public static final Item PURCHASE_CERTIFICATE = new ItemBase("purchase_certificate");
    public static final Item QUALIFICATION_CERTIFICATE = new ItemBase("qualification_certificate");
}
