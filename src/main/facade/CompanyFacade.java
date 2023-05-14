package main.facade;

import main.dao.CompanyDAO;
import main.dao.CouponDAO;
import main.dao.CustomerCouponDAO;
import main.dao.CustomerDAO;
import main.model.CategoryModel;
import main.model.CompanyModel;
import main.model.CouponModel;

import java.util.List;
import java.util.Objects;

public class CompanyFacade extends ClientFacade {

    private CompanyModel _data;
    private boolean _logged = false;

    public CompanyFacade(CompanyDAO company, CustomerDAO customer, CouponDAO coupon, CustomerCouponDAO customerCoupon) {
        super(company, customer, coupon, customerCoupon);
    }

    @Override
    public boolean login(String email, String password) {
        List<CompanyModel> companies = _company.getByEmail(email);

        for (CompanyModel company : companies){
            if (Objects.equals(company.password, password)){
                _data = company;
                _logged = true;
                return true;
            }
        }

        return false;
    }

    public void addCoupon(CouponModel data){
        _coupon.create(data.companyId, data.categoryId, data.title, data.description, data.dateStart, data.dateEnd, data.amount, data.price, data.image);
    }

    public void updateCoupon(CouponModel data){
        _coupon.updateCompanyId(data.id, data.companyId);
        _coupon.updateCategoryId(data.id, data.categoryId);
        _coupon.updateTitle(data.id, data.title);
        _coupon.updateDescription(data.id, data.description);
        _coupon.updateStartDate(data.id, data.dateStart);
        _coupon.updateEndDate(data.id, data.dateEnd);
        _coupon.updateAmount(data.id, data.amount);
        _coupon.updatePrice(data.id, data.price);
        _coupon.updateImage(data.id, data.image);
    }

    public void deleteCoupon(int id){
        _coupon.delete(id);
    }

    public List<CouponModel> getCompanyCoupons(){
        return _coupon.getByCompanyId(_data.id);
    }

    public List<CouponModel> getCompanyCoupons(CategoryModel data){
        return _coupon.getByCategoryId(data.id);
    }

    public List<CouponModel> getCompanyCoupons(double maxPrice){
        return _coupon.getByPriceLowerThan(maxPrice);
    }

    public CompanyModel getCompanyDetails(){
        return _data;
    }
}
