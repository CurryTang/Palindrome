import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class StudentLinkedListDequeTest{
    @Test
    public void testAddFirst(){
        StudentLinkedListDeque<Integer> sda1 = new StudentLinkedListDeque();
        sda1.addFirst(1);
        int get1 = sda1.get(0);
        assertEquals(1, get1);
        sda1.addFirst(2);
        int get2 = sda1.get(1);
        assertEquals(get1, get2);
        int get3 = sda1.get(0);
        assertEquals(2, get3);
    }

    @Test
    public void testAddLast(){
        StudentLinkedListDeque<Integer> sda1 = new StudentLinkedListDeque();
        for(int i = 0;i < 10;i++){
            Random rand = new Random();
            int item = rand.nextInt();
            sda1.addLast(item);
            assertEquals(item, (int)(sda1.get(i)));
        }
        
    }

    @Test
    public void testIsEmpty(){
        StudentLinkedListDeque<Integer> sda1 = new StudentLinkedListDeque();
        assertTrue("New deque should be empty", sda1.isEmpty());
    }

    @Test
    public void testSize(){
        StudentLinkedListDeque<Integer> sda1 = new StudentLinkedListDeque();
        for(int i = 0;i < 10;i++){
            Random rand = new Random();
            int item = rand.nextInt();
            sda1.addLast(item);
            assertEquals(i + 1, sda1.size());
        }
    }

    @Test
    public void testPrintDeque(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        StudentLinkedListDeque<Integer> sad = new StudentLinkedListDeque<Integer>();
        sad.addFirst(1);
        sad.addFirst(2);
        String expected1 = "2 1 ";
        String expected2 = "2 1";
        sad.printDeque();
        assertTrue(expected1.equals(baos.toString()) || expected2.equals(baos.toString()));
    }

    @Test
    public void testRemoveFirst(){
        StudentLinkedListDeque<Integer> sda = new StudentLinkedListDeque();
        assertEquals("Return null if empty deque", null, sda.removeFirst());
        sda.addFirst(1);
        sda.addFirst(2);
        sda.addLast(3);
        FailureSequence fs = new FailureSequence();
        DequeOperation dequeOp1 = new DequeOperation("addFirst", 1);
        DequeOperation dequeOp2 = new DequeOperation("addFirst", 2);
        DequeOperation dequeOp3 = new DequeOperation("addLast", 3);
        DequeOperation dequeOp4 = new DequeOperation("removeFirst");
        DequeOperation dequeOp5 = new DequeOperation("removeFirst");
        DequeOperation dequeOp6 = new DequeOperation("removeFirst");

        fs.addOperation(dequeOp1);
        fs.addOperation(dequeOp2);
        fs.addOperation(dequeOp3);
        fs.addOperation(dequeOp4);
        assertEquals(fs.toString(), 2, (int)sda.removeFirst());
        fs.addOperation(dequeOp5);
        assertEquals(fs.toString(), 1, (int)sda.removeFirst());
        fs.addOperation(dequeOp6);
        assertEquals(fs.toString(), 3, (int)sda.removeFirst());
        assertEquals(fs.toString(), null, sda.removeFirst());
    }


    @Test 
    public void testRemoveLast(){
        StudentLinkedListDeque<Integer> sda = new StudentLinkedListDeque();
        assertEquals("Return null if empty deque", null, sda.removeLast());
        sda.addFirst(1);
        sda.addFirst(2);
        sda.addLast(3);
        FailureSequence fs = new FailureSequence();
        DequeOperation dequeOp1 = new DequeOperation("addFirst", 1);
        DequeOperation dequeOp2 = new DequeOperation("addFirst", 2);
        DequeOperation dequeOp3 = new DequeOperation("addLast", 3);
        DequeOperation dequeOp4 = new DequeOperation("removeLast");
        DequeOperation dequeOp5 = new DequeOperation("removeLast");
        DequeOperation dequeOp6 = new DequeOperation("removeLast");
        fs.addOperation(dequeOp1);
        fs.addOperation(dequeOp2);
        fs.addOperation(dequeOp3);
        fs.addOperation(dequeOp4);
        assertEquals(fs.toString(), 3, (int)sda.removeLast());
        fs.addOperation(dequeOp5);
        assertEquals(fs.toString(), 1, (int)sda.removeLast());
        fs.addOperation(dequeOp6);
        assertEquals(fs.toString(), 2, (int)sda.removeLast()); 
        assertEquals(fs.toString(), null, sda.removeLast());
    }

    // Bug
    @Test
    public void testGet(){
        StudentLinkedListDeque<Integer> sda = new StudentLinkedListDeque();
        assertEquals(null, sda.get(0));
        FailureSequence fs = new FailureSequence();
        DequeOperation dequeOp1 = new DequeOperation("addFirst", 5);
        DequeOperation dequeOp2 = new DequeOperation("addFirst", 6);
        DequeOperation dequeOp3 = new DequeOperation("get", 1);
        DequeOperation dequeOp4 = new DequeOperation("get", 100);
        sda.addFirst(5);
        sda.addFirst(6);
        fs.addOperation(dequeOp1);
        fs.addOperation(dequeOp2);
        fs.addOperation(dequeOp3);
        assertEquals(fs.toString(), 5, (int)sda.get(1));
        fs.addOperation(dequeOp4);
        assertEquals(fs.toString(), null, sda.get(100));
    }

    public static void main(String[] args){
        jh61b.junit.TestRunner.runTests(StudentLinkedListDequeTest.class);
    }
}