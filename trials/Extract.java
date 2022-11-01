// package trials;
// package source.trials;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayDeque;
// import java.util.Queue;

// import source.DataStorage;
// import source.Tray;

// public class Extract
// {

//     static int max_col = 5;
//     static int max_row = 3; // day
//     static double trayCapacity = 500; // In cubic centimeter
//     static double density = 0.96; // In  gram per cubic centimeter

//     static Queue<Tray> q = new ArrayDeque<Tray>();

//     static double[] bin_min = new double[max_row];
//     static
//     {
//         for(int i = 0; i < bin_min.length; i++)
//         {
//             bin_min[i] = trayCapacity + 1;
//         }
//     }

//     Tray tray_table[][] = new Tray[max_row][max_col];

//     public static void main(String[] args)throws IOException
//     {

//         Extract ob = new Extract();

//         // Reading the CSV file
//         String filename = "source//data.csv";
//         BufferedReader br = new BufferedReader(new FileReader(filename));
//         br.readLine();

//         String line;

//         for(int i = 0; i < max_row; i++)
//             for(int j = 0; j < max_col; j++)
//                 ob.tray_table[i][j] = new Tray(trayCapacity);


//         while((line = br.readLine()) != null)
//         {
//             // System.out.println(line);
//             DataStorage ds = new DataStorage(line);

//             double volume = ds.weight/density;
//             System.out.println(ds.day + ", " + ds.month + ", " + ds.year + ", " + volume);

//             ob.addTotray_table(ds.day, Math.round(volume * 100)/100);

//         }

//         for(int i = 0; i < max_row; i++)
//         {
//             for(int j = 0; j < max_col; j++)
//                 System.out.print(ob.tray_table[i][j].remaining + " ");
//             System.out.println();
//         }

//         br.close();
//     }

//     void addTotray_table(int day, double volume)
//     {
//         day = day - 1;
//         int bin = 0;
//         bin_min[day] = trayCapacity + 1;
//         for(int i = 0; i < max_col; i++)
//         {
//             if(this.tray_table[day][i].hasSpace(volume) && this.tray_table[day][i].remaining - volume < bin_min[day])
//             {
//                 System.out.println("Inside adding if" + i);
//                 bin = i;
//                 bin_min[day] = this.tray_table[day][i].remaining - volume;
//             }
//         }
//         System.out.println("out");

//         if(bin_min[day] == trayCapacity + 1)
//         {

//             int max_loaded = 0;

//             for(int i = 1; i < max_col; i++)
//             {
//                 if(this.tray_table[day][max_loaded].occupied < this.tray_table[day][i].occupied)
//                 {
//                     max_loaded = i;
//                 }
//             }

//             // if(q.size() < 5)
//             // {
//                 // q.add(tray_table[day][max_loaded]);
//                 // System.out.println("Added In Queue");
//                 this.tray_table[day][max_loaded] = new Tray(trayCapacity);
//                 double m = this.tray_table[day][0].remaining;
//                 for(int i = 0; i < day; i++)
//                 {
//                     if(this.tray_table[day][i].remaining < m)
//                     {
//                         m = this.tray_table[day][i].remaining;
//                     }
//                 }
//                 bin_min[day] = m;
//                 this.addTotray_table(day + 1, volume);
//             // }
//             // else
//             {
                
//             }
//         }
//         else
//         {
//             this.tray_table[day][bin].add(volume);
//             bin_min[day] = this.tray_table[day][bin].remaining;
//         }
//         // System.out.println(q.size());
//     }
// }
