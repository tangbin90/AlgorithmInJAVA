import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

import java.util.Scanner;

/**
 * @author TangBin
 * @version V1.0
 * @date 09/04/2017 9:53 PM
 */
public class DoublingRatio {
    public static double timeTrail(int N){
        int MAX=1000000;
        int[] a = new int[N];
        for(int i=0;i<N;i++){
            a[i] = StdRandom.uniform(-MAX,MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args){
        double prev = timeTrail(125);
        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
        for(int N=250;true;N+=N){
            double time = timeTrail(N);
            StdOut.printf("%6d %7.1f ",N,time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
