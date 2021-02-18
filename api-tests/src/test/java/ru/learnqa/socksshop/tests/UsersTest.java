package ru.learnqa.socksshop.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.learnqa.socksshop.conditions.Conditions;
import ru.learnqa.socksshop.conditions.StatusCodeCondition;
import ru.learnqa.socksshop.payloads.UserPayload;
import ru.learnqa.socksshop.services.UserApiService;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static ru.learnqa.socksshop.conditions.Conditions.*;


public class UsersTest {

    private final UserApiService userApiService = new UserApiService();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ("http://217.28.229.104/");
    }

    @Test
    public void testCanBeRegistrationNewUser() {
        UserPayload user = new UserPayload()
        .email("test@mail.gov")
        .username(RandomStringUtils.randomAlphanumeric(8))
        .password("test123");
        userApiService.registerUser(user)
                .shouldHave(statusCode(200));









//                .body("id", is(not(emptyString())));


    }
//
//    @Test
//    public void testCanNotRegisterSameUserTwice(){
//        UserPayload user = new UserPayload()
//        .email("test@mail.gov")
//        .username(RandomStringUtils.randomAlphanumeric(8))
//        .password("test123");
//        RestAssured.given().contentType(ContentType.JSON).log().all()
//                .body(user)
//                .when()
//                .post("register")
//                .then().log().all()
//                .assertThat()
//                .statusCode(200)
//                .body("id", is(not(emptyString())));
//
//
//        RestAssured.given().contentType(ContentType.JSON).log().all()
//                .body(user)
//                .when()
//                .post("register")
//                .then().log().all()
//                .assertThat()
//                .statusCode(500);
//    }


}
