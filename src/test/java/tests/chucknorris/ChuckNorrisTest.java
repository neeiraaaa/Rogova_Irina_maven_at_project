package tests.chucknorris;

import org.junit.Test;
import pages.chucknorris.MainPage;

import static org.hamcrest.Matchers.*;

public class ChuckNorrisTest {

    MainPage mainPage = new MainPage();

    @Test
    public void randomNameConnectionTest() {
        mainPage.getJokeWithRandomName("Maks", "Ledovskih").assertThat().header("Connection", "Keep-Alive");
    }

    @Test
    public void randomNameValueTest() {
        mainPage.getJokeWithRandomName("Maks", "Ledovskih").body("type", equalTo("success"));
    }

    @Test
    public void randomNameJokeContainsFirstNameTest() {
        mainPage.getJokeWithRandomName("Maks", "Ledovskih").body("value.joke", containsString("Maks"));
    }

    @Test
    public void randomNameJokeContainsLastNameTest() {
        mainPage.getJokeWithRandomName("Maks", "Ledovskih").body("value.joke", containsString("Ledovskih"));
    }

    @Test
    public void randomJokeNameTest() {
        mainPage.getRandomJoke().body("value.joke", containsString("Norris"));
    }

    @Test
    public void randomJokeIdTest() {
        mainPage.getRandomJoke().body("value.id", isA(Integer.class));
    }

    @Test
    public void randomJokeConnectionTest() {
        mainPage.getRandomJoke().assertThat().header("Connection", "Keep-Alive");
    }

    @Test
    public void randomMultipleJokesCountTest() {
        mainPage.getMultipleRandomJokes(2).body("value", hasSize(2));
    }

    @Test
    public void randomMultipleJokesLastJokeNameTest() {
        mainPage.getMultipleRandomJokes(2).body("value.joke", hasToString(containsString("Norris")));
    }

    @Test
    public void randomMultipleJokesIdCountTest() {
        mainPage.getMultipleRandomJokes(2).body("value.id", hasSize(2));
    }

    @Test
    public void getSpecificJokeIdTest() {
        mainPage.getSpecificJoke(13).body("value.id", is(13));
    }

    @Test
    public void getSpecificJokeNameTest() {
        mainPage.getSpecificJoke(13).body("value.joke", containsString("Norris"));
    }

    @Test
    public void getSpecificJokeCategoryTest() {
        mainPage.getSpecificJoke(13).body("value.categories", hasToString(containsString("explicit")));
    }

    @Test
    public void getNumberOfJokesCountTest() {
        mainPage.getNumberOfJokes().body("value", is(574));
    }

    @Test
    public void getNumberOfJokesValueTypeOfValueTest() {
        mainPage.getNumberOfJokes().body("value", isA(Integer.class));
    }

    @Test
    public void getNumberOfJokesValueTypeTest() {
        mainPage.getNumberOfJokes().body("type", isA(String.class));
    }


}
