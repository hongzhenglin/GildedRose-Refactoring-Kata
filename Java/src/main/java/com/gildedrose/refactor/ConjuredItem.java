package com.gildedrose.refactor;

import com.gildedrose.Item;

/**
 * 功能：
 *
 * @author linhongz
 * @date 2019-08-27 10:28
 */
public class ConjuredItem implements CustomisedItem {
    private final Item item;

    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateItemState() {
        descreasSellByOne();
        if (sellOverZero()) {
            descreaseQualityByTwo();
        } else {
            decreaseQualityByFour();
        }
    }

    private void decreaseQualityByFour() {
        item.quality -= 4;
    }

    private void descreaseQualityByTwo() {
        item.quality -= 2;
    }

    private boolean sellOverZero() {
        return item.sellIn > 0;
    }

    private void descreasSellByOne() {
        item.sellIn -= 1;
    }
}
