package csci2720.app;

public class DoublyLinkedList<T extends Comparable<T>> {

    public NodeType<T> head;
    public NodeType<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    } // DoublyLinkedList


    /**
     * Inserts item into doubly linked list while still keeping sorted order
     *
     * @param item The item to be inserted into the doubly linked list
     */
    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<>();
        newNode.info = item;

        // if List is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        } // if

        // if new item is smaller than head's value
        if (item.compareTo(head.info) < 0) {
            newNode.next = head;
            head.back = newNode;
            head = newNode;
            return;
        } // if

        // if new item is larger than tail's current value
        if (item.compareTo(tail.info) > 0) {
            tail.next = newNode;
            newNode.back = tail;
            tail = newNode;
            return;
        } // if


        NodeType<T> current = head;
        while (current != null && item.compareTo(current.info) > 0) {
            current = current.next;
        } // while


        // if new item equals an existing item
        if (current != null && item.equals(current.info)) {
            System.out.println("The item already exists. Hope this helps. ❤️  ");
            return;
        } // if

        newNode.next = current;
        newNode.back = current.back;
        // if current has a previous node
        if (current.back != null) {
            current.back.next = newNode;
        } // if

        current.back = newNode;
    } // insertItem

    /**
     * Deletes the specified item from the doubly linked list.
     * If the item is not found or the list is empty, print a message
     *
     * @param item The item to be deleted from the list
     */
    public void deleteItem(T item) {

        // if list is empty
        if (this.head == null) {
            System.out.println("The list is empty, you cannot delete. Hope this helps. ❤️  ");
        } // if

        NodeType<T> current = this.head;

        // if head needs to be deleted
        if (item.equals(current.info)) {
            if (current.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = current.next;
                this.head.back = null;
            } // if

            return;
        } // if

        while (current != null && !item.equals(current.info)) {
            current = current.next;
        } // while

        // if item is not found
        if (current == null) {
            System.out.println("The item is not present in the list. Hope this helps. ❤️  ");
            return;
        } // if

        // if the next node isn't null to delete the node
        if (current.next != null) {
            current.next.back = current.back;
        } else {
            tail = current.back;
        } // if

        // if current has a previous node
        if (current.back != null) {
            current.back.next = current.next;
        } // if
    } // deleteItem

    /**
     * Returns the total number of elements in the doubly linked list
     * @return the length of the doubly linked list
     */
    public int length() {
        int length = 0;
        NodeType<T> current = head;

        if (current != null) {
            do {
                length++;
                current = current.next;
            } while (current != null); // do-while

        } // if

        return length;
    } // length

    /**
     * Prints all the elements in the doubly linked list to the standard output.
     */
    public void print() {
        NodeType<T> current = this.head;

        if (current == null) {
            System.out.println(" ");
        } else {
            do {
                System.out.print(current.info + " ");
                current = current.next;
            } while (current != null); // do=while
        } // if

        System.out.println("");
    } // print

    /**
     *
     *
     */
    public void printReverse() {

    } // printReverse


    /*----------------------------------------------------------------*/
    /*               The following methods are implemented            */
    /*                  using prototypes of our choice                */
    /*----------------------------------------------------------------*/

    /**
     *
     *
     */
    public void deleteSubsection() {

    } // deleteSubsection

    /**
     *
     *
     */
    public void reverseList() {

    } // reverseList

    /**
     *
     *
     */
    public void swapAlternate() {

    } // swapAlternate


} // DoublyLinkedList
