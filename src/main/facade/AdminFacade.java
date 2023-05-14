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

    public void addCompany(CompanyModel data) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        _company.create(data.name, data.email, data.password);
    }

    public void updateCompany(CompanyModel data) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        _company.updateEmail(data.id, data.email);
        _company.updateName(data.id, data.name);
        _company.updatePassword(data.id, data.password);
    }

    public void deleteCompany(int id) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        _company.delete(id);
    }

    public List<CompanyModel> getCompanies() throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        return _company.getAll();
    }

    public CompanyModel getCompany(int id) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        return _company.getById(id);
    }

    public void addCustomer(CustomerModel data) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        _customer.create(data.firstName, data.lastName, data.email, data.password);
    }

    public void updateCustomer(CustomerModel data) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        _customer.updateFirstName(data.id, data.firstName);
        _customer.updateLastName(data.id, data.lastName);
        _customer.updateEmail(data.id, data.email);
        _customer.updatePassword(data.id, data.password);
    }

    public void deleteCustomer(int id) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        _customer.delete(id);
    }

    public List<CustomerModel> getCustomers() throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        return _customer.getAll();
    }

    public CustomerModel getCustomer(int id) throws IllegalAccessException {
        if (!_logged) throw new IllegalAccessException("Cannot perform operation since you are not logged!");

        return _customer.getById(id);
    }

}
