package singlelinkedlist.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import singlelinkedlist.SLLNode;
import singlelinkedlist.SLList;

public class SLListTest {
    @Test
    public void testMultipleElementsSLListWhenAddHead() {
        SLList list = new SLList(new SLLNode(1, new SLLNode(2, new SLLNode(3, new SLLNode(4, new SLLNode(5, new SLLNode(6, null)))))));
        SLLNode new_head = new SLLNode(50);
        list.addHead(new_head);
        assertEquals(list.getHead(), new_head);
        assertEquals(list.getHead().getNext(), new_head.getNext());
        assertNotEquals(list.getHead().getNext(), null);
    }

    @Test
    public void testZeroElementsSLListWhenAddHead() {
        SLList list = new SLList();
    }
}
