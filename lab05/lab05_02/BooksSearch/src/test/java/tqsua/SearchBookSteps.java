package tqsua;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchBookSteps {

    private Library library;
    private List<Book> results;

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day) {
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), 0, 0);
    }

    @Given("a search book tool I just turned on")
    public void setup() {
        library = new Library();
    }

    @Given("a book with the title {string}, written by {string}, published in {iso8601Date}")
    public void addNewBook(final String title, final String author,  final LocalDateTime date) {
        library.addBook(new Book(title, author, date));
    }

    @When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
    public void searchByPub(LocalDateTime fromYear, LocalDateTime toYear) {
        results = library.findBooks(fromYear, toYear);
    }

    @When("the customer searches for books written by {string}")
    public void searchByAuthor(String author) {
        results = library.findBooks(author);
    }

    @When("the customer searches for books with title {string}")
    public void searchByTitle(String title) {
        results = library.findBooksByTitle(title);
    }

    @Then("{int} books should have been found")
    public void foundBooksSize(int books) {
        assertEquals(results.size(), books);
    }

    @Then("Book {int} should have the title {string}")
    public void equalTitle(int position, String title) {
        assertEquals(results.get(position-1).getTitle(), title);
    }
}


