package org.binge.radoslaw.repositories;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DatabaseConfig {

    private String databaseUser;
    private String databasePassword;
    private List<MainDatabase> mainDatabase;
    private List<SupportDatabase> supportDatabase;


    public int getMainDatabaseServerId() {
        return mainDatabase.get(0).getServerId();
    }

    public String getMainDatabaseUrl() {
        return mainDatabase.get(0).getUrl();
    }

    public String getSupportDatabaseUrlById(int i) {
        Map<Integer, String> supportDatabaseMap = supportDatabase.stream()
                .collect(Collectors.toMap(SupportDatabase::getServerId, SupportDatabase::getUrl));
        String url =  supportDatabaseMap.get(i);
        if (url == null) {
            throw new ArrayIndexOutOfBoundsException("No value found for requested key: " + i);
        } else {
            return url;
        }
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public List<MainDatabase> getMainDatabase() {
        return mainDatabase;
    }

    public List<SupportDatabase> getSupportDatabase() {
        return supportDatabase;
    }

}
