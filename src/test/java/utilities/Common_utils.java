package utilities;

import constants.Constants;

import java.io.IOException;
import java.util.Properties;

public class Common_utils
{
    public void loadProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/config.properties"));
        Constants.CHROME_VAL = properties.getProperty("CHROME_VAL");
        Constants.DRIVER_PATH = properties.getProperty("DRIVER_PATH");
        Constants.WEB_URL = properties.getProperty("WEB_URL");
        Constants.DATAPATH = properties.getProperty("DATAPATH");

    }
}
