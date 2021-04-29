package ru.learnqa.socksshop.assertions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.learnqa.socksshop.conditions.Condition;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {

    private final Response response;



    public AssertableResponse shouldHave(Condition condition){
        log.info("Кое что о проверке условия{}" , condition);
        condition.check(response);
        return this;

    }

    public <T> T asPojo(Class<T> tClass){
        return response.as(tClass);
    }


}
