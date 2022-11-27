package source;

import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
 
public class DataSetGen 
{
    public static LinkedList<Date> searchBetweenDates(Date startDate, Date endDate) 
    {
        Date begin = new Date(startDate.getTime());
        LinkedList<Date> list = new LinkedList<>();
        list.add(new Date(begin.getTime()));
        while(begin.compareTo(endDate)<0)
        {
            begin = new Date(begin.getTime() + 86400000);
            list.add(new Date(begin.getTime()));
        }
        return list;
    }
 
    public void dataSetGen(String begin, String end, int total_entries) throws Exception   
    {   
        // String begin = "1/1/2022";
        // String end = "3/1/2022";
        System.out.println(begin + " " + end);
        LinkedList<Date> hitList = searchBetweenDates(
        	    new SimpleDateFormat("dd/MM/yyyy").parse(begin),
        	    new SimpleDateFormat("dd/MM/yyyy").parse(end));
 
        String[] comboDates = new String[hitList.size()];
        for(int i=0; i<hitList.size(); i++)
            comboDates[i] = new SimpleDateFormat("dd/MM/yyyy").format(((Date)hitList.get(i)));
        
        random(comboDates, begin, end, total_entries);
    }

    static void random(String[] s, String begin, String end, int total_entries)throws IOException
    {
        String path = "source//data.csv";
        File file = new File(path);
        if(!file.exists())
            file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        String begin_backup = begin;
        String end_backup = end;

        String b_date = begin.substring(0, begin.indexOf("/"));
        begin = begin.substring(begin.indexOf("/") + 1);
        String b_month = begin.substring(0, begin.indexOf("/"));
        begin = begin.substring(begin.indexOf("/") + 1);
        String b_year = begin.substring(2);

        if(b_date.length() == 1)
            b_date = "0" + b_date;
        if(b_month.length() == 1)
            b_month = "0" + b_month;

        String e_date = end.substring(0, end.indexOf("/"));
        end = end.substring(end.indexOf("/") + 1);
        String e_month = end.substring(0, end.indexOf("/"));
        end = end.substring(end.indexOf("/") + 1);
        String e_year = end.substring(2);

        if(e_date.length() == 1)
            e_date = "0" + e_date;
        if(e_month.length() == 1)
            e_month = "0" + e_month;

        begin = begin_backup;
        end = end_backup;

        bw.write(b_date + "/" + b_month + "/" + "20" + b_year + "\n");
        bw.write(e_date + "/" + e_month + "/" + "20" + e_year + "\n");

        String[] sz = {"050", "075", "100"};

        for(int i = 0; i < total_entries; i++)
        {
            String comp_date = s[ThreadLocalRandom.current().nextInt(0, s.length)];
            String date = comp_date.substring(0, comp_date.indexOf("/"));
            comp_date = comp_date.substring(comp_date.indexOf("/") + 1);
            String month = comp_date.substring(0, comp_date.indexOf("/"));
            comp_date = comp_date.substring(comp_date.indexOf("/") + 1);
            String year = comp_date.substring(2);

            String size = sz[ThreadLocalRandom.current().nextInt(0, sz.length)];

            if(date.length() == 1)
                date = "0" + date;
            if(month.length() == 1)
                month = "0" + month;

            bw.write(date + "" + month + "" + year + size + "\n");
        }
        
        bw.flush();
        bw.close();
        fw.close();
    }
}
