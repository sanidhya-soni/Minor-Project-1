package source;

public class Rack
{
    Bin[] rack;
    int top;
    int capacity;

    Rack(int capacity)
    {
        this.rack = new Bin[capacity];
        this.top = 0;
        this.capacity = capacity;
    }

    void add(Bin bin)
    {
        if(hasSpace())
        {
            rack[top++] = bin;
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
