package source;

public class Warehouse
{
    int inventory[][];
    int row, col;

    Warehouse(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.inventory = new int[this.row * 2 - 1][this.col * 2 - 1];
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
    }

    public static void main(String[] args) {
        Warehouse ob = new Warehouse(5, 5);
        for(int i = 0; i < ob.row * 2 - 1; i++)
        {
            for(int j = 0; j < ob.col * 2 - 1; j++)
            {
                System.out.print(ob.inventory[i][j] + " ");
            }
            System.out.println();
        }
    }
}
