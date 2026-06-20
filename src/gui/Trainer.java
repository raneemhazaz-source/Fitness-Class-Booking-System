/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author skills 30-8-25
 */import java.util.ArrayList;
public class Trainer extends Person implements Availability{
    private String specialization;
    private ArrayList<Sessions> sessions;
    
     public Trainer() {
        super(); 
        this.specialization = "";
        this.sessions = new ArrayList<Sessions>();
    }
    
    
     public Trainer(String id, String name, String phoneNumber, int age, String specialization) {
        super(id,name,phoneNumber,age); 
        setSpecialization(specialization);
        this.sessions= new ArrayList<Sessions>(); //review this
    } 
    
    public String getSpecialization(){
        return specialization;
    }
    
     public ArrayList<Sessions> getSessions() {
        return sessions;
    }
    
    
    public void setSpecialization(String specialization) {
    if (specialization == null) {
        throw new IllegalArgumentException("Specialization cannot be null.");
    }
    if (specialization.equalsIgnoreCase("Yoga")
            || specialization.equalsIgnoreCase("Strength")
            || specialization.equalsIgnoreCase("Cardio")) {
        this.specialization = specialization;
    } 
    else {
        throw new IllegalArgumentException(
            "Invalid specialization. Must be Yoga, Strength, or Cardio.");
    }
    }
    
    public void setSessions(ArrayList<Sessions> sessions) {
        this.sessions = sessions != null ? sessions : new ArrayList<Sessions>();
    }
    
    //Check this
    public void addSession(Sessions session) {
        if (this.sessions == null) {
            this.sessions = new ArrayList<Sessions>();
        }
        
        this.sessions.add(session);
    }
    
    @Override
    public void printInfo(){
    super.printInfo();
    System.out.println("\nSpecialization: " + specialization);
    System.out.println("Sessions:");
    
    if (sessions.isEmpty()) {
        System.out.println("  (none)");
    } 
    else {
        for (Sessions s : sessions) {
            System.out.println("Session ID:  " + s.getSessionID() + "\nSession Name: " + s.getSessionName());
        }
    }
    }
    
    @Override
    public boolean isAvailable(){
        if(sessions.size()>=MAX_CAPACITY)
            return false;
        else
            return true;
    }
    
    public String toString(){
        return " Trainer id :\n"+super.getId()+"Trainer Name:\n"+super.getName()+"Trainer Phone:\n"+super.getPhoneNumber()+"Trainer Age:\n"+super.getAge()+"specialization"+ getSpecialization();
    }  
}
    
