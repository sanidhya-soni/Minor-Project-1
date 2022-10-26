package source.trials;

class BinPacking
{
    static int bestFit(int size[], int n, int c)
    {
        int res = 0;

        int[] bin_rem = new int[n];

        for (int i = 0; i < n; i++)
        {
            int j;
            int min = c + 1, bi = 0;

            for (j = 0; j < res; j++)
            {
                if (bin_rem[j] >= size[i] && bin_rem[j] - size[i] < min)
                {
                    bi = j;
                    min = bin_rem[j] - size[i];
                }
            }

            if (min == c + 1)
            {
                bin_rem[res] = c - size[i];
                res++;
            }
            else
                bin_rem[bi] -= size[i];
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] size = { 2, 5, 4, 7, 1, 3, 8 };
        int c = 10;
        int n = size.length;
        System.out.print("Number of bins required in Best Fit : " + bestFit(size, n, c));
    }
}
