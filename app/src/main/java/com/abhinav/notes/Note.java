package com.abhinav.notes;

public class Note {
    private String title;
    private String description;
    private int priority;

    //constructor
    public Note(){  //empty constructor for firebase so that it can create objects for the database
    }
    public Note(String title,String description,int priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    //getter and setter


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setPriority(int priority) {
//        this.priority = priority;
//    }
}
