/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author skills 30-8-25
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyClass {
    
    public static void main(String args[])  {
        
        
        Trainer trainer1 = new Trainer("T001", "Sara Ali", "0501234567", 30, "Yoga");
        Trainer trainer2 = new Trainer("T002", "Khalid Omar", "0559876543", 28, "Cardio");
        Trainer trainer3 = new Trainer("T003", "Noor Saleh", "0531112233", 35, "Strength");
 
        System.out.println("=== Trainers ===");
        trainer1.printInfo();
        System.out.println("----------------");
        trainer2.printInfo();
        System.out.println("----------------");
        trainer3.printInfo();
        
        Trainee trainee1 = new Trainee("TR001", "Lina Hassan", "0521234567", 22, "Flexibility");
        Trainee trainee2 = new Trainee("TR002", "Ahmed Saad", "0567654321", 25, "Weight Loss");
        Trainee trainee3 = new Trainee("TR003", "Reem Faisal", "0543339988", 29, "Strength");
 
        System.out.println("\n=== Trainees ===");
        trainee1.printInfo();
        System.out.println("----------------");
        trainee2.printInfo();
        System.out.println("----------------");
        trainee3.printInfo();
        
        Date date1 = new Date(2026, 5, 10, 9, 0);
        Date date2 = new Date(2026, 5, 11, 11, 30);
        Date date3 = new Date(2026, 5, 12, 15, 0);
 
 Yoga     yogaSession     = new Yoga("Vinyasa", "S001", "Morning Vinyasa Flow", 5, date1, trainer1);
        Cardio   cardioSession   = new Cardio("High", "S002", "HIIT Cardio Blast", 3, date2, trainer2);
        Strength strengthSession = new Strength("Dumbbells", "S003", "Full Body Strength", 4, date3, trainer3);
 
        trainer1.addSession(yogaSession);
        trainer2.addSession(cardioSession);
        trainer3.addSession(strengthSession);
 
        System.out.println("\n=== Sessions ===");
        yogaSession.printInfo();
        System.out.println("----------------");
        cardioSession.printInfo();
        System.out.println("----------------");
        strengthSession.printInfo();
        
         System.out.println("\n=== Bookings ===");
 
        ArrayList<Bookings> allBookings = new ArrayList<>();
 
       
        try {
            if (!yogaSession.isAvailable())
                throw new SessionFullException("Yoga session is full!");
 
            Bookings b1 = new Bookings("B001", trainee1, yogaSession, "Confirmed");
            yogaSession.addBooking(b1);
            trainee1.addBooking(b1);
            allBookings.add(b1);
            System.out.println("Booking B001 confirmed: " + trainee1.getName() + " -> " + yogaSession.getSessionName());
 
        } catch (SessionFullException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
         try {
            if (!cardioSession.isAvailable())
                throw new SessionFullException("Cardio session is full!");
 
            Bookings b2 = new Bookings("B002", trainee2, cardioSession, "Confirmed");
            cardioSession.addBooking(b2);
            trainee2.addBooking(b2);
            allBookings.add(b2);
            System.out.println("Booking B002 confirmed: " + trainee2.getName() + " -> " + cardioSession.getSessionName());
 
        } catch (SessionFullException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
       try {
            if (!strengthSession.isAvailable())
                throw new SessionFullException("Strength session is full!");
 
            Bookings b3 = new Bookings("B003", trainee3, strengthSession, "Confirmed");
            strengthSession.addBooking(b3);
            trainee3.addBooking(b3);
            allBookings.add(b3);
            System.out.println("Booking B003 confirmed: " + trainee3.getName() + " -> " + strengthSession.getSessionName());
 
        } catch (SessionFullException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
         System.out.println("\n=== Cancel Booking B002 ===");
        allBookings.get(1).cancelBooking();
        System.out.println("Booking B002 cancelled. Status: " + allBookings.get(1).getStatus());
       
       System.out.println("\n=== Testing Invalid Age (Built-in Exception) ===");
        try {
            Trainee invalidAge = new Trainee("TR999", "Test User", "0500000000", 15, "Wellness");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
       
       System.out.println("\n=== Testing Invalid Specialization (Built-in Exception) ===");
        try {
            Trainer invalidSpec = new Trainer("T999", "Test", "0500000000", 25, "Dancing");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
 
 
 System.out.println("\n=== Testing Session Full (Custom Exception) ===");
 
        Yoga tinyYoga = new Yoga("Yin", "S004", "Tiny Yoga", 1, date1, trainer1);
        trainer1.addSession(tinyYoga);
 
        try {
            Bookings fill1 = new Bookings("B004", trainee1, tinyYoga, "Confirmed");
            tinyYoga.addBooking(fill1);
            trainee1.addBooking(fill1);
            allBookings.add(fill1);
            System.out.println("Booking B004 added.");
            
            if (!tinyYoga.isAvailable())
                throw new SessionFullException("Session \"" + tinyYoga.getSessionName()
                        + "\" is full! Cannot book more trainees.");
 
        } catch (SessionFullException e) {
            System.out.println("Caught SessionFullException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
       
       
       System.out.println("\n=== Updated Trainee Info ===");
        trainee1.printInfo();
        System.out.println("----------------");
        trainee2.printInfo();
        System.out.println("----------------");
        trainee3.printInfo();
       
       
       System.out.println("\n=== Availability Check ===");
        System.out.println("Yoga session available: "     + yogaSession.isAvailable());
        System.out.println("Cardio session available: "   + cardioSession.isAvailable());
        System.out.println("Strength session available: " + strengthSession.isAvailable());
        System.out.println("Trainer1 available: "         + trainer1.isAvailable());
 
 
  System.out.println("\n=== Saving to File ===");
    try{   
  saveToFile(
            new Trainer[]  { trainer1, trainer2, trainer3 },
            new Trainee[]  { trainee1, trainee2, trainee3 },
            new Sessions[] { yogaSession, cardioSession, strengthSession, tinyYoga },
            allBookings
        );
    }catch(IOException e ){
       System.err.println("Error:File not save!"+e.getMessage());   
   } 
      
    }
    public static void saveToFile(Trainer[]trainers,Trainee[]trainees, Sessions[]sessions,ArrayList<Bookings>allBookings) throws IOException{
      try(FileWriter fw = new FileWriter("fitnessdata.txt")){
        fw.write("====FITNESS BOOKING SYSTEM====\n\n");
          for (Bookings bs : allBookings) {
            Write(bs,fw) ; 
          }
          System.out.println("Data has been saved successfully");
          System.out.println("\n === Reading data form file===");
          Read();
      }catch(IOException e){
        System.err.println("Error:"+e.getMessage());   
      }
    }
public static void Write(Bookings b , FileWriter fw) throws IOException{
 String type = "" ;
    if (b.getSession() instanceof Yoga) {
        type ="Yoga";
    }else if(b.getSession() instanceof Cardio){
       type ="Cardio"; 
    }else if(b.getSession() instanceof Strength){
       type ="Strength"; 
} 
   fw.write(type +""+b.getBookingId()+""+b.getTrainee().getName()+""+b.getSession().getSessionName()+""+b.getStatus()+"\n");
    }
public static void Read() throws FileNotFoundException{
   File file = new File("fitnessdata.txt");
   try(Scanner input = new Scanner(file)){
       while (input.hasNextLine()) {
           System.out.println(input.nextLine());
       }
   }catch(FileNotFoundException e ){
       System.err.println("Error:File not found!"+e.getMessage());   
   }
}
}
       
  


       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
   

