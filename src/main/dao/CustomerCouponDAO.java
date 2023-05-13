package main.dao;

import main.service.Database;

public class CustomerCouponDAO extends BaseDAO {


    public void createTable(){
        String q = "CREATE TABLE IF NOT EXIST `coupon-system`.`customer_vs_coupons` ( `customer_id` INT NOT NULL , `coupon_id` INT NOT NULL , PRIMARY KEY (`coupon_id`)) ENGINE = InnoDB;";
        _database.query(q);
    }
}
