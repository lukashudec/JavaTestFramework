package main.TestRunners;

import main.Models.Typicode.AOM.commentsApi;
import main.Models.Typicode.AOM.deserialized.Comment;
import main.utilityClasses.AbstractClasses.BaseTests.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

/*
1. Data structure creation:
    a. Create POJO class 'Comment' that will represent the response form /comments
    endpoint,
    b. Send request to get comments and deserialize response into the collection of objects
    'Comment'.
2. Send request GET on /comments endpoint and assert:
    a. response code,
    b. number of comments is greater than 0,
    c. response body has a comment with any of existing emails e.g. Jayne_Kuhic@sydney.com.
3. Filter the collection from point 1 using given condition:
    a. remove all comments from the collection that has postId different than 1,
    b. remove all comments that do not contain the word "non" in the body
*/


public class TypicodeCommentsTest extends BaseTest {


    List<Comment> result;

    @DataProvider(name = "mailProvider")
    public static Object[][] loginDataProvider() {
        return new Object[][]{{"email", "Jayne_Kuhic@sydney.com", true}, {"email", "wrong@mail.com", false}};
    }

    @Test(dataProvider = "mailProvider")
    void testGetComment(String key, String value, Boolean expectedResult) {
        // using fluent API model
        // using lombok for getters and setter
        // assertions defined in commentsAPI class

        result = commentsApi.get()
                .assertResponseStatusIs(200)
                .assertResponseContainsKeyWithValue(key, value, expectedResult)
                .assertResponseEntitiesCountIsGreaterThen(0)
                .getAsList().stream()
                .filter(Comment -> Comment.getPostId() == 1)
                .filter(Comment -> Comment.getBody().contains("non"))
                .collect(Collectors.toList());

        for (Comment c : result) {
            System.out.println(c.toString());
        }
    }

    @Test(dataProvider = "mailProvider")
    void testPostComments(String key, String value, Boolean expectedResult) {
        // not happy about this
        commentsApi.post()
                .assertResponseStatusIs(500);
    }

    @Test()
    void testGetCommentsFailing() {
        // verification for onFailure listener screenshot capability
        commentsApi.get()
                .assertResponseStatusIs(500);
    }

}
