package main.facade;

import main.dao.CompanyDAO;
import main.dao.CouponDAO;
import main.dao.CustomerCouponDAO;
import main.dao.CustomerDAO;
import main.model.CompanyModel;
import main.model.CustomerModel;

import java.util.List;
import java.util.Objects;

public class AdminFacade extends ClientFacade {

    // hardcoded
    private static final String EMAIL = "admin@admin.com";
    private static final String PASSWORD = "admin";

    public AdminFacade(CompanyDAO company, CustomerDAO customer, CouponDAO coupon, CustomerCouponDAO customerCoupon) {
        super(company, customer, coupon, customerCoupon);
    }

    @Override
    public boolean login(String email, String password) {
        _logged = Objects.equals(email, EMAIL) && Objects.equals(password, PASSWORD);
        return _logged;
    }

    public void addCompany(CompanyModel data){
        _company.create(data.name, data.email, data.password);
    }
    public void updateCompany(CompanyModel data){
        _company.updateEmail(data.id, data.email);
        _company.updateName(data.id, data.name);
        _company.updatePassword(data.id, data.password);
    }

    public void deleteCompany(int id){
        _company.delete(id);
    }

    public List<CompanyModel> getCompanies(){
        return _company.getAll();
    }

    public CompanyModel getCompany(int id){
        return _company.getById(id);
    }

    public void addCustomer(CustomerModel data){
        _customer.create(data.firstName, data.lastName, data.email, data.password);
    }

    public void updateCustomer(CustomerModel data){
        _customer.updateFirstName(data.id, data.firstName);
        _customer.updateLastName(data.id, data.lastName);
        _customer.updateEmail(data.id, data.email);
        _customer.updatePassword(data.id, data.password);
    }

    public void deleteCustomer(int id){
        _customer.delete(id);
    }

    public List<CustomerModel> getCustomers(){
        return _customer.getAll();
    }

    public CustomerModel getCustomer(int id){
        return _customer.getById(id);
    }

}
