package main.manager;

import main.facade.AdminFacade;
import main.facade.ClientFacade;
import main.facade.CompanyFacade;
import main.facade.CustomerFacade;
import main.service.IllegalSingletonInitializationException;

public class LoginManager {

    private static LoginManager _instance;
    private AdminFacade admin;
    private CompanyFacade company;
    private CustomerFacade customer;

    public LoginManager(AdminFacade admin, CompanyFacade company, CustomerFacade customer) throws IllegalSingletonInitializationException {
        if (_instance != null) throw new IllegalSingletonInitializationException();

        this.admin = admin;
        this.company = company;
        this.customer = customer;
    }

    public static LoginManager getInstance() throws IllegalSingletonInitializationException {
        if (_instance == null){
            throw new IllegalSingletonInitializationException();
        }

        return _instance;
    }

    public ClientFacade login(String email, String password, ClientType client){
        switch (client){
            case Administrator:
                if (admin.login(email, password)){
                    return admin;
                }
            case Company:
                if (company.login(email, password)){
                    return company;
                }
            case Customer:
                if (customer.login(email, password)){
                    return customer;
                }
        }

        return null;
    }
}
