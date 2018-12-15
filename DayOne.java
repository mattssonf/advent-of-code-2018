import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class DayOne {

    public static void AddFromFile(File file) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int sum = 0;
        String number;
        while((line = br.readLine()) != null){
            if(line.charAt(0) == '-') {
                number = line.substring(1);
                sum = sum - Integer.parseInt(number);
            }
            else {
                number = line.substring(1);
                sum = sum + Integer.parseInt(number);
            }
        }
        System.out.println("The sum of the frequencies is: " + sum);
    }

    public static void FindDuplicateFrequency(File file) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        Set<Integer> sums = new TreeSet<Integer>();

        String line;
        int sum = 0;
        String number;
        br.mark(5000);
        while(true){
            line = br.readLine();
            if(line  == null){
                br.reset();
                line = br.readLine();
            }
            if(line.charAt(0) == '-') {
                number = line.substring(1);
                sum = sum - Integer.parseInt(number);
                if(sums.contains(sum))
                    break;
                sums.add(sum);
            }
            else {
                number = line.substring(1);
                sum = sum + Integer.parseInt(number);
                if(sums.contains(sum))
                    break;
                sums.add(sum);
            }
            System.out.println(line);
        }
        System.out.println("The first duplicate frequency is: " + sum);
    }

    public static void main(String args[]) throws Exception{
        File frequencies = new File("frequencies.txt");
        AddFromFile(frequencies);
        FindDuplicateFrequency(frequencies);
    }
}
