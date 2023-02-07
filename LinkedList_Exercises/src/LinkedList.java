public class LinkedList <E> {
    public static class Node<E>{
        private E data;
        private Node<E>next;
        public Node(E data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node<String> n1 = new Node<>("Bread");
        Node<String> n2 = new Node<>("Milk");
        Node<String> n3 = new Node<>("Eggs");
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        System.out.println(n1.data);
        System.out.println(n1.next);
        System.out.println(n2.data);
        System.out.println(n2.next);
        System.out.println(n3.data);
        System.out.println(n3.next);
    }
}
