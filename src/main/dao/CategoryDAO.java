package main.dao;

import main.model.CategoryModel;
import main.service.Database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDAO extends BaseDAO {


    public CategoryDAO(Database db) {
        super(db);
    }

    public void createTable(){
        String q = "CREATE TABLE IF NOT EXISTS `categories` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(100) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
        _database.query(q);
    }

    public void create(String name){
        String q = "INSERT INTO `categories` (`name`) VALUES ('"+name+"')";
        _database.query(q);
    }

    public CategoryModel getById(int id){
        String q = "SELECT * FROM `categories` WHERE id = " + id;
        List<CategoryModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    /**
     * Method created to parse Database List of Dictionaries and convert it to list of models
     */
    private List<CategoryModel> parse(List<Map<String, Object>> results){
        List<CategoryModel> list = new ArrayList<>();
        if (results == null || results.size() == 0) return list;

        for (Map<String, Object> result : results){
            CategoryModel model = new CategoryModel((int) result.get("id"), (String) result.get("name"));
            list.add(model);
        }

        return list;
    }
}
