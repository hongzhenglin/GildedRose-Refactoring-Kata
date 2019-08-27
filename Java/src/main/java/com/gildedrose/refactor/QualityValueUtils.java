package com.gildedrose.refactor;

import com.gildedrose.Item;

/**
 * 功能：
 *
 * @author linhongz
 * @date 2019-08-27 14:22
 */
public class QualityValueUtils {
    public static int highestValuePossible(Item item) {
        if (CustomisedItemFactory.SULFURAS.equals(item.name)) {
            return 80;
        }

        return 50;
    }
}
