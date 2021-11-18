package api.delete;

import api.Constants;
import api.pojo.PetPojo;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static api.Constants.APPLICATION_JSON;

public class DeleteIntro {
    /*

     */
    @Test
    public void deleteTest() {

        RestAssured.baseURI = "https://petstore.swagger.io";

        PetPojo pet = new PetPojo();
        pet.setId(777000);
        pet.setName("Buzz");
        pet.setStatus("Buzzing");
        Response response = RestAssured.given().accept(APPLICATION_JSON)
                .and().contentType("application/json")
                .and().body(pet)
                .when().post("v2/pet")
                .then().statusCode(200).contentType(APPLICATION_JSON).extract().response();
        Map<String, ?> parsedResponse = response.as(new TypeRef<Map<String, ?>>() {
        });

        Assert.assertEquals(parsedResponse.get("id"), 777000.0);
        Assert.assertEquals(parsedResponse.get("name"), "Buzz");
        Assert.assertEquals(parsedResponse.get("status"), "Buzzing");

        //delete request

        response = RestAssured.given().accept(APPLICATION_JSON)
                .when().delete("v2/pet/" + 777000)
                .then().statusCode(200).contentType(APPLICATION_JSON).extract().response();

        Map<String, ?> parsedDeleteResponse = response.as(new TypeRef<Map<String, ?>>() {
        });
        Assert.assertEquals(parsedDeleteResponse.get("code"),200.0);
        Assert.assertEquals(parsedDeleteResponse.get("message"),String.valueOf(777000));

        //get request
    }
}