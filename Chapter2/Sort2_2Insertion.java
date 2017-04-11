import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * @author TangBin
 * @version V1.0
 * @date 10/04/2017 5:22 PM
 */
public class Sort2_2Insertion {
    public static void Insertion(Comparable[] a)
    {
        int length=a.length;
        for(int i=1;i<length;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                    exch(a,j,j-1);
            }
        }
    }

    public static void Insertion2(Comparable[] a)
    {
        int length=a.length;
        for(int i=1;i<length;i++){
            Comparable min=a[i];
            int j=i-1;
            while(j>=0&&less(min,a[j])){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=min;
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i = 0; i<a.length;i++){
            StdOut.print(a[i]+" ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i = 1;i<a.length;i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }

    public static void main(String[] args){
        String[] a = In.readStrings();
        Insertion2(a);
        assertEquals(isSorted(a),true);
        show(a);
    }
}
