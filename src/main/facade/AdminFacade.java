package main.facade;

import main.model.CompanyModel;
import main.model.CustomerModel;

import java.util.List;
import java.util.Objects;

public class AdminFacade extends ClientFacade {

    // hardcoded
    private static final String EMAIL = "admin@admin.com";
    private static final String PASSWORD = "admin";

    @Override
    public boolean login(String email, String password) {
        _logged = Objects.equals(email, EMAIL) && Objects.equals(password, PASSWORD);
        return _logged;
    }

    public void addCompany(CompanyModel data){}
    public void updateCompany(CompanyModel data){}
    public void deleteCompany(int id){}
    public List<CompanyModel> getCompanies(){}
    public CompanyModel getCompany(int id){}

    public void addCustomer(CustomerModel data){}
    public void updateCustomer(CustomerModel data){}
    public void deleteCustomer(int id){}
    public List<CustomerModel> getCustomers(){}
    public CustomerModel getCustomer(int id){}

}
