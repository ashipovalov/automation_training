package ru.learnqa.socksshop.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.learnqa.socksshop.payloads.UserPayload;
import ru.learnqa.socksshop.responses.UserRegistrationResponse;
import ru.learnqa.socksshop.services.UserApiService;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.text.IsEmptyString.emptyString;
import static ru.learnqa.socksshop.conditions.Conditions.*;


public class UsersTest {

    private final UserApiService userApiService = new UserApiService();
    private final Faker faker = new Faker(new Locale("ru"));

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ("http://217.28.229.104/");
    }

    @Test
    public void testCanBeRegistrationNewUser() {
        UserPayload user = new UserPayload()
                .email(faker.internet().emailAddress())
                .username(faker.name().username())
                .password(faker.internet().password());
        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", is(not(emptyString()))));



    }

    @Test
    public void testCanNotRegisterSameUserTwice() {
        UserPayload user = new UserPayload()
                .email(faker.internet().emailAddress())
                .username(faker.name().username())
                .password(faker.internet().password());
        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", is(not(emptyString()))));
        userApiService.registerUser(user)
                .shouldHave(statusCode(500));
    }


}
