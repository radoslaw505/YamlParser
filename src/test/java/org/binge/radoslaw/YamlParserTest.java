package org.binge.radoslaw;

import org.binge.radoslaw.repositories.DatabaseConfig;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class YamlParserTest {

    private YamlParser yamlParser = new YamlParser();

    @Test
    public void testParsingYaml() throws IOException {
        DatabaseConfig dbConfig = yamlParser.parseDbConfig();
        assertEquals(dbConfig.getClass().getTypeName(), DatabaseConfig.class.getTypeName());
        assertEquals("test", dbConfig.getDatabaseUser());
        assertEquals("test123", dbConfig.getDatabasePassword());
        assertEquals(dbConfig.getMainDatabase().getClass().getTypeName(), ArrayList.class.getTypeName());
        assertEquals(dbConfig.getSupportDatabase().getClass().getTypeName(), ArrayList.class.getTypeName());
    }

    @Test
    public void testParsedMainDatabase() {

    }



}