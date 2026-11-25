package lab_exam_solution.utils.set_approach2;

public class ComposedReservedSeatSet {
    private LinkedList<String> set = new LinkedList<>();

    private static void validateForNull(String seatNum) {
        if(seatNum == null){
            throw new IllegalArgumentException("Cannot add a null element to set of reserved seats");
        }
    }

    public boolean add(String seatNum){
        validateForNull(seatNum);

        if(set.indexOf(seatNum) != -1){
            return false;
        }

        set.add(seatNum);
        return true;
    }

    public boolean contains(String seatNum){
        validateForNull(seatNum);

        return set.indexOf(seatNum) != -1;
    }

    public boolean remove(String seatNum){
        validateForNull(seatNum);

        return set.remove(seatNum);
    }

    public int size(){
        return set.size();
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }
}
