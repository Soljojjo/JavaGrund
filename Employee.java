//Superklass för att öva på Inheritance
package Laboration2;

public class Employee {

    private String firstName;
    private String lastName;
    private int employeeId;
    private String department;
    private int salary;
    private int employmentYear;
    private int gender;
    private String birthDate;
    static int idGenerator = 1;

    public Employee(String firstName, String lastName, int gender, String birthDate, String department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = idGenerator;
        idGenerator++;
        this.department = department;
        this.salary = salary;
        //this.employmentYear = employmentYear;
        this.gender = gender;
        this.birthDate = birthDate;

    }
    
    public Employee(String firstName){ //Testkonstruktor
        this.firstName = firstName;
    }

 

    public String getFirstName() {
        return firstName;
    }

 

    public int getEmployeeId() {
        return employeeId;
    }

 

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

 

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmploymentYear() {
        return employmentYear;
    }

    public void setEmploymentYear(int employmentYear) {
        this.employmentYear = employmentYear;
    }

    public int getGender() {
        return gender;
    }
    
    public void setGender(int gender) {
        this.gender = gender;
    }
    
////den blir inte implementerad här utan i subklassen
//    public abstract void bonus();
    
    @Override
    public String toString(){
        return "Anställd: \n"+ "Förnamn: " + firstName + " Anställnings ID: " + employeeId;
    }
}