package main.facade;

import main.dao.BaseDAO;
import main.dao.CompanyDAO;
import main.dao.CouponDAO;
import main.dao.CustomerDAO;

abstract class ClientFacade {
    protected boolean _logged = false;

    protected CompanyDAO _company;
    protected CustomerDAO _customer;
    protected CouponDAO _coupon;

    public void init(CompanyDAO company, CustomerDAO customer, CouponDAO coupon){
        _company = company;
        _customer = customer;
        _coupon = coupon;
    }

    abstract public boolean login(String email, String password);
}
