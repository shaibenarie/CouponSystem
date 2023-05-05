package main.dao;

import main.service.Database;

public class CouponDAO {
    private Database _database;

    public CouponDAO(Database db){
        _database = db;
    }

    public void create(){
        String q = "CREATE TABLE IF NOT EXIST `coupon-system`.`coupons` ( `id` INT NOT NULL AUTO_INCREMENT , `company_id` INT NOT NULL , `category_id` INT NOT NULL , `title` VARCHAR(1000) NOT NULL , `description` VARCHAR(10000) NOT NULL , `start_date` DATETIME NULL DEFAULT NULL , `end_date` DATETIME NULL DEFAULT NULL , `amount` INT NOT NULL , `price` DOUBLE NOT NULL , `image` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`), INDEX `company_id` (`company_id`), INDEX `category_id` (`category_id`)) ENGINE = InnoDB;";
        _database.query(q);
    }
}
