package main.dao;

import main.service.Database;

public class CategoryDAO {
    private final Database _database;

    public CategoryDAO(Database db){
        _database = db;
    }

    public void create(){
        String q = "CREATE TABLE IF NOT EXIST `coupon-system`.`categories` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(100) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
        _database.query(q);
    }
}
