package api;

import api.pojo.PetPojo;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeserializationPokemon {
    @Test
    public void test(){
        //https://pokeapi.co/api/v2/pokemon
        RestAssured.baseURI = "https://pokeapi.co";
        RestAssured.basePath = "api/v2/pokemon";
        Response response = RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        //deserialization
        Map<String, Object> deserializeResp = response.as(new TypeRef<Map<String, Object>>() {});
        double count = (double) deserializeResp.get("count");
        Assert.assertEquals(count,1118);

        List<Map<String ,String>>resultList = (List<Map<String ,String>>) deserializeResp.get("results");

        List<String> urlList = new ArrayList<>();
        for (int i=0;i<resultList.size();i++){
            Map <String,String> resultMap= resultList.get(i);
            String url = resultMap.get("url");
            if (url.equals(null)){
                continue;
            }
            urlList.add(url);
        }
        System.out.println("Url list is: "+urlList);
        Assert.assertEquals(urlList.size(),20);
    }

}
