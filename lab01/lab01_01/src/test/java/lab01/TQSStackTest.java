package lab01;

import org.apache.commons.lang3.RandomStringUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TQSStackTest {
    
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;
    private static final int MIN_NUM = 3;
    private static final int MAX_NUM = 20;

    private TQSStack<String> mainStack;

    // Util Random functions
    private static int generateRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private static int generateRandomInt() {
        return generateRandomInt(MIN_NUM, MAX_NUM);
    }
    private static String generateRandomString() {
        int length = generateRandomInt(MIN_LENGTH, MAX_LENGTH);
        return RandomStringUtils.random(length, true, true);
    }

    // Set Initial Conditions
    @BeforeEach
    public void setup() {
        mainStack = new TQSStack<>();
    }
    private void populate(int limit) {
        for(int i = 0; i < limit; i++) {
            mainStack.push(generateRandomString());
        }
    }
    private void populate() {
        this.populate(generateRandomInt());
    }

    // General checks
    private void isEmpty() {
        assertTrue(mainStack.isEmpty());
    }

    private void hasSizeZero() {
        assertEquals(0, this.mainStack.size() );
    }

    // Tests
    @DisplayName("a) A stack is empty on construction.")
    @Test
    public void stackIsEmpConst() {
        this.isEmpty();
    }

    @DisplayName("b) A stack has size 0 on construction.")
    @Test
    public void stackSz0Const() {
        this.hasSizeZero();
    }

    @DisplayName("c) After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    @Test
    public void notEmpAftN() {
        int N = generateRandomInt();
        this.populate(N);

        assertFalse( mainStack.isEmpty() );
        assertEquals( N, mainStack.size() );
    }

    @DisplayName("d) If one pushes x then pops, the value popped is x.")
    @Test
    public void pushXPop() {
        String str = generateRandomString();

        mainStack.push(str);
        String str2 = mainStack.pop();

        assertEquals(str, str2);
    }

    @DisplayName("e) If one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    public void peekXSzE() {
        this.populate();
        String str = generateRandomString();
        mainStack.push(str);

        int initialSize = mainStack.size();
        String str2 = mainStack.peek();

        assertEquals(str, str2);
        assertEquals(initialSize, mainStack.size());
    }

    @DisplayName("f) If the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    public void aftNPopSz0() {
        int N = generateRandomInt();
        this.populate(N);

        for(int i = 0; i < N; i++){
            mainStack.pop();
        }

        this.isEmpty();
        this.hasSizeZero();
    }

    @DisplayName("g) Popping from an empty stack does throw a NoSuchElementException")
    @Test
    public void popEmpExc() {
        assertThrows(NullPointerException.class, () -> mainStack.pop());
    }

    @DisplayName("h) Peeking into an empty stack does throw a NoSuchElementException")
    @Test
    public void pekEmpExc() {
        assertThrows(NullPointerException.class, () -> mainStack.peek());
    }

}
