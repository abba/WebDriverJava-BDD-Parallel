package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Driver;

/**
 * Created by zsuleiman on 04/02/2017.
 */
public class SearchPage extends Driver{



    @FindBy(how= How.ID,using = "twotabsearchtextbox")
    public static WebElement searchBox;

    public SearchPage(){

        super(aDriver);

        PageFactory.initElements(Driver.aDriver,this);

    }

    public String searchPageTitle(){

    new WebDriverWait(aDriver, 2L)
                .until(ExpectedConditions.titleContains(""));
        return aDriver.getTitle();

    }


    public SearchPage  searchKeyword(String keyword){

        searchBox.clear();
        searchBox.sendKeys(keyword);


        return this;
    }

    public SearchResultsPage submitSearch(){

        searchBox.submit();

        return new SearchResultsPage();
    }


    public SearchPage selectFilter(){


        return this;
    }

    public String sortBy(String sortBy){



        return sortBy;
    }





}
