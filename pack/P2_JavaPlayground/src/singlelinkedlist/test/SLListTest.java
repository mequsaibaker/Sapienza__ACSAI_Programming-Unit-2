package singlelinkedlist.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import singlelinkedlist.SLLNode;
import singlelinkedlist.SLList;

public class SLListTest {
    @Test
    public void testMultipleElementsSLListWhenAddHead() {
        SLList list = new SLList(new int[]{1,2,3,4,5,6});
        SLLNode pre_head = list.getHead();
        SLLNode pre_tail = list.getTail();
        int pre_len = list.getLen();
        int new_value = 50;
        list.addHead(new_value);

        //test head value after insertion
        assertEquals(new_value, list.getHead().getValue());
        //test the new head.next is equal to the pre_head
        assertEquals(pre_head, list.getHead().getNext());
        //test the new len is increased by one
        assertEquals(pre_len + 1, list.getLen());
        //test the tail of the list wasn't changed after insertion
        assertEquals(pre_tail, list.getTail());
    }

    @Test
    public void testZeroElementsSLListWhenAddHead() {
        SLList list = new SLList();
        SLLNode pre_head = list.getHead();
        SLLNode pre_tail = list.getTail();
        int pre_len = list.getLen();
        int new_value = 50;
        list.addHead(new_value);

        //test head value after insertion
        assertEquals(new_value, list.getHead().getValue());
        //test the new head.next is equal to the pre_head
        assertEquals(pre_head, list.getHead().getNext());
        //test the new len is increased by one
        assertEquals(pre_len + 1, list.getLen());
        //test the tail of the list is equal to the head
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    public void testOneElementsSLListWhenAddHead() {
        SLList list = new SLList(new int[]{1});
        SLLNode pre_head = list.getHead();
        SLLNode pre_tail = list.getTail();
        int pre_len = list.getLen();
        int new_value = 50;
        list.addHead(new_value);

        //test head value after insertion
        assertEquals(new_value, list.getHead().getValue());
        //test the new head.next is equal to the pre_head
        assertEquals(pre_head, list.getHead().getNext());
        //test the new len is increased by one
        assertEquals(pre_len + 1, list.getLen());
        //test the tail of the list wasn't changed after insertion
        assertEquals(pre_tail, list.getTail());
        //text the new head.next is equal to the tail
        assertEquals(list.getTail(), list.getHead().getNext());
    }

    @Test
    public void testMultipleElementsSLListWhenAddTail() {
        SLList list = new SLList(new int[]{1,2,3,4,5,6});
        SLLNode pre_head = list.getHead();
        SLLNode pre_tail = list.getTail();
        int pre_len = list.getLen();
        int new_value = 50;
        list.addTail(new_value);

        //test tail value after insertion
        assertEquals(new_value, list.getTail().getValue());
        //test the pre tail.next is equal to the new_tail
        assertEquals(list.getTail(), pre_tail.getNext());
        //test the new len is increased by one
        assertEquals(pre_len + 1, list.getLen());
        //test the tail of the list was changed after insertion
        assertNotEquals(pre_tail, list.getTail());
    }

    @Test
    public void testZeroElementsSLListWhenAddTail() {
        SLList list = new SLList();
        SLLNode pre_head = list.getHead();
        SLLNode pre_tail = list.getTail();
        int pre_len = list.getLen();
        int new_value = 50;
        list.addHead(new_value);

        //test tail value after insertion
        assertEquals(new_value, list.getTail().getValue());
        //test that there is a tail added
        assertNotEquals(null, list.getTail());
        //test that there is a head added
        assertNotEquals(null, list.getHead());
        //test the new len is increased by one
        assertEquals(pre_len + 1, list.getLen());
        //test the head of the list is equal to the tail
        assertEquals(list.getTail(), list.getHead());
    }
}
