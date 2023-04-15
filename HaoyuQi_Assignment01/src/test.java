import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter your size");
        int i =sc.nextInt();
        System.out.println("enter your pairs m");
        int j =sc.nextInt();
        long startime=0; long endtime=0; long time=0;
        startime=System.nanoTime();
        ArrayList<coordinate> arr =CoordinateSystem.generateCoordinate(i);
        System.out.println("your coordinate set is :"+'\n' + CoordinateSystem.printCoordinateSet(arr));
//        System.out.println("DC The min distance is "+minDistance.aGetMinDis(p,j));
//        System.out.println("VL The min distance is "+minDistance.ViolenceGetMinDis(arr,j));
        minDistance a=new minDistance(0,null,null);
        System.out.println("VL The min distance and its correspond coordinates are "+'\n'+CoordinateSystem.print_dis_cor_set(a.ViolenceGetMinDis(arr,j),j));
        endtime=System.nanoTime();
        time=endtime-startime;
        System.out.println("n="+i+"   "+"m="+j);
        System.out.println("algorithm running time = "+ time+" ns");
    }
}
