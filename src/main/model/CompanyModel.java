package main.model;

public class CompanyModel {
    public int id;
    public String name;
    public String email;
    public String password;


    public CompanyModel(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
