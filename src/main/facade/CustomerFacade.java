package main.facade;

import main.dao.CompanyDAO;
import main.dao.CouponDAO;
import main.dao.CustomerCouponDAO;
import main.dao.CustomerDAO;
import main.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerFacade extends ClientFacade {

    private CustomerModel _data;
    private boolean _logged = false;

    public CustomerFacade(CompanyDAO company, CustomerDAO customer, CouponDAO coupon, CustomerCouponDAO customerCoupon) {
        super(company, customer, coupon, customerCoupon);
    }

    @Override
    public boolean login( String email, String password) {
        List<CustomerModel> customers = _customer.getByEmail(email);

        for(CustomerModel customer : customers){
            if (Objects.equals(customer.password, password)){
                _data = customer;
                _logged = true;
                return true;
            }
        }

        return false;
    }

    public boolean register(String firstName, String lastName,String email, String password) {
        List<CustomerModel> customers = _customer.getByEmail(email);

        if (customers.size() > 0) return false;

        _customer.create(firstName, lastName, email, password);
        return login(email, password);
    }

    public void purchaseCoupon(CouponModel data) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        _coupon.create(data.companyId, data.categoryId, data.title, data.description, data.dateStart, data.dateEnd, data.amount, data.price, data.image);
    }

    public List<CouponModel> getCustomerCoupons() throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        List<CouponModel> all = new ArrayList<>();

        List<CustomerCouponModel> coupons = _customerCoupon.getByCustomerId(_data.id);
        for (CustomerCouponModel coupon : coupons){
            all.add(_coupon.getById(coupon.couponId));
        }

        return all;
    }

    public List<CouponModel> getCustomerCoupons(CategoryModel data) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        List<CouponModel> response = new ArrayList<>();
        List<CouponModel> coupons = getCustomerCoupons();
        for (CouponModel coupon : coupons){
            if (coupon.categoryId == data.id) response.add(coupon);
        }

        return response;
    }

    public List<CouponModel> getCustomerCoupons(double maxPrice) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        List<CouponModel> response = new ArrayList<>();
        List<CouponModel> coupons = getCustomerCoupons();
        for (CouponModel coupon : coupons){
            if (coupon.price < maxPrice) response.add(coupon);
        }

        return response;
    }

    public CustomerModel getCustomerDetails() throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        return _data;
    }
}
