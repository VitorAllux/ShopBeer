package BackupAndRestore;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class runBackup {

	
    public static void realizaBackup() throws IOException, InterruptedException{      
        final List<String> comandos = new ArrayList<String>();      

        comandos.add("V:\\PostgreSQL\\13\\bin\\pg_dump.exe");    // esse é meu caminho  
            
        comandos.add("-h");      
        comandos.add("localhost");     //ou  comandos.add("192.168.0.1"); 
        comandos.add("-p");      
        comandos.add("5432");      
        comandos.add("-U");      
        comandos.add("postgres");      
        comandos.add("-F");      
        comandos.add("c");      
        comandos.add("-b");      
        comandos.add("-v");      
        comandos.add("-f");      
          
        comandos.add("V:\\backup.sql");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
        comandos.add("BeerDB");      
        ProcessBuilder pb = new ProcessBuilder(comandos);      
          
        pb.environment().put("PGPASSWORD", "318463-Vitor");      //Somente coloque sua senha         
          
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
            JOptionPane.showMessageDialog(null,"backup realizado com sucesso.");  
      
        } catch (IOException e) {      
            e.printStackTrace();      
        } catch (InterruptedException ie) {      
            ie.printStackTrace();      
        }         
            
    }     
    
    public static void realizaRestore() throws IOException, InterruptedException{      
        final List<String> comandos = new ArrayList<String>();      
          
        comandos.add("V:\\PostgreSQL\\13\\bin\\pg_restore.exe"); //testado no windows xp
        
        comandos.add("-h");
        comandos.add("localhost");    //ou   comandos.add("192.168.0.1"); 
        comandos.add("-p");      
        comandos.add("5432");      
        comandos.add("-U");      
        comandos.add("postgres");      
        comandos.add("-d");      
        comandos.add("BeerDB");     
        comandos.add("-v");   
        comandos.add("--create");
          
        comandos.add("V:\\backup.sql");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  

        ProcessBuilder pb = new ProcessBuilder(comandos);      
          
        pb.environment().put("PGPASSWORD", "318463-Vitor");     //Somente coloque sua senha         
          
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
            JOptionPane.showMessageDialog(null,"Restore realizado com sucesso.");  
      
        } catch (IOException e) {      
            e.printStackTrace();      
        } catch (InterruptedException ie) {      
            ie.printStackTrace();      
        }         
            
    }
    
    public static void fazRestore() {
        JFileChooser open; 
        final List<String> comandos = new ArrayList<String>(); 
    	open = new JFileChooser(new File("C:/BKPCECOM")); 
        int op = open.showOpenDialog(null);   
        if(op == JFileChooser.APPROVE_OPTION){
           File arq = open.getSelectedFile(); 
           String nomeDoArquivo = open.getName(arq);
           String pathDoArquivo = arq.toString(); 
           System.out.println(nomeDoArquivo + "          " + pathDoArquivo);
       final List<String> comandos1 = new ArrayList<String>();      
       comandos1.add("V:\\PostgreSQL\\13\\bin\\pg_restore.exe");   
       comandos1.add("-h");      
       comandos1.add("localhost");      
       comandos1.add("-p");      
       comandos1.add("5432");      
       comandos1.add("-U");      
       comandos1.add("postgres");
       comandos1.add("-c");
       comandos1.add("-d");
       comandos1.add("BeerDB");     
       comandos1.add("-v");      
         
       //comandos.add("C:\\BOHib3.6.4\\Backups do Banco de Dados\\bkpBolOcor04102012.backup");   // eu utilizei meu C:\ e D:\ para os testes e gravei o backup com sucesso.  
       comandos1.add("V:\\\\backup.sql");
       ProcessBuilder pb = new ProcessBuilder(comandos1);      
       pb.environment().put("PGPASSWORD", "318463-Vitor");        
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
     JOptionPane.showMessageDialog(null,"Restauração realizado com sucesso!");
       } catch (IOException e) {      
           e.printStackTrace();      
       } catch (InterruptedException ie) {      
           ie.printStackTrace();      
       }         
        } else{
            
        }
    }
	
	public static void main(String[] args) throws IOException, InterruptedException {
		//runBackup.realizaBackup();
		runBackup.fazRestore();
	} 
}
