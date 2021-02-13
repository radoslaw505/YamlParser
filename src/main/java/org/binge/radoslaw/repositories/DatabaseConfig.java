package org.binge.radoslaw.repositories;

import java.util.List;

public class DatabaseConfig {

    private String databaseUser;
    private String databasePassword;
    private List<MainDatabase> mainDatabase;
    private List<SupportDatabase> supportDatabase;


    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public List<MainDatabase> getMainDatabase() {
        return mainDatabase;
    }

    public int getMainDatabaseServerId() {
        return mainDatabase.get(0).getServerId();
    }

    public String getMainDatabaseUrl() {
        return mainDatabase.get(0).getUrl();
    }

    public List<SupportDatabase> getSupportDatabase() {
        return supportDatabase;
    }

}
