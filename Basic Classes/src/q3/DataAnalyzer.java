/**
 * @author: Ross Parsons
 */

package q3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The DataAnlyzer class works on Linked Lists of integers and computes the minimum, maximum, and average values.
 * The main() function in the DataAnalyzerTester will print the calculations and store the
 * results in a file input by the user.
 * */

public class DataAnalyzer {

    /**
     * Constructs a DataAnalyzer object.
     * @param numList is a LinkedList of integers. The class field - numberList is set to numList.
     * */
    public DataAnalyzer(LinkedList<Integer> numList)
    {
        numberList = numList;
    }


    /**
     * The min() function computes the minimum number in numList
     * @param numList a Linked List
     * */
    public int min(LinkedList<Integer> numList)
    {
        if (numList.size() <= 0){
            System.out.println("List is empty. Min cannot be calculated. ");
            return -1;
        }
        int smallest = numList.get(0);
        for(int i = 1; i < numList.size(); i++){
            if (numList.get(i) <= smallest){
                smallest = numList.get(i);
            }
        }
        return smallest;
    }
    /**
     * The max() function computes the maximum number in numList
     * @param numList a Linked List
     * */
    public int max(LinkedList<Integer> numList)
    {
        if (numList.size() <= 0){
            System.out.println("List is empty. Max cannot be calculated. ");
            return -1;
        }
        int greatest = numList.get(0);
        for (int i = 1; i < numList.size(); i++){
            if (numList.get(i) >= greatest){
                greatest = numList.get(i);
            }
        }
        return greatest;
    }
    /**
     * The average() function computes the average number in numList
     * @param numList a Linked List
     * */
    public double average(LinkedList<Integer> numList)
    {
        int sum = 0;
        for (int num: numList) {
            sum += num;
        }
        return 1.0 * sum/numList.size();

    }
    private LinkedList<Integer> numberList;
}
class DataAnalyzerTester {
    public static void main(String[] args) throws IOException {

        String filename = args[0];
        LinkedList<Integer> numList = new LinkedList<>();
        Scanner in = new Scanner(System.in);

        // convert user entered integers into a Linked List.
        for (int i = 1; i < args.length; i++)
        {
            numList.add(Integer.parseInt(args[i]));
        }
        try {
            File file = new File(filename);
            // createNewFile() returns bool value. If true, then new file is created.
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                // if createNewFile() returns false, a new file is not created.
            }else {
                System.out.println("File already exists .... adding data to " + filename);
            }
        } catch (IOException exception){
            System.out.println("An error has occurred.");
            exception.printStackTrace();
        }
        // FileWriter used to write numList, the output of min(), max(), and average().
        FileWriter fileWriter = new FileWriter(filename);

        // Add numList to the file
        fileWriter.append(numList.toString());

        DataAnalyzer d = new DataAnalyzer(numList);

        int smallest = d.min(numList);
        System.out.println("Minimum value is " + smallest + " ... writing to " + filename);
        // append output of min() to the file.
        fileWriter.append("\nMinimum value is " + smallest);

        int greatest = d.max(numList);
        System.out.println("Maximum values is " + greatest + " ... writing to " + filename);
        // append output of max() to the file.
        fileWriter.append("\nMaximum value is " + greatest);

        double average = d.average(numList);
        System.out.println("Average values is " + average + " ... writing to " + filename);
        // append output of average() to the file.
        fileWriter.append("\nAverage value is " + average);

        fileWriter.close();

    }
}
