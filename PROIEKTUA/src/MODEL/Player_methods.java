package MODEL;

import MODEL.Player;
import java.io.*;

import java.util.ArrayList;


public class Player_methods {
    
    public static void write_player(Player pla) throws IOException
    {
       // definimos con una variable el file
        File playerfile = new File("D:/player.txt");
        
        try
        {
            
            
            // If the file doesn't exist, create a new ObjectOutputStream to write the header
            if(!playerfile.exists())
            {
                FileOutputStream write1 = new FileOutputStream(playerfile);
                ObjectOutputStream writeFile1 = new ObjectOutputStream(write1);
                writeFile1.close();
            }

            // Create another ObjectOutputStream without the header to be able to write objects without overwriting
            FileOutputStream write = new FileOutputStream(playerfile, true);
            ObjectOutputStream writefile = new ObjectOutputStream(write)
            {
                @Override
                protected void writeStreamHeader() throws IOException
                {
                    reset();
                }
            };
            
            // escribe el objeto y cierra los ficheros
            writefile.writeObject(pla);
            write.close();
            writefile.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    public static void show_player() throws IOException 
    {
         // definimos con una variable el file
        File playerfile = new File("D:/player.txt");
        
        try
        {
            FileInputStream read = new FileInputStream(playerfile);
            ObjectInputStream readFile = new ObjectInputStream(read);

            try
            {
                while(true)
                {
                    Player pla = (Player) readFile.readObject();
                    pla.printInfo();
                    System.out.println();
                }
            }
            catch(EOFException eof)
            {
                read.close();
                readFile.close();
            }
        }
        catch(ClassNotFoundException ex1)
        {
            System.out.println("Class not found.");
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    public static void search_player() throws IOException, ClassNotFoundException 
   {
        // Definimos variables
        String buscdni = null, dni;
        boolean result = false;
        File playerfile = new File("D:/player.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try
        {   
            //show_player(); con esto vemos que players tenemos creados
            
            // Preguntamos por el dni al usuario
            System.out.print("Enter the dni of the player: ");
            buscdni = reader.readLine().toLowerCase();
            
            
             
            // Define a new ObjectInputStream
            FileInputStream fs = new FileInputStream(playerfile);
            ObjectInputStream os = new ObjectInputStream(fs);

            try
            {
                while(true)
                {
                    Player pla = (Player) os.readObject();
                    dni = pla.getDni().toLowerCase();
                    
                    // vemos haber si hay algun player con el dni que el usuario a metido
                    if(dni.contains(buscdni))
                    {
                        System.out.println();
                        pla.printInfo();//imprime toda la informacion de eseplayer
                        result = true;//para que salga del while
                    }
                }
            }
            catch(EOFException eof)
            {
                fs.close();
                os.close();
            }
            
            if(result == false)
            {
                System.out.println("The player that you want to search doesnt exist");
            }
        }
       
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    public static void delete_player() throws IOException, ClassNotFoundException
    {
         // Definimos las variables
        String dni, buscdni = null;
        File playerfile = new File("D:/player.txt");
        File playerfile2 = new File("D:/playercopy.txt");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try
        {
            // Define a new ObjectInputStream and a new ObjectOutputStream
            FileInputStream fs = new FileInputStream(playerfile);
            ObjectInputStream os = new ObjectInputStream(fs);
            
            // Create another ObjectOutputStream without the header to be able to write objects without overwriting
            FileOutputStream fos = new FileOutputStream(playerfile2, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        
            try
            {
                // Enseñamos todos los players que hay
                //Preguntar al usuario por el dni
                show_player();
                System.out.print("Enter the dni of the player you want to delete: ");
                buscdni = reader.readLine().toLowerCase();
                
                while(true)
                {
                    Player pla = (Player) os.readObject();
                    dni = pla.getDni().toLowerCase();
                    
                    /* Check if there is a player with the dni the user has entered and show the result
                    Si el dni que esta guardado NO es igual al que el usuario ha metido escribe en el segundo file
                    el objeto entero (esto ira mirando todos los objetos que estan de antes)*/
                    
                    if(!dni.equals(buscdni))
                    {
                        oos.writeObject(pla);
                    }
                }
            }
            catch(EOFException eof)
            {
                fs.close();
                os.close();
                fos.close();
                oos.close();
                playerfile.delete();
                playerfile2.renameTo(playerfile); //renombra el segundo fitxero (el que no tiene ningun objeto repetido) llamandolo como el primero
                System.out.println();
                System.out.print("The player has been delete");
                System.out.println(); //sino el menu queda pegado por eso ponemos una linea en blanco
            }
        }
       
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    
    
    /*  public static void add_Player ( ArrayList <Player> alplayer)
    {
        Player p = new Player();
        alplayer.add(p);
    }
    
    //Show all the players
    public static void show_Player(ArrayList <Player> alplayer)
    {
       for (int i = 0; i < alplayer.size(); i++)
            {
                Player pla= alplayer.get(i);
                pla.printInfo();
            }
    }
    
    //Busca el jugador que quieras y te dice si esta creado o no y te enseña la informacion de ese jugador
    public static void search_Player(ArrayList <Player> alplayer) throws IOException 
    {
        String buscar,buscname;
        boolean ikusi=true;//para que salga del for por si hay mas de un nombre.
        
        
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        try
        {
            System.out.println("Enter the name of the player to check if it exists:");
            buscar=reader.readLine();
            
            for (int i=0; i<alplayer.size();i++)
            {
               buscname=alplayer.get(i).getName();
               
               if (buscar.equals(buscname))
               {
                   
                   Player p = alplayer.get(i);
                   p.printInfo();
                   ikusi=false;
               }  
            }
            if(ikusi==true)
               {
                System.out.println("Doesn´t exist the name that you enter.");
               }
            
        }
        catch(NumberFormatException error1)
            {
                System.out.println("The number you entered is not correct.");
            }
    }
    
    //Borra el jugador que quieras poniendo su dni
    public static void delete_Player(ArrayList <Player> alplayer) throws IOException
    {
        String dniplayer,deletename;
        boolean ikusi2 = true;
        
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        show_Player(alplayer);
        try
        {
            System.out.println("Put the DNI of the player that you want delete.");
            dniplayer=reader.readLine();
            
            for (int i=0; i<alplayer.size();i++)
            {
               deletename=alplayer.get(i).getDni();
               
               if (deletename.equals(dniplayer))
               {
                alplayer.remove(i);
                ikusi2=false;
               }
               
            }
            if (ikusi2==true)
            {
                System.out.println("The dni doesn´t exist.");
            }
            
        }
        
        catch(NumberFormatException error1)
            {
                System.out.println("The number you entered is not correct.");
            }
    }
    
    //Para poder cambiar donde vive ese jugador que tendremos que meter su nombre
    public static void changeTown_Player(ArrayList <Player> alplayer) throws IOException
    {
        String buscar,buscname;
        boolean ikusi=true;//para que salga del for por si hay mas de un nombre.
        
        
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        try
        {
            System.out.println("Enter the name of the player that you want change the town:");
            buscar=reader.readLine();
            
            for (int i=0; i<alplayer.size();i++)
            {
               buscname=alplayer.get(i).getName();
               
               if (buscar.equals(buscname))
               {
                   alplayer.get(i).setTown();
                   ikusi=false;
               }  
            }
            if(ikusi==true)
               {
                System.out.println("Doesn´t exist the name that you enter.");
               }
            
        }
        catch(NumberFormatException error1)
            {
                System.out.println("The number you entered is not correct.");
            }
    }
    
    //Para cambiar el email de ese jugador  de el que hemos metido su nombre
    public static void changeEmail_Player(ArrayList <Player> alplayer) throws IOException
    {
        String buscar,buscname;
        boolean ikusi=true;//para que salga del for por si hay mas de un nombre.
        
        
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        try
        {
            System.out.println("Enter the name of the player that you want change the email:");
            buscar=reader.readLine();
            
            for (int i=0; i<alplayer.size();i++)
            {
               buscname=alplayer.get(i).getName();
               
               if (buscar.equals(buscname))
               {
                   alplayer.get(i).setEmail();
                   ikusi=false;
               }  
            }
            if(ikusi==true)
               {
                System.out.println("Doesn´t exist the name that you enter.");
               }
            
        }
        catch(NumberFormatException error1)
            {
                System.out.println("The number you entered is not correct.");
            }
    }
    
    //Para cambiar en que equipo juega el jugador del que hemos metido el nombre
    public static void changeTeamplay_Player(ArrayList <Player> alplayer) throws IOException
    {
        String buscar,buscname;
        boolean ikusi=true;//para que salga del for por si hay mas de un nombre.
        
        
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        try
        {
            System.out.println("Enter the name of the player that you want change in what teamdoes he/she play:");
            buscar=reader.readLine();
            
            for (int i=0; i<alplayer.size();i++)
            {
               buscname=alplayer.get(i).getName();
               
               if (buscar.equals(buscname))
               {
                   alplayer.get(i).setTeamplay();
                   ikusi=false;
               }  
            }
            if(ikusi==true)
               {
                System.out.println("Doesn´t exist the name that you enter.");
               }
            
        }
        catch(NumberFormatException error1)
            {
                System.out.println("The number you entered is not correct.");
            }
    }
 */
    
    
     public static void addPlayer() throws FileNotFoundException{
       try
       {
           Player p = new Player();
           /*para guardar los valores en los atributos*/
           DataOutputStream save = new DataOutputStream(new FileOutputStream("player.dat",true));
           save.writeUTF(p.getDni());
           save.writeUTF(p.getName());
           save.writeUTF(p.getSurname());
           save.writeInt(p.getBirthday());
           save.writeUTF(p.getTown());
           save.writeUTF(p.getEmail());
           save.writeUTF(p.getTeamplay());
           save.writeUTF(p.getWhereplay());
           save.writeInt(p.getId());
           save.close();
           
       }
       catch (IOException er) 
       {
            System.out.println("ERROR");
        }
    }
    
    public static void erakutsiPlayer(){
        String dni,name,surname,town,email,teamplay,whereplay;
        int birthday,id;
        try
        {
        DataInputStream read = new DataInputStream(new FileInputStream("player.dat"));
            try 
            {
                while (1==1)
                {
                    dni = read.readUTF();
                    name = read.readUTF();
                    surname = read.readUTF();
                    birthday = read.readInt();
                    town = read.readUTF();
                    email = read.readUTF();
                    teamplay = read.readUTF();
                    whereplay = read.readUTF();
                    id = read.readInt();
                    
                    System.out.println("Name: "+name);
                    System.out.println("Surname: "+surname);
                    System.out.println("Birthday: "+birthday);
                    System.out.println("Town:"+town);
                    System.out.println("Email:"+email);
                    System.out.println("Team play:"+teamplay);
                    System.out.println("Where play:"+whereplay);
                    System.out.println("Id:"+id);
                }
            }
        catch (EOFException er1) 
        {
            read.close();
        }
        }
       catch (FileNotFoundException movida) {
            System.out.println("File not found");
        } catch (IOException fff) {
            System.out.println("ERROR, PERO NO SÃ‰ CUÃ�L");
        }
    }
   
}
