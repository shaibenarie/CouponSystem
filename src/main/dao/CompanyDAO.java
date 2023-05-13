package main.dao;

import main.model.CategoryModel;
import main.model.CompanyModel;
import main.service.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompanyDAO extends BaseDAO {
    private Database _database;

    public void createTable(){
        String q = "CREATE TABLE IF NOT EXISTS `coupon-system`.`companies` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(100) NOT NULL , `email` VARCHAR(1000) NOT NULL , `password` VARCHAR(32) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
        _database.query(q);
    }

    public void create(String name, String email, String password){
        _database.query("INSERT INTO companies (`name`, `email`, `password`) VALUES ('"+name+"', '"+email+"', '"+password+"')");
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

    public CompanyModel getById(int id){
        String q = "SELECT * FROM companies WHERE id = " + id;
        List<CompanyModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    public CompanyModel getByName(String name){
        String q = "SELECT * FROM companies WHERE name = '"+name+"'";
        List<CompanyModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    public CompanyModel getByEmail(String email){
        String q = "SELECT * FROM companies WHERE email = '"+email+"'";
        List<CompanyModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    /**
     * Method created to parse Database List of Dictionaries and convert it to list of models
     */
    private List<CompanyModel> parse(List<Map<String, Object>> results){
        List<CompanyModel> list = new ArrayList<>();
        if (results == null || results.size() == 0) return list;

        for (Map<String, Object> result : results){
            CompanyModel model = new CompanyModel((int) result.get("id"), (String) result.get("name"), (String) result.get("email"), (String) result.get("password"));
            list.add(model);
        }

        return list;
    }

}
