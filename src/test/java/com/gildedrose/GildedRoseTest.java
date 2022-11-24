package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void GIVEN_Item_WHEN_QualityDropsToZero_THEN_QualityCannotBeZero(){
        Item[] items = new Item[1];
        items[0] = new Item("Test",0,0);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Test",-1,0);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_Item_WHEN_NoSpecialConditions_THEN_QualityDecrease(){
        Item[] items = new Item[1];
        items[0] = new Item("Test",10,10);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Test",9,9);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_Item_WHEN_SellInExpires_THEN_QualityDecreaseFaster(){
        Item[] items = new Item[1];
        items[0] = new Item("Test",0,10);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Test",-1,8);
        assertEquals(expected.toString(),actual.toString());
    }

}
