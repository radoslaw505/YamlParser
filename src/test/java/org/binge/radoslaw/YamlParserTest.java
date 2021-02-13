package org.binge.radoslaw;

import org.binge.radoslaw.repositories.DatabaseConfig;
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

    @Test
    public void testParsedSupportDatabase() {
        assertEquals("jdbc:mysql://192.168.1.12/SUP1", dbConfig.getSupportDatabaseUrlById(2));
        assertEquals("jdbc:mysql://192.168.3.20/SUP2", dbConfig.getSupportDatabaseUrlById(3));
        assertEquals("jdbc:mysql://192.168.3.22/SUP3", dbConfig.getSupportDatabaseUrlById(4));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            dbConfig.getSupportDatabaseUrlById(666);
        });

        String expectedMessage = "No value found for requested key: 666";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
