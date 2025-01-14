import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.UserType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OcjenjivacTest {
    @Test
    void testOcjenjivacProperties() {
        Ocjenjivac ocjenjivac = new Ocjenjivac();
        ocjenjivac.setUsername("testUser");
        ocjenjivac.setFirstName("Test");
        ocjenjivac.setLastName("User");
        ocjenjivac.setEmail("test@test.com");
        ocjenjivac.setKorisnikId("001");
        ocjenjivac.setUserType(UserType.OCJENJIVAC);

        assertEquals(ocjenjivac.getUsername(), "testUser");
        assertEquals(ocjenjivac.getFirstName(), "Test");
        assertEquals(ocjenjivac.getLastName(), "User");
        assertEquals(ocjenjivac.getEmail(), "test@test.com");
        assertEquals(ocjenjivac.getKorisnikId(), "001");
        assertEquals(ocjenjivac.getUserType(), UserType.OCJENJIVAC);
    }
}