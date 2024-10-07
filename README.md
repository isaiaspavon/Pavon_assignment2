# Pavon_assignment2

Project 2 for Data Structures at UGA

> Isaias Pavon
> ip13488@uga.edu

To build the Project:

    $ mvn package

To compile the project:

    $ mvn compile

To run the project:

    # For int-input.txt
       $ mvn exec:java -Dexec.args="src/main/java/csci2720/app/int-input.txt"

    # For double-input.txt
       $ mvn exec:java -Dexec.args="src/main/java/csci2720/app/double-input.txt"

    # For string-input.txt
       $ mvn exec:java -Dexec.args="src/main/java/csci2720/app/string-input.txt"

> Delete Subsection

    1. If the head is null, return (the list is empty).
    2. While the head is not null and the value of the head is within the bounds:
       a. Move head to the next node.
       b. If head is not null, set head's back pointer to null.
    3. Set current to head.
    4. While current is not null and current.next is not null:
       a. If current.next value is within the bounds:
          i. Set current.next to current.next.next (remove the node).
          ii. If current.next is not null, update its back pointer to current.
       b. Else, move current to current.next.

    Time Complexity: O(n) where n is the number of nodes in the list.

> Reverse List

    1. If the head is null, print a message and return (the list is empty).
    2. Set current to head.
    3. While current is not null:
       a. Store the next node (prev = current.next).
       b. Swap the next and back pointers (current.next = current.back; current.back = prev).
       c. Move to the next node (current = prev).
    4. Set a temporary variable to the current head.
    5. Set head to tail and tail to the temporary variable.
    6. If head is not null, set head's back pointer to null.
    7. If tail is not null, set tail's next pointer to null.

    Time Complexity: O(n) where n is the number of nodes in the list.

> Swap Alternate

    1. If head is null or head.next is null, return (the list is empty or has one node).
    2. Set current to head.
    3. While current is not null and current.next is not null:
       a. Swap the data between current and current.next.
       b. Move current to current.next.next (to reach the next pair).

    Time Complexity: O(n) where n is the number of nodes in the list.