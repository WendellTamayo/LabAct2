import java.sql.SQLOutput;
import java.util.Scanner;

interface EmployeeInterface{
    int size=20;
    public boolean add(Employee e); // add either an hourly employee or commission employee
    public int search(String name); //return the index if the name is existing in the array, if not existing return -1
    public void display(); //display the information of the employee with its earnings.
    public boolean isFull(); //return 1 if array is full, 0 if not
    public boolean isEmpty(); // return 1 if array is empty, 0 if not
    public void displayCountEmployee(); //display the number of employee in hourly and commission
    public Employee delete(String name);// deletes the employee whose name is equal to parameter name
}

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address;
    }
}

class Employee extends Person {
    private int age;
    private String companyName;

    Employee(String name, String address, int age, String companyName) {
        super(name, address);
        this.age = age;
        this.companyName = companyName;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: " + age + "\nCompany Name: " + companyName;
    }
}

class CommissionEmployee extends Employee {
    private double regularSalary;
    private double commissionRate;
    private int itemSold;

    CommissionEmployee(String name, String address, int age, String companyName, double regularSalary, int itemSold, double commissionRate) {
        super(name, address, age, companyName);
        this.regularSalary = regularSalary;
        this.commissionRate = commissionRate;
        this.itemSold = itemSold;
    }

    public double getRegularSalary() {
        return regularSalary;
    }

    public void setRegularSalary(double regularSalary) {
        this.regularSalary = regularSalary;
    }

    public int getItemSold() {
        return itemSold;
    }

    public void setItemSold(int itemSold) {
        this.itemSold = itemSold;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double earnings() {
        return regularSalary * commissionRate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nGross Sales: " + regularSalary + "\nCommission Rate: " + commissionRate;
    }
}

class HourlyEmployee extends Employee {
    private double rate;
    private int hoursWorked;

    HourlyEmployee(String name, String address, int age, String companyName, int hoursWorked, double rate) {
        super(name, address, age, companyName);
        this.rate = rate;
        this.hoursWorked = hoursWorked;
    }

    public HourlyEmployee(String name, String address, int age, String companyName) {
        super(name, address, age, companyName);
    }

    public double getRate() {
        return rate;
    }

    public void setHourlyRate(double rate) {
        this.rate = rate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double earnings() {
        return rate * hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHours Worked: " + hoursWorked + "\nRate: " + rate;
    }
}

class EmployeeImp implements EmployeeInterface {
    private Employee[] employee;
    private int size;
    private int countHourlyEmployee = 0;
    private int countCommissionEmployee = 0;
    public EmployeeImp(int size) {
        employee = new Employee[size];
        setSize(size);
    }
    public EmployeeImp() {
        employee = new Employee[size];
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean add(Employee e) {
        if (isFull()) {
            return false;
        } else {
            employee[countHourlyEmployee + countCommissionEmployee] = e;
            if (e instanceof HourlyEmployee) {
                countHourlyEmployee++;
            } else if (e instanceof CommissionEmployee) {
                countCommissionEmployee++;
            }
            return true;
        }
    }

    @Override
    public int search(String name) {
        for (int i = 0; i < countHourlyEmployee + countCommissionEmployee; i++) {
            if (employee[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        for (int i = 0; i < countHourlyEmployee + countCommissionEmployee; i++) {
            System.out.println(employee[i].toString());
            if (employee[i] instanceof HourlyEmployee) {
                System.out.println("Earnings: " + ((HourlyEmployee) employee[i]).earnings());
                System.out.println();
            } else if (employee[i] instanceof CommissionEmployee) {
                System.out.println("Earnings: " + ((CommissionEmployee) employee[i]).earnings());
                System.out.println();
            }
        }
    }

    @Override
    public boolean isFull() {
        return countHourlyEmployee + countCommissionEmployee == size;
    }

    @Override
    public boolean isEmpty() {
        return countHourlyEmployee + countCommissionEmployee == 0;
    }

    @Override
    public void displayCountEmployee() {
        System.out.println("Number of Hourly Employee: " + countHourlyEmployee);
        System.out.println("Number of Commission Employee: " + countCommissionEmployee);
    }

    @Override
    public Employee delete(String name) {
        if (countHourlyEmployee + countCommissionEmployee == 0) {
            return null;
        }
        int index = search(name);
        if (index == -1 && !isEmpty()) {
            System.out.println("No such record." + name);
            System.out.println();
            return null;
        } else {
            Employee temp = employee[index];
            for (int i = index; i < countHourlyEmployee + countCommissionEmployee - 1; i++) {
                employee[i] = employee[i + 1];
            }
            System.out.println("Deleted Employee ");
            System.out.println("Name: " + temp.getName());
            System.out.println("Address: " + temp.getAddress());
            System.out.println("Age: " + temp.getAge());
            System.out.println("Company Name: " + temp.getCompanyName());
            employee[countHourlyEmployee + countCommissionEmployee - 1] = null;
            if (temp instanceof HourlyEmployee) {
                countHourlyEmployee--;
                System.out.println("Hours worked: " + ((HourlyEmployee) temp).getHoursWorked());
                System.out.println("Rate: " + ((HourlyEmployee) temp).getRate());

            } else if (temp instanceof CommissionEmployee) {
                countCommissionEmployee--;
                System.out.println("Regular Salary: " + ((CommissionEmployee) temp).getRegularSalary());
                System.out.println("Item sold: " + ((CommissionEmployee) temp).getItemSold());
                System.out.println("Commission Rate: " + ((CommissionEmployee) temp).getCommissionRate());
            }
            return temp;
        }
    }
}

class Main {
    public static void main(String[] args) {
        EmployeeImp  e = new EmployeeImp (5);
        HourlyEmployee h1 = new HourlyEmployee("Yule Josef Ato","Cebu City",23,"Accenture",40, 550.98);
        HourlyEmployee h2 = new HourlyEmployee("Linc Josef Ato","Talisay City",28,"Alliance",41, 600.00);
        CommissionEmployee c1 = new CommissionEmployee ("Matt Torcende","Butuan City",27,"Systemscore",40000.0f, 550, 0.10f);
        CommissionEmployee c2 = new CommissionEmployee ("Ysabelle Fuentes","Cagayan de Oro City",29,"EagleBytes",48000.0f, 650, 0.20f);
        HourlyEmployee h3= new HourlyEmployee("Aya Sanchez","Surigao City",50,"CIT");
        e.add(h1);
        e.add(h2);
        e.add(c1);
        e.add(c2);
        e.add(h3);
        e.display();
        e.displayCountEmployee();
        System.out.println(Accumul.accum("ZpglnRxqenU"));
        System.out.println(MAIN.soda());
    }
}

class Accumul {

    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    result.append(Character.toUpperCase(s.charAt(i)));
                } else {
                    result.append(Character.toLowerCase(s.charAt(i)));
                }
            }
            if (i != s.length() - 1) {
                result.append("-");
            }
        }
        return result.toString();
    }
}

//import java.util.Scanner;
public class StringUtils {

    public static String toAlternativeString(String string) {
        String new_str = "";
        for(int i = 0; i < string.length(); i++){
            if(Character.isUpperCase(string.charAt(i))){
                new_str += Character.toLowerCase(string.charAt(i));
            }else{
                new_str += Character.toUpperCase(string.charAt(i));
            }
        }
        // your code here!
    }
}

