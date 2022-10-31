package trials;

public class Info
{
    String name;
    int year;
    int month;
    int date;
    int data;


//    1280822 - 1 means apple, 28 means date, 08 means month, 22 means year

    Info(int inp_data)
    {
        this.data = inp_data;

        this.year = inp_data % 100;
        inp_data /= 100;
        this.month = inp_data % 100;
        inp_data /= 100;
        this.date = inp_data % 100;
        inp_data /= 100;
        this.name = (inp_data == 1)? "Apple": "Wrong";
        if(inp_data == 0)
        {
            System.out.println("Badhiya");
        }
        System.out.println(this.data);
    }

    public static void main(String[] args) {
        Info ob = new Info(1280822);
        System.out.println(ob.date);
        System.out.println(ob.month);
        System.out.println(ob.year);
        System.out.println(ob.name);
    }
}
