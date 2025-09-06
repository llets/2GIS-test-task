package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Config;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConfigAndDataUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String CONFIG_PATH = "src/test/resources/configuration.json";
    private static final String TEST_DATA_LISTS_PATH = "src/test/resources/TestDataWithLists.json";
    private static final String TEST_DATA_SINGLE_PATH = "src/test/resources/TestDataWithSingleObjects.json";
    private static Config loadedConfig;

    public static <T> List<T> loadTestsDataFromJson(String testClassName, Class<T> clazz) {
        LogManager.getLogger().info("Loading tests data from json");
        try {
            Map<String, List<Map<String, Object>>> testDataMap = objectMapper.readValue(
                    new File(TEST_DATA_LISTS_PATH),
                    new TypeReference<Map<String, List<Map<String, Object>>>>() {}
            );

            List<Map<String, Object>> testDataList = testDataMap.get(testClassName);

            if (testDataList == null) {
                throw new RuntimeException("No test data found for: " + testClassName);
            }

            return testDataList.stream()
                    .map(data -> objectMapper.convertValue(data, clazz))
                    .collect(java.util.stream.Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Error loading test data from JSON", e);
        }
    }

    public static <T> T loadSingleTestDataFromJson(String testClassName, Class<T> clazz) {
        LogManager.getLogger().info("Loading single test data from json");
        try {
            Map<String, Object> rootMap = objectMapper.readValue(
                    new File(TEST_DATA_SINGLE_PATH),
                    new TypeReference<Map<String, Object>>() {}
            );

            Object testData = rootMap.get(testClassName);

            if (testData == null) {
                throw new RuntimeException("No test data found for: " + testClassName);
            }

            return objectMapper.convertValue(testData, clazz);

        } catch (IOException e) {
            throw new RuntimeException("Error loading test data from JSON: " + e.getMessage(), e);
        }
    }

    private static void loadConfigFromJson() {
        LogManager.getLogger().info("Loading config data from json");
        try {
            loadedConfig = objectMapper.readValue(new File(CONFIG_PATH), Config.class);
        } catch (IllegalArgumentException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Config getLoadedConfig() {
        LogManager.getLogger().debug("Getting loaded config from json");
        if (loadedConfig == null)
            loadConfigFromJson();
        return loadedConfig;
    }

}