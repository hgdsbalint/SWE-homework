import java.util.Scanner;
public class main{
    public void testSzorzat(){
        Szorzas szorzat = new Szorzas();
        assertEquals(2, szorzat.multiply(1,2), "It should be 2");
        assertEquals(6, szorzat.multiply(3,2), "It should be 6");
        assertEquals(0, szorzat.multiply(60,0), "It should be 0");
        assertEquals(-20, szorzat.multiply(-5,4), "It should be -20");



    }
}
