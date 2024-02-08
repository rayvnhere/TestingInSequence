package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }
    @After
    public void end(){
        closeBrowser();
    }
}

/*@Before tag from (io.cucumber.java) cuz we are implementing the concepts of CUCUMBER not Junit
this method will always execute before every scenario because it has @Before tag which is PRE-CONDITION

@After tag from (io.cucumber.java)
this method will always execute after every scenario because it has @AFTER tag which is POST-CONDITION

#cucu automatically uses these tag's
# for hooks you dont have to generate stepDef
 */