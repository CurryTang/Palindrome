// Using doubly linked list

public class LinkedListDeque<Item>{
    public class Node{
        public Item item;
        public Node next;
        public Node prev;
        public Node(Item i, Node n, Node p){
            item = i;
            next = n;
            prev = p;
        }
    }

    // Sentinel node
    private Node sentinelHead;
    // Keep the size to optimize the size() method
    private int size;

    public LinkedListDeque(){
        size = 0;
        sentinelHead = new Node(null,null,null);
        sentinelHead.next = sentinelHead;
        sentinelHead.prev = sentinelHead;
    }

    public LinkedListDeque(Item item){
        this();
        size = 1;
        Node node = new Node(item, sentinelHead, sentinelHead);
        sentinelHead.next = node;
        sentinelHead.prev = node;
    }

    public void addFirst(Item item){
        Node newNode = new Node(item, sentinelHead.next, sentinelHead);
        sentinelHead.next.prev = newNode; // When empty: sentinel.prev = item; else: sentinel.next.prev = item
        sentinelHead.next = newNode;
        size += 1;
        
    }

    public void addLast(Item item){
        Node tail = sentinelHead.prev;
        Node newNode = new Node(item, sentinelHead, tail);
        sentinelHead.prev = newNode;
        tail.next = newNode;
        size += 1;
    }
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }else{
            return false;
        }
    }
    public int size() {
        return size;
    }
    // Prints the items in the Deque from first to last, separated by a space.
    public void printDeque() {
        Node cursor = sentinelHead.next;
        while(cursor != sentinelHead){
            System.out.print(cursor.item);
            System.out.print(' ');
            cursor = cursor.next;
        }
        System.out.println();
    }
    public Item removeFirst() {
        if (isEmpty()){
            return null;
        }
        Item item = sentinelHead.next.item;
        Node deleteNode = sentinelHead.next;
        sentinelHead.next = deleteNode.next;
        deleteNode.next.prev = deleteNode.prev;
        if (sentinelHead.prev == deleteNode){
            sentinelHead.prev = sentinelHead;
        }
        size -= 1;
        return item;

    }
    public Item removeLast() {
        if (isEmpty()){
            return null;
        }
        Node deleteNode = sentinelHead.prev;
        Node newTail = deleteNode.prev;
        newTail.next = sentinelHead;
        sentinelHead.prev = newTail;
        size -= 1;
        return deleteNode.item;
    }
    public Item get(int index) {
        if (isEmpty()){
            return null;
        }
        Node curr = sentinelHead;
        for(int i = 0;i < index && i < size;i++){
            curr = curr.next;
        }
        return curr.next.item;
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> a = new LinkedListDeque<Integer>();
        a.addFirst(3);
        a.addFirst(5);
        a.addLast(6);
        System.out.println(a.get(1));
        System.out.println(a.get(2));
        System.out.println(a.get(0));   
        System.out.println(a.size());
        a.printDeque();
        int back1 = a.removeFirst();
        int back2 = a.removeLast();
        System.out.println(back1 + " " + back2);
        a.printDeque();
        

    }


}