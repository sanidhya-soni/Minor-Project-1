package source;

public class Warehouse
{
    int inventory[][];
    Rack[][] racks;
    static int rack_capacity = 4;
    int current_rack[];
    
    int row, col;

    Warehouse(int row, int col)
    {
        this.row = row;
        this.col = col;
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
                }
                else
                {
                    this.inventory[i][j] = 0;
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
        racks[this.current_rack[bin.day]][bin.day].add(bin);
        if(this.current_rack[bin.day] >= rack_capacity)
        {
            this.current_rack[bin.day]++;
        }
    }

    void print()
    {
        for(int i = 0; i < this.row * 2 - 1; i++)
        {
            for(int j = 0; j < this.col * 2 - 1; j++)
            {
                System.out.print(this.inventory[i][j] + " ");
            }
            System.out.println();
        }
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
