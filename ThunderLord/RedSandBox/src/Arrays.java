public class Arrays
{

    public static void main(String[] args)
    {
        int[][] twod = new int[2][2];
        int[] twod_first = twod[0];
        
        twod_first[0] = 4;

        System.out.println(twod[0]);
    }
}
