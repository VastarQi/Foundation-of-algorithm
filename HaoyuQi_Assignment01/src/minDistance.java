import java.io.*;
import java.lang.management.MonitorInfo;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;

/**
 * This class stores the procudure to calculate the min distance
 */

public class minDistance {
    public  ArrayList<Double> minArr = new ArrayList<Double>();
    public  coordinate a;
    public  coordinate b;
    public  double distance;
    //this class is used to store the calculate result, which involve 2 coordinates and their distance
    public minDistance(double distance, coordinate a, coordinate b){
        this.minArr=minArr;
        this.a=a;this.b=b;
        this.distance=distance;
    }
    //this is used to store the result of minDistance result
    public  ArrayList<minDistance> resultArr= new ArrayList<minDistance>(1000);
    public static ArrayList arr=new ArrayList();


    public static minDistance disCor =new minDistance(0,null,null);

    public  ArrayList<minDistance> ViolenceGetMinDis (ArrayList<coordinate> arr, int m) {
        /**
         * @Author Haoyu Qi
         * @Description use brute force method to solve the problem
         * @Param [arr, m]
         * @return java.util.ArrayList<minDistance>
         */
        double min = Double.MAX_VALUE;
        double temp;
//        int i = 0;int j = i + 1;
        int tempi=0; int  tempj=0;
        if (arr.size()==0||arr.size()==1||resultArr.size()==m) {
            return resultArr;
        } else {
            // traverse all the element and calculate all the distance between each 2
            for (int i=0; i < arr.size(); i++) {
                for (int j = i + 1; j < arr.size(); j++) {
                    temp = CoordinateSystem.getDistance(arr.get(i), arr.get(j));
                    if (temp < min) {
                        min = temp;
                        tempi=i;
                        tempj=j;
                    }
                }

            }
            resultArr.add(new minDistance(min,arr.get(tempi),arr.get(tempj)));
//            disCor.distance=min;
//            minArr.add(min);
////            System.out.println(minArr);
//            disCor.a=arr.get(tempi);disCor.b=arr.get(tempj);
//            System.out.println("will add  "+disCor.distance);
////            resultArr.add(new disCor);
//            System.out.println("starelemet: "+resultArr.get(0).distance);
//            System.out.println("endelemet:  "+resultArr.get(resultArr.size()-1).distance);
//            System.out.println("size  "+resultArr.size());
//            for(int e=0; e<resultArr.size() ;e++){
//                System.out.println(resultArr.get(e).a.x);

//            }
//        System.out.println(",,,,");
            /**
             * pop the coordinate correspond to the minimum distance in current coordinate set
             */
            arr.remove(tempi);
            arr.remove(tempj-1);
            /**
             * recursive the function with the poped new coordinate set
             */
            ViolenceGetMinDis(arr, m);

        }
        return resultArr;

    }
//        Object[] arr=heap.toArray();
//        for (int i=0;i< m;++i){
//            System.out.println(heap.poll()+'\n');
//        }
//        return min;

//    public static double aGetMinDis (ArrayList<coordinate> arr, int m){
//        double min=Double.MAX_VALUE;
//        double temp=0;
//        double[] Y=new double[P.length];
//        for (int j=0;j< P.length;j++){
//            Y[j]=P[j].y;
//        }
//        Arrays.sort(Y,0,P.length);
//        for (int i=0;i<P.length;++i){
//            for (int j=i+1;j<P.length&&(P[j].y-P[i].y)<min;++j){
//                if (CoordinateSystem.getDistance(P[j],P[i])<min){
//                    min=CoordinateSystem.getDistance(P[j],P[i]);
//                }
//            }
//            return min;
//
//        }
//
//        return temp;
//    }
//
//    public static double DCGetMinDis (coordinate[]P, int m) {
//        double min = Double.MAX_VALUE;
//        double temp = 0;
//        double[] Y = new double[P.length];
//
//    }


    public static void main(String[] args) {

        arr.add(1);
        arr.add(2);


//        BufferedReader input;
//        if (args.length != 1) {
//            System.out.println("Usage: java Lab3 [frequencyTable file pathname]");
//            System.exit(1);
//            //check the input file path
//        }
//        try {
//            input=new BufferedReader(new FileReader(args[0]));
//
//        } catch (Exception ioe) {
//            System.err.println(ioe.toString());
//            return;
//        }
//
//
//

    }
}
