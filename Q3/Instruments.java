import java.io.*;
import java.util.Random;
public class Instruments{
    private String manufacturer;
    private String country_of_production;
    private int year_of_production;
    private Double weight;
    private Double price;
    private String material;
    private Boolean isElectric;
    private Boolean isTuned;
    private Boolean isBroken;
    public String pitch;
    public double soundQuality;

    public Instruments(String new_manufacturer, String new_country_of_production, int new_year_of_production, double new_weight, Double new_price, String new_material,
     Boolean new_isElectric, Boolean new_isTuned,Boolean new_isBroken, String new_pitch, double soundQuality){
    		manufacturer = new_manufacturer;
    		country_of_production = new_country_of_production;
    		year_of_production = new_year_of_production;
    		weight = new_weight;
    		price = new_price;
    		material = new_material;
    		isTuned = new_isTuned;
    		isElectric = new_isElectric;
            isBroken = new_isBroken;
    		this.soundQuality = tune();
    		pitch = new_pitch;
           }
    // abstract public void sound();
    public void produceSound(){
    	if (isBroken == true){
    		System.out.println("The instrument is unplayable.");
    	}
    	else{
    	if(soundQuality<5){
    		System.out.println("Bad sound");
    	}
    	else {
    		System.out.println("Nice sound");
    	}
    	soundQuality -= 1.0;
    	setIsBroken();
    }
}
    public void setisTuned(boolean isTuned){
    	this.isTuned = isTuned;
    }
    public void tune(){
    	setisTuned(true);
    }
    public void setSoundQuality(Double soundQuality){
    	if (isTuned == false){
    		this.soundQuality = 5.0;
    		System.out.println("its not tuned, so the sound quality is set to 5");
    	}
    	else{
    	this.soundQuality = soundQuality;
    }
    }
    public void setIsTuned(boolean isTuned){
    	this.isTuned = isTuned;
    }
    public void setIsBroken(){
        if(this.soundQuality <= 0){
            this.isBroken = true;
            setIsTuned(false);
        }
    }
    public double tune(){
        Random r = new Random();
        double n = Math.random()*5+5;
        return n;
    }
    public String toString(){
    	String returning = "Sound quality" + soundQuality + "Is it broken " + isBroken + "is it tuned " + isTuned;
    	return returning;
    }
}