package com.example.demo.common;

import java.util.List;

import an.awesome.pipelinr.Notification;

import java.util.ArrayList;


public abstract class Agregate {
    private final List<Notification> events = new ArrayList<>();
    public void addEvent(Notification event){
        events.add(event);
    }
    public void removeEvent(Notification event){
        events.remove(event);
    }
    public void clearEvents(){
        events.clear();
    }
    public  List<Notification> getEvents(){
        return events.stream().toList();
    }
    
}
