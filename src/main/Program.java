package main;

import main.dao.*;
import main.facade.AdminFacade;
import main.facade.CompanyFacade;
import main.facade.CustomerFacade;
import main.service.Database;
import main.service.TaskRunner;
import main.service.WorkerService;

import java.util.LinkedList;
import java.util.function.Function;

public class Program {
    LinkedList<BaseDAO> _connectors = new LinkedList<>();
    private CategoryDAO _category;
    private CompanyDAO _company;
    private CouponDAO _coupon;
    private CustomerCouponDAO _customerCoupon;
    private CustomerDAO _customer;

    public AdminFacade admin;
    public CompanyFacade company;
    public CustomerFacade customer;

    public void Start(){
        initializeDatabase();
        initializeFacades();
        initializeWorkers();
    }

    private void initializeDatabase(){
        Database database = new Database("localhost", "root", "", "coupon-system");

        _category = new CategoryDAO(database);
        _company = new CompanyDAO(database);
        _coupon = new CouponDAO(database);
        _customerCoupon = new CustomerCouponDAO(database);
        _customer = new CustomerDAO(database);
    }

    private void initializeFacades() {
        admin = new AdminFacade(_company, _customer, _coupon, _customerCoupon);
        company = new CompanyFacade(_company, _customer, _coupon, _customerCoupon);
        customer = new CustomerFacade(_company, _customer, _coupon, _customerCoupon);
    }

    private void initializeWorkers() {
        Function<Void, Void> task = parameter -> {
            _coupon.cleanExpired();
            System.out.println("Cleaning coupons...");
            return null;
        };

        int intervalInHours = 24; // Run the task every 24 hours
        WorkerService workerService = new WorkerService(new TaskRunner(task), intervalInHours);

        // Keep the main thread alive for demonstration purposes
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the worker service (optional)
        workerService.stop();
    }
}
