package com.gildedrose.refactor;

import com.gildedrose.Item;

/**
 * 功能：
 *
 * @author linhongz
 * @date 2019-08-27 10:12
 */
public class StandardItem implements CustomisedItem {


    private final Item item;

    public StandardItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateItemState() {
        decreaseSellByDayValueWithOne();
        if (sellIsOverZero()) {
            decreaseQualityBy(1);
        } else {
            decreaseQualityBy(2);
        }
    }


    private void decreaseQualityBy(int qualityValue) {
        item.quality -= qualityValue;
    }

    private boolean sellIsOverZero() {
        return item.sellIn > 0;
    }

    private void decreaseSellByDayValueWithOne() {
        item.sellIn -= 1;
    }
}
