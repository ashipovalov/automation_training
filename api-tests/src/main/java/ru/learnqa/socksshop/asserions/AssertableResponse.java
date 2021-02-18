package ru.learnqa.socksshop.asserions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import ru.learnqa.socksshop.conditions.Condition;

@RequiredArgsConstructor
public class AssertableResponse {

    private final Response register;


    public void shouldHave(Condition condition){
        condition.check(register);

    }


}
