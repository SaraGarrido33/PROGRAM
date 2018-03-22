package MODEL;

import java.util.Scanner;
import java.io.*;
public class Team implements Serializable{
    private String name;
    private int numberofplayers;
    private String dni; //Seria el dnii del entrenador(relacion)
    
public Team(){
    
}

public void printInfo(){
    getName(name);
    getNumberofplayers(numberofplayers);
    getDni(dni);
}

public void setName(){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the name of the team: ");
    name=in.nextLine();
}
public void setName(String newName){
    name=newName;
}
public void getName(String newName){
    System.out.println("Name of the team: "+name);
}
public String getName()
    {
        return name;
    }

public void setNumberofplayers(){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the number of players: ");
    numberofplayers=in.nextInt();
}
public void setNumberofplayers(int newNumberofplayers){
    numberofplayers=newNumberofplayers;
}
public void getNumberofplayers(int newNumberofplayers){
    System.out.println("Number of players: "+numberofplayers);
}
public int getNumberofplayers(){
    return numberofplayers;
}

public void setDni(){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the dni of the coach: ");
    dni=in.nextLine();
}
public void setDni(String newDni){
    dni=newDni;
}
public void getDni(String newDni){
    System.out.println("This is the dni of the coach: "+dni);
}
public String getDni(){
    return dni;
}
}
