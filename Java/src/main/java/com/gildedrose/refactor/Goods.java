package com.gildedrose.refactor;

/**
 * 功能：
 *
 * @author linhongz
 * @date 2019-08-26 16:05
 */
public class Goods {
    private static final int MAX_QUALITY = 50;
    private final String goodsName;
    private final int quality;
    private final int sellId;


    public Goods(String goodsNams, int sellId, int quality) {
        this.goodsName = goodsNams;
        this.sellId = sellId;
        this.quality = quality;
    }

    public int currentQuality(int sellDays) {
        if("Sulfuras".equals(goodsName)){
            return  quality;
        }
        if (sellDays > sellId) {
            return quality / 2;
        }
        return 0;
    }
}
