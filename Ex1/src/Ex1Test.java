import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        // Test converting a number to a string in binary
        String result = Ex1.int2Number(11, 2); // 11 in decimal should convert to "1011" in binary
        assertEquals("1011", result);

        // Test converting a number to a string in hexadecimal
        result = Ex1.int2Number(2748, 16); // 2748 in decimal should convert to "ABC" in hexadecimal
        assertEquals("ABC", result);

        // Test with base 10 (decimal)
        result = Ex1.int2Number(111, 10); // 111 in decimal should remain "111"
        assertEquals("111", result);
    }

    @Test
    void maxIndexTest() {

        String[] arr1 = {"3", "4", "111b2", "1100b2"};
        int max1 = Ex1.maxIndex(arr1);
        assertEquals(arr1[max1], "1100b2");

        String[] arr2 = {"12", "51", "333b4", "21210b4"};
        int max2 = Ex1.maxIndex(arr2);
        assertEquals(arr2[max2], "21210b4");

        String[] arr3 = {"1", "15", "22b7", "21b7"};
        int max3 = Ex1.maxIndex(arr3);
        assertEquals(arr3[max3], "22b7");
    }

}
