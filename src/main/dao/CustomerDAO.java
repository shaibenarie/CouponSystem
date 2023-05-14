package main.dao;

import main.model.CustomerModel;
import main.service.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDAO extends BaseDAO{

    public CustomerDAO(Database db) {
        super(db);
    }

    public void createTable(){
        String q = "CREATE TABLE IF NOT EXISTS `customers` ( `id` INT NOT NULL AUTO_INCREMENT , `first_name` VARCHAR(20) NOT NULL , `last_name` VARCHAR(20) NOT NULL , `email` VARCHAR(1000) NOT NULL , `password` VARCHAR(32) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
        _database.query(q);
    }

    public void create(String firstName, String lastName, String email, String password){
        String q = "INSERT INTO customers (`first_name`, `last_name`, `email`, `password`) VALUES ('"+firstName+"', '"+lastName+"', '"+email+"', '"+password+"')";
        _database.query(q);
    }

    public CustomerModel getById(int id){
        String q = "SELECT * FROM customers WHERE id = " + id;
        List<CustomerModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    public List<CustomerModel> getByEmail(String email){
        String q = "SELECT * FROM customers WHERE email = '"+email+"'";
        return parse(_database.select(q));
    }

    public List<CustomerModel> getAll(){
        String q = "SELECT * FROM customers";
        return parse(_database.select(q));
    }

    public void delete(int id) {
        String q = "DELETE FROM customers WHERE id = " + id;
        _database.query(q);
    }

    public void updateFirstName(int id, String firstName) {
        String q = "UPDATE customers SET first_name = '"+firstName+"' WHERE id = " + id;
        _database.query(q);
    }

    public void updateLastName(int id, String lastName) {
        String q = "UPDATE customers SET last_name = '"+lastName+"' WHERE id = " + id;
        _database.query(q);
    }

    public void updateEmail(int id, String email) {
        String q = "UPDATE customers SET email = '"+email+"' WHERE id = " + id;
        _database.query(q);
    }

    public void updatePassword(int id, String password) {
        String q = "UPDATE customers SET password = '"+password+"' WHERE id = " + id;
        _database.query(q);
    }

    /**
     * Method created to parse Database List of Dictionaries and convert it to list of models
     */
    private List<CustomerModel> parse(List<Map<String, Object>> results){
        List<CustomerModel> list = new ArrayList<>();
        if (results == null || results.size() == 0) return list;

        for (Map<String, Object> result : results){
            CustomerModel model = new CustomerModel((int) result.get("id"), (String) result.get("first_name"), (String) result.get("last_name"), (String) result.get("email"), (String) result.get("password"));

            list.add(model);
        }

        return list;
    }



}
