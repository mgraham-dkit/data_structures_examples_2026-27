package lab_exam_solution.utils.list_approach2;

import lab_exam_solution.entities.Booking;
import lab_exam_solution.entities.Customer;

import java.util.Arrays;

public class DynamicArrayBookingList {
    private static final int EXPANSION_MULTIPLIER = 2;
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Booking[] data = new Booking[INITIAL_CAPACITY];

    private void ensureCapacity(){
        if(size == data.length){
            Booking [] temp = new Booking[data.length*EXPANSION_MULTIPLIER];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
    }

    private void validateIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " is outside bounds of list");
        }
    }

    private void validateNull(Booking booking){
        if(booking == null){
            throw new IllegalArgumentException("Booking cannot be null");
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(Booking value){
        validateNull(value);
        ensureCapacity();

        data[size] = value;
        size++;
    }

    public Booking get(int index){
        validateIndex(index);

        return data[index];
    }

    public Booking remove(int index){
        validateIndex(index);

        Booking removed = data[index];

        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }

        data[size-1] = null;
        size--;

        return removed;
    }


    public Booking[] find(String custNum){
        if(custNum == null){
            throw new IllegalArgumentException("Cannot search for a null customer number");
        }

        Booking [] bookings = new Booking[size];
        int countBookings = 0;

        for (int i = 0; i < size; i++) {
            Customer currentCustomer = data[i].getCustomer();
            String currentCustNum = currentCustomer.getCustId();

            if(currentCustNum.equalsIgnoreCase(custNum)){
                bookings[countBookings] = data[i];
                countBookings++;
            }
        }

        Booking [] resized = Arrays.copyOf(bookings, countBookings);
        return resized;
    }
}
