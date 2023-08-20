package study.employees;

public class WaiterEmployee extends BaseEmployee {

    private final double hourlyPayment;

    public WaiterEmployee(double hours, double hourlyPayment){
        this.hours = hours;
        this.hourlyPayment = hourlyPayment;
    }


    /**
     * Waiter earns money for every HOUR he works
     */
    @Override
    public double calculatePayment() {
        return hours * hourlyPayment;
    }
}
