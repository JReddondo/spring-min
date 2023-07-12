package com.example.demo.common;


import java.util.Date;
import java.util.UUID;

import an.awesome.pipelinr.Notification;

public abstract class EventBase<T> implements Notification{
    private final UUID id;
    private final Date date;
    private final String type;
    private final T body;
    public T getBody() {
        return body;
    }
    public UUID getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public String getType() {
        return type;
    }
    protected EventBase(UUID id, Date date, String type, T body) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.body = body;
    }

}
