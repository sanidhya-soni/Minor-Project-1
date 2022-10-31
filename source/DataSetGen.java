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
 
    public static void main(String[] args) throws Exception   
    {   
        String begin = "1/1/2022";
        String end = "18/1/2022";
 
        LinkedList<Date> hitList = searchBetweenDates(
        	    new SimpleDateFormat("dd/MM/yyyy").parse(begin),
        	    new SimpleDateFormat("dd/MM/yyyy").parse(end));
 
        String[] comboDates = new String[hitList.size()];
        for(int i=0; i<hitList.size(); i++)
            comboDates[i] = new SimpleDateFormat("dd/MM/yyyy").format(((Date)hitList.get(i)));
        
        random(comboDates);
    }

    static void random(String[] s)throws IOException
    {
        String path = "source//data.csv";
        File file = new File(path);
        if(!file.exists())
            file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i = 0; i < 100; i++)
        {
            String comp_date = s[ThreadLocalRandom.current().nextInt(0, s.length)];
            String date = comp_date.substring(0, comp_date.indexOf("/"));
            comp_date = comp_date.substring(comp_date.indexOf("/") + 1);
            String month = comp_date.substring(0, comp_date.indexOf("/"));
            comp_date = comp_date.substring(comp_date.indexOf("/") + 1);
            String year = comp_date;

            if(date.length() == 1)
                date = "0" + date;
            if(month.length() == 1)
                month = "0" + month;

            bw.write(date + "" + month + "" + year + "\n");
        }
        
        bw.flush();
        bw.close();
        fw.close();
    }
}
