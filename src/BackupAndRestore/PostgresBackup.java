package BackupAndRestore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PostgresBackup {

	public PostgresBackup(String localSave,String localDump, String nomeBanco, String senhaBanco, String user) {
		final List<String> comandos = new ArrayList<String>();
		comandos.add(localDump);

		comandos.add("-h");
		comandos.add("localhost");
		comandos.add("-p");
		comandos.add("5432");
		comandos.add("-U");
		comandos.add(user);
		comandos.add("-F");
		comandos.add("c");
		comandos.add("-b");
		comandos.add("-v");
		comandos.add("-f");


		comandos.add(localSave); 
		comandos.add(nomeBanco);
		ProcessBuilder pb = new ProcessBuilder(comandos);

		pb.environment().put("PGPASSWORD", senhaBanco);

		try {
			final Process process = pb.start();

			final BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line = r.readLine();
			while (line != null) {
				System.err.println(line);
				line = r.readLine();
			}
			r.close();

			process.waitFor();
			process.destroy();
			JOptionPane.showMessageDialog(null, "Backup realizado com sucesso!!", "Sucesso!",
					JOptionPane.INFORMATION_MESSAGE,
					new javax.swing.ImageIcon(getClass().getResource("/Imagens/verificado.png")));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}
