import main.Program;
import main.service.Database;

public class Application {
    public static void main(String[] args) {
        Program program = new Program();
        Database database = new Database("localhost", "root", "", "coupon-system");
        // database.execute("show tables");
    }
}
