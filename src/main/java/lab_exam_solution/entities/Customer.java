package lab_exam_solution.entities;

public class Customer {
    private final String custId;
    private final String email;
    private final String name;

    public Customer(String custId, String email, String name) {
        if(custId == null || custId.isBlank()){
            throw new IllegalArgumentException("All Customers must contain a customer ID");
        }
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("All Customers must contain a non-blank email");
        }
        this.custId = custId;
        this.email = email;
        this.name = name;
    }

    public String getCustId() {
        return custId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;
        return custId.equals(customer.custId);
    }

    @Override
    public int hashCode() {
        return custId.hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId='" + custId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
