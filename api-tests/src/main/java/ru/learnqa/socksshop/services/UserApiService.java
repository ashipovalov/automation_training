package ru.learnqa.socksshop.services;

import io.qameta.allure.Step;
import ru.learnqa.socksshop.assertions.AssertableResponse;
import ru.learnqa.socksshop.payloads.UserPayload;

public class UserApiService extends ApiService{


    @Step
    public AssertableResponse registerUser(UserPayload user) {
        return new AssertableResponse(setUp()
                .body(user)
                .when()
                .post("register"));
    }
}
