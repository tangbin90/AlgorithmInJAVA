package Chapter1;

import java.util.Arrays;
import edu.princeton.cs.algs4.*;
import java.lang.*;

public class Ext1_1_5
{
    static boolean JudgeXY(double x, double y)
    {
        if(x<=1.0&&x>=0&&y<=1.0&&y>=0)
            return true;
        else
            return false;
    }
    public static void main(String[] args)
    {
        double x=StdIn.readDouble();
        double y=StdIn.readDouble();
      
        if(JudgeXY(x,y))
            StdOut.printf("true");
         else
            StdOut.printf("false");
        
        System.out.println((char)(4+'a'));
        return;
    }
}