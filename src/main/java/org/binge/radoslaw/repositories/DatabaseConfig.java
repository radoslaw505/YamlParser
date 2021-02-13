package org.binge.radoslaw.repositories;

import java.util.List;

public class DatabaseConfig {

    private String databaseUser;
    private String databasePassword;
    private List<MainDatabase> mainDatabase;
    private List<SupportDatabase> supportDatabaseList;

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public List<MainDatabase> getMainDatabase() {
        return mainDatabase;
    }

    public void setMainDatabase(List<MainDatabase> mainDatabase) {
        this.mainDatabase = mainDatabase;
    }

    public List<SupportDatabase> getSupportDatabaseList() {
        return supportDatabaseList;
    }

    public void setSupportDatabaseList(List<SupportDatabase> supportDatabaseList) {
        this.supportDatabaseList = supportDatabaseList;
    }
}
