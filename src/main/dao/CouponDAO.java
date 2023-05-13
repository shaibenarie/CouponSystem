package main.dao;

import main.model.CompanyModel;
import main.model.CouponModel;
import main.service.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CouponDAO extends BaseDAO {

    public void createTable(){
        String q = "CREATE TABLE IF NOT EXIST `coupon-system`.`coupons` ( `id` INT NOT NULL AUTO_INCREMENT , `company_id` INT NOT NULL , `category_id` INT NOT NULL , `title` VARCHAR(1000) NOT NULL , `description` VARCHAR(10000) NOT NULL , `start_date` DATETIME NULL DEFAULT NULL , `end_date` DATETIME NULL DEFAULT NULL , `amount` INT NOT NULL , `price` DOUBLE NOT NULL , `image` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`), INDEX `company_id` (`company_id`), INDEX `category_id` (`category_id`)) ENGINE = InnoDB;";
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

    public CouponModel getByCompanyId(int id){
        String q = "SELECT * FROM coupons WHERE company_id = " + id;
        List<CouponModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    public CouponModel getByCategoryId(int id){
        String q = "SELECT * FROM coupons WHERE category_id = " + id;
        List<CouponModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    public CouponModel getByPriceLowerThan(double price){
        String q = "SELECT * FROM coupons WHERE price < " + price;
        List<CouponModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
    }

    public CouponModel getByPriceHigherThan(double price){
        String q = "SELECT * FROM coupons WHERE price > " + price;
        List<CouponModel> list = parse(_database.select(q));

        if (list.size() == 0){
            return null;
        }

        return list.get(0);
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
