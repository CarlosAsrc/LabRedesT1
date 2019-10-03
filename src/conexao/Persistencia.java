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






	public static void read(String a) {
		Path path2 = Paths.get(a);

		try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {

			String linha = null;

			String situacao="";
			String mensagem="";

			while ((linha = br.readLine()) != null) {

				Scanner scanner = new Scanner(linha);

				Scanner sc = scanner.useDelimiter("/");

				situacao= sc.next().trim();
				mensagem= sc.next().trim();
				
	
				
			}
		} catch (IOException x) {

		}
		

	}
		

	public static void save (String onde, String situacao, String mensagem) throws FileNotFoundException {
		String arquivo = situacao+"\n"+mensagem;
		try (PrintStream out = new PrintStream(
				new FileOutputStream(onde))) {
			out.print(arquivo);
		}
	}
	}


