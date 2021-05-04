package main.utilityClasses.AbstractClasses.BaseApi;

import io.restassured.response.Response;
import lombok.Getter;
import main.Models.Typicode.AOM.deserialized.Comment;
import main.utilityClasses.AbstractClasses.BaseTestObject.BaseTestObject;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractApi extends BaseTestObject {
    @Getter
    protected static String URL;
    @Getter
    protected static String ENDPOINT;
    @Getter
    protected final Response response;
    @Getter
    protected List<Comment> asList;

    public AbstractApi(Response response) {
        this.response = response;
    }

    public AbstractApi assertResponseStatusIs(int input) {
        assertEquals(input, response.getStatusCode());
        return this;
    }

    public AbstractApi assertResponseContainsKeyWithValue(String key, String value, boolean expectedResult) {
        assertNotNull(response.getBody().jsonPath().getString(key), "Key: " + key + " not found");
        assertEquals(expectedResult, response.getBody().jsonPath().getString(key).contains(value), "Value: " + value + " not found");
        return this;
    }

    public AbstractApi assertResponseEntitiesCountIsGreaterThen(int count) {
        assertTrue(getAsList().size() > count);
        return this;
    }
}
