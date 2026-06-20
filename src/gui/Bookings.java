/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author skills 30-8-25
 */
public class Bookings {
    private String bookingId;
    private Trainee trainee;
    private Sessions session;
    private String status;
    
    // Default constructor
    public Bookings() {
        this.bookingId = "";
        this.trainee = null;
        this.session = null;
        this.status = "";
    }
    
    // Parameterized constructor
    public Bookings(String bookingId, Trainee trainee, Sessions session, String status) {
        this.bookingId = bookingId;
        this.trainee = trainee;
        this.session = session;
        setStatus(status); 
    }
    
  
    public String getBookingId() {
        return bookingId;
    }
    
    public Trainee getTrainee() {
        return trainee;
    }
    
    public Sessions getSession() {
        return session;
    }
    
    public String getStatus() {
        return status;
    }
    
    
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    
    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }
    
    public void setSession(Sessions session) {
        this.session = session;
    }
    
    public void setStatus(String status) {
    if (status == null) {
        throw new IllegalArgumentException("Status cannot be null.");
    }
    
    if (status.equalsIgnoreCase("Confirmed") 
            || status.equalsIgnoreCase("Cancelled")
            || status.equalsIgnoreCase("Pending")) {
        this.status = status;
    } 
    
    else {
        throw new IllegalArgumentException(
            "Invalid status. Must be Confirmed, Cancelled, or Pending.");
    }
    }
    
    public void cancelBooking(){
        this.status="Cancelled";
    }
    
    public void printInfo(){
        System.out.println("\nBooking ID: " + bookingId+"\nStatus: " + status);
        System.out.println("--- Trainee ---");
        if (trainee != null) {
            trainee.printInfo();
        } 
        else {
            System.out.println("(no trainee)");
        }
        System.out.println("--- Session ---");
        if (session != null) {
            session.printInfo();
        } 
        else {
            System.out.println("(no session)");
        }
    }
    
}