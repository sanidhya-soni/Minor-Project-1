package com.saho.minor_1_fx;

public class Warehouse
{
    int inventory[][];
    Rack[][] racks;
    int rack_capacity;
    int current_rack[];
    
    int row, col;

    Warehouse(int row, int col, int rack_capacity)
    {
        this.row = row;
        this.col = col;
        this.rack_capacity = rack_capacity;
        this.inventory = new int[this.row * 2 - 1][this.col * 2 - 1];
        this.racks = new Rack[row][col];
        this.current_rack = new int[row];
        for(int i = 0; i < this.row * 2 - 1; i++)
        {
            for(int j = 0; j < this.col * 2 - 1; j++)
            {
                if(i % 2 == 0 && j % 2 == 0)
                {
                    this.inventory[i][j] = 1;
                    // this.inventory[i][j] = 0;
                }
                else
                {
                    this.inventory[i][j] = 0;
                    // this.inventory[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                racks[i][j] = new Rack(rack_capacity);
            }
        }
    }

    void add(Bin bin)
    {
        try
        {
            if(this.current_rack[bin.day] <= row && racks[this.current_rack[bin.day]][bin.day].hasSpace())
            {
                racks[this.current_rack[bin.day]][bin.day].add(bin);
            }
            else
            {
                this.current_rack[bin.day]++;
                if(!(this.current_rack[bin.day] >= row))
                    add(bin);
            }
            if(!racks[this.current_rack[bin.day]][bin.day].hasSpace())
                    this.current_rack[bin.day]++;
        }
        catch(IndexOutOfBoundsException e)
        {
            // System.out.println("Cant accomodate for this day");
        }
    }

    void dispatch(int amt, int day)
    {
        day -= 1;
        int total_bins_available = current_rack[day] * rack_capacity + racks[current_rack[day]][day].top;
        System.out.println(current_rack[day] + " " + day + " " + racks[current_rack[day]][day].top);
        System.out.println(total_bins_available);

        if(amt < total_bins_available)
        {
            while(amt != 0)
            {
                amt--;
                if(!racks[current_rack[day]][day].isEmpty())
                {
                    racks[current_rack[day]][day].pop();
                }
                else
                {
                    current_rack[day]--;
                    racks[current_rack[day]][day].pop();
                }
            }
        }
    }


    String print(String output)
    {
        for(int i = 0; i < this.row * 2 - 1; i++)
        {
            for(int j = 0; j < this.col * 2 - 1; j++)
            {
                System.out.print(this.inventory[i][j] + " ");
                output += this.inventory[i][j] + " ";
            }
            System.out.println();
            output += "\n";
        }
        return output;
    }

    String printRacks(String output)
    {
        System.out.println("\nRacks Status");
        output += "\nRacks Status" + "\n";
//        System.out.println("Day 1  Day 2  Day 3");
        for(int i = 0; i < this.racks[0].length; i++)
        {
            System.out.print("Day " + i + "  ");
            output += "Day " + (i + 1) + "  ";
        }
        System.out.println();
        output += "\n";
        for(int i = 0; i < this.racks.length; i++)
        {
            for(int j = 0; j < this.racks[0].length; j++)
            {
                System.out.print(racks[i][j].capacity - racks[i][j].top + "   |   ");
                output +=racks[i][j].capacity - racks[i][j].top + "   |   ";
            }
            System.out.println();
            output += "\n";
        }
        System.out.println();
        output += "\n";
        return output;
    }

    // public static void main(String[] args) {
    //     Warehouse ob = new Warehouse(5, 5);
    //     for(int i = 0; i < ob.row * 2 - 1; i++)
    //     {
    //         for(int j = 0; j < ob.col * 2 - 1; j++)
    //         {
    //             System.out.print(ob.inventory[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
}
