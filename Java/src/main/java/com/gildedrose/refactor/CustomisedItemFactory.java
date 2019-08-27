package com.gildedrose.refactor;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能：
 *
 * @author linhongz
 * @date 2019-08-27 12:50
 */
public class CustomisedItemFactory {

    private static Map<String, CustomisedItem> ITEM_TYPE_LIST = new HashMap<>();

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_ITEM = "Conjured";

    private CustomisedItemFactory() {

    }

    public static CustomisedItem getCustomiseItem(Item item) {
        CustomisedItem customisedItem = null;
        switch (item.name) {
            case AGED_BRIE:
                customisedItem = new AgedBrieItem(item);
                break;
            case SULFURAS:
                customisedItem = new SulfurasItem(item);
                break;
            case BACKSTAGE_PASSES_ITEM:
                customisedItem = new BackstagePassesItem(item);
                break;
            case CONJURED_ITEM:
                customisedItem = new ConjuredItem(item);
                break;
            default:
                customisedItem = new StandardItem(item);
                break;
        }
        return customisedItem;
    }


}
