package main;

import main.dao.*;
import main.service.Database;

import java.util.LinkedList;

public class Program {
    LinkedList<BaseDAO> _connectors = new LinkedList<>();

    public void Start(){
        initializeDatabase();
    }

    private void initializeDatabase(){
        Database database = new Database("localhost", "root", "", "coupon-system");

        _connectors = new LinkedList<>();
        _connectors.add(new CategoryDAO());
        _connectors.add(new CompanyDAO());
        _connectors.add(new CouponDAO());
        _connectors.add(new CustomerCouponDAO());
        _connectors.add(new CustomerDAO());

        // iterate trough each dao connection and attach database to the class
        // initialize database table (if not exist)
        for(BaseDAO connector:_connectors){
            connector.init(database);
            connector.createTable();
        }
    }
}
