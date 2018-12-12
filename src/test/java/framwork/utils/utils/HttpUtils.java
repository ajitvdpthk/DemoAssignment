package framwork.utils.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import framwork.utils.configuration.TestConfig;
import framwork.utils.dto.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpUtils {
    public static final String CONFIG_FILE = "config/config.yml";
    private static File file;
    private static ObjectMapper mapper;
    private static TestConfig instance = null;


    public static RequestSpecification getRequestSpecification() {
        return given().log().all().
                baseUri(getConfig().getResourceUrl()).
                contentType(ContentType.JSON);

    }

    /**
     * get reqest for resource
     *
     * @return
     */
    public static Response getRequest(RequestSpecification specification,String pathParams) {
        return specification.
                when().
                get(pathParams).
                then().
                statusCode(200).
                extract().
                response();


    }

    /**
     * post request for resource
     */
    public static Response postRequest(RequestSpecification specification, User user) {
        return specification.
                body(user).
                when().
                post().
                then().
                statusCode(201).
                extract().
                response();


    }

    /**
     * put request for resource
     */
    public static Response putRequest(RequestSpecification specification, User user,String value) {
        return specification.
                body(user).
                when().
                put(value).
                then().
                statusCode(200).
                extract().
                response();


    }
    /**
     * Delete request for resource
     */
    public static Response deleteRequest(RequestSpecification specification, String value) {
        return specification.
                when().
                delete(value).
                then().
                statusCode(204).
                extract().
                response();


    }
    /**
     * get read config into object
     *
     * @return
     */
    private static TestConfig loadConfiguration() {
        TestConfig config = null;
        file = new File(CONFIG_FILE);
        mapper = new ObjectMapper(new YAMLFactory());
        try {

            config = mapper.readValue(file, TestConfig.class);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return config;
    }

    /**
     * get config values
     *
     * @return
     * @throws IOException
     */
    public static TestConfig getConfig() {
        if (instance == null) {
            instance = loadConfiguration();
        }
        return instance;
    }
}
