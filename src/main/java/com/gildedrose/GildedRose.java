public void updateQuality() {
    for (Item item : items) {
        boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
        boolean isAgedBrie = item.name.equals("Aged Brie");
        boolean isBackstagePass = item.name.equals("Backstage passes to a TAFKAL80ETC concert");

        if (!isAgedBrie && !isBackstagePass) {
            if (!isSulfuras && item.quality > 0) {
                item.quality--;
            }
        } else {
            if (item.quality < 50) {
                item.quality++;

                if (isBackstagePass) {
                    if (item.sellIn < 11 && item.quality < 50) {
                        item.quality++;
                    }
                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        }

        if (!isSulfuras) {
            item.sellIn--;
        }

        if (item.sellIn < 0) {
            if (isAgedBrie) {
                if (item.quality < 50) {
                    item.quality++;
                }
            } else if (isBackstagePass) {
                item.quality = 0;
            } else {
                if (!isSulfuras && item.quality > 0) {
                    item.quality--;
                }
            }
        }
    }
}
