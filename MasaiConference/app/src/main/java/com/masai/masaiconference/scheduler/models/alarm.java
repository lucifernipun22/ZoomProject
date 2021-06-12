package com.masai.masaiconference.scheduler.models;

import org.joda.time.MutableDateTime;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class alarm implements Serializable {

    public long id = -1;
    public MutableDateTime startDateTime, endDateTime; //Joda time - super handy
    public Set<String> contacts = new HashSet<>();
    public String note, title, location;
    public int notification = 0;

    public alarm() {
    }
}
