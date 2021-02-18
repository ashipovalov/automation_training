package ru.learnqa.socksshop.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.learnqa.socksshop.asserions.AssertableResponse;
import ru.learnqa.socksshop.payloads.UserPayload;

public class UserApiService extends ApiService{

    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setUp()
                .body(user)
                .when()
                .post("register"));
    }
}
