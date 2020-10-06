package edu.bonn.cs.iv.core.config;

import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ConfigHandler {
    private static AbstractConfiguration config;
    private final static List<String> requiredBaseParameters = Arrays.asList("outFile", "modelName", "duration", "nodes");
    private final static List<String> requiredBaseMapParameters = Arrays.asList("osmFile", "duration");

    public static boolean loadConfig(String file_name) {
        if (config != null) throw new IllegalStateException("Config already loaded");

        Configurations configs = new Configurations();
       try {
            config = configs.properties(new File(file_name));
        } catch (ConfigurationException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean saveConfig(String file_name) {
        checkConfig();

        try(Writer writer = new FileWriter(file_name)) {
            AbstractConfiguration tmp_config;
            if (file_name.contains(".xml")) {
                tmp_config = new XMLConfiguration();
            } else if (file_name.contains(".yml") || file_name.contains(".yaml")) {
                tmp_config = new YAMLConfiguration();
            } else if (file_name.contains(".json")) {
                tmp_config = new JSONConfiguration();
            } else tmp_config = new PropertiesConfiguration();

            tmp_config.append(config);
            ((FileBasedConfiguration) tmp_config).write(writer);
        }catch (IOException e){
            System.err.println("Unable to open config file");
            e.printStackTrace();
            return false;
        }catch (ConfigurationException e){
            System.err.println("Unable to read config. Bad format");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Configuration getConfig(){
        checkConfig();
        return config;
    }

    public static void getValue(String key){
        checkConfig();
        config.get(Object.class, key);
    }

    public static Configuration crateEmptyConfig(){
        return config = new PropertiesConfiguration();
    }

    private static void checkConfig(){
        if (config == null) throw new IllegalStateException("Config not initialized");
    }

}
