package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GildedRoseItemsTest {

    @Test
    void GIVEN_AgedBrie_WHEN_IncreaseInQuality_THEN_QualityIncrease(){
        Item[] items = new Item[1];
        items[0] = new Item("Aged Brie",2,2);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Aged Brie",1,3);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_AgedBrie_WHEN_DaysOff_THEN_QualityIncreaseDouble(){
        Item[] items = new Item[1];
        items[0] = new Item("Aged Brie",0,2);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Aged Brie",-1,4);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_AgedBrie_WHEN_QualityOver50_THEN_StopIncreaseQuality(){
        Item[] items = new Item[1];
        items[0] = new Item("Aged Brie",2,50);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Aged Brie",1,50);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_BackStagePasses_WHEN_Outside10Days_THEN_IncreaseQualityByOne(){
        Item[] items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert",20,2);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Backstage passes to a TAFKAL80ETC concert",19,3);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_BackStagePasses_WHEN_Inside10Days_THEN_IncreaseQualityByTwo(){
        Item[] items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert",10,2);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Backstage passes to a TAFKAL80ETC concert",9,4);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_BackStagePasses_WHEN_Inside5Days_THEN_IncreaseQualityBy3(){
        Item[] items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert",5,2);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Backstage passes to a TAFKAL80ETC concert",4,5);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_BackStagePasses_WHEN_SellInExpires_THEN_QualityGoesZero(){
        Item[] items = new Item[1];
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert",0,20);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Backstage passes to a TAFKAL80ETC concert",-1,0);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_Sulfuras_WHEN_Any_THEN_NaverChange(){
        Item[] items = new Item[1];
        items[0] = new Item("Sulfuras, Hand of Ragnaros",10,20);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Sulfuras, Hand of Ragnaros",10,20);
        assertEquals(expected.toString(),actual.toString());
    }

    ////////////////////////////////////////////////////////////////////////

    @Test
    void GIVEN_ConjuredManaCake_WHEN_NormalConditions_THEN_QualityDecreaseTwiceTheSpeed(){
        Item[] items = new Item[1];
        items[0] = new Item("Conjured Mana Cake", 3, 6);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Conjured Mana Cake", 2, 4);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void GIVEN_ConjuredManaCake_WHEN_SellInExpires_THEN_QualityDecrease4TimesTheSpeed(){
        Item[] items = new Item[1];
        items[0] = new Item("Conjured Mana Cake", 0, 6);
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Item actual = gildedRose.getItems()[0];
        Item expected = new Item("Conjured Mana Cake", -1, 2);
        assertEquals(expected.toString(),actual.toString());
    }


}
