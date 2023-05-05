package main.dao;

import main.service.Database;

public class CompanyDAO {
    private Database _database;

    public CompanyDAO(Database db){
        _database = db;
    }

    public void create(){
        String q = "CREATE TABLE IF NOT EXISTS `coupon-system`.`companies` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(100) NOT NULL , `email` VARCHAR(1000) NOT NULL , `password` VARCHAR(32) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
        _database.query(q);
    }

    public void updateName(int id, String name){
        _database.query("UPDATE companies SET name = '" + name + "' WHERE id = " + id);
    }

    public void updateEmail(int id, String email){
        _database.query("UPDATE companies SET email = '" + email + "' WHERE id = " + id);
    }

    public void updatePassword(int id, String password){
        _database.query("UPDATE companies SET password = '" + password + "' WHERE id = " + id);
    }

}
