package com.SolidusLabs;

 class GiftItem {
    String name;
    Integer value;
    public GiftItem(String t, Integer v) {
        this.name = t;
        this.value =v;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name  + " " + value ;
    }
}
