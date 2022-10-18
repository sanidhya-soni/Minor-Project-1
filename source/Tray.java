package source;

public class Tray
{

    double capacity, occupied, remaining;
    boolean full;

    /* Tray()
    {
        this.max_cap = 0;
        this.curr_load = 0;
        this.full = false;
    } */

    Tray(double capacity)
    {
        this.capacity = capacity;
        this.remaining = capacity;
        full = false;
        System.out.println("New Tray Created");
    }

    void add(double volume)
    {
        if(hasSpace(volume))
        {
            this.occupied += volume;
            this.remaining -= volume;
            System.out.println("Item added successfully!" + occupied + " " + remaining);
        }
        else
        {
            this.full = true;
            System.out.println("This can't Fit");
        }
    }

    boolean isFull()
    {
        return this.full;
    }

    boolean hasSpace(double volume)
    {
        // System.out.println(this.remaining - volume > 0);
        return this.remaining - volume > 0;
    }
}
