package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {

	protected Properties Prop = null;
	protected FileInputStream LoadFile = null;

	public ReadingPropertiesFile(String FilePath) throws IOException {
		Prop = new Properties();
		LoadFile = new FileInputStream(FilePath);
		Prop.load(LoadFile);
	}

	// ===== Driver Methods =======
	public String GetBrowser() {
		return Prop.getProperty("browser");
	}
	public String Get_URL() {
		return Prop.getProperty("URL");
	}
	public String Get_Filepath() {
		return Prop.getProperty("Filepath");
	}

	public String Get_Filename() {
		return Prop.getProperty("Filename");
	}
	public String Get_Sheetindex() {
		return Prop.getProperty("Sheetindex");
	}
}
