package BackupAndRestore;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PostgresRestore {
    JFileChooser open; 
    final List<String> comandos = new ArrayList<String>();
    
    public PostgresRestore(String dirBackup, String pgRestore, String nomeBanco, String senhaBanco, String user, String ip,String porta)
    {

           final List<String> comandos = new ArrayList<String>();      
           comandos.add(pgRestore);

           comandos.add("-h");      
           comandos.add(ip);      
           comandos.add("-p");      
           comandos.add(porta);      
           comandos.add("-U");      
           comandos.add(user);
           comandos.add("-c");
           comandos.add("-d");
           comandos.add(nomeBanco);     
           comandos.add("-v");      
             
        
           comandos.add(dirBackup);
           ProcessBuilder pb = new ProcessBuilder(comandos);      
           pb.environment().put("PGPASSWORD", senhaBanco);        
           try {      
               final Process process = pb.start();      
               final BufferedReader r = new BufferedReader(      
                   new InputStreamReader(process.getErrorStream()));      
               String line = r.readLine();      
               while (line != null) {      
               System.err.println(line);      
               line = r.readLine();    
               
               }      
               r.close();      
               
               process.waitFor();    
               process.destroy();                
   				JOptionPane.showMessageDialog(null, "Restore realizado com sucesso!!", "Sucesso!",
					JOptionPane.INFORMATION_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/verificado.png")));
           } catch (IOException e) {      
               e.printStackTrace();      
           } catch (InterruptedException ie) {      
               ie.printStackTrace();      
           }         
    }
}
