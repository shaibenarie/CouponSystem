package main.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public CouponModel(int companyId, Categories category, String title, String description, Date dateStart, Date dateEnd, int amount, double price, String image) {
        this.id = -1;
        this.companyId = companyId;
        this.categoryId = category.getValue();
        this.title = title;
        this.description = description;
        this.dateStart = fromDate(dateStart);
        this.dateEnd = fromDate(dateEnd);
        this.amount = amount;
        this.price = price;
        this.image = image;
    }

    public boolean isExpired(){
        Date endsAt = toDate(dateEnd);
        Date now = new Date();
        return now.after(endsAt);
    }

    private static String fromDate(Date date){
        // Create a SimpleDateFormat instance with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Format the Date object to a string
        String formattedDate = dateFormat.format(date);

        return formattedDate;
    }

    private static Date toDate(String dateTimeString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            date = dateFormat.parse(dateTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }


}
