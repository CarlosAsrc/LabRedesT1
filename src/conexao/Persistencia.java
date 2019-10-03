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






	public static void read( String tipomensagem) {
		Path path2 = Paths.get(tipomensagem);
		String acao="";
		String mensagem="";
		
		try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {

			String linha = null;
			int contlinha =0;
			

			while ((linha = br.readLine()) != null) {
				contlinha = contlinha+1;
				Scanner scanner = new Scanner(linha);

				Scanner sc = scanner.useDelimiter("/");
				 acao=sc.next().trim();;
				mensagem=  sc.next().trim();
	if (tipomensagem.equals("me")) {		
if (contlinha >GerenciadorTarefa.countme) {
	Tarefa tarefa = new Tarefa(acao,mensagem);
	GerenciadorTarefa.tarefase.add(tarefa);
	GerenciadorTarefa.countme=GerenciadorTarefa.countme+1;
	GerenciadorTarefa.tarefasespera.add(tarefa);
}
	}
	
	if (tipomensagem.equals("mr")) {		
if (contlinha >GerenciadorTarefa.countmr) {
	Tarefa tarefa = new Tarefa(acao,mensagem);
	GerenciadorTarefa.tarefasr.add(tarefa);
	GerenciadorTarefa.countmr=GerenciadorTarefa.countmr+1;
	
}
	}
				
			}
			
		} catch (IOException x) {

		}
		
		 

	}
		

	public static void save (String onde) throws FileNotFoundException {
		String arquivo="";
		if (onde.equals("mr")) {
		for (int i=0;i<GerenciadorTarefa.tarefasr.size();i++) {
			 arquivo = arquivo+ GerenciadorTarefa.tarefasr.get(i).getAcao()+"/"+GerenciadorTarefa.tarefasr.get(i).getMensagem()+"\n";	
			 if (i<(GerenciadorTarefa.tarefase.size()-1)) {
				 arquivo=arquivo+"\n";
			 }
		
		}
		 
		}
		if (onde.equals("me")) {
			for (int i=0;i<GerenciadorTarefa.tarefase.size();i++) {
				 arquivo = arquivo+ GerenciadorTarefa.tarefase.get(i).getAcao()+"/"+GerenciadorTarefa.tarefase.get(i).getMensagem();
				 if (i<(GerenciadorTarefa.tarefase.size()-1)) {
					 arquivo=arquivo+"\n";
				 }
			}
			}
		try (PrintStream out = new PrintStream(
				new FileOutputStream(onde))) {
			out.print(arquivo);
		}
	}
	}


