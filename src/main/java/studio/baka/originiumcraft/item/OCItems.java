package studio.baka.originiumcraft.item;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/* The class initializes all the items of OriginiumCraft mod. */
public class OCItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item ARTIFICIAL_ORIGINIUM = new ItemBase("artificial_originium");
    public static final Item ORIGINIUM = new ItemOriginium();
    public static final Item LONGMEN_COIN =  new ItemBase("longmen_coin");

}
