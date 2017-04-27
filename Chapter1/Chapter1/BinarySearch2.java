package Chapter1;

import java.util.Arrays;
import edu.princeton.cs.algs4.*;
import java.lang.*;

public class BinarySearch2
{
    public static int rank(int key, int[] a)
    {
        int lo=0;
        int hi=a.length-1;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(a[mid]>key) hi=mid-1;
            else if(a[mid]<key) lo=mid+1;
            else return mid;
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] whitelist={1,2,3,5};
        //Arrays.sort(whitelist);
        while(!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            StdOut.println(rank(key,whitelist));
        }
    }
}