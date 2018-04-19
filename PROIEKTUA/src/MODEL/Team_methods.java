package MODEL;

import java.io.*;
import java.util.ArrayList;

public class Team_methods {
    
    public static void write_team(Team te) throws IOException
    {
       // definimos con una variable el file
        File teamfile = new File("D:/team.txt");
        
        try
        {

            // If the file doesn't exist, create a new ObjectOutputStream to write the header
            if(!teamfile.exists())
            {
                FileOutputStream write1 = new FileOutputStream(teamfile);
                ObjectOutputStream writeFile1 = new ObjectOutputStream(write1);
                writeFile1.close();
            }

            // Create another ObjectOutputStream without the header to be able to write objects without overwriting
            FileOutputStream write = new FileOutputStream(teamfile, true);
            ObjectOutputStream writefile = new ObjectOutputStream(write)
            {
                @Override
                protected void writeStreamHeader() throws IOException
                {
                    reset();
                }
            };
            
            // escribe el objeto y cierra los ficheros
            writefile.writeObject(te);
            write.close();
            writefile.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    public static ArrayList <Team> show_team() throws IOException 
    {
         // definimos con una variable el file y el array
        
        File teamfile = new File("D:/team.txt");
        ArrayList <Team> alTeam = new ArrayList();
        try
        {
            FileInputStream read = new FileInputStream(teamfile);
            ObjectInputStream readFile = new ObjectInputStream(read);

            try
            {
                while(true)
                {
                    Team te = (Team) readFile.readObject();
                    alTeam.add(te);
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
        return alTeam;
    }
    public static void search_team() throws IOException, ClassNotFoundException 
   {
        // Definimos variables
        String buscname = null, name;
        boolean result = false;
        File teamfile = new File("D:/team.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try
        {   
            
            
            // Preguntamos por el dni al usuario
            System.out.print("Enter the name of the team: ");
            buscname = reader.readLine().toLowerCase();
            
            
             
            // Define a new ObjectInputStream
            FileInputStream fs = new FileInputStream(teamfile);
            ObjectInputStream os = new ObjectInputStream(fs);

            try
            {
                while(true)
                {
                    Team te = (Team) os.readObject();
                    name = te.getName().toLowerCase();
                    
                    // vemos haber si hay algun player con el dni que el usuario a metido
                    if(name.contains(buscname))
                    {
                        System.out.println();
                        te.printInfo();//imprime toda la informacion de eseplayer
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
                System.out.println("The team that you want to search doesnt exist");
            }
        }
       
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    public static void delete_team() throws IOException, ClassNotFoundException
    {
         // Definimos las variables
        String name, buscname = null;
        File teamfile = new File("D:/team.txt");
        File teamfile2 = new File("D:/teamcopy.txt");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try
        {
            // Define a new ObjectInputStream and a new ObjectOutputStream
            FileInputStream fs = new FileInputStream(teamfile);
            ObjectInputStream os = new ObjectInputStream(fs);
            
            // Create another ObjectOutputStream without the header to be able to write objects without overwriting
            FileOutputStream fos = new FileOutputStream(teamfile2, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        
            try
            {
                // Enseñamos todos los players que hay
                //Preguntar al usuario por el dni
                show_team();
                System.out.print("Enter the name of the team you want to delete: ");
                buscname = reader.readLine().toLowerCase();
                
                while(true)
                {
                    Team te = (Team) os.readObject();
                    name = te.getName().toLowerCase();
                    
                    /* Check if there is a player with the dni the user has entered and show the result
                    Si el dni que esta guardado NO es igual al que el usuario ha metido escribe en el segundo file
                    el objeto entero (esto ira mirando todos los objetos que estan de antes)*/
                    
                    if(!name.equals(buscname))
                    {
                        oos.writeObject(te);
                    }
                }
            }
            catch(EOFException eof)
            {
                fs.close();
                os.close();
                fos.close();
                oos.close();
                teamfile.delete();
                teamfile2.renameTo(teamfile); //renombra el segundo fitxero (el que no tiene ningun objeto repetido) llamandolo como el primero
                System.out.println();
                System.out.print("The team has been delete");
                System.out.println(); //sino el menu queda pegado por eso ponemos una linea en blanco
            }
        }
       
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    /*
    public static void add_Team ( ArrayList <Team> alteam)
    {
        Team te = new Team();
        alteam.add(te);
    }
    
    //Show all the teams
    public static void show_Team(ArrayList <Team> alteam)
    {
       for (int i = 0; i < alteam.size(); i++)
            {
                Team te= alteam.get(i);
                te.printInfo();
            }
    }
    
    public static void search_Team(ArrayList <Team> alteam) throws IOException 
    {
        String buscar,buscname;
        boolean ikusi=true;//para que salga del for por si hay mas de un nombre.
        
        
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        try
        {
            System.out.println("Enter the name of the team to check if it exists:");
            buscar=reader.readLine();
            
            for (int i=0; i<alteam.size();i++)
            {
               buscname=alteam.get(i).getName();
               
               if (buscar.equals(buscname))
               {
                   
                   Team te = alteam.get(i);
                   te.printInfo();
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
    
    public static void delete_Team(ArrayList <Team> alteam) throws IOException
    {
        String nameteam,deleteteam;
        boolean ikusi2 = true;
        
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        show_Team(alteam);
        try
        {
            System.out.println("Put the name of the team that you want delete.");
            nameteam=reader.readLine();
            
            for (int i=0; i<alteam.size();i++)
            {
               deleteteam=alteam.get(i).getName();
               
               if (deleteteam.equals(nameteam))
               {
                alteam.remove(i);
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
    } */
     public static void addTeam() throws FileNotFoundException{
       try
       {
           Team te = new Team();
           DataOutputStream save = new DataOutputStream(new FileOutputStream("team.dat",true));
           save.writeUTF(te.getName());
           save.writeInt(te.getNumberofplayers());
           save.writeUTF(te.getDni());
           save.close();
           
       }
       catch (IOException er) 
       {
            System.out.println("ERROR");
        }
    }
    
    public static void erakutsiTeam(){
        String name,dni;
        int numberofplayers;
        try
        {
        DataInputStream read = new DataInputStream(new FileInputStream("team.dat"));
            try 
            {
                while (1==1)
                {
                    name = read.readUTF();
                    numberofplayers = read.readInt();
                    dni = read.readUTF();
                    
                    
                    System.out.println("Name: "+name);
                    System.out.println("Number ofplayers: "+numberofplayers);
                    System.out.println("DNI: "+dni);
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
