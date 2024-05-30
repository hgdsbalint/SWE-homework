import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntRangeTest {
    private IntRange range;

    @BeforeEach
    public void setUp(){
        range = IntRange.of(15,30);
    }
    @Test
    public void testIsEmtpy(){
        Assertions.assertTrue(IntRange.EMPTY.isEmpty());
        Assertions.assertFalse(range.isEmpty());
    }

    @Test
    public void testcontains(){
        Assertions.assertTrue(range.contains(15));
        Assertions.assertTrue(range.contains(30));
        Assertions.assertTrue(range.contains(20));
        Assertions.assertTrue(range.contains(21));
        Assertions.assertFalse(range.contains(-10), "-10 is not an element of range[15, 30]");
    }
    @Test
    public void testIntersect(){
        Assertions.assertSame(range, range.intersect(range));
        Assertions.assertEquals(IntRange.of(25,30), range.intersect(IntRange.of(25,40)));
    }
}