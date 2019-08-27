package com.gildedrose.refactor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 功能：
 *
 * @author linhongz
 * @date 2019-08-26 16:03
 */
public class GoodsTest   {
    @Test
    public void should_double_down_when_sellIn_over() {
        Goods goods = new Goods("",10,40);
        int quality = goods.currentQuality(11);
        assertEquals(20,quality);
    }
}
