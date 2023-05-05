package main.dao;

import main.service.Database;

public class CustomerCouponDAO {
    private final Database _database;

    public CustomerCouponDAO(Database db){
        _database = db;
    }

    public void create(){
        String q = "CREATE TABLE IF NOT EXIST `coupon-system`.`customer_vs_coupons` ( `customer_id` INT NOT NULL , `coupon_id` INT NOT NULL , PRIMARY KEY (`coupon_id`)) ENGINE = InnoDB;";
        _database.query(q);
    }
}
