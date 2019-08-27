package com.gildedrose.refactor;

import com.gildedrose.Item;

/**
 * 功能：
 *
 * @author linhongz
 * @date 2019-08-27 10:26
 */
public class SulfurasItem implements CustomisedItem {
    private final Item item;

    public SulfurasItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateItemState() {
        item.quality =80;
    }
}
