package pages.magnitAuthorizationApi;

import driver.BasicDriver;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MagnitAuthorization {

    private static final String MAIN_URL = "https://express-stage.magnit.ru/delivery_api/auth_client";
    private static final String GET_ANONYMOUS_TOKEN = "https://express-stage.magnit.ru/delivery_api/auth_client/authentication";
    private static final String SEND_CODE = "'https://express-stage.magnit.ru/delivery_api/auth_client/v2/authorization/confirm_phone";
    private static final String CONFIRMATION_MOBILE_NUMBER = "https://express-stage.magnit.ru/delivery_api/auth_client/v2/authorization/confirm_phone/complete";
    private static final String GET_TOKEN_WITH_CLINT_RIGHTS = "https://express-stage.magnit.ru/delivery_api/auth_client/user";
    private static final String EMAIL_LOGIN_INPUT = "//input[@placeholder='E-mail или Логин']";
    private static final String PASSWORD_INPUT = "//input[@placeholder= 'Пароль']";
    private static final String BUTTON_TO_COME_IN = "//button[@class= 'btn btn--blue btn--login']";


    private RequestSpecification magnitSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(MAIN_URL)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    private ValidatableResponse extractableResponse(String url) {
        return RestAssured
                .given()
                .spec(magnitSpecification())
                .when()
                .get(url)
                .then()
                .statusCode(200);
    }

    private String urlSetter(String url) {
        return url;
    }

    public ValidatableResponse getAnonymousToken() {
        return extractableResponse(urlSetter(GET_ANONYMOUS_TOKEN));
    }

    public ValidatableResponse sendCode(String phone) {
        return extractableResponse(urlSetter(String.format(SEND_CODE, phone)));
    }

    public static void copyCodeOnWebSite() {
        WebDriver driver = BasicDriver.getWebDriver();
        driver.manage().window().maximize();
        driver.get("https://onlinesim.ru/auth/login/?redirect=https%3A%2F%2Fonlinesim.ru%2Fv2%2Fpages%2Fprofile%3F");
        driver.findElement(By.xpath(EMAIL_LOGIN_INPUT)).click();
        driver.findElement(By.xpath(EMAIL_LOGIN_INPUT)).sendKeys("BSL");
        driver.findElement(By.xpath(PASSWORD_INPUT)).click();
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys("Magnit");
        driver.findElement(By.xpath(BUTTON_TO_COME_IN)).click();

        //to do something

        driver.quit();
        driver.close();
    }


    public ValidatableResponse confirmationMobileNumber(String phone, String code) {
        return extractableResponse(urlSetter(String.format(CONFIRMATION_MOBILE_NUMBER , phone, code)));
    }

    public ValidatableResponse getTokenWithClintRight(String phone, String email, String name) {
        return extractableResponse(urlSetter(String.format(GET_TOKEN_WITH_CLINT_RIGHTS , phone, email, name)));
    }
}
