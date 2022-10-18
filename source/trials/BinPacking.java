package source.trials;

// Java program to find number
// of bins required using
// Best fit algorithm.
class BinPacking
{
    static int bestFit(int weight[], int n, int c)
    {
        int res = 0;

        int[] bin_rem = new int[n];

        for (int i = 0; i < n; i++)
        {
            int j;
            int min = c + 1, bi = 0;

            for (j = 0; j < res; j++)
            {
                if (bin_rem[j] >= weight[i] && bin_rem[j] - weight[i] < min)
                {
                    bi = j;
                    min = bin_rem[j] - weight[i];
                }
            }

            if (min == c + 1)
            {
                bin_rem[res] = c - weight[i];
                res++;
            }
            else
                bin_rem[bi] -= weight[i];
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] weight = { 2, 5, 4, 7, 1, 3, 8 };
        int c = 10;
        int n = weight.length;
        System.out.print("Number of bins required in Best Fit : " + bestFit(weight, n, c));
    }
}
