package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.refactor.CustomisedItemFactory;
import org.junit.Test;

public class GildedRoseTest {


    @Test
    public void foo() {
        GildedRose app = newGildedRose("foo", 0, 0);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    public void should_decreases_sell_by_dayNumber_eachTime() {
        GildedRose gildedRose = newGildedRose("Standard item", 0, 10);
        gildedRose.updateQuality();
        assertEquals(-1, itemSellByDayNumber(gildedRose));
    }


    @Test
    public void standardItem_decrease_qaulity_by_dayNumber_eachTime() {

        GildedRose gildedRose = newGildedRose("Standard item", 10, 10);
        gildedRose.updateQuality();
        assertEquals(9, itemQualityValue(gildedRose));
    }


    @Test
    public void standardItem_decreases_quality_by_two_when_sellin_is_zero_or_less() {
        GildedRose gildedRose = newGildedRose("foo", 0, 5);
        gildedRose.updateQuality();
        assertEquals(3, itemQualityValue(gildedRose));
    }

    @Test
    public void standardItem_cannot_have_quality_below_zero() {
        GildedRose gildedRose = newGildedRose("foo",0,0);
        gildedRose.updateQuality();
        assertEquals(0,itemQualityValue(gildedRose));
    }

    @Test
    public void brie_quaylity_increases_by_eachTime() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.AGED_BRIE, 10, 10);
        gildedRose.updateQuality();
        assertEquals(11, itemQualityValue(gildedRose));
    }



    @Test
    public void brie_quality_cannot_above_fifty_when_increasing() {
        GildedRose app = newGildedRose(CustomisedItemFactory.AGED_BRIE, 1, 49);

        app.updateQuality();
        app.updateQuality();

        assertEquals(50, itemQualityValue(app));
    }

    @Test
    public void backstagePasses_decreases_sell_by_eachTime() {
        GildedRose app = newGildedRose(CustomisedItemFactory.BACKSTAGE_PASSES_ITEM, 0, 0);

        app.updateQuality();

        assertEquals(-1, itemSellByDayNumber(app));
    }


    @Test
    public void conjured_decreases_sell_by_eachTime() {
        GildedRose app = newGildedRose(CustomisedItemFactory.CONJURED_ITEM, 0, 0);

        app.updateQuality();

        assertEquals(-1, itemSellByDayNumber(app));
    }

    @Test
    public void brie_increase_quality_eachTime() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.AGED_BRIE, 1, 1);
        gildedRose.updateQuality();
        assertEquals(2, itemQualityValue(gildedRose));
    }


    @Test
    public void brie_qaulity_shoudnot_above_fifty_when_incresing() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.AGED_BRIE, 1, 49);
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        assertEquals(50, itemQualityValue(gildedRose));
    }

    @Test
    public void sulfuras_has_quality_eighty() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.SULFURAS, 1, 80);
        assertEquals(80, itemQualityValue(gildedRose));
    }

    @Test
    public void sulfuras_not_decrease_sellIn() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.SULFURAS, 1, 80);
        gildedRose.updateQuality();
        assertEquals(1, itemSellByDayNumber(gildedRose));
    }

    @Test
    public void sulfuras_not_decrease_quality() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.SULFURAS, 1, 80);
        gildedRose.updateQuality();
        assertEquals(80, itemQualityValue(gildedRose));
    }

    @Test
    public void backstagePass_quality_increase_one_when_sellIn_eleven() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.BACKSTAGE_PASSES_ITEM, 12, 1);
        gildedRose.updateQuality();
        assertEquals(2, itemQualityValue(gildedRose));

    }


    @Test
    public void backstagePass_quality_increase_two_when_sellIn_ten() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.BACKSTAGE_PASSES_ITEM, 10, 1);
        gildedRose.updateQuality();
        assertEquals(3, itemQualityValue(gildedRose));
    }


    @Test
    public void backstagePass_quality_increase_one_when_sellIn_five() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.BACKSTAGE_PASSES_ITEM, 5, 1);
        gildedRose.updateQuality();
        assertEquals(4, itemQualityValue(gildedRose));

    }


    @Test
    public void backstagePass_quality_drops_to_zero_when_sellIn_zero_or_less() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.BACKSTAGE_PASSES_ITEM, 0, 5);
        gildedRose.updateQuality();
        assertEquals(0, itemQualityValue(gildedRose));

    }

    @Test
    public void backstagePass_quality_cannot_over_fitty_when_increasing() {
        GildedRose gildedRose = newGildedRose(CustomisedItemFactory.BACKSTAGE_PASSES_ITEM, 10, 50);
        gildedRose.updateQuality();
        assertEquals(50, itemQualityValue(gildedRose));
    }

    //未实现
    @Test
    public void conjured_decreases_quality_by_two_if_sell_above_zero() {
        GildedRose app = newGildedRose( CustomisedItemFactory.CONJURED_ITEM, 2, 5);

        app.updateQuality();

        assertEquals(3, itemQualityValue(app));
    }

    //未实现
    @Test
    public void conjured_decreases_quality_by_four_when_sell_is_zero_or_less() {
        GildedRose app = newGildedRose( CustomisedItemFactory.CONJURED_ITEM,0, 5);

        app.updateQuality();

        assertEquals(1, itemQualityValue(app));
    }

    @Test
    public void conjured_cannot_have_quality_below_zero() {
        GildedRose app = newGildedRose( CustomisedItemFactory.CONJURED_ITEM, 0, 0);

        app.updateQuality();

        assertEquals(0, itemQualityValue(app));
    }

    private int itemSellByDayNumber(GildedRose gildedRose) {
        return gildedRose.items[0].sellIn;
    }


    private GildedRose newGildedRose(String itemName, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
        return new GildedRose(items);
    }

    private int itemQualityValue(GildedRose app) {
        return app.items[0].quality;
    }


}
