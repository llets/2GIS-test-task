package tests;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import models.Place;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import requests.v1.auth.tokens.TokenRequest;
import utils.ConfigAndDataUtils;

import java.util.List;

public class BaseTest {

    protected Cookie cookie = null;

    @BeforeMethod
    public void getToken(){
        Response response = TokenRequest.performPost();
        System.out.println(response.getCookie("token"));
        this.cookie = new Cookie.Builder("token", response.getCookie("token")).build();
    }

}