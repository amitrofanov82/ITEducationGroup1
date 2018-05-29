package lesson90.app.model;

import java.io.IOException;
import java.util.Properties;

import com.google.gson.annotations.Expose;

public class Elephant {
	
	private ElephantPersonality personality;
	private double weightKg;
	private String pictureAsBase64;
	private String name;
	
	@Expose(serialize=false)
	private Properties props = new Properties();
	
	
	public Elephant() {
		personality = new ElephantPersonality();
		personality.setIq(100);
		personality.setTemperament(Temperament.AGRESSIVE);
		weightKg = 5000;
		name = "Elephant Vasya";
		
		try {
			props.load(this.getClass().getResourceAsStream("/base64pictures.properties"));
		} catch (IOException e) {
			//do nothing
		}
		pictureAsBase64 = props.getProperty("elephantPicture");
	}
	public ElephantPersonality getPersonality() {
		return personality;
	}
	public void setPersonality(ElephantPersonality personality) {
		this.personality = personality;
	}
	public double getWeightKg() {
		return weightKg;
	}
	public void setWeightKg(double weightKg) {
		this.weightKg = weightKg;
	}
	public String getPictureAsBase64() {
		return pictureAsBase64;
	}
	public void setPictureAsBase64(String pictureAsBase64) {
		this.pictureAsBase64 = pictureAsBase64;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
































