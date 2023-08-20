package study;

import study.employees.BaseEmployee;
import study.employees.CEOEmployee;
import study.employees.ManagerEmployee;
import study.employees.WaiterEmployee;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<BaseEmployee> list = new ArrayList<>();

        list.add(new WaiterEmployee(5, 30));
        list.add(new WaiterEmployee(20, 28));
        list.add(new WaiterEmployee(2, 35));
        list.add(new ManagerEmployee());
        list.add(new ManagerEmployee());
        list.add(new ManagerEmployee());

        double payment = 0;

        for(BaseEmployee employee : list){
            payment += employee.calculatePayment();
        }

        System.out.println("Money spent: " + payment);
    }
}
