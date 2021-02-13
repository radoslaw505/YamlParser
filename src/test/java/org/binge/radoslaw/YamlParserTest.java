package org.binge.radoslaw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.binge.radoslaw.repositories.DatabaseConfig;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class YamlParserTest {

    private YamlParser yamlParser = new YamlParser();

    @Test
    public void testParsingYaml() throws IOException {
        DatabaseConfig dbConfig = yamlParser.parseDbConfig();
        assertEquals("test", dbConfig.getDatabaseUser());
        assertEquals("test123", dbConfig.getDatabasePassword());
    }





}