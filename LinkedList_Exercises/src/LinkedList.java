

public class LinkedList <E> {
    private int size;
    private Node<E> head;
//    private Node<E>tail;
    public LinkedList(){
        size =0;
        head = null;
    }
    public int size(){
        return size;
    }
    public boolean add(E item){
        this.add(size,item);
        return true;
    }
    public void add(int index,E item){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Index bound");
        }
        Node <E> adding = new Node<>(item);
        if(index==0){
            adding.next=head;
            head=adding;
        }else {
            Node <E> before = getNode(index-1);
            adding.next=before.next;
            before.next=adding;
        }
        size++;
    }
    public E remove(int index){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Index bound");
        }
        E toReturn =null;
        if(index==0){
            toReturn = head.data;
            head =head.next;
        }else {
            Node <E> before = getNode(index-1);
            toReturn = before.next.data;
            before.next = before.next.next;
        }
        size--;
        return toReturn;
    }
    private Node<E> getNode(int index){
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    public String toString(){
        String out="";
        Node<E> current = head;
        while (current!=null){
            out+=current.data;
            out+="-->";
            current = current.next;
        }
        return out;
    }
    public E get(int index){
        if(index<0|| index>=size){
            throw new IndexOutOfBoundsException(":(");
        }
        return getNode(index).data;
    }
    public E set(int index,E item){
        if(index<0|| index>=size){
            throw new IndexOutOfBoundsException(":(");
        }
        Node <E> target = getNode(index);
        E oldData = target.data;
        target.data =item;
        return oldData;
    }

    public static class Node<E>{
        private E data;
        private Node<E>next;
        public Node(E data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(3,4);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
    }
}
