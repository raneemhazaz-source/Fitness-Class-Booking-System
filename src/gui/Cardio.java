/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author skills 30-8-25
 */
public class Cardio extends Sessions {

private String intensityLevel;

public Cardio () { 
    super();
    this.intensityLevel = "LOW";
}
public Cardio (String intensityLevel, String sessionID, String sessionName, int capacity, Date date, Trainer trainer) {
    super(sessionID,sessionName,capacity,date,trainer);
    setIntensityLevel(intensityLevel);
}


@Override
public void printInfo() {
       System.out.println("Session ID:"+getSessionID());
       System.out.println("Session Name:" +getSessionName());
       System.out.println("Capacity: "+getCapacity());
       System.out.print("Date: "); 
       if (getDate() != null) { getDate().printInfo(); }
       System.out.println("\nIntensity Level: "+intensityLevel);}


// S&G 
public void setIntensityLevel(String level) {
    if (level.equalsIgnoreCase("Low")|| level.equalsIgnoreCase("Medium") ||level.equalsIgnoreCase("High") ) {
        this.intensityLevel= level;
    } else {
        System.out.println("Invalid intensity level. Please choose low, medium, or high!");
        this.intensityLevel="LOW";
    }
}

public String getIntensityLevel() {
    return intensityLevel; }


 @Override
    public String toString() {
        return "String intensityLevel\n\t"+getIntensityLevel()+"Session ID:\n\t"+getSessionID()+"Session Name:\n\t" +getSessionName()+"Capacity: \n\t"+getCapacity()+"Date\n\t"+getDate()+"Trainer\n\t"+getTrainer();
    }
}