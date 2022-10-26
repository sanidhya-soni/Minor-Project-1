package source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{

    static int size_row = 3;
    static int no_of_tray_column = 5;
    static int day = 3;
    static Bin_Packing_Best_Fit[] bp = new Bin_Packing_Best_Fit[Main.day];

    Tray tray_table[][][];

    Main()
    {
        for(int i = 0; i < Main.day; i++)
        {
            for(int j = 0; j < Main.size_row; j++)
            {
                for(int k = 0; k < Main.no_of_tray_column; k++)
                {
                    tray_table[i][j][k] = new Tray(j + 3, j + 3);
                }
            }
        }

        for(int i = 0; i < Main.day; i++)
        {
            Main.bp[i] = new Bin_Packing_Best_Fit();
        }
    }

    public static void main(String[] args) throws IOException
    {

        Main ob = new Main();

        String filename = "source//data.csv";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();

        String line;

        while((line = br.readLine()) != null)
        {
            // System.out.println(line);
            DataStorage ds = new DataStorage(line);

            System.out.println(ds.day + ", " + ds.month + ", " + ds.year + ", " + ds.size);

            bp[ds.day].add_using_bin_packing_bestFit(ob.tray_table[ds.day], ds.size);
        }

        br.close();
    }
}
