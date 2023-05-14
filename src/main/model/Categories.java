package main.model;

public enum Categories {
    CATEGORY_FOOD(1),
    CATEGORY_LIFESTYLE(2),
    CATEGORY_SPORTS(3);

    private int value;

    Categories(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
