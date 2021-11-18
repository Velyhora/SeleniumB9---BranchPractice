package selenium.test.sentrifugo.data;

import org.testng.annotations.DataProvider;

public class CredData {
    @DataProvider( name ="credentials")
    public Object[][] gexCred(){
        return new Object[][]{
                {"Techtorial","sentrifugo"},
                {"EM01","test"},
                {"test","test"}
        };
    }
    @DataProvider(name = "positiveCred")
    public Object[][] getPosCred(){
        return new Object[][] {
                {"EM01","sentrifugo"},
                {"EM02","sentrifugo"}
        };
    }
}
