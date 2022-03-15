/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.Iterator;

/**
 * @author ico0
 */
public class DipTest {

    private Dip instance;


    public DipTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }


    @Test
    public void testConstructorFromBadArrays() {

        int[] correctNumbers = new int[]{10, 20, 30, 40, 50};
        int[] correctStars = new int[]{1, 2};
        // count(numbers) < 5
        assertThrows(IllegalArgumentException.class, () -> new Dip(new int[]{10, 20, 30, 40}, correctStars ));
        // count(numbers) > 5
        assertThrows(IllegalArgumentException.class, () -> new Dip(new int[]{10, 20, 30, 40, 50, 60}, correctStars ));
        // count(stars) < 2
        assertThrows(IllegalArgumentException.class, () -> new Dip(correctNumbers, new int[]{1} ));
        // count(stars) > 2
        assertThrows(IllegalArgumentException.class, () -> new Dip(correctNumbers, new int[]{1, 2, 3} ));
    }

    @Test
    public void testFormat() {
        // note: correct the implementation of the format(), not the test...
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[  1  2]", result, "format as string: formatted string not as expected. ");
    }

    @Test
    public void testNumbersRange() {
        Dip badDip = new Dip(new int[]{10, 20, 30, 40, 60}, new int[]{1, 11});
        Iterator<Integer> it = badDip.getNumbersColl().iterator();
        while()
    }

}
