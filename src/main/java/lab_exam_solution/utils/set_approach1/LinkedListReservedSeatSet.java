package lab_exam_solution.utils.set_approach1;

public class LinkedListReservedSeatSet {
    private Node first;
    private Node last;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private void validateForNull(String seatNum) {
        if (seatNum == null) {
            throw new IllegalArgumentException("Seat number cannot be null");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of data set");
        }
    }

    public boolean add(String seatNum) {
        validateForNull(seatNum);

        if (contains(seatNum)) {
            return false;
        }

        Node newNode = new Node(seatNum);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    private int indexOf(String seatNum) {
        validateForNull(seatNum);

        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.data.equalsIgnoreCase(seatNum)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public boolean remove(String target) {
        int index = indexOf(target);
        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }

    private String remove(int index) {
        validateIndex(index);

        String removed;
        if (index == 0) {
            removed = first.data;
            first = first.next;

            if (first == null) {
                last = null;
            }
        } else {
            Node current = first;
            Node prev = null;

            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }

            removed = current.data;
            prev.next = current.next;
            if (current == last) {
                last = prev;
            }
        }

        size--;
        return removed;
    }

    public boolean contains(String seatNum) {
        validateForNull(seatNum);

        return indexOf(seatNum) != -1;
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

}
