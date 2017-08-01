package dmz.codeChallenges;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MultiplicationTableTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private MultiplicationTable underTest;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void EndToEndTest() {

        String expectedResult = "Multiplication table with the first 10 prime numbers:\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|    x|    2|    3|    5|    7|   11|   13|   17|   19|   23|   29|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|    2|    4|    6|   10|   14|   22|   26|   34|   38|   46|   58|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|    3|    6|    9|   15|   21|   33|   39|   51|   57|   69|   87|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|    5|   10|   15|   25|   35|   55|   65|   85|   95|  115|  145|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|    7|   14|   21|   35|   49|   77|   91|  119|  133|  161|  203|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|   11|   22|   33|   55|   77|  121|  143|  187|  209|  253|  319|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|   13|   26|   39|   65|   91|  143|  169|  221|  247|  299|  377|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|   17|   34|   51|   85|  119|  187|  221|  289|  323|  391|  493|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|   19|   38|   57|   95|  133|  209|  247|  323|  361|  437|  551|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|   23|   46|   69|  115|  161|  253|  299|  391|  437|  529|  667|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";
        expectedResult += "|   29|   58|   87|  145|  203|  319|  377|  493|  551|  667|  841|\n";
        expectedResult += "+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n";

        underTest = new MultiplicationTable();
        underTest.run(10);

        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void WriteToConsoleTest() {

        String expectedResult = "Testing console output...";

        underTest = new MultiplicationTable();
        underTest.WriteToConsole("Testing console output...");

        assertEquals(expectedResult, outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void GetMaxWidthSuccess() {

        underTest = new MultiplicationTable();
        int testValue = 10;
        int expectedResult = 5;

        int result = underTest.GetMaxWidth(testValue);
        assertEquals("Result is wrong", expectedResult, result);
    }

    @Test
    public void GetRowDividerSuccess() {

        underTest = new MultiplicationTable();
        String expectedResult = "+---+---+---+---+\n";

        String result = underTest.GetRowDivider(3, 3);
        assertNotNull("Result can't be null", result);
        assertEquals("Result is wrong", expectedResult, result);
    }

    @Test
    public void InputValidationTrue() {
        underTest = new MultiplicationTable();

        Boolean result = underTest.InputValidation(500);
        assertTrue("Result is wrong", result);
    }

    @Test
    public void InputValidationFalse() {
        underTest = new MultiplicationTable();

        Boolean result = underTest.InputValidation(25000);
        assertFalse("Result is wrong", result);
    }

    @Test
    public void PrintMultiplicationTableSuccess() {

        Integer[] primeNumbers = {  1, 2, 3 };
        List<Integer> list = Arrays.asList(primeNumbers);

        String expectedResult;
        expectedResult = "Multiplication table with the first 3 prime numbers:\n";
        expectedResult += "+---+---+---+---+\n";
        expectedResult += "|  x|  1|  2|  3|\n";
        expectedResult += "+---+---+---+---+\n";
        expectedResult += "|  1|  1|  2|  3|\n";
        expectedResult += "+---+---+---+---+\n";
        expectedResult += "|  2|  2|  4|  6|\n";
        expectedResult += "+---+---+---+---+\n";
        expectedResult += "|  3|  3|  6|  9|\n";
        expectedResult += "+---+---+---+---+\n";

        underTest = new MultiplicationTable();
        String result = underTest.PrintMultiplicationTable(list);

        assertNotNull("Result can't be null", result);
        assertEquals("Result is wrong", expectedResult, result);
    }
}