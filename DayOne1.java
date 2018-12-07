import java.io.*;

public class DayOne1 {
    public static void main(String args[]) throws Exception{
        File frequencies = new File("frequencies.txt");
        BufferedReader br = new BufferedReader(new FileReader(frequencies));

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
}
