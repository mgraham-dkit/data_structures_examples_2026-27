package lab_exam_solution.utils.list_approach1;

import lab_exam_solution.entities.Booking;
import lab_exam_solution.entities.Customer;

import java.util.Arrays;

public class BookingLinkedList {
    private Node first;
    private Node last;
    private int size;

    private static class Node{
        private Booking data;
        private Node next;

        public Node(Booking data){
            this.data = data;
            this.next = null;
        }
    }

    public void add(Booking booking){
        validateForNull(booking);
        Node newNode = new Node(booking);

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

    public Booking get(int index){
        validateIndex(index);

        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    private void validateIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of list");
        }
    }

    private static void validateForNull(Booking booking) {
        if(booking == null){
            throw new IllegalArgumentException("Booking cannot be null");
        }
    }

    public Booking remove(int index){
        validateIndex(index);

        Booking removed;
        if(index == 0){
            removed = first.data;
            first = first.next;

            if(first == null){
                last = null;
            }
        }else{
            Node current = first;
            Node prev = null;

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

    public Booking[] find(String custNum){
        if(custNum == null){
            throw new IllegalArgumentException("Cannot search for a null customer number");
        }

        Booking [] bookings = new Booking[size];
        int countBookings = 0;

        Node current = first;
        for (int i = 0; i < size; i++) {
            Customer currentCustomer = current.data.getCustomer();
            String currentCustNum = currentCustomer.getCustId();

            if(currentCustNum.equalsIgnoreCase(custNum)){
                bookings[countBookings] = current.data;
                countBookings++;
            }
            current = current.next;
        }

        Booking [] resized = Arrays.copyOf(bookings, countBookings);
        return resized;
    }
}
