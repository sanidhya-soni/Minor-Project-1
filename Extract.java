package pro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Extract
{

    static int size = 3;
    static int day = 5;

    public static void main(String[] args)throws IOException
    {

        // Extract ob = new Extract();

        // Reading the CSV file
        String filename = "pro//data.csv";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();

        String line;

        while((line = br.readLine()) != null)
        {
            // System.out.println(line);
            DataStorage ds = new DataStorage(line);
            System.out.println(ds.day + ", " + ds.month + ", " + ds.year + ", " + ds.weight);
        }

        br.close();
    }
}
