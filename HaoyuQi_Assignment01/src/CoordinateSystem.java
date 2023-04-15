import java.util.ArrayList;
import java.util.Random;

public class CoordinateSystem {
    public float x=0;
    public float y=0;
    coordinate point = new coordinate(this.x, this.y);

    public CoordinateSystem (float x, float y){
        this.x=x;
        this.y=y;
    }
    public float distanceToOrigin(){
        return (float) Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
    public float distanceTo(float x,float y){
        return (float) Math.sqrt(Math.pow(this.x -x,2)+Math.pow(this.y -y,2));
    }
    //this function returns the distance between each given 2 coordinate
    public static float getDistance(coordinate p1, coordinate p2){
        return (float) Math.sqrt(Math.pow(p1.x- p2.x,2)+Math.pow(p1.y- p2.y,2));
    }
    //this function will generate the coordinates randomly with a size
    public static ArrayList generateCoordinate (int size){
        ArrayList<coordinate> site = new ArrayList<coordinate>();
        coordinate p []=new coordinate[size];
        Random r=new Random(10);
        for (int i=0;i<size;i++){
            Double x=r.nextDouble()*5;//change the number here to change the range of random numbers
            Double y=r.nextDouble()*5;
            coordinate c=new coordinate(x,y);
            site.add(c);
        }
        return site;
    }
    public static StringBuffer printCoordinateSet(ArrayList<coordinate> arr){
        StringBuffer buffer =new StringBuffer();
        for(int i=0; i<arr.size();i++){
            buffer.append("("+arr.get(i).x+","+arr.get(i).y+")"+'\n');
        }
        return buffer;
//        System.out.println(buffer);
    }
    public static StringBuffer print_dis_cor_set(ArrayList<minDistance> set, int m){
        StringBuffer buffer =new StringBuffer();
        if (m>set.size()){
            System.out.println("ERROR, invalid m value, m should be at most n/2"+'\n');
            buffer.append("invalid m value, can not process the function"+'\n');
            return buffer;
        }
        else {

        for(int i=0; i<m;i++){
//            System.out.println(i);
//            System.out.println(set.get(i).a.y);
            buffer.append(i+1 + ". "+"("+set.get(i).a.x+","+set.get(i).a.y+")"+"  "+"("+set.get(i).b.x+","+set.get(i).b.y+")"+'\n'+"distance= "+set.get(i).distance+"\n"+"\n");

        }
        return buffer;
    }}


}
