interface Payable {
    double getPaymentAmount();
}

abstract class Employee implements Payable{
    private String firstName;
    private String lastName;
    private String SSN;

    public Employee() {
    }

    public Employee(String SSN, String firstName, String lastName) {
        this.SSN = SSN;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
}

class SalariedEmployee extends Employee implements Payable {
    private double PaymentAmount;

    public void setPaymentAmount(double paymentAmount) {
        PaymentAmount = paymentAmount;
    }

    public SalariedEmployee(String SSN, String firstName, String lastName, double PaymentAmount) {
        super(SSN, firstName, lastName);
        this.PaymentAmount = PaymentAmount;
    }

    @Override
    public double getPaymentAmount() {
        return PaymentAmount;
    }
}

class Main {
    public static void main(String[] args) {
        SalariedEmployee sal = new SalariedEmployee("1010","Juan","dela Cruz", 345.0);
        System.out.println("SSN: "+sal.getSSN());
        System.out.println("Firstname: "+sal.getFirstName());
        System.out.println("Lastname: "+sal.getLastName());
        System.out.println("Pay amount: "+sal.getPaymentAmount());
    }
}
