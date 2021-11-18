package selenium.TestNGBasics;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @DataProvider(name = "names")
    public Object [][] getNames(){
        // new Object [4][3]
        //
        return new Object[][]{
                {"David","Hunt","David Hunt"},
                {"Kushal","Puri","Kushal Puri"},
                {"Priyanka", "Gopal","Priyanka Gopal"},
                {"Sammer", "Parlapati", "Sammer Parlapati"}
        };
    }


    @Test(dataProvider = "names")
    public void test1(String firstName, String lastName, String expectedName){
        String fName= firstName;
        String lName= lastName;
        String fullName = fName+" "+lName;

        Assert.assertEquals(fullName, expectedName);
    }

}
