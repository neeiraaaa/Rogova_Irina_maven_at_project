package tests.magnit;

import org.junit.Test;
import pages.magnitAuthorizationApi.MagnitAuthorization;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isA;

public class MagnitTest {

    MagnitAuthorization magnitAuthorization = new MagnitAuthorization();

    @Test
    public void anonymousToken() {
        magnitAuthorization.getAnonymousToken().body("exp", isA(Integer.class));
    }

    @Test
    public void sendCodePhone() {
        magnitAuthorization.sendCode("+79773099541");
    }



}
