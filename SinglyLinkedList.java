package testprj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ashish on 22/02/18.
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        LinkedList list = new LinkedList();
        System.out.println("Singly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. Append an element into the Linkedlist");
            System.out.println("2. Remove the tail element from a Linkedlist");
            System.out.println("3. Remove all element in the Linkedlist that is great than a target value");
            int choice = scan.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter integer element to insert");
                    list.insertAtEnd(scan.nextInt());
                    break;
                case 2:
                    list.deleteAtPos(list.getSize());
                    break;
                case 3:
                    System.out.println("Enter integer element");
                    list.removeValueGreaterThan( scan.nextInt());
                    break;
                default:
                    System.out.println("Wrong Entry");
                    break;
            }

            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}


class LinkedList {
    protected Node start;
    protected Node end;
    public int size;

    /**
     * Default Constructor
     */
    public LinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    /**
     * Check if list is empty
     */
    public boolean isEmpty() {
        return start == null;
    }

    /**
     * Get size of list
     */
    public int getSize() {
        return size;
    }

    /**
     * insert an element at end
     *
     * @param val
     */
    public void insertAtEnd(int val) {
        Node nptr = new Node(val, null);
        size++;
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            end.setLink(nptr);
            end = nptr;
        }
    }



    /**
     * insert an element at position
     *
     * @param pos
     */
    public void deleteAtPos(int pos) {
        if (pos == 1) {
            start = start.getLink();
            size--;
            return;
        }
        if (pos == size) {
            Node s = start;
            Node t = start;
            while (s != end) {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size--;
            return;
        }
        Node ptr = start;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size--;
    }

    /**
     * display elements
     */
    public void display() {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData() + "->");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData() + "\n");
    }

    public void removeValueGreaterThan(int val) {
        ArrayList<Integer> indexArray = new ArrayList<Integer>();
        int index = 1;
        Node ptr = start;
        if (start.getData() > val) {
            indexArray.add(index);
        }
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            index++;
            if (ptr.getData() > val) {
                indexArray.add(index);
            }
            ptr = ptr.getLink();
        }
        if (ptr.getData() > val) {
            indexArray.add(index++);
        }
        for (Integer i : indexArray) {
            deleteAtPos(i);
        }
    }

}

/**
 * Class Node
 */
class Node {
    protected int data;
    protected Node link;

    /**
     * Default Constructor
     */
    public Node() {
        link = null;
        data = 0;
    }

    /**
     * Constructor
     */
    public Node(int d, Node n) {
        data = d;
        link = n;
    }

    /**
     * set link to next Node
     *
     * @param n
     */
    public void setLink(Node n) {
        link = n;
    }

    /**
     * set data to current Node
     *
     * @param d
     */
    public void setData(int d) {
        data = d;
    }

    /**
     * get link to next node
     */
    public Node getLink() {
        return link;
    }

    /**
     * get data from current Node
     */
    public int getData() {
        return data;
    }
}
