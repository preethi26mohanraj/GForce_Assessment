package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.apache.commons.validator.GenericValidator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Add_computers;
import utilities.Common_utils;
import java.io.IOException;
import static constants.Constants.*;

public class Seleniumsteps extends BaseClass
{

   @Before
    public void initial_Setup(Scenario s) throws IOException {
        this.sele_sc = s;
        Common_utils com_utils = new Common_utils();
        com_utils.loadProperties();
        System.setProperty(CHROME_VAL, DRIVER_PATH);
        driver = new ChromeDriver();
        add_comp = new Add_computers(driver);
        sele_sc.log("  The browser is launched");
    }

    @Given("User opens the web application")
    public void user_opens_the_link() throws InterruptedException {
       driver.get(WEB_URL);
       driver.manage().window().maximize();
       Thread.sleep(2000);
       sele_sc.log("!------The application is launched successfully------!");

    }

    @When("User clicks on the Add a New Computer button")
    public void user_clicks_add_new_comp_button()
    {
        add_comp.setAdd_new_comp();
        sele_sc.log("!------The button to add new computer to database exists------!");
    }
    @Then("User should view the new form page with heading {string}")
    public void user_views_the_new_form_page(String exp_hdr) throws InterruptedException {
        String act_title = add_comp.getpage_hdr();
        sele_sc.log("!------The Actual title is------!" + act_title);
        Thread.sleep(2000);
        Assert.assertEquals(act_title,exp_hdr);
        sele_sc.log("!------The Actual and expected title matches------!");
    }


    @When("Enters the values for {string},{string},{string} and {string}")
    public void enters_the_values_for_fields(String computer_nm, String intro_dt, String discon_dt, String company_nm) throws InterruptedException {

        String mes1 = add_comp.getmand_computer_nm();
        String mes2 = add_comp.getmand_intro_dt();
        String mes3 = add_comp.getmanddiscont_dt();
        String mes4 = add_comp.getmandcompany_nm();
        if (computer_nm != "" && intro_dt != "" && discon_dt != "" && company_nm != "") {
            add_comp.setComp_name(computer_nm);
            boolean introdt_format = GenericValidator.isDate(intro_dt, "yyyy-MM-dd", true);
            sele_sc.log("!------The value is------!" + introdt_format);
            if (introdt_format == false) {
                sele_sc.log("!------Input Introduced date in right format------!");
                Assert.fail("Input Introduced date in right format");

            } else
                add_comp.setIntroduced_dt(intro_dt);
            boolean discontdt_format = GenericValidator.isDate(discon_dt, "yyyy-MM-dd", true);
            sele_sc.log("!------The value is------!" + discontdt_format);
            if (discontdt_format == false) {

                sele_sc.log("!------Input Discontinued date in right format------!");
                Assert.fail("Input Discontinued date in right format");
            } else
                add_comp.setDiscontinued_dt(discon_dt);
            add_comp.setCompany(company_nm);
            Thread.sleep(1000);

            sele_sc.log("!------New computer details are entered------!");
        } else if (mes1.contains("Required") && mes2.contains("Required") && mes3.contains("Required") && mes4.contains("Required")) {
            Assert.fail("All fields are mandatory");
            Assert.fail("Enter values for all the fields");
        } else
            Assert.fail("Missing information to highlight the mandatory field");
    }

    @And("User clicks the Add computer button to add the entry")
    public void user_clicks_add_button()
    {
        add_comp.setAdd_comp_btn();
        sele_sc.log("!------Clicks Adding new computer to database ------!");
    }
    @Then("User should view the data for {string} in the main page")
    public void user_view_the_new_data(String searchby_name) throws InterruptedException {
        add_comp.setSearch_nm(searchby_name);
        add_comp.setSearch_click();
        String act_comp_nm = add_comp.getadded_nm();
        sele_sc.log("!------The Actual Computer name added is------!" + act_comp_nm);
        Thread.sleep(2000);
        Assert.assertEquals(act_comp_nm,searchby_name);
        sele_sc.log("!------The Actual and expected computer name matches------!");
        sele_sc.log("!------The new computer name is added to the database------!");
    }

    @When("Enters the values for {string}")
    public void enters_the_values(String laptop_nm) {
        add_comp.setComp_name(laptop_nm);
        sele_sc.log("!------The computer name is entered------!");
    }
    @When("User clicks cancel button to abort the adding the entry")
    public void user_clicks_cancel_button() {
        sele_sc.log("!------User wants to stop adding to the database------!");
        add_comp.setCancel_btn();
    }
    @Then("User should go back to the main page")
    public void user_views_the_main_page() {
       sele_sc.log("!------Check the header in the main page------!");
       String actual_hdr = add_comp.getmain_page_hdr();
       add_comp.getmain_page_hdr().contains("computers found");
       sele_sc.log("!------The header in the main page is ------!"+ actual_hdr);
    }

    @After
    public void close_browser()
    {
        driver.close();
    }

}
