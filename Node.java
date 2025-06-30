class Node {
    Medicine data;
    Node prev;
    Node next;

    public Node(Medicine data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Medicine getData(){
        return data;
    }
  

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
    this.next = next;
    if (next != null) {
        next.setPrev(this);
    }
}

}// node class