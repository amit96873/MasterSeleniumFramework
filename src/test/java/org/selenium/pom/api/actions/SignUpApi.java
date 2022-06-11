package org.selenium.pom.api.actions;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.selenium.pom.utils.ConfigLoader;

import static io.restassured.RestAssured.given;

public class SignUpApi {

    private Cookies cookies;


    public Cookies getCookie(){
        return cookies;
    }

    public Response getAccount(){
        Cookies cookies = new Cookies();
        Response response = given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                cookies(cookies).
                log().all().
                when().
                get("/nav/").
                then().
                log().all().
                extract().
                response();
        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to fetch the account, HTTP Status Code: " + response.getStatusCode());
        }
        return response;

    }
}
