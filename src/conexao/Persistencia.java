package conexao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Persistencia {


	public static int linhaenviar( ) throws IOException {
		Path path2 = Paths.get("enviar");
		int contlinha =0;
		try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {

			String linha = null;
			
			while ((linha = br.readLine()) != null) {
				contlinha = contlinha+1;
				
	}
		}
		return contlinha;
		
			
	}
	public static int linhafazer( ) throws IOException {
		Path path2 = Paths.get("fazer");
		int contlinha =0;
		try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {

			String linha = null;
			
			while ((linha = br.readLine()) != null) {
				contlinha = contlinha+1;
				
	}
		}
		return contlinha;
		
			
	}
	public static void readenviar () throws IOException {
		GerenciadorTarefa.envio.clear();
		Path path2 = Paths.get("enviar");
		try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {

			String linha = null;
			String acao="";
			String mensagem="";
			while ((linha = br.readLine()) != null) {
				Scanner scanner = new Scanner(linha);

				Scanner sc = scanner.useDelimiter("/");
				 acao=sc.next().trim();
				 mensagem=sc.next().trim();
				 Tarefa tarefa= new Tarefa(acao,mensagem);
				 GerenciadorTarefa.envio.add(tarefa);
			}
			
			}
	}
	public static void readfazer () throws IOException {
		GerenciadorTarefa.fazer.clear();
		Path path2 = Paths.get("fazer");
		try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {

			String linha = null;
			String acao="";
			String mensagem="";
			while ((linha = br.readLine()) != null) {
				Scanner scanner = new Scanner(linha);

				Scanner sc = scanner.useDelimiter("/");
				 acao=sc.next().trim();
				 mensagem=sc.next().trim();
				 Tarefa tarefa= new Tarefa(acao,mensagem);
				 GerenciadorTarefa.fazer.add(tarefa);
			}
			
			}
	}
	public static void readcount () throws IOException {
		Path path2 = Paths.get("count");
		try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {

			String linha = null;
			String count ="";
			while ((linha = br.readLine()) != null) {
				Scanner scanner = new Scanner(linha);

				Scanner sc = scanner.useDelimiter("");
				 count=sc.next().trim();
				 
			}
			GerenciadorTarefa.count=Integer.parseInt(count);
			}
	}



	public static Tarefa read( String tipomensagem, int diferenca) {
		Path path2 = Paths.get(tipomensagem);
		String acao="";
		String mensagem="";
		int contlinha =0;
		try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {

			String linha = null;
			
			

			while ((linha = br.readLine()) != null) {
				contlinha = contlinha+1;
				if (contlinha>GerenciadorTarefa.count&&contlinha<=GerenciadorTarefa.count+diferenca) {
					
				Scanner scanner = new Scanner(linha);

				Scanner sc = scanner.useDelimiter("/");
				 acao=sc.next().trim();
				mensagem=  sc.next().trim();
				
	Tarefa tarefa = new Tarefa(acao,mensagem);
	return tarefa;
				}
}
	
				
			
			
		} catch (IOException x) {

		}
		return null;
		
	}

	
		

	public static void save (String onde) throws FileNotFoundException {
		String arquivo="";
		
		if (onde.equals("enviar")) {
			
		for (int i=0;i<GerenciadorTarefa.envio.size();i++) {
			 arquivo = arquivo+ GerenciadorTarefa.envio.get(i).getAcao()+"/"+GerenciadorTarefa.envio.get(i).getMensagem();	
			 if (i<(GerenciadorTarefa.envio.size()-1)) {
				 arquivo=arquivo+"\n";
			 }
		
		}
		 
		}
		if (onde.equals("fazer")) {
			
			for (int i=0;i<GerenciadorTarefa.fazer.size();i++) {
				 arquivo = arquivo+ GerenciadorTarefa.fazer.get(i).getAcao()+"/"+GerenciadorTarefa.fazer.get(i).getMensagem();
				 if (i<(GerenciadorTarefa.fazer.size()-1)) {
					 arquivo=arquivo+"\n";
				 }
			}
			
			}
		if (onde.equals("count")) {
			
			arquivo = ""+GerenciadorTarefa.count;
			}
		arquivo=arquivo+",";
		try (PrintStream out = new PrintStream(
				new FileOutputStream(onde))) {
			out.print(arquivo);
		}
	}
	}


