package pro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Extract_trash
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

        // Initializing arrangement of empty trays
        // Tray[][] tray_set = new Tray[Extract.day][Extract.size];
        // for(int i = 0; i < day; i++)
        // {
        //     for(int j = 0; j < size; j++)
        //     {
        //         tray_set[i][j] = new Tray(j + 2);
        //     }
        // }

        // Rack[][] rack_set = new Rack[Extract.day][Extract.size];
        // for(int i = 0; i < day; i++)
        // {
        //     for(int j = 0; j < size; j++)
        //     {
        //         rack_set[i][j] = new Rack(5);
        //     }
        // }

        String line;
        // int[] arr = new int[5];
        // ArrayList<Integer> arr = new ArrayList<>();
        
        // Tray tray_1 = new Tray(2);
        // Tray tray_2 = new Tray(3);
        // Tray tray_3 = new Tray(4);

        // ArrayList<Integer> columns = new ArrayList<>();


        // Stack<Tray> st_small = new Stack<>();
        // Stack<Tray> st_medium = new Stack<>();
        // Stack<Tray> st_large = new Stack<>();
        while((line = br.readLine()) != null)
        {
            // System.out.println(line);
            DataStorage ds = new DataStorage(line);
            System.out.println(ds.day + ", " + ds.month + ", " + ds.year + ", " + ds.weight);

            // if(tray_set[ds.day][ds.size].hasSpace())
            //     System.out.println(tray_set[ds.day][ds.size].add());
            // else
            // {
            //     System.out.println("Inside Else");
            //     if(rack_set[ds.day][ds.size].hasSpace())
            //         rack_set[ds.day][ds.size].push(tray_set[ds.day][ds.size]);
            //     tray_set[ds.day][ds.size] = new Tray(ds.size + 2);
            //     System.out.println(tray_set[ds.day][ds.size].add());
            // }

            // arr[ds.day - 1]++;
            /* switch(ds.size)
            {
                case 1:
                    if(tray_1.hasSpace())
                        System.out.println(tray_1.add());
                    else
                    {
                        st_large.push(tray_1);
                        tray_1 = new Tray(2);
                        System.out.println(tray_1.add());
                    }
                    break;

                case 2:
                    if(tray_2.hasSpace())
                        System.out.println(tray_2.add());
                    else
                    {
                        st_medium.push(tray_2);
                        tray_2 = new Tray(3);
                        System.out.println(tray_2.add());
                    }
                    break;

                case 3:
                    if(tray_3.hasSpace())
                        System.out.println(tray_3.add());
                    else
                    {
                        st_small.push(tray_3);
                        tray_3 = new Tray(4);
                        System.out.println(tray_3.add());
                    }
                    break;

                default:
                    System.out.println("Unable to insert the data");
            } */
        }
        // System.out.println(tray_1.full);
        // for(int i: arr)
        //     System.out.println(i);
        br.close();
    }
}
