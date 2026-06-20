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
public class Trainee extends Person{
    private String fitnessGoal;
    private ArrayList<Bookings> bookings;
    
    public Trainee(String id, String name, String phoneNumber, int age, String fitnessGoal) {
        super(id,name,phoneNumber,age); 
        setFitnessGoal(fitnessGoal);
        this.bookings=new ArrayList<Bookings>(); //review this
    } 
    
    public Trainee() {
        super();
        this.fitnessGoal="";
        this.bookings = new ArrayList<Bookings>();
    }
    
    // Getters
    public String getFitnessGoal() {
        return fitnessGoal;
    }
    
    public ArrayList<Bookings> getBookings() {
       return bookings;
    }
    
    // Setters
    public void setFitnessGoal(String fitnessGoal) {
    if (fitnessGoal == null) {
        throw new IllegalArgumentException("Fitness goal cannot be null.");
    }
    if (fitnessGoal.equalsIgnoreCase("Weight Loss")
            || fitnessGoal.equalsIgnoreCase("Flexibility")
            || fitnessGoal.equalsIgnoreCase("Wellness")
            || fitnessGoal.equalsIgnoreCase("Strength")) {
        this.fitnessGoal = fitnessGoal;
    } 
    else {
        throw new IllegalArgumentException(
            "Invalid fitness goal. Must be Weight Loss, Flexibility, Strength, or Wellness.");
    }
    }
    
    public void setBookings(ArrayList<Bookings> bookings) {
    if (bookings == null) {
        throw new IllegalArgumentException("Bookings list cannot be null.");
    }
    this.bookings = bookings;
    }
    
    
    public void addBooking(Bookings booking) {
    this.bookings.add(booking);
    }
    
    
   @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("\nFitness Goal: " + fitnessGoal);
        System.out.println("Bookings:");
        
        if (bookings.isEmpty()) {
            System.out.println("  (none)");
        } 
        
        else {
            for (Bookings b : bookings) {
                System.out.println("Booking ID: " + b.getBookingId()+"\nStatus: " + b.getStatus());
            }
        }
    }
    
}