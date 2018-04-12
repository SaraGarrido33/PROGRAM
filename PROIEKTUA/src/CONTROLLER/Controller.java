/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Team;
import MODEL.Team_methods;
import VIEW.CreateTeam;
import VIEW.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DM3-1-16
 */
public class Controller implements ActionListener{
    //añadir como atributo cada model y cada view
    Team t; //clase sinmas
    private Team_methods t_m = new Team_methods(); //clase que tiene los metodos
    private Main menu; //view del menu
    private CreateTeam c_t; //view del crear team
    
    //Constructor
    public Controller(Team a, Team_methods b, Main c,CreateTeam d){
        t=a;
        t_m=b;
        menu=c;
        c_t=d;
        
        //Activar los listener
        c_t.create.addActionListener(this);
        menu.BotonTeam.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==c_t.create) //Si le he dado en el boton create;
        {
            //creamos el objeto vacio y lo rellenamos cogiendo la informacion de los textbox y metiendola al objeto
            Team te = new Team();
            te.setName(c_t.NameTeam.getText()); 
            te.setNumberofplayers(Integer.parseInt(c_t.NumOfPlayers.getText()));
            te.setDni(c_t.DniCoach.getText());
            try
            {
            t_m.write_team(te);
            System.out.println("Gordeta");
            }
            catch(Exception a)
            {
            
            }
        
        
        
        //ponemos los textbox en blanco
        c_t.NameTeam.setText(null);
        c_t.NumOfPlayers.setText(null);
        c_t.DniCoach.setText(null);
        
        }
        else if (e.getSource()==menu.BotonTeam)//cuando le dan al boton team
        {
            c_t.setVisible(true); //para que se abrala ventana de crear el team
        }
        
        
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
