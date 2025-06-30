import static org.junit.Assert.*; // import all static assertions
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());

        // Assert same object reference
        String s = "hello";
        String t = s;
        assertSame(s, t);

        // Assert not same (different objects)
        String x = new String("test");
        String y = new String("test");
        assertNotSame(x, y);

        // Assert array equals
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }
}

