package com.rubens.configs;

import java.io.FileInputStream;
import java.util.Properties;

public class OmdbAPIConfig {
    private static final String ENV = "caminho";
    private static Properties props;

    public static String getApiKey() throws Exception {
        loadConfigFile();
        return props.getProperty("OMDB_API_KEY");
    }

    public static String getURI() throws Exception {
        loadConfigFile();
        return props.getProperty("OMDB_URI");
    }

    private static Properties loadConfigFile() throws Exception {
        try {
            FileInputStream file = new FileInputStream(ENV);
            props.load(file);

            return props;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
