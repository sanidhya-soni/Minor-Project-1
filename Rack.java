package pro;

public class Rack
{
    int capacity;
    Tray[] rack;
    int top;

    Rack(int capacity)
    {
        this.capacity = capacity;
        rack = new Tray[this.capacity];
        this.top = 0;
    }

    void push(Tray tray)
    {
        if(hasSpace())
        {
            rack[top++] = tray;
            System.out.println("Tray added succesfully in rack!");
        }
        else
            System.out.println("Rack is full, Get a new one!");
    }

    void pop()
    {
        if(!hasSpace())
        {
            top--;
            System.out.println("Tray removed succesfully!");
        }
        else
            System.out.println("Rack is Empty!");
    }

    boolean hasSpace()
    {
        return this.top < this.capacity;
    }
}
