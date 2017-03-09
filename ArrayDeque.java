public class ArrayDeque<Item> {
	/* the stored integers */
	private Item[] items;
	private int size;
    private int front;
    private int rear;
    private int maxDepth;

	private static int RFACTOR = 2;

    /** Creates an empty list. */
    public ArrayDeque() {
    	size = 0;
    	items = (Item[]) new Object[8];
        front = 4;
        rear = 5;
        maxDepth = rear - 1;
    }

    /** Resize our backing array so that it is
      * of the given capacity. */
    private void resize(int capacity) {
    	Item[] a = (Item[]) new Object[capacity];
    	System.arraycopy(items, 0, a, 0, size);
    	items = a;    	
    }

    public boolean isEmpty(){
        return (size == 0) ? (true) : (false);
    }

    private boolean isFull() {
        return (size == items.length) ? (true) : (false);
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {    	
    	if(isFull()){
            resize(RFACTOR * items.length);
        }
        items[rear] = x;
        rear = (rear + 1) % items.length;
        if (rear % items.length > maxDepth){
            maxDepth = rear;
        }
        size += 1;
    }

    public void addFirst(Item x){
        if(isFull()){
            resize(RFACTOR * items.length);
        }
        items[front] = x;
        front = (front - 1) % items.length;
        if (front % items.length > maxDepth){
            maxDepth = front;
        }
        size += 1;
    }


    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    public void printDeque() {
        int cursor = (front + 1) % items.length;
        while(cursor != rear){
            System.out.print(items[cursor]);
            System.out.print(' ');
            cursor = (cursor + 1) % items.length;
        }
        System.out.println();
    }

    public Item removeFirst(){
        Item deleteObject = items[(front + 1) % items.length];
        size -= 1;
        if (size <= items.length / 4 && items.length > 16 && maxDepth < items.length / 2){
            resize(items.length / 2);
        }
        items[(front + 1) % items.length] = null;
        front = (front + 1) % items.length;
        if (front % items.length > maxDepth){
            maxDepth = front;
        }
        return deleteObject;
    }

    public Item get(int i){
        return items[(front + i + 1) % items.length];
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        Item deleteObject = items[(rear - 1) % items.length];
        size -= 1;
        if (size <= items.length / 4 && items.length > 16 && maxDepth < items.length / 2){
            resize(items.length / 2);
        }
        items[(rear - 1) % items.length] = null;
        rear = (rear - 1) % items.length;
        if (rear % items.length > maxDepth){
            maxDepth = rear;
        }
        return deleteObject;
    }

    public static void main(String[] args){
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addFirst(1);
        a.addFirst(2);
        a.printDeque();
        // a.addFirst("abc");
        // a.addLast("abcd");
        // a.printDeque();
        // a.removeLast();
        // a.printDeque();
        // System.out.println(a.front);
        // System.out.println(a.get(0));
        // System.out.println(a.removeFirst());
        // a.printDeque();
    }

}