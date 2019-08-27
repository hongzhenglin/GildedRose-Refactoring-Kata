package com.gildedrose;

import com.gildedrose.refactor.CustomisedItem;
import com.gildedrose.refactor.CustomisedItemFactory;
import com.gildedrose.refactor.QualityValueUtils;

class GildedRose {
    public static final int LOWEST_QUALITY_VALUE = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            customisedItem(item).updateItemState();
            if (hasReachedLowestQualityValue(item)) {
                item.quality = LOWEST_QUALITY_VALUE;
            } else if (hasReachedHighestQualityValue(item)) {
                item.quality = QualityValueUtils.highestValuePossible(item);
            }
        }
    }

    private boolean hasReachedHighestQualityValue(Item item) {
        return item.quality > QualityValueUtils.highestValuePossible(item);
    }

    private boolean hasReachedLowestQualityValue(Item item) {
        return item.quality < LOWEST_QUALITY_VALUE;
    }

    private CustomisedItem customisedItem(Item item) {
        return CustomisedItemFactory.getCustomiseItem(item);
    }
}