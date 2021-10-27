package com.DuyenNguyen.experimenting.restAssured44;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest extends RestAssuredBaseTest {
    @Test
    public void testingRestAssuredSimpleEndPointVerification() {
        String baseUrl = "https://www.weatherapi.com";
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec
                .setBaseUri(baseUrl)
                //.addParam("key", "eb27251e68054eabb1944815212610")
                .addParam("key", "29bebb4c6e3844ffafe115519210709") // Andrii's key
                .addParam("q", "Lviv")
                .addParam("days", "1");

        System.out.println("spec: " + spec);

        Response rp = RestAssured.given(spec.build()).get("/current.json");

        log.info("----------gaugau------------");

        rp.then().assertThat().log().all().body("location.name", equalTo("Lviv"));

    }
}
