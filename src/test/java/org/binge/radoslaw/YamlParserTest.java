package org.binge.radoslaw;

import org.binge.radoslaw.repositories.DatabaseConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YamlParserTest {

    private YamlParser yamlParser = new YamlParser();
    private DatabaseConfig dbConfig = yamlParser.parseDbConfig();

    YamlParserTest() throws IOException {
    }

    @Test
    public void testParsingYaml() {
        assertEquals(DatabaseConfig.class.getTypeName(), dbConfig.getClass().getTypeName());
        assertEquals("test", dbConfig.getDatabaseUser());
        assertEquals("test123", dbConfig.getDatabasePassword());
        assertEquals(ArrayList.class.getTypeName(), dbConfig.getMainDatabase().getClass().getTypeName());
        assertEquals(ArrayList.class.getTypeName(), dbConfig.getSupportDatabase().getClass().getTypeName());
    }

    @Test
    public void testParsedMainDatabase() {
        assertEquals(1, dbConfig.getMainDatabaseServerId());
        assertEquals("jdbc:mysql://192.168.1.10/MAIN", dbConfig.getMainDatabaseUrl());
    }

}
