package pages;

import base.TestBase;

import java.io.IOException;

public class BrowseFundRaiser extends TestBase  {





    public BrowseFundRaiser() throws IOException {
        super();
    }

    /**
     * Created by Tejas Toley
     * This method return the title of the page
     * @return
     */
    public String getTitle(){
        return driver.getTitle();
    }


}
