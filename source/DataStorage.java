package source;

public class DataStorage
{
    int day, month, year, size;
    DataStorage(String data)
    {
        this.day = Integer.parseInt(data.substring(0, 2));
        this.month = Integer.parseInt(data.substring(2, 4));
        this.year = Integer.parseInt(data.substring(4, 6));
        this.size = Integer.parseInt(data.substring(6)); // size in mm
    }
}
