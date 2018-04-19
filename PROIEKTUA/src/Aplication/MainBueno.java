/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplication;

import CONTROLLER.Controller;
import MODEL.Person;
import MODEL.Player;
import MODEL.Player_methods;
import MODEL.Team;
import MODEL.Team_methods;
import VIEW.CreatePlayer;
import VIEW.CreateTeam;
import VIEW.Main;
import VIEW.ShowTeams;

/**
 *
 * @author DM3-1-16
 */
public class MainBueno {
    //por cada class hay que hacer
    
    Team teamclass;
    Team_methods teammethods;
    CreateTeam createteam;
    Main mainview;
    Controller control;
    Person personclass;
    Player playerclass;
    Player_methods playermethods;
    CreatePlayer createplayer;
    ShowTeams showteams;
    
    public static void main(String[]args)
    {
        MainBueno mainbueno= new MainBueno();
        mainbueno.hasi();
    }
    
    private void hasi(){
        //por cada clase hay que añadir
        teamclass = new Team();
        teammethods = new Team_methods();
        createteam = new CreateTeam();
        mainview = new Main();
        playerclass = new Player(false);
        playermethods = new Player_methods();
        createplayer = new CreatePlayer();
        showteams = new ShowTeams();
        
        //hay que añadir al controller siempre todas las cosas nuevas
        control = new Controller(teamclass,teammethods,mainview,createteam,personclass,playerclass,playermethods,createplayer,showteams);
        
        mainview.setVisible(true);
        
    }
}
