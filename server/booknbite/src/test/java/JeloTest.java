import org.junit.jupiter.api.Test;

class JeloTest {

    @Test
    void testJeloProperties() {
        Jelo jelo = new Jelo(1L, "example.jpg", "Pizza", "Pizza calzone", "10,00", "Alergeni", 0, "Glavno jelo");

        assertEquals(Long.valueOf(1), jelo.getJeloId());
        assertEquals("example.jpg", jelo.getImageSrc());
        assertEquals("Pizza", jelo.getNazivJela());
        assertEquals("Pizza calzone", jelo.getOpisJela());
        assertEquals("10,00", jelo.getCijena());
        assertEquals("Alergeni", jelo.getAlergeni());
        assertEquals(0, jelo.getInitialOcjena());
        assertEquals("Glavno jelo", jelo.getKategorija());


    }
}