import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class DayTwo {
    public static void findProduct (File file) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        int two = 0;
        int three = 0;
        StringBuilder sb = new StringBuilder();
        int current;
        boolean noTwo;
        boolean noThree;
        HashSet<Character> hashSet = new HashSet<Character>();

        while((line = br.readLine()) != null){
            noTwo = true;
            noThree = true;

            for(int i = 0; i < line.length(); i++){
                hashSet.add(line.charAt(i));
            }
            Iterator<Character> it = hashSet.iterator();
            char[] uniqueChars = new char[hashSet.size()];

            int j = 0;
            while(it.hasNext()){
                uniqueChars[j] = it.next();
                j++;
            }

            for(current = 0; current < uniqueChars.length; current++) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == uniqueChars[current]) {
                        sb.append(line.charAt(i));
                    }
                }
                if ((sb.length() == 2) && noTwo) {
                    noTwo = false;
                    two++;
                }
                if ((sb.length() == 3) && noThree) {
                    noThree = false;
                    three++;
                }
                sb.setLength(0);
                hashSet.clear();

                if(!(noTwo||noThree))
                    break;
            }
        }

        System.out.println("Twos: " + two + " Threes: " + three + " Product: " + two*three);
    }

    public static void findPair(File file) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String lines[] = new String[250];

        int l = 0;
        while ((line = br.readLine()) != null){
            lines[l] = line;
            l++;
        }

        boolean equal;
        int pos = 0;
        String correctLine = null;

        here:
        for(int i = 0; i < lines.length-1; i++){
            for(int j = i+1; j < lines.length; j++){
                equal = true;
                for(int k = 0; k < 26; k++){
                    if(!(lines[i].charAt(k) == lines[j].charAt(k)) && equal){
                        equal = false;
                        pos = k;
                        correctLine = lines[i];
                    }
                    else if(!(lines[i].charAt(k) == lines[j].charAt(k)) && !equal){
                        break;
                    }
                    if(!equal && k == 25){
                        break here;
                    }
                }
            }
        }
        System.out.println(pos);
        for(int i = 0; i < correctLine.length(); i++){
            if(i != pos)
                System.out.print(correctLine.charAt(i));
        }
    }

    public static void main(String args[]) throws Exception{
        File boxIDs = new File("boxIDs.txt");

        findProduct(boxIDs);
        findPair(boxIDs);
    }
}
