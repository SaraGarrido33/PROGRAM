/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Person;
import MODEL.Player;
import MODEL.Player_methods;
import MODEL.Team;
import MODEL.Team_methods;
import VIEW.CreatePlayer;
import VIEW.CreateTeam;
import VIEW.Main;
import VIEW.ShowTeams;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
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
    
    
    Person pe;
    Player p;
    private Player_methods p_m = new Player_methods();
    private CreatePlayer c_p;
    
    private ShowTeams s_t;//view del show team
    
    //Constructor
    public Controller(Team a, Team_methods b, Main c,CreateTeam d,Person e, Player f,Player_methods g, CreatePlayer h, ShowTeams i){
        t=a;
        t_m=b;
        menu=c;
        c_t=d;
        pe=e;
        p=f;
        p_m=g;
        c_p=h;
        s_t=i;
        
        //Activar los listener
        c_t.create.addActionListener(this);
        menu.BotonTeam.addActionListener(this);
        c_p.createplayer2.addActionListener(this);
        menu.BotonPlayer.addActionListener(this);
        menu.showteamboton.addActionListener(this);
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
        
        if(e.getSource()==c_p.createplayer2) {
            Player pla= new Player(false);
            pla.setDni(c_p.dni.getText());
            pla.setName(c_p.NamePlayer.getText());
            pla.setSurname(c_p.SurnamePlayer.getText());
            pla.setBirthday(Integer.parseInt(c_p.BirthdayPlayer.getText()));
            pla.setTown(c_p.TownPlayer.getText());
            pla.setEmail(c_p.EmailPlayer.getText());
            pla.setTeamplay(c_p.NameTeamPlayer.getText());
            pla.setWhereplay(c_p.PositionPlayer.getText());
            pla.setId(Integer.parseInt(c_p.IdLeaguePlayer.getText()));
            
            try
            {
                p_m.write_player(pla);
                System.out.println("Player gordeta.");
            }
            catch (Exception a)
            {
                
            }
            c_p.dni.setText(null);
            c_p.NamePlayer.setText(null);
            c_p.SurnamePlayer.setText(null);
            c_p.BirthdayPlayer.setText(null);
            c_p.TownPlayer.setText(null);
            c_p.EmailPlayer.setText(null);
            c_p.NameTeamPlayer.setText(null);
            c_p.PositionPlayer.setText(null);
            c_p.IdLeaguePlayer.setText(null);           
            
        }
        else if (e.getSource()==menu.BotonPlayer)
        {
            c_p.setVisible(true);
        }
        
        else if (e.getSource()==menu.showteamboton) //cuando haga click en el boton de show teams lo que va a pasar
        {
           s_t.setVisible(true);  //se va a abrir el view deshow teams
           
           ArrayList <Team> alTeam = new ArrayList(); // creamos el arraylist
           int i;
           
           try
           {
               alTeam = t_m.show_team(); //ejecutamosla funcion de show que tenemos en team methods 
           }
           catch (IOException ex)
           {
               
           }
           
           DefaultTableModel teamTb = (DefaultTableModel) s_t.tablateams.getModel(); //hay que poner sio si y lo de verde es el nombre de la tabla
           
           for(i=0; i<alTeam.size(); i++) //recorre toda la tabla
           {
               Team te = alTeam.get(i);//va contando
               Vector os = null; //hay queponer si o si 
               teamTb.addRow(os); //añade una linea
               //Vas poniendo en la tabla los atributos 
               teamTb.setValueAt(te.getName(), i, 0);
               teamTb.setValueAt(te.getNumberofplayers(), i, 1);
               teamTb.setValueAt(te.getDni(), i, 2);
               
           }
        }
    
}
}
