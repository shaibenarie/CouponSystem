package study.employees;

public class CEOEmployee extends BaseEmployee{

    private final float moneyLeft;

    public CEOEmployee(float moneyLeft){
        this.moneyLeft = moneyLeft;
    }


    @Override
    public double calculatePayment() {
        return moneyLeft;
    }
}
