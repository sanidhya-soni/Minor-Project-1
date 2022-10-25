package source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{

    static int row = 3;
    static int column = 5;
    static int day = 3;

    int tray_table[][];

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

            
        }

        br.close();
    }
}
