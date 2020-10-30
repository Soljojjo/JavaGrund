package Laboration2;

import java.util.ArrayList;
import javax.swing.*;
import java.util.Scanner;

public class MainClass {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /* -Skapa en superklass Employee för att öva på inheritance
        -skapa subklasser för varje befattning; Managers Programmers, Secretaries, 
        Technicians, Graphic designer för att öva på Polymorphism
        Ska vi ha olika bonusuträkningar för varje befattning??(Abstract method)
        -metod för att räkna ut bonus för alla olika kategorier av anställda/subklass 
        öva på Polymorphism
        - En meny för Employee Management meny
        -En separat vy för att visa statistisk information för anställda
        // default: System.out.println("Wrong Choice!");
        -En lista med avdelningar 
        -En lista med befattningar
        
        Bonusuppgifter:
        -interface med specifika beteenden; för några anställda: firmabil
        -Felhantering vid minst två tillfällen i projektet
       
         */
        
        employeeSamples();

        boolean isProgramRunning = true;

        welcomeMessage();

        while (isProgramRunning) {

            switch (mainMenu()) { //Switch för val från huvudmenyn

                case 1:
                    switchOne();
                    break;
                case 2:
                    switchTwo();
                    break;
                case 0:
                    isProgramRunning = false;
                    System.out.println("Du har valt att avsluta");
            }
        }
    }

    public static void welcomeMessage() {
        System.out.println("***Välkommen till personalsystemet för FIXON AB "
                + "(MMJ Edition)***\n");
    }

    public static int employeeMenu() {
        boolean isEmployeeMenu = true;
        while (isEmployeeMenu){
        System.out.println("ANSTÄLLNINGSMENY");
        System.out.println("1. Registrera");
        System.out.println("2. Avregistrera");
        System.out.println("3. Uppdatera information");
        System.out.println("4. Sök på namn");
        System.out.println("5. Sök på id");
        System.out.println("6. Sök på avdelning");
        System.out.println("7. Anställningslista");
        System.out.println("8. Huvudmenyn");
        System.out.println("0. Åter till anställningsmeny"); //skriv in så att man återkommer till Employeement menyn
     
        System.out.println("\nVälj från menyn");
        
        isEmployeeMenu= false;
        
        }
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    

    public static int statisticsMenu() {
        System.out.println("STATISTIKMENY");
        System.out.println("1. Företagets Medellön ");
        System.out.println("2. Högsta lön");
        System.out.println("3. Lägsta lön");
        System.out.println("4. Bonus");//Bonussumma totalt/bonussumma per befattning
        System.out.println("5. Procent kvinnor på företaget");
        System.out.println("6. Procent män/befattning");
        System.out.println("0. Huvudmenyn");

        System.out.println("\nVälj från menyn");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static int mainMenu() {
//        String input = JOptionPane.showInputDialog("Välkommen till Personalsystemet"
//                + " (MMJ edition).\nVad vill du göra?\n1:Anställningshantering."
//                + "\n2: Personalstatistik.\n0: Avsluta programmet.");
//
//        int number = Integer.parseInt(input);
//
//        //visa val on GUI
//        JOptionPane.showMessageDialog(null, "" + number);
        System.out.println("HUVUDMENY");
        System.out.println("Vad vill du göra?\n1: Anställningshantering\n"
                + "2: Personalstatistik\n0: Avsluta programmet");
        int number = sc.nextInt();
        sc.nextLine();

        return number;
    }

    public static void switchOne() {
        switch (employeeMenu()) {

            case 1:
                addEmployee();
                break;
            case 2:
                endEmployee();
                break;
            case 3:
                updateEmployee();
                break;
            case 4:
                searchByName();
                break;
            case 5:
                searchById();
                break;
            case 6:
                //MainClass.searchByDep();
                break;
            case 7:
                displayEmployees();
                break;
            case 0:
            //ska vara tom, skickas tillbaka till Main menu. 
        }
    }

    public static void switchTwo() {
        switch (statisticsMenu()) {

            case 1:
                // MainClass.averageSalary();
                break;
            case 2:
                // MainClass.highestSalary();
                break;
            case 3:
                // MainClass.lowestSalary();
                break;
            case 4:
                // MainClass.totalBonus(); //Bonussumma totalt/bonussumma per befattning
                break;
            case 5:
                // MainClass.womenPercentage();
                break;
            case 6:
                // MainClass.menPercentageRoles();
                break;
            case 0:
                //ska vara tom, skickas tillbaka till Main menu

                break;
        }
    }

    //arraylist för employee
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void addEmployee() {

        System.out.println("Förnamn");
        String firstName = sc.nextLine();
        //spara ner förnamnet i klassen

        System.out.println("Efternamn");
        String lastName = sc.nextLine();
        //spara ner efternamnet i klassen

        System.out.println("Kön; Man: 1, Kvinna: 2, Hen: 3 ");
        int gender = sc.nextInt();
        sc.nextLine();
        //spara ner kön i klassen

        System.out.println("Födelsedatum, YYMMDD");
        String birthDate = sc.nextLine();
        //spara ner födelsedatum i klassen

        //TODO lista med avdelningar
        System.out.println("Avdelning");
        String department = sc.nextLine();
        //spara ner Avdelningen i klassen

        System.out.println("Lön");
        int salary = sc.nextInt();
        sc.nextLine();
//        //spara ner lönen i klassen
        Employee e = new Manager(firstName, lastName, gender, birthDate, department, salary);
        employees.add(e);
        System.out.println("Anställd är skapad.");
    }

    public static void updateEmployee() {
        
        int index= -1; //Skapar en variabel för att spara rätt index i arraylist
        System.out.println("Skriv idnummer på anställd du vill ändra uppgifter på: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        //skriv ut Alla uppgifter för den personen som användaren vill ändra
            System.out.println("Anställd du vill ändra: ");
              for (Employee employee : employees) {

            if (employee.getEmployeeId() == id) {
                System.out.println(employee);
                index = employees.indexOf(employee);
            }
        }
            
        switch (1){//Skriver in 1 så länge så att vi kommer in i case 1
            
        
        case 1:
            //Ändra förnamn, uppdatera 1:a positionen
            System.out.println("Vilket förnamn vill du ändra till?: \n");
            String fName = sc.nextLine();
            
            //Hittar till rätt objekt via index sen uppdatera förnamn
            employees.get(index).setFirstName(fName);
            
            //Skriver ut det nya namnet
            System.out.println("Förnamnet är ändrat till: "+ employees.get(index).getFirstName()+"\n");
                 
            break;
            
        case 2:
            //Ändra efternamnet, uppdatera 2:a positionen
            System.out.println("Vilket efternamn vill du ändra till?: \n");
            String lName = sc.nextLine();
            
            //hittar till rätt objekt via index sen uppdatera efternamn
            employees.get(index).setLastName(lName);
            
            //Skriver ut det nya namnet
            System.out.println("Efternamnet är ändrat till " + employees.get(index).getLastName()+ "\n");
            break;
        
        case 3:
            //Ändra kön Man:1, Kvinna:2, Hen:3, uppdatera 3:e positionen
            System.out.println("Vilket kön vill du ändra till?: \n");
            int nGender= sc.nextInt();
            sc.nextLine();
            
            //hittar till rätt objekt, person, via index sen uppdatera kön
            employees.get(index).setGender(nGender);
            
            //Skriver ut nytt värde i kön
            System.out.println("Kön är ändrat till " + employees.get(index).getGender());
            
            break;
            
        case 4:
            //Ändra Födelsedatum, uppdatera 4:e positionen
            System.out.println("Vilket födelsedatum vill du ändra till? YYMMDD: \n");
            String nBirthDate = sc.nextLine();
            
            //hittar till rätt objekt, person, via index sen uppdatera födelsedatum
            employees.get(index).setBirthDate(nBirthDate);
            
            //Skriver ut nytt födelsdatum
            System.out.println("Födelsedatum är ändrat till: " + employees.get(index).getBirthDate());
            
            break;
        
        case 5:
            //Ändra Avdelning, uppdatera 5:e positionen
            break;
            
        case 6:
            //Ändra Lön, uppdatera 6:e positionen
            break;    
            
        }
    }   
//    public static void updateEmployee() {
//
//        System.out.println("Fyll i förnamn för att ändra förnamn: ");
//        String firstName = sc.nextLine();
//        for (Employee employee : employees) {
//
//            if (employee.getFirstName().equals(firstName)) {
//
//                System.out.println("Fyll i nytt namn");
//                String newName = sc.nextLine();
//                employee.setFirstName(newName);
//                System.out.println("Förnamn är uppdaterat: " + newName);
//            }
//        }
//    }

    
    public static void endEmployee() {
        //todo vilken som ska bort
        System.out.println("Vilken anställd ska raderas?");
        //Här skulle jag vilja kalla på searchByName eller searchById
        int index = searchByName();
        employees.remove(index);
        System.out.println("Anställd är borttagen.");
    }

    public static void displayEmployees() {
        System.out.println("Alla anställda på FIXON AB:");
        int i = 1;
        for (Employee employee : employees) {
            System.out.println(i + ". " + employee);
            i++;
            System.out.println("");
        }
    }


    public static int searchByName() {
        int index = 0;
        System.out.println("Fyll i det förnamn du vill söka på: ");
        String firstName = sc.nextLine();
        System.out.println("Fyll i det efternamn du vill söka på: ");
        String lastName = sc.nextLine();
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                System.out.println(employee);
                index = employees.indexOf(employee);
            }
        }
        return index;
    }

    public static void searchById() {
        System.out.println("Fyll i det id du vill söka på: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Employee employee : employees) {

            if (employee.getEmployeeId() == id) {
                System.out.println(employee);
            }
        }
    }
    
    public static void employeeSamples(){
       
        Employee a = new Manager("Greta", "Gretasson", 2, "750220", "Management", 35000);
        Employee b = new Manager("Hans", "Hanssom", 1, "750310", "Management", 32000);
        Employee c = new Manager("Jakob", "Jakobsson", 1, "920406", "Management", 30000);
        Employee d = new Manager("Lisa", "Lisasson", 3, "990506", "Development", 29000);
        Employee e = new Manager("David", "Davidsson", 1, "800630", "Development", 23000);
        Employee f = new Manager("Mia", "Miasson", 2, "790520", "Management", 45000);
        Employee g = new Manager("Mats", "Matsson", 2, "780130", "Development", 28000);
       
        employees.add(a);
        employees.add(b);
        employees.add(c);
        employees.add(d);
        employees.add(e);
        employees.add(f);
        employees.add(g);
       
    }

}//Class klammer1

