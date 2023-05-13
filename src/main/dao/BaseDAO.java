package main.dao;

import main.service.Database;

public abstract class BaseDAO {
    protected Database _database;

    public void init(Database db){
        _database = db;
    }

    public abstract void createTable();

}
