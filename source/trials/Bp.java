package source.trials;

import java.util.Arrays;

public class Bp
{

    int maxBins(int[] apples, int max)
    {
        int bins = 0;

        int[] space_av = new int[apples.length];

        Arrays.fill(space_av, max);

        return bins;
    }
    
    public static void main(String[] args)
    {
        Bp ob = new Bp();
        int[] apples = {14, 10, 13, 6, 3, 7, 9, 15, 8};
        int max = 25;
        int bins = ob.maxBins(apples, max);
        System.out.println("Max bins required = " + bins);
    }
}
