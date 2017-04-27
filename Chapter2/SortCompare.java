import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Scanner;

/**
 * @author TangBin
 * @version V1.0
 * @date 10/04/2017 11:20 PM
 */
public class SortCompare {
    public static double time(String alg, Double[] a){
        Stopwatch timer = new Stopwatch();
        switch (alg){
            case "Insertion":
                Sort2_2Insertion.Insertion2(a);
                break;
            case "Selection":
                Sort2_1Selection.selection(a);
                break;
            case "Shell":
                Sort2_3Shell.sort(a);
                break;
            default:
                break;
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t=0;t<T;t++){
            for(int i=0;i<N;i++)
                a[i]= StdRandom.uniform();
            total+=time(alg,a);
        }
        return total;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int T = sc.nextInt();
        double t1 = timeRandomInput("Shell",N, T);
        double t2 = timeRandomInput("Insertion",N, T);
        StdOut.printf("For %d random Doubles\n  %s is", N, "Shell");
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, "Insertion");
    }
}
