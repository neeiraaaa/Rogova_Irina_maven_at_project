package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.BookingRegistrationPage;
import steps.RegistrationOnBooking;

@Suite.SuiteClasses({BookingRegistrationPage.class, RegistrationOnBooking.class}) //что-то еще добавить нужно???
@RunWith(Suite.class)

public class JUnitRunner {


}


//@RunWith(MyTestRunner.class)
//public class MyTestClass {

    //@Test
    //public void myTest() {
   // ..
   // }
//}
