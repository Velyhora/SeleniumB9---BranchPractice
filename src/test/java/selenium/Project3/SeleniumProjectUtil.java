package selenium.Project3;

import selenium.HomeWork1.HomeWork2.HomeworkUtil;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SeleniumProjectUtil {
    public static List<WebElement> getDisplayedElements(List<WebElement> elements) {
        List<WebElement> displayedElements = new ArrayList<>();
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                displayedElements.add(element);
            }
        }
        return displayedElements;
    }
//
//    public static List<Double> getPriceFromText(List<WebElement> displayedPrices) {
//                       }

    //get the text and created double values for them and store in the list
    public static List<Double>getPriceFromText(List<WebElement> webElements){
        List<String >texts= HomeworkUtil.getListText(webElements);
        // we need to delete the spaces on the end or beginning and we need to remove dollarsign
        List<Double>prices = new ArrayList<>();
        for (String text:texts){
            String price=text.trim().substring(1);
            double doubleValue= Double.parseDouble(price);
            prices.add(doubleValue);

        }
        return prices;
    }

}