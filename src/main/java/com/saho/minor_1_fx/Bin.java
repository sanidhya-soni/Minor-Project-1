package com.saho.minor_1_fx;

import java.util.LinkedList;

public class Bin
{
    double max_capacity;
    double occupied;
    double space_left;
    boolean isFull;
    int day;
    LinkedList<Tray> items;

    Bin(double capacity, int day)
    {
        this.max_capacity = capacity;
        this.occupied = 0;
        this.space_left = this.max_capacity;
        this.isFull = false;
        this.day = day;
        items = new LinkedList<Tray>();
        // System.out.println("New Bin Added");
    }

    void add(int height)
    {
        if(this.hasSpace(height))
        {
            this.occupied += height;
            this.space_left -= height;
        }
    }

 
    boolean hasSpace()
    {
        return !isFull;
    }

    boolean hasSpace(int x)
    {
        return space_left - x >= 0;
    }

    boolean isEmpty()
    {
        return this.space_left == this.max_capacity;
    }

    boolean isFull()
    {
        return isFull;
    }
}
