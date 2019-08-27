package com.gildedrose.refactor;

import com.gildedrose.Item;

/**
 * 功能：
 *
 * @author linhongz
 * @date 2019-08-27 10:33
 */
public class BackstagePassesItem implements CustomisedItem {
    private final Item item;

    public BackstagePassesItem(Item item) {
        this.item = item;

    }

    @Override
    public void updateItemState() {
        decreaseSellByOne();
        if (sellIsOver(10)) {
            increaseQuality(1);
        } else if (sellIsOver(5)) {
            increaseQuality(2);
        } else if (sellIsOver(0)) {
            increaseQuality(3);
        } else {
            dropQualityToZero();
        }
    }

    private void dropQualityToZero() {
        item.quality = 0;
    }

    private boolean sellIsOver(int sellValue) {
        return item.sellIn > sellValue;
    }

    private void increaseQuality(int qualityValue) {
        item.quality += qualityValue;
    }

    private void decreaseSellByOne() {
        item.sellIn -= 1;
    }
}
