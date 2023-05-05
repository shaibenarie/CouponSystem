package main.dao;

import main.service.Database;

public class CustomerDAO {

    private final Database _database;

    public CustomerDAO(Database db){
        _database = db;
    }

    public void create(){
        String q = "CREATE TABLE IF NOT EXIST `coupon-system`.`customers` ( `id` INT NOT NULL AUTO_INCREMENT , `first_name` VARCHAR(20) NOT NULL , `last_name` VARCHAR(20) NOT NULL , `email` VARCHAR(1000) NOT NULL , `password` VARCHAR(32) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
        _database.query(q);
    }
}
