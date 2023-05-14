package main.dao;

import main.model.CompanyModel;
import main.model.CouponModel;
import main.service.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CouponDAO extends BaseDAO {

    public CouponDAO(Database db) {
        super(db);
    }

    public void createTable(){
        String q = "CREATE TABLE IF NOT EXISTS `coupons` ( `id` INT NOT NULL AUTO_INCREMENT , `company_id` INT NOT NULL , `category_id` INT NOT NULL , `title` VARCHAR(1000) NOT NULL , `description` VARCHAR(10000) NOT NULL , `start_date` DATETIME NULL DEFAULT NULL , `end_date` DATETIME NULL DEFAULT NULL , `amount` INT NOT NULL , `price` DOUBLE NOT NULL , `image` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`), INDEX `company_id` (`company_id`), INDEX `category_id` (`category_id`)) ENGINE = InnoDB;";
        _database.query(q);
    }

    public void create(int companyId, int categoryId, String description, String title, String startDate, String endDate, int amount, double price, String image){
        String q = "INSERT INTO coupons (`company_id`, `category_id`, `title`, `description`, `start_date`, `end_date`, `amount`, `price`, `image`) " +
                "VALUES ("+companyId+", "+categoryId+", '"+description+"', '"+title+"', '"+startDate+"', '"+endDate+"', "+amount+", '"+price+"', '"+image+"')";
        _database.query(q);
    }

    public CouponModel getById(int id){
        String q = "SELECT * FROM coupons WHERE id = " + id;
        List<CouponModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    public List<CouponModel> getByCompanyId(int id){
        String q = "SELECT * FROM coupons WHERE company_id = " + id;
        return parse(_database.select(q));
    }

    public List<CouponModel> getByCategoryId(int categoryId){
        String q = "SELECT * FROM coupons WHERE category_id = " + categoryId;
        return parse(_database.select(q));
    }

    public List<CouponModel> getByPriceLowerThan(double price){
        String q = "SELECT * FROM coupons WHERE price < " + price;
        return parse(_database.select(q));
    }

    public List<CouponModel> getByPriceHigherThan(double price){
        String q = "SELECT * FROM coupons WHERE price > " + price;
        return parse(_database.select(q));
    }

    public void updateCompanyId(int id, int companyId) {
        String q = "UPDATE coupons SET company_id = " + companyId + " WHERE id = " +id;
        _database.query(q);
    }

    public void updateCategoryId(int id, int categoryId) {
        String q = "UPDATE coupons SET category_id = " + categoryId + " WHERE id = " +id;
        _database.query(q);
    }

    public void updateTitle(int id, String title) {
        String q = "UPDATE coupons SET title = '" + title + "' WHERE id = " +id;
        _database.query(q);
    }

    public void updateDescription(int id, String description) {
        String q = "UPDATE coupons SET description = " + description + " WHERE id = " +id;
        _database.query(q);
    }

    public void updateStartDate(int id, String startDate) {
        String q = "UPDATE coupons SET start_date = '" + startDate + "' WHERE id = " +id;
        _database.query(q);
    }

    public void updateEndDate(int id, String endDate) {
        String q = "UPDATE coupons SET end_date = '" + endDate + "' WHERE id = " +id;
        _database.query(q);
    }

    public void updateAmount(int id, int amount) {
        String q = "UPDATE coupons SET amount = " + amount + " WHERE id = " +id;
        _database.query(q);
    }

    public void updatePrice(int id, double price) {
        String q = "UPDATE coupons SET price = " + price + " WHERE id = " +id;
        _database.query(q);
    }

    public void updateImage(int id, String image) {
        String q = "UPDATE coupons SET image = '" + image + "' WHERE id = " +id;
        _database.query(q);
    }

    public void delete(int id){
        String q = "DELETE FROM coupons WHERE id = " +id;
        _database.query(q);
    }


    /**
     * Method created to parse Database List of Dictionaries and convert it to list of models
     */
    private List<CouponModel> parse(List<Map<String, Object>> results){
        List<CouponModel> list = new ArrayList<>();
        if (results == null || results.size() == 0) return list;

        for (Map<String, Object> result : results){
            CouponModel model = new CouponModel(
                    (int) result.get("id"), (int) result.get("company_id"), (int) result.get("category_id"),
                    (String) result.get("title"), (String) result.get("description"), (String) result.get("start_date"), (String) result.get("end_date"),
                    (int) result.get("amount"), (double) result.get("price"), (String) result.get("description")
            );

            list.add(model);
        }

        return list;
    }


}
