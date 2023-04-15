import java.io.*;
import java.util.Random;

/**
 * This class is to be used to get the time complexity, also the used methods is stored in this class
 */
public class getComplexity {
    public static int comapare=0;
    public static int assign=0;
    static String generate01(int len){
        Random random01=new Random();
        String testS="";
        for (int i=0;i<len;i++){
            int R=random01.nextInt(2);
            testS=testS+Integer.toString(R);
        }
        return testS;
    }
    /**
     * repeat function is used to construct the x' and y' which are as length as s
     * @param S
     * @param x
     * @param y
     * @return
     */
    static String[] repeat(String S, String x, String y){
        int rx =(int) Math.ceil((double) S.length()/x.length());
        int ry=(int) Math.ceil((double) S.length()/y.length());
        String X="";
        String Y="";
        for (int i=0;i<rx;i++){
            X=X+x;
            assign++;
        }
        for (int i=0;i<ry;i++){
            Y=Y+y;
            assign++;
        }
        String XandY[]={X,Y};

        return XandY;
    }
    /**
     * isInterleaved is used to judge whether string s is the interweave od A and B
     * @param A
     * @param B
     * @param S
     * @return
     */
    static boolean isInterweaved(String A, String B, String S){
        int m = A.length(); int n = B.length();
        boolean interLeave[][] = new boolean[m + 1][n + 1];
        if ((m + n) != S.length())
            return false;
        for(int i = 0; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if (i == 0 && j == 0) {
                    comapare++;
                    interLeave[i][j] = true;
                    assign++;
                }
                else if (i == 0)
                {
                    comapare++;
                    if (B.charAt(j - 1) ==S.charAt(j - 1)) {
                        comapare++;
                        interLeave[i][j] = interLeave[i][j - 1];
                        assign++;
                    }
                }
                else if (j == 0)
                {
                    comapare++;
                    if (A.charAt(i - 1) ==S.charAt(i - 1)) {
                        comapare++;
                        interLeave[i][j] = interLeave[i - 1][j];
                        assign++;
                    }
                }
                else if (A.charAt(i - 1) == S.charAt(i + j - 1) && B.charAt(j - 1) !=S.charAt(i + j - 1)) {
                    comapare++;
                    interLeave[i][j] = interLeave[i - 1][j];
                    assign++;
                } else if (A.charAt(i - 1) !=S.charAt(i + j - 1) &&B.charAt(j - 1) ==S.charAt(i + j - 1)) {
                    comapare++;
                    interLeave[i][j] = interLeave[i][j - 1];
                    assign++;
                } else if (A.charAt(i - 1) ==S.charAt(i + j - 1) && B.charAt(j - 1)==S.charAt(i + j - 1)) {
                    comapare++;
                    interLeave[i][j] = (interLeave[i - 1][j] || interLeave[i][j - 1]);
                    assign++;
                }
            }
        }
        return interLeave[m][n];
    }
    public static void main(String[] args) throws IOException {

        String S="";
        String x="11";String y="00";
        int len[]={10,20,30,50,100,200,300,500,800,1000};
        for (int k=0;k<len.length;k++){
            S=generate01(len[k]);
            String X=repeat(S,x,y)[0];
            String Y=repeat(S,x,y)[1];
            String Xtemp="" ;
            String Ytemp="" ;
            for (int i=1;i<S.length();i++){
                int j = S.length()-i;
                Xtemp=X.substring(0,i);
                Ytemp=Y.substring(0,j);
                if (isInterweaved(Xtemp,Ytemp,S)==true){
                    int ac=comapare+assign;
                    String outputString="s digits is "+S.length()+"\n"+"a+c="+ac+"  a= "+assign+"  c= "+comapare;
                    System.out.println("True");
                    System.out.println(outputString);
                    assign=0;comapare=0;
                    break;
                }

            }
        }

    }


}
