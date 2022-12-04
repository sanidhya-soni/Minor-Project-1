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
            // System.out.println("Bin added succesfully in rack!");
        }
        else
        {
            // System.out.println("Rack is full, Get a new one!");
        }
    }

    void pop()
    {
        top--;
    }


    boolean hasSpace()
    {
        return this.top < this.capacity;
    }

    boolean isEmpty()
    {
        return top == 0;
    }
}
