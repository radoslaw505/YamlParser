package org.binge.radoslaw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.binge.radoslaw.repositories.DatabaseConfig;

import java.io.IOException;

public class YamlParser {

    private String yamlFile = "config.yaml";

    public DatabaseConfig parseDbConfig() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        return mapper.readValue(YamlParser.class.getClassLoader().getResource(yamlFile), DatabaseConfig.class);
    }


}
