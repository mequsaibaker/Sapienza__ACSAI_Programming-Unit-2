import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingleLinkedListTest {
    @Test
    public void testHeadAppend() {
        SingleLinkedList list = new SingleLinkedList();
        list.headAppend(5);
        list.headAppend(0);
        assertEquals(2, list.len());
    }

    @Test
    public void testTailAppend() {

    }
}
