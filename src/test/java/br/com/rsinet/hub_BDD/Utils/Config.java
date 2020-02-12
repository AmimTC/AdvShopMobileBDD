package br.com.rsinet.hub_BDD.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private Properties properties;
	private final String propertyFilePath = "Config/Config.properties";
	
	public Config() {

		BufferedReader ler;
		try {
			ler = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(ler);
				ler.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties n�o acha " + propertyFilePath);
		}
	}
	public String getDeviceName() {

		String deviceName = properties.getProperty("deviceName");
		if (deviceName != null)
			return deviceName;
		else
			throw new RuntimeException("deviceName n�o especificado no arquivo Configuration.properties");
	}

	public String getUdid() {
		String udid = properties.getProperty("udid");
		if (udid != null)
			return udid;
		else
			throw new RuntimeException("udid n�o especificado no arquivo Configuration.properties");
	}

	public String getPlatformName() {
		String platformName = properties.getProperty("platformName");
		if (platformName != null)
			return platformName;
		else
			throw new RuntimeException("platformName n�o especificado no arquivo Configuration.properties");
	}

	public String getPlatformVersion() {
		String platformVersion = properties.getProperty("platformVersion");
		if (platformVersion != null)
		return platformVersion;
		else
			throw new RuntimeException("platformVersion n�o especificada no arquivo Configuration.properties");
	}
	public String getAppPackage() {
		String appPackage = properties.getProperty("appPackage");
		if (appPackage != null)
			return appPackage;
		else
			throw new RuntimeException("appPackage n�o especificada no arquivo Configuration.properties");
	}

	public String getAppActivity() {
		String appActivity = properties.getProperty("appActivity");
		if (appActivity != null)
			return appActivity;
		else
			throw new RuntimeException("appActivity n�o especificada no arquivo Configuration.properties");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("android"))
			return DriverType.ANDROID;
		else
			throw new RuntimeException(
					"nome do browser n�o especificado no arquivo Configuration.properties: " + browserName);

	}
	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException("Report n�o especificado ");
	}
}

