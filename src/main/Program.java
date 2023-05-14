package main;

import main.dao.*;
import main.facade.AdminFacade;
import main.facade.CompanyFacade;
import main.facade.CustomerFacade;
import main.service.Database;

import java.util.LinkedList;

public class Program {
    LinkedList<BaseDAO> _connectors = new LinkedList<>();
    private CategoryDAO _category;
    private CompanyDAO _company;
    private CouponDAO _coupon;
    private CustomerCouponDAO _customerCoupon;
    private CustomerDAO _customer;

    public AdminFacade admin;
    public CompanyFacade company;
    public CustomerFacade customer;

    public void Start(){
        initializeDatabase();
        initializeFacades();
    }

    private void initializeDatabase(){
        Database database = new Database("localhost", "root", "", "coupon-system");

        _category = new CategoryDAO(database);
        _company = new CompanyDAO(database);
        _coupon = new CouponDAO(database);
        _customerCoupon = new CustomerCouponDAO(database);
        _customer = new CustomerDAO(database);
    }

    private void initializeFacades() {
        admin = new AdminFacade(_company, _customer, _coupon, _customerCoupon);
        company = new CompanyFacade(_company, _customer, _coupon, _customerCoupon);
        customer = new CustomerFacade(_company, _customer, _coupon, _customerCoupon);
    }
}
