import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
    public class output_in_CSV_n_ST {
        public static String escapeSpecialCharacters(String data) {
            String escapedData = data.replaceAll("\\R", " ");
            if (data.contains(",") || data.contains("\"") || data.contains("'")) {
                data = data.replace("\"", "\"\"");
                escapedData = "\"" + data + "\"";
            }
            return escapedData;
        }
        public static String convertToCSV(String[] data) {
            return Stream.of(data)
                    .map(output_in_CSV_n_ST::escapeSpecialCharacters)
                    .collect(Collectors.joining(","));
        }

        /**
         *
         *
         * @param filePath
         * @param dataLineList
         */
        public static void writeCsvFile(String filePath, List<String[]> dataLineList) {
            File csvOutputFile = new File(filePath);
            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                dataLineList.stream()
                        .map(output_in_CSV_n_ST::convertToCSV)
                        .forEach(pw::println);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) {
            List<String[]> dataLineList = new ArrayList<>();
            int n=0; int m=0;
            int mArr[]=new int[]{10,15,20,50,75,100,250,500};
            long startime=0; long endtime=0; long time=0;
            for (int i=0;i<mArr.length;i++){
                startime=System.nanoTime();
                ArrayList<coordinate> arr = CoordinateSystem.generateCoordinate(1000);
                minDistance a=new minDistance(0,null,null);
                a.ViolenceGetMinDis(arr,mArr[i]);
                endtime=System.nanoTime();
                time=endtime-startime;
                dataLineList.add(new String[]{Double.toString( mArr[i]) ,Long.toString(time) });
                writeCsvFile("E:\\1.csv", dataLineList);
            }}
    }



