import org.junit.Test;

import static org.junit.Assert.*;



public class Program01Test {

    @Test

    public void testCaesarCode() {

        assertEquals("de", Program01.caesarCode("ab", 3));

        assertEquals("ef", Program01.caesarCode("bc", 3));

        assertEquals("d", Program01.caesarCode("a", 3));

        assertEquals("c", Program01.caesarCode("z", 3));

        assertEquals("hi", Program01.caesarCode("ab", 7));

    }

}
