package pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="healthprofile")
@XmlType(propOrder = { "weight", "height","lastupdate", "BMI" })
@XmlAccessorType(XmlAccessType.FIELD)
public class HealthProfile {
	private double weight; // in kg
	private double height; // in m
	private String lastupdate; 

	public HealthProfile(double weight, double height,String lastupdate) {
		this.weight = weight;
		this.height = height;
		this.lastupdate=lastupdate;
	}

	public HealthProfile() {
		this.weight = 85.5;
		this.height = 1.72;
		this.lastupdate="2015-10=22";
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
public void setLastupdate(String lastupdate){
	this.lastupdate=lastupdate;
}
public String getLastupdate() {
	return lastupdate;
}
	@XmlElement(name="bmi")
	public double getBMI() {
		return this.weight/(Math.pow(this.height, 2));
	}
	public String toString() {
		return "Height="+height+", Weight="+weight+",BMI="+getBMI()+",LastUpdate="+lastupdate;
	}

}
