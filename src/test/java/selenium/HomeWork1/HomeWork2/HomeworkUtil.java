package selenium.HomeWork1.HomeWork2;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomeworkUtil {
    //We have list of web elements and we need to get text out of them
    public static List<String>getListText(List<WebElement>webElements){
        List<String>texts= new ArrayList<>();
        for (int i = 0; i <webElements.size() ; i++) {
            texts.add(webElements.get(i).getText());
        }
        return texts;
    }
}
