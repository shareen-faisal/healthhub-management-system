
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

      public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public Node getEntry(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

     public void add(Medicine data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode) ;
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }// add method

    public void remove(Medicine targetObject) {
    Node current = head;

    while (current != null) {
    if (current.data.equals(targetObject)) {
    if (current == head) {
    // Remove from the beginning
    head = head.getNext();
    if (head != null) {
    head.setPrev(null);
    } else {
    // The list is now empty
    tail = null;
    }
    } else if (current == tail) {
    // Remove from the end
    tail = tail.getPrev();
    tail.next = null;
    } else {
    // Remove from the middle
    current.getPrev().setNext(current.getNext());
    current.getPrev().setNext( current.getPrev() );
    }

    size--;
    return; // Object found and removed, exit the method
    }

    current = current.getNext();
    }
    System.out.println("Object not found: " + targetObject);
    }

    public void displayInfo() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData().getName());
            current = current.getNext();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}