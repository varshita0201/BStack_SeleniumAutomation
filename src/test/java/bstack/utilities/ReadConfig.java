package bstack.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src=new File("./Configuration/config.properites");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}
	public String getAppUrl() {
		String url=pro.getProperty("url");
		return url; 
	}
	
	public String getUserId() {
		String userId=pro.getProperty("userid");
		return userId;
	}
	
	public String getPassword() {
		String psw=pro.getProperty("passWord");
		return psw;
	}
}
