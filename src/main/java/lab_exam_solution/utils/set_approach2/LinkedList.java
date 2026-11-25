package lab_exam_solution.utils.set_approach2;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void add(T element){
        Node<T> newNode = new Node<>(element);

        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public T get(int index){
        validateIndex(index);

        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    private void validateIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of array");
        }
    }


    public int indexOf(T target){
        validateForNull(target);

        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if(current.data.equals(target)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public boolean remove(T target){
        int index = indexOf(target);
        if(index == -1){
            return false;
        }

        remove(index);
        return true;
    }

    private void validateForNull(T target) {
        if(target == null){
            throw new IllegalArgumentException("Cannot search for null");
        }
    }

    public T remove(int index){
        validateIndex(index);

        T removed;
        if(index == 0){
            removed = first.data;
            first = first.next;

            if(first == null){
                last = null;
            }
        }else{
            Node<T> current = first;
            Node<T> prev = null;

            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }

            removed = current.data;
            prev.next = current.next;
            if(current == last){
                last = prev;
            }
        }

        size--;
        return removed;
    }
}
