package source;

public class Bin
{
    double max_capacity;
    double occupied;
    double space_left;
    boolean isFull;

    Bin(double capacity)
    {
        this.max_capacity = capacity;
        this.occupied = 0;
        this.space_left = this.max_capacity;
        this.isFull = false;
        System.out.println("New Bin Added");
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
