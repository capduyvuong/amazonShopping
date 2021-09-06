package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyValues {
    private InputStream inputStream;
    private Properties prop;

    public PropertyValues(String propFilePath) {

        try {
            prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(propFilePath);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file path '" +
                        propFilePath + "' not found in the classpath");
            }
        } catch (Exception ex) {
            Log.errorAndStop("Exception: when open config init " + ex.getMessage());
        }
    }

    public String getProperty(String propertyName){
        try{
            Log.debug("Property value of property '" + propertyName + "' : " + prop.getProperty(propertyName) );
            return prop.getProperty(propertyName);
        } catch(Exception ex){
            return "";
        }

    }

    public void closeInit(){
        try{
            inputStream.close();
        } catch( IOException ioe ){
            Log.errorAndStop("Exception when close config init : "
                    + ioe.getMessage());
        }
    }
}
