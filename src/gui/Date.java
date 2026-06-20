/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author skills 30-8-25
 */
public class Date {
    
    private int year, month, day, hour, minute;
    
    public Date(int year, int month, int day, int hour, int minute) {
       setYear(year);
       setMonth(month);
       setDay(day);
       setHour(hour);
       setMinute(minute);
    }
    
      public Date () {
        this(2026,1,1,0,0);
    }
    
    
    public void printInfo() {
        System.out.printf("%02d/%02d/%d at %02d:%02d",day,month,year,hour,minute);
        
    }
    
    
    
    // S&G with validation
    public int getYear() {
        return year; }
    public void setYear(int year) {
        this.year = year; }    
        
    public int getMonth() {
        return month; }
    public void setMonth(int month) {
        if (month <=12 && month >= 1) {
        this.month = month; }
        else  { System.out.println("Please enter valid month. (1-12)"); }   }
        
        
    public int getDay() {
        return day; }
    public void setDay(int day) {
        if (day <=31 && day >= 1) {
        this.day = day; }
        else { System.out.println("Please enter valid day. (1-31)"); } }
        
        
    public int getHour() {
        return hour; }
    public void setHour(int hour) {
        if (hour <=23 && hour >= 0) {
        this.hour = hour; }
        else { System.out.println("Please enter valid hour (0-23)."); }}
        
        
    public int getMinute() {
        return minute; }
    public void setMinute(int minute) {
        if (minute  <=59 && minute >= 0) {
        this.minute = minute; } 
        else { System.out.println("Please enter valid minute. (0-59)"); }
    }

    @Override
    public String toString() {
        return  "year:\n\t" + getYear() + " month:\n\t" + month + " day:\n\t" + day + ", hour:\n\t" + hour + ", minute:\n\t" + minute  ;
    }
    
}
    
