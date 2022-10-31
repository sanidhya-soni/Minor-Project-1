package source;

public class bin_pack {
    public static int bestFit(double size[], int n, int cap)
    {
        //size[] - size of each fruit
        //n - number of items or fruits
        //c - capacity of each bin

        int count = 0;   //counts the number of bins
        double []remain_bin = new double[n];  //total number of remaining bins

        for (int i = 0; i < n; i++)  //loop for each bin to start with the space available
        {
            double min = cap + 1;  //minimum space available in bin
            int bin_num = 0;     //specifies index of each bin

            for (int j = 0; j < count; j++)  //for loop to check if the bin has space available or not
            {
                if (remain_bin[j] >= size[i] && remain_bin[j] - size[i] < min)
                {
                    bin_num = j;
                    min = remain_bin[j] - size[i];
                }
            }

            if (min == cap + 1) {
                remain_bin[count] = cap - size[i];
                count++;
            }
            else
                remain_bin[bin_num] -= size[i];
        }
        return count;
    }

    public static void main(String args[])
    {
        double size[] = {0.5, 0.7, 0.5, 0.2, 0.4, 0.2, 0.5, 0.1, 0.6};
        int c = 1;
        int n = size.length;
        System.out.println("Number of bins required in Best Fit : "+ bestFit(size, n, c));
    }

}
