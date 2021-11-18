package api;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class Deserialization {
    @Test
    public void deserializationTest() {
        //https://petstore.swagger.io/v2/pet/1
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet/100001";
        Response response = RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200).log().all().extract().response();
        Map<String, Object> deserializeResp = response.as(new TypeRef<Map<String, Object>>() {});
      String name= (String)  deserializeResp.get("name");
        System.out.println("Pet name is: "+name);
        Assert.assertEquals(name,"Annetta");

     Map<String, Object>categoryMap=(Map<String, Object>) deserializeResp.get("category");
        System.out.println("Pet category is: "+categoryMap);

        double id =(double)deserializeResp.get("id");
        Assert.assertEquals(id,100001);

    }
}
