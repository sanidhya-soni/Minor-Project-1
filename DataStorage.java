package pro;

public class DataStorage
{
    int day, month, year, weight;
    DataStorage(String data)
    {
        this.day = Integer.parseInt(data.substring(0, 2));
        this.month = Integer.parseInt(data.substring(2, 4));
        this.year = Integer.parseInt(data.substring(4, 6));
        this.weight = Integer.parseInt(data.substring(6));
    }
}
