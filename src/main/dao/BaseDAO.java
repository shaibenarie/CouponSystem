package main.dao;

import main.service.Database;

public abstract class BaseDAO {
    protected Database _database;

    public BaseDAO(Database db){
        _database = db;

        createTable();
    }

    public abstract void createTable();

}
