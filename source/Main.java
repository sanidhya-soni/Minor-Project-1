package source;
import java.util.Scanner;
import AStar.PathAstar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Main
{

    Tray[][] tray_table;
    Bin[][] bins;
    Warehouse warehouse;
    static int size = 3;
    static int day = 3;
    String begin_date;
    String end_date;
    static int max_row = 3;
    static int max_col = 3;
    static int bin_capacity = 500;

    static double[] bin_min = new double[max_row];
    static
    {
        for(int i = 0; i < bin_min.length; i++)
        {
            bin_min[i] = bin_capacity + 1;
        }
    }

    Main()
    {
        // day = 3, size = 3
        tray_table = new Tray[day][size];
        bins = new Bin[max_row][max_col];
        warehouse = new Warehouse(3, 3);
    }

    void extract() throws IOException, ParseException
    {

        String filename = "source//data.csv";
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String line;
        String begin_date = br.readLine();
        String end_date = br.readLine();

        int dateDiff = this.getDifferenceDays(begin_date, end_date);

        for(int i = 0; i < day; i++)
        {
            for(int j = 0; j < size; j++)
            {
                int height = (j == 0)? 50: (j == 1)? 75: 100;
                this.tray_table[i][j] = new Tray(size + 1 - j, size + 1 - j, height);
            }
        }
        for(int i = 0; i < max_row; i++)
        {
            for(int j = 0; j < max_col; j++)
            {
                this.bins[i][j] = new Bin(Main.bin_capacity, i);
            }
        }

        while((line = br.readLine()) != null)
        {
            // System.out.println(line);
            DataStorage ds = new DataStorage(line);

            // System.out.println(ds.day + ", " + ds.month + ", " + ds.year + ", " + ds.size);

            dateDiff = this.getDifferenceDays(begin_date, ds.day + " " + ds.month + " 20" + ds.year);
            int row = dateDiff;
            int col = (ds.size == 50)? 0: ((ds.size == 75)? 1: 2);

            if(this.tray_table[row][col].hasSpace())
            {
                this.tray_table[row][col].add();
            }
            else
            {
                
                this.addToBinTable(this.tray_table[row][col], row, col);


                this.tray_table[row][col] = new Tray(this.tray_table[row][col].row, this.tray_table[row][col].column, this.tray_table[row][col].height);
                this.tray_table[row][col].add();
            }
        }
        br.close();
    }

    void addToBinTable(Tray t, int row, int col)
    {
        int bin = 0;
        bin_min[row] = bin_capacity + 1;

        for(int i = 0; i < max_col; i++)
        {
            if(this.bins[row][i].hasSpace(this.tray_table[row][col].height) && this.bins[row][i].space_left - this.tray_table[row][col].height < bin_min[row])
            {
                // System.out.println("Inside adding if" + i);
                bin = i;
                bin_min[row] = this.bins[row][i].space_left - t.height;
            }
        }


        if(bin_min[row] == bin_capacity + 1)
        {
            int max_loaded = 0;

            for(int i = 1; i < max_col; i++)
            {
                if(this.bins[row][max_loaded].occupied < this.bins[row][i].occupied)
                {
                    max_loaded = i;
                }
            }

            warehouse.add(this.bins[row][max_loaded]);

            this.bins[row][max_loaded] = new Bin(Main.bin_capacity, this.bins[row][max_loaded].day);
            double m = this.bins[row][0].space_left;
            for(int i = 0; i < row; i++)
            {
                if(this.bins[row][i].space_left < m)
                {
                    m = this.bins[row][i].space_left;
                }
            }
            bin_min[row] = m;
            this.addToBinTable(t, row, col);
        }

        else
        {
            this.bins[row][bin].add(t.height);
            this.bins[row][bin].items.add(t);
            bin_min[row] = this.bins[row][bin].space_left;
        }
    }

    int getDifferenceDays(String s1, String s2) throws ParseException
    {
        String dtf = "dd mm yyyy";
        Date d1 = new SimpleDateFormat(dtf).parse(s1);
        Date d2 = new SimpleDateFormat(dtf).parse(s2);
        long diff = d2.getTime() - d1.getTime();
        return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    void orderLocation()
    {

    }

    public static void main(String[] args)throws Exception
    {
        DataSetGen.main(args);
        System.out.println("\n Starting to sort");

        String anim= "|/-\\";
        for (int x =0 ; x <=100 ; x++) 
        {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
            System.out.write(data.getBytes());
            Thread.sleep(20);
        }

        Main ob = new Main();
        ob.extract();
        
        Scanner myObj = new Scanner(System.in);
        // System.out.println("\n\nEnter the amount of apples you want to order (in Kg) :- ");
        // double orderAmount = myObj.nextDouble(); 
        ob.orderLocation();
        System.out.println("The path of your order of "+orderAmount+" Kg Apples is : -");
        PathAstar astar = new PathAstar(ob.warehouse.inventory);
        ob.warehouse.print();
        astar.findPath(1, 1, 3, 4);
        myObj.close();
    }
}
