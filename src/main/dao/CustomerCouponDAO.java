package main.dao;

import main.model.CouponModel;
import main.model.CustomerCouponModel;
import main.service.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerCouponDAO extends BaseDAO {


    public CustomerCouponDAO(Database db) {
        super(db);
    }

    public void createTable(){
        String q = "CREATE TABLE IF NOT EXISTS `customer_vs_coupons` ( `customer_id` INT NOT NULL , `coupon_id` INT NOT NULL , PRIMARY KEY (`coupon_id`)) ENGINE = InnoDB;";
        _database.query(q);
    }

    public void create(int customerId, int couponId){
        String q = "INSERT INTO customer_vs_coupons (`customer_id`, `coupon_id`) VALUES ("+customerId+", "+couponId+")";
        _database.query(q);
    }

    public List<CustomerCouponModel> getByCustomerId(int customerId){
        String q = "SELECT * FROM customer_vs_coupons WHERE customer_id = " + customerId;
        return parse(_database.select(q));
    }

    public List<CustomerCouponModel> getByCouponId(int couponId){
        String q = "SELECT * FROM customer_vs_coupons WHERE coupon_id = " + couponId;
        return parse(_database.select(q));
    }

    /**
     * Method created to parse Database List of Dictionaries and convert it to list of models
     */
    private List<CustomerCouponModel> parse(List<Map<String, Object>> results){
        List<CustomerCouponModel> list = new ArrayList<>();
        if (results == null || results.size() == 0) return list;

        for (Map<String, Object> result : results){
            CustomerCouponModel model = new CustomerCouponModel((int) result.get("customer_id"), (int) result.get("coupon_id"));

            list.add(model);
        }

        return list;
    }
}
