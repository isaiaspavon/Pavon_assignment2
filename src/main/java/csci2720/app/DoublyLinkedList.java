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
            return;
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
     * Prints the elements of the list in reverse order starting from the tail
     */
    public void printReverse() {
        if (tail == null) {
            System.out.println(" ");
        } else {
            NodeType<T> current = tail;
            while (current != null) {
                System.out.print(current.info + " ");
                current = current.back;
            } // while
        } // if

        System.out.println();
    } // printReverse


    /*----------------------------------------------------------------*/
    /*               The following methods are implemented            */
    /*                  using prototypes of our choice                */
    /*----------------------------------------------------------------*/

    /**
     * Deletes a section of the list specified by the user input
     *
     * @param lower The lower bound of the section to be deleted
     * @param upper The upper bound of the section to be deleted
     */
    public void deleteSubsection(T lower, T upper) {
        // if list is empty
        if (this.head == null) {
            return;
        } // if

        while (head != null && head.info.compareTo(lower) >= 0 && head.info.compareTo(upper) <= 0) {
            head = head.next;

            if (head != null) {
                head.back = null;
            } // if
        } // while

        NodeType<T> current = head;
        while (current != null && current.next != null) {
            if(current.next.info.compareTo(lower) >= 0 && current.next.info.compareTo(upper) <= 0) {
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.back = current;
                } // if
            } else {
                current = current.next;
            } // if
        } // while
    } // deleteSubsection

    /**
     * Reverses the linked list by swapping the next and back pointers for each node
     */
    public void reverseList() {
        if (head == null) {
            System.out.print("The list is empty, nothing to reverse. Hope this helps. ❤️  ");
            return;
        } // if

        NodeType<T> current = head;
        NodeType<T> prev;

        while (current != null) {
            prev = current.next;
            current.next = current.back;
            current.back = prev;
            current = current.back;
        } // while

        prev = head;
        head = tail;
        tail = prev;


        if (head != null) {
            head.back = null;
        } // if

        if (tail != null) {
            tail.next = null;
        } // if
    } // reverseList

    /**
     * Swaps the data between adjacent nodes in the list, alternating
     * the values in pairs. This continues until the end of the list is reached.
     */
    public void swapAlternate() {
        if (this.head == null || this.head.next == null) {
            return;
        } // if

        NodeType<T> current = this.head;

        do {
            T temp = current.info;
            current.info = current.next.info;
            current.next.info = temp;
            current = current.next.next;
        } while (current != null && current.next != null); // do-while
    } // swapAlternate


} // DoublyLinkedList
