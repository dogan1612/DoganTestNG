package Framework.Core;

import Component.Pages.LandingPage;
import Component.Pages.LoginPage;



public class Pages {
    private LoginPage loginPage;
    private LandingPage landingPage;

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public LandingPage landingPage() {
        if (landingPage == null) {
            landingPage = new LandingPage();
        }
        return landingPage;
    }

}
