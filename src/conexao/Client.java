package conexao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;

public class Client {

	public static void main(String[] args) throws SocketException, IOException, InterruptedException {

		String acao = "ok";
		String mensagema = "ok";
		Tarefa tarefa = new Tarefa(acao, mensagema);
		
		GerenciadorTarefa.envio.add(tarefa);
		
		GerenciadorTarefa.count = 0;

		Persistencia.save("enviar");
		
		Persistencia.save("fazer");

		System.out.println("Procurando Server....");

		BufferedReader clientRead = new BufferedReader(new InputStreamReader(System.in));

		InetAddress IP = InetAddress.getByName("2804:14d:4c86:8f60:b1b9:4ba7:3554:13da");

		DatagramSocket clientSocket = new DatagramSocket();
		int contlinha = 0;
		int tempo = 0;
		while (true) {
			tempo = tempo + 1;
			System.out.println("\nTempo: " + tempo);
			byte[] sendbuffer = new byte[1024];
			byte[] receivebuffer = new byte[1024];

			String mensagem = analiseenviar();
			String clientData = mensagem;

			sendbuffer = clientData.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, 9876);
			clientSocket.send(sendPacket);

			DatagramPacket receivePacket = new DatagramPacket(receivebuffer, receivebuffer.length);
			clientSocket.receive(receivePacket);
			String serverData = new String(receivePacket.getData());
			System.out.print("\nServer: " + serverData);

			analisems(serverData);

			TimeUnit.SECONDS.sleep(1);

		}

	}

	public static String analiseenviar() throws IOException {
		
		if (Persistencia.linhaenviar() > GerenciadorTarefa.count) {

			Tarefa tarefa = Persistencia.read("enviar", (Persistencia.linhaenviar() - GerenciadorTarefa.count));

			GerenciadorTarefa.count = GerenciadorTarefa.count + 1;
			
			String resposta = tarefa.getAcao() + "/" + tarefa.getMensagem();

			return resposta;

		}

		return "ok/ok,";
	}

	public static String limpastring(String a) {
		String d = "";
		for (int i = 0; i < a.length(); i++) {
			char b = a.charAt(i);

			String c = "" + b;

			if (c.equals(",")) {
				break;

			}
			d = d + c;
		}
		return d;

	}

	public static void analisems(String a) throws IOException {
		String b = limpastring(a);

		if (!b.equals("ok2/ok2")) {
			System.out.println("entrou");
			Persistencia.readfazer();
			String[] array = a.split("/");

			String acao = array[0];
			String mensagem = array[1];
			Tarefa tarefa = new Tarefa(acao, mensagem);
			GerenciadorTarefa.fazer.add(tarefa);
			Persistencia.save("fazer");
		}
	}

}
