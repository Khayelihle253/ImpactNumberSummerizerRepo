package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class that implements the interface
 */
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {
    @Override
    public Collection<Integer> collect(String input) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        String[] arrayOfNumbers = input.split(",");
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if(!listOfNumbers.contains(Integer.parseInt(arrayOfNumbers[i]))) {
                listOfNumbers.add(Integer.parseInt(arrayOfNumbers[i]));
            }
        }
        return listOfNumbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        String summerizedListOfNumbers = "";
        //add all input numbers into an arraylist so that we can iterate through it
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.addAll(input);

        for (int i = 0; i < inputNumbers.size()-1; i++) {
            if (inputNumbers.get(i)+1 == inputNumbers.get(i+1)){
                summerizedListOfNumbers += inputNumbers.get(i) + "-"; //sequence start number
                while (inputNumbers.get(i)+1 == inputNumbers.get(i+1)){
                    i++;
                }
                summerizedListOfNumbers += inputNumbers.get(i) + ", ";
            }else{
                summerizedListOfNumbers += inputNumbers.get(i) + ", ";
            }
        }
        //add the last number
        summerizedListOfNumbers += inputNumbers.get(inputNumbers.size()-1);

        return summerizedListOfNumbers;
    }

}
