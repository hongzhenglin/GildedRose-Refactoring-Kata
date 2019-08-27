package com.gildedrose.refactor;

import com.gildedrose.Item;

/**
 * 功能：
 *
 * @author linhongz
 * @date 2019-08-27 10:22
 */
public class AgedBrieItem implements CustomisedItem {


    private Item item;

    public AgedBrieItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateItemState() {
        decreaseSellByOne();
        increaseQualityByOne();
    }

    private void increaseQualityByOne() {
        item.quality += 1;
    }

    private void decreaseSellByOne() {
        item.sellIn -= 1;
    }
}
