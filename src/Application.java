import main.Program;
import main.dao.CompanyDAO;
import main.model.Categories;
import main.model.CompanyModel;
import main.model.CouponModel;

import java.util.Calendar;
import java.util.Date;

public class Application {
    public static void main(String[] args) throws IllegalAccessException {
        Program program = new Program();
        program.Start();

        // here you can test everything
        String name = "Shais Sausages";
        String email = "shai@sausages.com";
        String pass = "sausagesaregood";


        if (!program.company.register(name, email, pass)){
            program.company.login(email, pass);
        }

        CompanyModel company = program.company.getCompanyDetails();
        program.company.addCoupon(new CouponModel(company.id, Categories.CATEGORY_FOOD, "50% Off", "Get 50% off for your first sasuage purchase!", new Date(2023, Calendar.MAY,13), new Date(2023, Calendar.JUNE, 13), 1, 23.00, "sausage.png"));
    }
}
