package utils;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;


    public static void initializePageObjects(){
        login = new LoginPage();
        dashboardPage = new DashboardPage();
        addEmployeePage = new AddEmployeePage();
        employeeSearchPage = new EmployeeSearchPage();
    }
}


/* used static here to avoid null pointer issue

instead of creating OBJECT in each class to initialize pages
creating this PageInitializer class to store objects

this class will used to create all objects
this class will be utilized in all stepDef, so that we dont have to create object there anymore
simply have to call the objects there

and that is done how:
  public static void initializePageObjects(){  // NEED TO INITIALIZE THIS OBJECT to make it usable//or else NullPointerException
        loginPage = new LoginPage(IM AN OBJECT);  //tis can be done by adding this method in Hooks precondition of launching //so that it launch and initialize it


with the concept of multi level inheritance if we extend this pageInitializer in commonMethods then
PageInitializer will be available in commonMethods
and commonMethod is already being extended in every class
and so with the help of multi Level inheritance all stepDef will get PageInitializer

PageInitializer is  Parent
CommonMethod    is  Child
allStepDef     are  GrandChild

 */
