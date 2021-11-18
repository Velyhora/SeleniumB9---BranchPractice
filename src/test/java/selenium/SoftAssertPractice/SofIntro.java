package selenium.SoftAssertPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SofIntro {

    public int sum(int a, int b){
        return a+b;
    }

    @Test
    public void validateCalculation(){
        System.out.println("First");
        Assert.assertEquals(sum(5,5),6);
        System.out.println("Second");
        Assert.assertEquals(sum(-10,10),0);
        System.out.println("Third");
        Assert.assertEquals(sum(-5,-5),-10);

    }
    @Test
    public void validateSoftCalculation(){
        SoftAssert softAssert = new SoftAssert();
        System.out.println("First");
        softAssert.assertEquals(sum(5,5),6);
        System.out.println("Second");
        softAssert.assertEquals(sum(-10,11),1);
        System.out.println("Third");
        softAssert.assertEquals(sum(-5,-5),10);

      softAssert.assertAll("Calculation Error Message");
        //Static Polymorphism - java decides witch method to call at compile time when it is overloaded
        //Static Polymorphism - java decides witch method to call at run- time when it is overridden

    }
}
