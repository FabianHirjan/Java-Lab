import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class studentTest {

    @Test
    public void testSetAnPoz() {
        Student s = new Student();
        s.setAn(2);
        assertEquals(2, s.getAn());
    }
}
