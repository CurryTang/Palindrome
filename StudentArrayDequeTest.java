// Unittest for StudentArrayDeque class.
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class StudentArrayDequeTest{
    @Test
    public void testAddFirst(){
        StudentArrayDeque<Integer> sda1 = new StudentArrayDeque();
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
        StudentArrayDeque<Integer> sda1 = new StudentArrayDeque();
        for(int i = 0;i < 10;i++){
            Random rand = new Random();
            int item = rand.nextInt();
            sda1.addLast(item);
            assertEquals(item, (int)(sda1.get(i)));
        }
        
    }

    @Test
    public void testIsEmpty(){
        StudentArrayDeque<Integer> sda1 = new StudentArrayDeque();
        assertTrue("New deque should be empty", sda1.isEmpty());
    }

    @Test
    public void testSize(){
        StudentArrayDeque<Integer> sda1 = new StudentArrayDeque();
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
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<Integer>();
        sad.addFirst(1);
        sad.addFirst(2);
        String expected1 = "2 1 ";
        String expected2 = "2 1";
        sad.printDeque();
        assertTrue(expected1.equals(baos.toString()) || expected2.equals(baos.toString()));
    }

    //First bug, wrong removefirst implementation
    @Test
    public void testRemoveFirst(){
        StudentArrayDeque<Integer> sda = new StudentArrayDeque();
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

    //Second bug
     @Test 
    public void testRemoveLast(){
        StudentArrayDeque<Integer> sda = new StudentArrayDeque();
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

    @Test
    public void testGet(){
        StudentArrayDeque<Integer> sda = new StudentArrayDeque();
        assertEquals(null, sda.get(0));
        sda.addFirst(5);
        sda.addFirst(6);
        assertEquals(5, (int)sda.get(1));
        assertEquals(null, sda.get(100));
    }

    public static void main(String[] args){
        jh61b.junit.TestRunner.runTests(StudentArrayDequeTest.class);
    }
}