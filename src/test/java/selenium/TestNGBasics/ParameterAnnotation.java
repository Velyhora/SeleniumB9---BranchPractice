package selenium.TestNGBasics;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {

    @Parameters("school")

    @Test(priority = 1,invocationTimeOut = 3000)
    public void printInfo(String sc) throws InterruptedException {
        Thread.sleep(2000); // this method will fail bc more than 1000 mill sec
        System.out.println(sc);

    }
    @Parameters({"city","state"})
    @Test(priority = 2, invocationCount = 4)
    public void personalInfo(String city, String state){
        System.out.println(city);
        System.out.println(state);
        // invocationCount - It shows that this method will run 4 times.
    }
}
