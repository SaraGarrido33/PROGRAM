package MODEL;

import java.io.Serializable;
import java.util.Scanner;
import java.io.*;

public class Player extends Person implements Serializable{
    private String teamplay; //ze taldeetan jolasten du
    private String whereplay; //ze postutan (portero,pivote..)
    private int id; //Es el id de liga. (estan relacionados)
    

public Player(boolean f)
{super(false);}//para que en Person que es el padre entre al constructor vacio porque si no pones nada te entra al constructor normal

@Override
public void printInfo(){
    super.printInfo();
    getTeamplay(teamplay);
    getWhereplay(whereplay);
    getId(id);
}

public void setTeamplay(){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the name of the team that you play: ");
    teamplay=in.nextLine();
}
public void setTeamplay(String newTeamplay){
    teamplay=newTeamplay;
}
public void getTeamplay(String newTeamplay){
    System.out.println("The team that he/she play: "+teamplay);
}
public String getTeamplay()
{
    return teamplay;
}

public void setWhereplay(){
    Scanner in = new Scanner(System.in);
    System.out.println("In what position do you play?: ");
    whereplay=in.nextLine();
}
public void setWhereplay(String newWhereplay){
    whereplay=newWhereplay;
}
public void getWhereplay(String newWhereplay){
    System.out.println("This is the position of the player: "+whereplay);
}
public String getWhereplay()
{
    return whereplay;
}

public void setId(){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the id of the league: ");
    id=in.nextInt();
}
public void setId(int newId){
    id=newId;
}
public void getId(int newId){
    System.out.println("This is the id of the league: "+id);
}
public int getId(){
    return id;
}
}
