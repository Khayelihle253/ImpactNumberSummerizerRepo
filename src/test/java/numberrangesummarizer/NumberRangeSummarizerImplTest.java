package numberrangesummarizer;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

public class NumberRangeSummarizerImplTest {

    public static NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();

    @Test
    public void testThatNumberAreSummarized() {
        String inputNumbers = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedSummary = "1, 3, 6-8, 12-15, 21-24, 31";
        Collection<Integer> numbers = numberRangeSummarizer.collect(inputNumbers);
        assertEquals(numberRangeSummarizer.summarizeCollection(numbers), expectedSummary);
    }

    @Test
    public void testThatCollectionIsSequential() {
        Collection<Integer> numbers = numberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertFalse(Boolean.parseBoolean(Arrays.stream(numbers.toArray()).unordered().toString()));
    }

    @Test
    public void testThatStringIsSplit() {
        Collection<Integer> numbers = numberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertFalse(numbers.isEmpty());
        assertEquals(numbers.iterator().hasNext(), true);
    }

    @Test
    public void testCollectionSize() {
        assertEquals(numberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31").size(), 14);
    }

    @Test
    public void testCollectMethodReturnsList() throws Exception {
        Collection<Integer> testList = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> list = numberRangeSummarizer.collect(input);
        assertArrayEquals(list.toArray(), testList.toArray());
    }


    @Test(expected = Exception.class)
    public void testForEmptyInput() {
        String input = "";
        Collection<Integer> output = numberRangeSummarizer.collect(input);
        numberRangeSummarizer.summarizeCollection(output);
    }


    @Test(expected = Exception.class)
    public void lestIfLettersAreGivenAsInputs() {
        String input = "1,2,3,5,f,h,8,9";
        Collection<Integer> output = numberRangeSummarizer.collect(input);
        numberRangeSummarizer.summarizeCollection(output);
    }


    @Test
    public void testForDuplicates() {
        String input = "1,3,3,5,5,7,9,11,12,12,13,14,16";
        String compare = "1, 3, 5, 7, 9, 11-14, 16";
        Collection<Integer> output = numberRangeSummarizer.collect(input);
        String Result = numberRangeSummarizer.summarizeCollection(output);
        assertEquals(Result, compare);
    }
}
