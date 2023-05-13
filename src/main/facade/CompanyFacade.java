package main.facade;

import main.model.CategoryModel;
import main.model.CompanyModel;
import main.model.CouponModel;

import java.util.List;

public class CompanyFacade extends ClientFacade {

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    public void addCoupon(CouponModel data){

    }
    public void updateCoupon(CouponModel data){}
    public void deleteCoupon(int id){}

    public List<CouponModel> getCompanyCoupons(){}
    public List<CouponModel> getCompanyCoupons(CategoryModel data){}
    public List<CouponModel> getCompanyCoupons(double maxPrice){}
    public CompanyModel getCompanyDetails(){}
}
