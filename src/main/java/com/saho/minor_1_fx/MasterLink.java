package com.saho.minor_1_fx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MasterLink
{
    static String output = "";
    String[] arguments;

    MasterLink()
    {
        this.arguments = new String[8];
    }

    void start() throws Exception {

        Main ob = new Main(this.arguments);
        DataSetGen dsg = new DataSetGen();
        dsg.dataSetGen(ob.begin_date, ob.end_date, ob.total_fruits);
        System.out.println("\nProcessing");

//        String anim= "|/-\\";
//        for (int x =0 ; x <=100 ; x++)
//        {
//            String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
//            System.out.write(data.getBytes());
//            Thread.sleep(20);
//        }
//        System.out.println("\n");
        ob.extract();

        for(int i = 0; i < ob.day; i++)
        {
            System.out.println("Trays used for day " + (i + 1) + " = "+ ob.no_of_tray_used[i]);
            output += "Trays used for day " + (i + 1) + " = " + ob.no_of_tray_used[i] + "\n";
        }
        PathAstar astar = new PathAstar(ob.warehouse.inventory);
        System.out.println("\nTotal Bins Used = " + ob.bins_used + "\n");
        output += "\nTotal Bins Used = " + ob.bins_used + "\n\n";
        output = ob.printBins(output);
        output = ob.warehouse.printRacks(output);
        System.out.println("\n\nWareshouse Inventory Representation\n");
        output += "\n\nWareshouse Inventory Representation\n" + "\n";
        output = ob.warehouse.print(output) + "\n\n";
        output = ob.orderLocation(Integer.parseInt(this.arguments[this.arguments.length - 1]), output);
        if(ob.source_row == -1 && ob.source_col == -1)
        {
            System.out.println("Stock isn't Available");
            output += "Stock isn't Available\n";
            File f = new File("output.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter("output.txt");
            fw.write(output);
            fw.close();
            return;
        }
        output = ob.sourceInInventory(output);
        output = astar.findPath(ob.source_row, ob.source_col, ob.warehouse.inventory.length - 2, ob.warehouse.inventory[0].length - 1, output);
        System.out.println( "\n\n\n\n\n\n" + output);

        File f = new File("C:\\Users\\Public\\Documents\\output.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter("C:\\Users\\Public\\Documents\\output.txt");
        fw.write(output);
        fw.close();
    }

    public static void main(String[] args) throws Exception {
//        String
        MasterLink x = new MasterLink();
        String filename = "data.csv";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        x.arguments[0] = br.readLine();
        x.arguments[1] = br.readLine();
        x.arguments[2] = br.readLine();
        x.arguments[3] = br.readLine();
        x.arguments[4] = br.readLine();
        x.arguments[5] = br.readLine();
        x.arguments[6] = br.readLine();
        x.arguments[7] = br.readLine();
        x.start();
    }
}
