package main.facade;

import main.model.CategoryModel;
import main.model.CouponModel;
import main.model.CustomerModel;

import java.util.List;

public class CustomerFacade extends ClientFacade {

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    public void purchaseCoupon(CouponModel data){}
    public List<CouponModel> getCustomerCoupons(){}
    public List<CouponModel> getCustomerCoupons(CategoryModel data){}
    public List<CouponModel> getCustomerCoupons(double maxPrice){}
    public CustomerModel getCustomerDetails(){}
}
