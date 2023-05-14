package main.facade;

import main.dao.*;

abstract class ClientFacade {
    protected boolean _logged = false;

    protected CompanyDAO _company;
    protected CustomerDAO _customer;
    protected CouponDAO _coupon;
    protected CustomerCouponDAO _customerCoupon;

    public ClientFacade(CompanyDAO company, CustomerDAO customer, CouponDAO coupon, CustomerCouponDAO customerCoupon){
        _company = company;
        _customer = customer;
        _coupon = coupon;
        _customerCoupon = customerCoupon;
    }

    abstract public boolean login(String email, String password);
}
