/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author skills 30-8-25
 */
public abstract class Person {
    private String id;
    private String name;
    private String phoneNumber;
    private int age;

    public Person() {
        this.id = "";
        this.name = "";
        this.phoneNumber = "";
        this.age = 0;
    }


    public Person(String id, String name, String phoneNumber, int age) {
    setId(id);
    setName(name);
    setPhoneNumber(phoneNumber);
    setAge(age);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
    if (id == null || id.trim().isEmpty()) {
        throw new IllegalArgumentException("ID cannot be empty.");
    }
    this.id = id.trim();
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be empty.");
    }
    this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
    if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
        throw new IllegalArgumentException("Phone number cannot be empty.");
    }
    
    String trimmed = phoneNumber.trim();
    
    for (int i = 0; i < trimmed.length(); i++) {
        if (!Character.isDigit(trimmed.charAt(i))) {
            throw new IllegalArgumentException("Phone number must contain only digits.");
        }
    }
    
    this.phoneNumber = trimmed;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
    if (age >= 18) {
        this.age = age;
    } 
    
    else {
        throw new IllegalArgumentException("Age must be 18 or older, got: " + age);
    }
    
        
    }
    
    public void printInfo(){
        System.out.println("Name: "+name+"\nID: "+id+"\nAge: "+age+"\nPhone Number: "+phoneNumber);
    }
    
    
    
}
