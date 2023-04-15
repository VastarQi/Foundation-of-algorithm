/**
 * this class is to check the algorithm correctness,
 * it allow you input your own s, x, y and determine whether s is interweave of x and y:
 */

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
public class checkCorrectness {

    public static void main(String[] args) throws IOException {
        String t="";
        System.out.println("Input the String s:");
        String s="";String x="";String y="";
        Scanner sc_s=new Scanner(System.in);
        s=sc_s.nextLine();
        Pattern p=Pattern.compile("[01]+");
        Matcher matcher = p.matcher(s);
        if (matcher.find()){
            t=matcher.group(0);
            if (t!=s){
                System.out.println("invalid characters in begin or end, has been discard");
            }
        }

        System.out.println("Input the String x:");
        Scanner sc_x=new Scanner(System.in);
        x=sc_x.nextLine();
        System.out.println("Input the String y:");
        Scanner sc_y=new Scanner(System.in);
        y=sc_y.nextLine();

        String X=getComplexity.repeat(t,x,y)[0];
        String Y=getComplexity.repeat(t,x,y)[1];
        String Xtemp="" ;
        String Ytemp="" ;
        boolean h=false;

        for (int i=1;i<t.length();i++){
            int j = t.length()-i;
            Xtemp=X.substring(0,i);
            Ytemp=Y.substring(0,j);
            if (getComplexity.isInterweaved(Xtemp,Ytemp,t)==true){
                h=true;
                System.out.println(t+'\n'+"is the interweave of "+'\n'+ x +"   and  "+y);
                break;
            }
    }
        if (h==false){
            Matcher matcherB = p.matcher(s);
            if (matcherB.find() && matcherB.group().length()>=2){
                System.out.println("invalid characters still exist, check your input");
            }
            else {
                System.out.println("string s not long enough");
            }
        }
}}
