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

    Scanner sc = new Scanner(System.in);
    Tray[][] tray_table;
    int[] no_of_tray_used;
    Bin[][] bins;
    Warehouse warehouse;
    static int size = 3;
    static int day = 3;
    String begin_date;
    String end_date;
    static int max_row = 3;
    static int max_col = 3;
    static int warehouse_row = 3;
    static int warehouse_col = 3;
    static int bin_capacity = 500;
    int bins_used;
    int source_row;
    int source_col;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Range of Date of Stock in DD/MM/YYYY format");
        System.out.print("Start Date: ");
        begin_date = sc.nextLine();
        System.out.print("End Date: ");
        end_date = sc.nextLine();
        // day = 3, size = 3
        tray_table = new Tray[day][size];
        bins = new Bin[max_row][max_col];
        warehouse = new Warehouse(warehouse_row, warehouse_col);
        bins_used = 0;
        no_of_tray_used = new int[day];
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

                this.no_of_tray_used[dateDiff]++;
                this.tray_table[row][col] = new Tray(this.tray_table[row][col].row, this.tray_table[row][col].column, this.tray_table[row][col].height);
                this.tray_table[row][col].add();
            }
        }
        br.close();
    }

    void addToBinTable(Tray t, int row, int col)
    {
        for(int i = 0; i < this.bins.length; i++)
        {
            for(int j = 0; j < this.bins[0].length; j++)
            {
                if(bins[i][j].space_left < 50)
                {
                    warehouse.add(bins[i][j]);
                    bins[i][j] = new Bin(bins[i][j].max_capacity, bins[i][j].day);
                    this.bins_used++;
                }
            }
        }

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
            this.bins_used++;
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
        System.out.print("Enter the distance to which you need to take your stock: ");
        int distance = sc.nextInt();
        int day = (distance <= 50)? 3: (distance <= 100)? 2: 1;
        int col = day - 1;
        int row = 0;
        for(int i = warehouse.racks.length - 1; i >= 0; i--)
        {
            if(this.warehouse.racks[i][col].top < 4 && this.warehouse.racks[i][col].top > 0);
            {
                row = this.warehouse.racks[i][col].top;
                break;
            }
        }
        if(row == 0 && this.warehouse.racks[row][col].top == 0)
        {
            System.out.println("Stock not Found");
            this.source_col = -1;
            this.source_row = -1;
            sc.close();
            return;
        }
        this.source_row = row;
        this.source_col = col;
        System.out.println("Row = " + row + ", Col = " + col);
        sc.close();
    }

    void printBins()
    {
        System.out.println("BINS TABLE");
        for(int i = 0; i < this.bins.length; i++)
        {
            System.out.print("Day " + (i + 1) + ": ");
            for(int j = 0; j < this.bins[0].length; j++)
            {
                System.out.print(bins[i][j].space_left + "   |    ");
            }
            System.out.println();
        }
    }

    void sourceInIventory()
    {
        if(this.source_row < 2)
        {
            this.source_row = this.source_row * 2 + 1;
        }
        else
        {
            this.source_row = this.source_row * 2 - 2;
        }
        
        this.source_col = this.source_col * 2;
        
        System.out.println("Source_Row = " + this.source_row);
        System.out.println("Source Column = " + this.source_col);
    }

    public static void main(String[] args)throws Exception
    {
        DataSetGen.main(args);
        System.out.println("\nProcessing");

        String anim= "|/-\\";
        for (int x =0 ; x <=100 ; x++) 
        {
            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
            System.out.write(data.getBytes());
            Thread.sleep(20);
        }
        System.out.println("\n");

        Main ob = new Main();
        ob.extract();
        
        for(int i = 0; i < day; i++)
        {
            System.out.println("Trays used for day " + (i + 1) + " = "+ ob.no_of_tray_used[i]);
        }
        PathAstar astar = new PathAstar(ob.warehouse.inventory);
        System.out.println("\nTotal Bins Used = " + ob.bins_used + "\n");
        ob.printBins();
        ob.warehouse.printRacks();
        System.out.println("\n\nWareshouse Inventory Representation\n");
        ob.warehouse.print();
        ob.orderLocation();
        ob.sourceInIventory();
        astar.findPath(ob.source_row, ob.source_col, 3, 4);
    }
}
