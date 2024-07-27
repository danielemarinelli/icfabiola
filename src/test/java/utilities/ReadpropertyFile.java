package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ReadpropertyFile {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("C:\\Users\\damarine2101\\eclipse-workspace\\com.icfabiola.school\\src\\test\\resources\\configfiles\\config.properties");
		Properties p = new Properties();
		p.load(fr);
		System.out.println(p.getProperty("browser"));
	}

}
