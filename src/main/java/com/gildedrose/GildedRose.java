package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
    Item[] items;

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        boolean doesDegrade = !item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES) && !item.name.equals(SULFURAS);
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
        boolean isExpired = item.sellIn < 0;
        int degradeRate = calculateDegradeRate(item, isExpired);

        if (doesDegrade) {
            adjustQuality(item, degradeRate);
        }

        if (item.name.equals(AGED_BRIE) ) {
            adjustQuality(item, 1);
            if(isExpired){
                adjustQuality(item, 1);
            }
        }

        if (item.name.equals(BACKSTAGE_PASSES)) {
            handleBackStagePassQualityLogic(item, isExpired);
        }

    }

    private void handleBackStagePassQualityLogic(Item item, boolean isExpired) {
        adjustQuality(item, 1);
        if (item.sellIn < 11) {
            adjustQuality(item, 1);
        }

        if (item.sellIn < 6) {
            adjustQuality(item, 1);
        }

        if (isExpired) {
            item.quality = item.quality - item.quality;
        }
    }

    private int calculateDegradeRate(Item item, boolean isExpired) {
        int degradeRate;
        if(item.name.equals(CONJURED_MANA_CAKE)){
            degradeRate = -2;
        }else{
            degradeRate = -1;
        }
        if(isExpired){
            degradeRate *= 2;
        }
        return degradeRate;
    }

    private void adjustQuality(Item item, int adjustment) {
        int newQuality = item.quality + adjustment;
        if(newQuality<=50 && newQuality >= 0) {
            item.quality = item.quality + adjustment;
        }
    }
}