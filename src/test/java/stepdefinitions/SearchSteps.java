package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.HomePage;
import pageobjects.SearchPage;
import pageobjects.SearchResultsPage;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by zsuleiman on 05/02/2017.
 */
public class SearchSteps  {


    private HomePage homePage = new HomePage();
    private SearchPage searchPage = new SearchPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();



    @Given("^User navigates to Amazon$")
    public void userNavigateToAmazon(){

       homePage.gotoAmazon();
    }

    @Then("^User should be Amazon page$")
    public void pageShouldBeAmazon(){

        assertThat(
                homePage.pageTitle().
                        contains("Amazon.co.uk"),
                is(true));

    }

    @Given("^User search for \"([^\"]*)\"$")
    public void userSearchFor(String searchKeyword){

        searchPage.searchKeyword(searchKeyword);
        searchPage.submitSearch();

    }


    @Then("^search results should contains \"([^\"]*)\"$")
    public void searchResultsShouldContain(String searchKeyword){

        assertThat(
                searchResultsPage.
                getResultTitles().toString()
                .contains(searchKeyword),is(true));

    }

    @Then("^No results should returned$")
    public void noSearchResultReturned(){

        assertThat(
                searchResultsPage.
                        zeroSearchResults(),
                is(true));

    }
    @Then("^Message \"([^\"]*)\" should be displayed$")
    public void invalidSearchMessageShouldBeDisplayed(String message){

            assertThat(searchResultsPage
                    .searchErrorMessage(),
                    containsString(message));

    }

    @When("^User Applies Category Filter \"([^\"]*)\"$")
    public void userFiltersByCategory(String category){

        searchResultsPage.filterByCategory(category);


    }

    @Then("^Results Should be Filtered with \"([^\"]*)\"$")
    public void resultsShouldBeFilteredBy(String filter){

            assertThat(searchResultsPage.
                    resultFilteredBy(filter),is(true));

    }


    @Given("^Sort By \"([^\"]*)\"$")
    public void userSortBy(String sortBy){

        searchResultsPage.sortBy(sortBy);

    }

    @Then("^Result should be Sorted By \"([^\"]*)\"$")
    public void resultShouldBeSortedBy(String sortedBy){

        assertThat(
                searchResultsPage.sortedBy(),
                containsString(sortedBy));
    }

}
