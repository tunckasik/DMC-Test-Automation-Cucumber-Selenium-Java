package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.Departments_PO;

public class A06_departments_Steps {

    Departments_PO departments_po = new Departments_PO();

    @Given("I navigate to departments page")
    public void iNavigateToDepartmentsPage() {
        departments_po.navigateToDepartmentsPage();
    }

    @Then("I verify {int} departments are visible")
    public void iVerifyDepartmentsAreVisible(int arg0) {
        departments_po.verifyDepartmentsNumber(arg0);
    }
}
