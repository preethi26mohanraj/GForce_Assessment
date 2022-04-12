package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Add_computers
{
                public WebDriver pdriver;

                public Add_computers(WebDriver ldriver)
                {
                    pdriver =ldriver;
                        PageFactory.initElements(pdriver,this);
                }

                By add_new_comp = By.xpath("//*[@id = 'add']");
                By new_form_page = By.xpath("//*[@id='main']/h1");
                By comp_name = By.xpath("//*[@id='name']");
                By introduced_dt = By.xpath("//*[@id='introduced']");
                By Discontinued_dt = By.xpath("//*[@id='discontinued']");
                By company = By.xpath("//*[@id='company']");
                By comp_nm_IBM = By.xpath("//*[@id='company']/option[14]");
                By comp_nm_Canon = By.xpath("//*[@id='company']/option[16]");
                By add_comp_btn = By.xpath("//*[@id='main']/form/div/input");
                By cancel_btn = By.xpath("//*[@id='main']/form/div/a");
                By search_nm = By.xpath("//*[@id='searchbox']");
                By search_click = By.xpath("//*[@id='searchsubmit']");
                By new_comp_nm = By.xpath("//*[@id='main']/table/tbody/tr/td[1]/a");
                By compu_nm_mand = By.xpath("//*[@id='main']/form/fieldset/div[1]/div/span");
                By intro_dt_mand = By.xpath("//*[@id='main']/form/fieldset/div[2]/div/span");
                By discon_dt_mand = By.xpath("//*[@id='main']/form/fieldset/div[3]/div/span");
                By comp_nm_mand = By.xpath("//*[@id='main']/form/fieldset/div[4]/div/span");
                By main_page_hdr = By.xpath("//*[@id='main']/h1");


                //Action methods

                public void setAdd_new_comp()
                 {
                        pdriver.findElement(add_new_comp).click();
                 }

                public String getmain_page_hdr()
                {
                    String main_page_title = pdriver.findElement(main_page_hdr).getText();
                    return main_page_title;
                }

                public String getpage_hdr()
                {
                        String new_page_title = pdriver.findElement(new_form_page).getText();
                        return new_page_title;
                }

                public void setCompany(String comp_name) throws InterruptedException
                {
                    pdriver.findElement(company).click();
                    WebElement listitem;
                    Thread.sleep(2000);

                    if(comp_name.equals("IBM"))
                    {
                       listitem= pdriver.findElement(comp_nm_IBM);
                    }
                    else if(comp_name.equals("Canon"))
                    {
                        listitem= pdriver.findElement(comp_nm_Canon);
                    }
                    else
                        listitem= pdriver.findElement(company);
                    listitem.click();
                    Thread.sleep(2000);

                }

                public void setComp_name(String computer_nm)
                {
                    pdriver.findElement(comp_name).sendKeys(computer_nm);
                }

                public void setIntroduced_dt(String txt_intro_dt)
                {
                    pdriver.findElement(introduced_dt).sendKeys(txt_intro_dt);
                }

                public void setDiscontinued_dt(String txt_discontinue_dt)
                {
                    pdriver.findElement(Discontinued_dt).sendKeys(txt_discontinue_dt);
                }

                public void setAdd_comp_btn()
                {
                    pdriver.findElement(add_comp_btn).click();
                }
                public  void setCancel_btn()
                {
                    pdriver.findElement(cancel_btn).click();
                }
                public void setSearch_nm(String txt_search_nm)

                {
                    pdriver.findElement(search_nm).sendKeys(txt_search_nm);
                }

                public void setSearch_click()
                {
                    pdriver.findElement(search_click).click();
                }

                public String getadded_nm()
                {
                    String added_comp_nm = pdriver.findElement(new_comp_nm).getText();
                    return added_comp_nm;
                }

                public String getmand_computer_nm()
                {
                    String mand_computer_nm = pdriver.findElement(compu_nm_mand).getText();
                    return mand_computer_nm;
                }

                public String getmand_intro_dt()
                {
                    String mand_intro_dt = pdriver.findElement(intro_dt_mand).getText();
                    return mand_intro_dt;
                }

                public String getmanddiscont_dt()
                {
                    String mand_discont_dt = pdriver.findElement(discon_dt_mand).getText();
                    return mand_discont_dt;
                }

                public String getmandcompany_nm()
                {
                    String mand_comp_nm = pdriver.findElement(comp_nm_mand).getText();
                    return mand_comp_nm;
                }
}
