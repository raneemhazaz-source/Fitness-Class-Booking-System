/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author skills 30-8-25
 */
import java.util.ArrayList;


public abstract class Sessions implements Availability {
    
    private String sessionID, sessionName;
    private int capacity;
    private Date date;
    private Trainer trainer;
    private ArrayList<Bookings> bookings;
    
    
    public Sessions(){
        this.bookings = new ArrayList<>(); }
        
    public Sessions(String sessionID, String sessionName, int capacity, Date date, Trainer trainer) {
        this.sessionID = sessionID;
        this.sessionName = sessionName;
        this.capacity = capacity;
        this.date = date;
        this.trainer = trainer;
        this.bookings = new ArrayList<>();
    }
    
    
    @Override
    public boolean isAvailable() {
        return bookings.size() < capacity;
    }
    
    public abstract void printInfo();
    
    
    // S&G
    public String getSessionID() { 
        return sessionID; }
    public void setSessionID(String sessionID) { 
        this.sessionID = sessionID; }

    public String getSessionName() { 
        return sessionName; }
    public void setSessionName(String sessionName) { 
        this.sessionName = sessionName; }

    public int getCapacity() { 
        return capacity; }
        
    public void setCapacity(int capacity) { 
        if (capacity <= MAX_CAPACITY && capacity > 0) {
            this.capacity = capacity; 
        } else {
            System.out.println("Invalid capacity! Must be between 1 and " + MAX_CAPACITY);
            this.capacity = MAX_CAPACITY; 
        }
}
    public Date getDate() {
        return date;
    }

    
    
    public void setDate(Date date) { 
        this.date = date; }

    public Trainer getTrainer() { 
        return trainer; }
    public void setTrainer(Trainer trainer) { 
        this.trainer = trainer; }
        
    public ArrayList<Bookings> getBookings() {
    return bookings;
    }

    // *** Checker! 
   public void addBooking(Bookings booking) throws IllegalArgumentException {
       if (bookings.size()>= capacity) {
           throw new IllegalArgumentException("Session Full: Max capacity reached, cannot add more bookings! ");
       }
       bookings.add(booking);
       
       
   }
    
    
    
    

}