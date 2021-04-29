package ru.learnqa.socksshop.services;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import ru.learnqa.socksshop.ProjectConfig;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiService {

    protected RequestSpecification setUp(){
        return RestAssured.given().
                contentType(ContentType.JSON).
                filters(getFilters());
    }


    private List<Filter> getFilters(){
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        if(config.logging()){
            return Arrays.asList(new RequestLoggingFilter() , new ResponseLoggingFilter());
        }
        return Collections.emptyList();

    }

}
