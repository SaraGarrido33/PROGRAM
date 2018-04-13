package MODEL;

import java.io.Serializable;
import java.util.Scanner;
public class Person implements Serializable{
    private String dni;
    private String name;
    private String surname;
    private int birthday;
    private String town;
    private String email;
    
    public Person(boolean f)
    {}
    public Person(){
        setDni();
        setName();
        setSurname();
        setBirthday();
        setTown();
        setEmail();
    }

    public void printInfo()
    {
        getDni(dni);
        getName(name);
        getSurname(surname);
        getBirthday(birthday);
        getTown(town);
        getEmail(email);
    }

    public void setDni()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your DNI: ");
        dni=in.nextLine();
    }
    public void setDni(String newDni){
        dni=newDni;
    }
    public void getDni(String dni)
    {
        System.out.println("DNI: "+dni);
    }
    public String getDni()
    {
        return dni;
    }
    
    public void setName()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name: ");
        name=in.nextLine();
    }
    public void setName(String newName){
        name=newName;
    }
    public String getName()
    {
        return name;
    }
    public void getName(String name)
    {
       System.out.println("Name: "+name); 
    }
    
    public void setSurname()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your surname: ");
        surname=in.nextLine();
    }
    public void setSurname(String newSurname){
        surname=newSurname;
    }
    public void getSurname(String newSurname)
    {
       System.out.println("Surname: "+surname);
    }
    public String getSurname()
    {
        return surname;
    }
    
    public void setBirthday()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your birthday: ");
        birthday=in.nextInt();
    }
    public void setBirthday(int newBirthday){
        birthday=newBirthday;
    }
    public void getBirthday(int newBirthday)
    {
     System.out.println("Birthday: "+birthday);
    }
    public int getBirthday()
    {
        return birthday;
    }
    
    public void setTown()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the town where you live: ");
        town=in.nextLine();
    }
    public void setTown(String newTown){
        town=newTown;
    }
    public void getTown(String newTown)
    {
        System.out.println("Town: "+town);
    }
    public String getTown()
    {
        return town;
    }
    
    public void setEmail()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your email: ");
        email=in.nextLine();
        
    }
    public void setEmail(String newEmail){
        email=newEmail;
    } 
    public void getEmail(String newEmail)
    {
        System.out.println("Email: "+email);
    }
    public String getEmail()
    {
        return email;
    }
    
}