import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingleLinkedListTest {
    @Test
    public void testFirstAppendFirstRemove() {
        SingleLinkedList list = new SingleLinkedList();
        for(int i = 0; i < 10; i++) {
            list.firstAppend(i);
        }
        for(int i = 9; i >=0; i--) {
            int head_v = list.head().value();
            assertEquals(head_v, list.headRemove().value());
        }
        // list.headAppend(5);
        // list.headAppend(0);
        // assertEquals(2, list.len());
    }

    @Test
    public void testTailAppend() {

    }
}
