import java.util.Collections;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }


    public void deleteList() {
        head = null;
        tail = null;
        size = 0;
    }

    // This is an instance method, so you can access the head, tail, and the Node class
    public int count(E item) {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.item.equals(item)) {
                count++;
            }

            current = current.next;
        }
        return count;
    }


    //  3 5
    //  4 7
    //  1 2
//    public static DoublyLinkedList<Integer> merge(DoublyLinkedList<Integer> listA, DoublyLinkedList<Integer> listB){
//        DoublyLinkedList<Integer> out =  new DoublyLinkedList<>();
//        while(listA.size() >0  && listB.size() > 0) {
//            if(listA.get(0)  < listB.get(0)) {
//                out.add(listA.get(0));
//                listA.remove(0);
//            } else {
//                out.add(listB.get(0));
//                listB.remove(0);
//            }
//        }
//        while(listA.size() != 0) {
//            out.add(listA.remove(0));
//        }
//        while(listB.size() != 0) {
//            out.add(listB.remove(0));
//        }
// return out;
//}

    public static DoublyLinkedList<Integer> marge(DoublyLinkedList<Integer> listA, DoublyLinkedList<Integer> listB){
        DoublyLinkedList <Integer> all = new DoublyLinkedList<>();
        while (listA.size()>0 && listB.size()>0){
            if(listA.get(0)<= listB.get(0)){
                all.add(listA.remove(0));

            }else{
                all.add(listB.remove(0));
            }
        }
        while (listA.size()!=0){
            all.add(listA.remove(0));
        }
        while (listB.size()!=0){
            all.add(listB.remove(0));
        }

        return all;
    }




    // 5 4 3 2 1
    //
    public void reverse(){
        DoublyLinkedList<E> temp = new DoublyLinkedList<>();
        while(this.size != 0){
            E item = this.remove(0);
            temp.add(0,item);
        }
        this.head = temp.head;
        this.tail = temp.tail;
        this.size = temp.size;
    }
//    public void reverse() {
//        Node temp = null;
//        Node current = this.head;
//        while (current != null) {
//            // swap the previous and next pointers of the current node
//            temp = current.prev;
//            current.prev = current.next;
//            current.next = temp;
//
//            // move to the next node
//            current = current.prev;
//        }
//        // swap the head and tail pointers of the LinkedList
//        temp = this.head;
//        this.head = this.tail;
//        this.tail = temp;
//    }

//    public void removeDuplicates(){
//        Node<E> current = head;
//        while (current!=null){
//            if  (current.item==current.next){
//                current.next = current.next.next;
//            }
//            current= current.next;
//        }
//    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.item == current.next.item) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
/*
    It is more difficult to insert an element at the beginning of an array list because all the existing elements need to be shifted by one position to the right to make space for the new element.


    It is more difficult to remove the last element of an array list because it requires shifting all the elements to the left after the last element is removed.

    It is more difficult to find the middle element of an array list because arrays do not have a built-in method to calculate the middle index, and the size of the array needs to be known in advance to perform the calculation. Additionally, arrays have fixed sizes, which means that if the array size changes, the middle index will also change.

1. because all the existing elements need to be shifted one index;
2. because it requires shifting all the elements to the left after the last element is removed;
3.
4. reversing the arraylist is easier than the linkedlist. because array list are keeps the order;
5. it is not impossible;
6. it would be easier. we can use the addAll() method and add two list at once and sort is.
7. it is easier to add on the arraylist because it keeps the order.
8.
9. it would not be easier;
10. in array list we can use the index to remove the array list easily






a reference-based list, such as a LinkedList, uses individual nodes that are linked together
using pointers or references.
adding or removing an item from a linked list requires updating a few pointers, O(1);
accessing an item at a specific index in a linked list requires traversing the list
from the beginning or end until the desired element is reached, which takes O(n) time in the worst case.

*/
// While this is a static method, it’s inside of SortedLinkedList
// So you have access to head, tail (optional), and the Node class
// Example inputs/output:
// [1,2,2,3,4,5] and [2,2,2,4] --> [2,4]
// [1,3,5,6] and [1,2,3,5] --> [1,3,5]
public static DoublyLinkedList<Integer> sortedIntersect(DoublyLinkedList A, DoublyLinkedList B){
    DoublyLinkedList <Integer> output= new DoublyLinkedList<>();
    while (A.size()>0&& B.size()>0){
        if(A.get(0)==B.get(0)){
            output.add((Integer) A.remove(0));
        } else if ((Integer)A.get(0)>(Integer)B.get(0)) {
            A.remove(0);
        } else if ((Integer)B.get(0)>(Integer)A.get(0)) {
            B.remove(0);
        }
        output.removeDuplicates();
        return output;
    }


    return output;
}



    public E get(int index){
        return this.getNode(index).item;
    }


    public boolean add (E item){
        add(size,item);
        return true;
    }


    public void add(int index, E item) {
        //Scenario: Out of bounds
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Aren't we tired of errors?");
        }

        Node<E> temp =  new Node<E>(item);
        //Scenario: Adding the very first item
        if(size == 0) {
            this.head = temp;
            this.tail = temp;
        }
        //Scenario: Adding a new head
        else if(index == 0){
            temp.next = head;
            head.prev = temp;
            head = temp;

        }
        //Scenario: Adding a new tail
        else if(index == size) {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        //Scenario: Any other case
        else{
            Node<E> before =  this.getNode(index - 1);
            temp.next = before.next;
            temp.prev = before;
            before.next = temp;
            temp.next.prev  = temp;
        }



        size++;
    }


    public E remove(int index) {
        E removed = null;
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Foobar");
        }

        if (size == 1) {
            removed = head.item;
            head = null;
            tail = null;
        } else if( index == 0) {
            removed = head.item;
            head = head.next;
            head.prev = null;
        } else if(index == size -1) {
            removed = tail.item;
            tail = tail.prev;
            tail.next = null;

        } else {
            Node<E> before = getNode(index -1);
            removed = before.next.item;
            before.next = before.next.next;
            before.next.prev = before;
        }

        size--;
        return removed;
    }



    private Node<E> getNode(int index){  //O(n)
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public String toString() {
        String output="[ ";
        Node<E> current = head;
        while(current != null) {
            output  += current.item.toString() + " --> ";
            current = current.next;
        }


        return output+"]";
    }

    public static void main(String[] args) {
//        DoublyLinkedList<String> l =  new DoublyLinkedList<>();
//        l.add("a");
//        l.add("b");
//        l.add("c");
//        l.add("d");
//        System.out.println(l.remove(3));
//        System.out.println(l.count("b"));
        DoublyLinkedList<Integer> num =  new DoublyLinkedList<>();
        DoublyLinkedList<Integer> num2 =  new DoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            num.add(i);
            num2.add(i);
        }
        System.out.println(marge(num,num2));
        for (int i = 0; i < 10; i++) {
            num.add(i);
            num2.add(i);
        }
//        num.reverse();
        num.add(9);
        num.add(10);
        num.add(10);
        num.add(11);
        num.removeDuplicates();
        System.out.println(num);

    }

    private static class Node<E>{
        private E item;
        private Node<E> next;
        private Node<E> prev;

        public Node(E item){
            this.item =  item;
        }
    }
}