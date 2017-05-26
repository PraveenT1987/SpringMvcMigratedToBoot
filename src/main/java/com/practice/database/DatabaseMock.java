package com.practice.database;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravikiran_gorthi on 5/5/17.
 */
public class DatabaseMock {

    private Map<String, String> userDatabase;

    public DatabaseMock() {
        userDatabase = new HashMap<>();
        userDatabase.put("ravi", "abc");
        userDatabase.put("nisum", "nisum");
    }

    public Map<String, String> getUserDatabase() {
        return userDatabase;
    }

}
