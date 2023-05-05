package main.model;

public class CouponModel {
    public int id;
    public int companyId;
    public int categoryId;
    public String title;
    public String description;
    public String dateStart;
    public String dateEnd;
    public int amount;
    public double price;
    public String image;

    public CouponModel(int id, int companyId, int categoryId, String title, String description, String dateStart, String dateEnd, int amount, double price, String image) {
        this.id = id;
        this.companyId = companyId;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }
}
