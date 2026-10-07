package b_lists.utils;

public class LinkedList {
    private Node first;
    private int size;


    private static class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    public void add(String element){
        Node newNode = new Node(element);

        if(size == 0){
            first = newNode;
        }else {
            Node current = first;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
        size++;
    }

}
