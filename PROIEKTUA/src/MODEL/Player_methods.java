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
    
    
} 