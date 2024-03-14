import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingleLinkedListTest {
    @Test
    public void testFirstAppendFirstRemove() {
        SingleLinkedList list = new SingleLinkedList();
        for(int i = 0; i < 10; i++) {
            list.headAppend(i);
        }
        for(int i = 0; i < 10; i++) {
            Node head_v = list.head();
            assertEquals(head_v, list.headRemove());
        }
        // list.headAppend(5);
        // list.headAppend(0);
        // assertEquals(2, list.len());
    }

    @Test
    public void testTailAppend() {

    }
}
