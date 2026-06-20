/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author skills 30-8-25
 */
public class Yoga extends Sessions {

private String yogaStyle;

public Yoga () {
    super();
    this.yogaStyle="NONE";
}
public Yoga (String yogaStyle, String sessionID, String sessionName, int capacity, Date date, Trainer trainer) {
    super(sessionID,sessionName,capacity,date,trainer);
    setYogaStyle(yogaStyle);
}


@Override
public void printInfo() {
       System.out.println("Session ID:"+getSessionID());
       System.out.println("Session Name:" +getSessionName());
       System.out.println("Capacity: "+getCapacity());
       System.out.print("Date: "); 
       if (getDate() != null) { getDate().printInfo(); }
       System.out.println("\nYoga Style: "+yogaStyle);}


// S&G 
public void setYogaStyle(String style) {
    if (style.equalsIgnoreCase("Aerial")|| style.equalsIgnoreCase("Yin") ||style.equalsIgnoreCase("Vinyasa") ) {
        this.yogaStyle= style;
    } else {
        System.out.println("Invalid style. Please choose Aerial, Yin, or Vinyasa!");
        this.yogaStyle="NONE";
    }
}

   

public String getYogaStyle() {
    return yogaStyle; }

   @Override
    public String toString() {
        return "String yogaStyle\n\t"+getYogaStyle()+"Session ID:\n\t"+getSessionID()+"Session Name:\n\t" +getSessionName()+"Capacity: \n\t"+getCapacity()+"Date\n\t"+getDate()+"Trainer\n\t"+getTrainer();
    }

}
