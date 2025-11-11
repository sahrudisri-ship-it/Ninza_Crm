package propertyUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String readDataFromPropertyFile(String key) throws IOException
	
	{
		
	FileInputStream File=new FileInputStream("./src/test/resources/PropertyFile.properties");
	Properties pop =new Properties();
	pop.load(File);
	String value = pop.getProperty(key);
	return value;
	
	
	

	
	}

}
