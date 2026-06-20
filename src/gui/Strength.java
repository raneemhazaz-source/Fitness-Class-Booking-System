/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author skills 30-8-25
 */
public class Strength extends Sessions {

private String equipmentRequired;

public Strength () {
    super();
    this.equipmentRequired="NONE";
}
public Strength (String equipmentRequired, String sessionID, String sessionName, int capacity, Date date, Trainer trainer) {
    super(sessionID,sessionName,capacity,date,trainer);
    setEquipmentRequired(equipmentRequired);
}


@Override
public void printInfo() {
       System.out.println("Session ID:"+getSessionID());
       System.out.println("Session Name:" +getSessionName());
       System.out.println("Capacity: "+getCapacity());
       System.out.print("Date: "); 
       if (getDate() != null) { getDate().printInfo(); }
       System.out.println("\nEquipment Required: "+equipmentRequired);}


// S&G 
public void setEquipmentRequired(String equipment) {
    if (equipment.equalsIgnoreCase("Barbells")|| equipment.equalsIgnoreCase("Dumbbells") ||equipment.equalsIgnoreCase("Resistance Bands") ||  equipment.equalsIgnoreCase("Bodyweight") ) {
        this.equipmentRequired= equipment;
    } else {
        System.out.println("Invalid equipment. Please choose barbells, dumbells, resistance bands, or bodyweight!");
        this.equipmentRequired="NONE";
    }
}

public String getEquipmentRequired() {
    return equipmentRequired; }


 @Override
    public String toString() {
        return "equipmentRequired:\n\t"+getEquipmentRequired()+"Session ID:\n\t"+getSessionID()+"Session Name:\n\t" +getSessionName()+"Capacity:\n\t "+getCapacity()+"Date\n\t"+getDate()+"Trainer\n\t"+getTrainer();
    }
}
