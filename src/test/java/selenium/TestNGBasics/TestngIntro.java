package selenium.TestNGBasics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngIntro {
    //We can use annotations to execute the code as well
    //@Test: It will execute the code. Inside the same class we can have more than one Test annotation
    @Test(priority = 1)
    public void test1(){
        System.out.println("Test annotation: test1");
    }
    @Test(priority = 2)
    public void test2(){
        System.out.println("Test annotation: test2");


    }@Test
    public void validateGetSum(){
       int result= getSum(10,5);//15
       int expected = 15;
        Assert.assertEquals(result,expected); // if both value is not equals each other, this method will fail
        //if assertion fails the next line will not be executed
        System.out.println("Get su validation method.");
    }
    //create one method take two parameter and return sum of the values
    public int getSum (int num1, int num2){
       return num1+num2;
    }
    //create one method takes two parameter and return multiplication of the value
    // create two test unit test to validate the function is working correctly
    //if the one of the number is less than 0 , than return -1.

    public int getMulti (int num1, int num2){
        if (num1<0||num2<0){
            return -1;
        }
        return num1*num2;

    }
    @Test
    public void validateMultiHappyPath(){
        int actual= getMulti(5,8);
        int expected = 40;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void validateMultiNegativeNum(){
        int actual = getMulti(-8,10);
        int expected = -80;
        Assert.assertEquals(actual, expected);//throws an error// actual -1 but expected -80
        System.out.println("after assertion"); //this line will not be expected
        //HARD ASSERTION
    }
    @Test
    public void validateMultiZeroValue(){
        int actual = getMulti(4,0);
        int expected = 0;
        Assert.assertEquals(actual,expected);

    }
}
