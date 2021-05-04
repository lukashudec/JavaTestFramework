package main.Models.Typicode.AOM;

import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import lombok.Getter;
import main.Models.Typicode.AOM.deserialized.Comment;
import main.utilityClasses.AbstractClasses.BaseApi.AbstractApi;
import main.utilityClasses.AbstractClasses.Interfaces.Loggable;


public class commentsApi extends AbstractApi {
    @Getter
    protected final static String URL = "https://jsonplaceholder.typicode.com";
    @Getter
    protected final static String ENDPOINT = "/comments/";

    private commentsApi(Response response) {
        super(response);
        try {
            asList = response.jsonPath().getList(".", Comment.class);
        } catch (JsonPathException e) {
            log(Status.INFO, "Response not parsed properly");
        }

    }

    public static commentsApi get() {
        Loggable.staticStep("GET: " + ENDPOINT);
        Response response = RestAssured
                .given().baseUri(URL).basePath(ENDPOINT)
                .get();
        return new commentsApi(response);
    }

    public static commentsApi post() {
        Loggable.staticStep("POST: " + ENDPOINT);
        Response response = RestAssured
                .given().baseUri(URL).basePath(ENDPOINT)
                .post();
        return new commentsApi(response);
    }

    @Override
    public commentsApi assertResponseStatusIs(int input) {
        return (commentsApi) super.assertResponseStatusIs(input);
    }

    @Override
    public commentsApi assertResponseContainsKeyWithValue(String key, String value, boolean expectedResult) {
        return (commentsApi) super.assertResponseContainsKeyWithValue(key, value, expectedResult);
    }

    @Override
    public commentsApi assertResponseEntitiesCountIsGreaterThen(int count) {
        return (commentsApi) super.assertResponseEntitiesCountIsGreaterThen(count);
    }


}


