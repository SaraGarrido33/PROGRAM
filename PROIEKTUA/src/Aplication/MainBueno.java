/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplication;

import CONTROLLER.Controller;
import MODEL.Team;
import MODEL.Team_methods;
import VIEW.CreateTeam;
import VIEW.Main;

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
    
    public static void main(String[]args)
    {
        MainBueno mainbueno= new MainBueno();
        mainbueno.hasi();
    }
    
    private void hasi(){
        teamclass = new Team();
        teammethods = new Team_methods();
        createteam = new CreateTeam();
        mainview = new Main();
        control = new Controller(teamclass,teammethods,mainview,createteam);
        mainview.setVisible(true);
    }
}
