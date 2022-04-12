package stepDefinitions;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pageObjects.Add_computers;
import java.util.concurrent.ThreadLocalRandom;

public class BaseClass

{
    public WebDriver driver;
    public Add_computers add_comp;
    public Scenario sele_sc;


    //Created to generate random value for borrow amount
    public static Integer randomno_amt()
    {
        Integer amt_gen_no = ThreadLocalRandom.current().nextInt(500,50001);
        return amt_gen_no;
    }

    public static Integer randomno_lp()
    {
        Integer lp_gen_no = ThreadLocalRandom.current().nextInt(1,31);
        return lp_gen_no;
    }

    public static Integer lp_below_range()
    {
        Integer lp_below_rang = ThreadLocalRandom.current().nextInt(0 ,1);
        return lp_below_rang;
    }

    public static Integer lp_abv_range()
    {
        Integer lp_abv_rang = ThreadLocalRandom.current().nextInt(31,50);
        return lp_abv_rang;
    }

    public static Integer amt_bel_range()
    {
        Integer amt_below_rang = ThreadLocalRandom.current().nextInt(500);
        return amt_below_rang;
    }

    public static Integer amt_abv_range()
    {
        Integer amt_above_rang = ThreadLocalRandom.current().nextInt(50001,200000);
        return amt_above_rang;
    }

}
