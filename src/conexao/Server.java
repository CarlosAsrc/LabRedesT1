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

import application.Main;

public class Server {

	public static void main(String[] args) throws InterruptedException, IOException {
		String acao = "ok2";
		String mensagema = "ok2";
		Tarefa tarefa = new Tarefa(acao, mensagema);

		GerenciadorTarefa.envio.add(tarefa);

		Persistencia.save("enviar");
		Persistencia.save("count");
		Persistencia.save("fazer");

		System.out.println("Servidor iniciado, aguardando resposta....");
		DatagramSocket serverSocket = new DatagramSocket(9876);
		boolean bye = false;
		int tempo = 0;
		while (true) {
			tempo = tempo + 1;
			System.out.println("Tempo: " + tempo);
			byte[] receivebuffer = new byte[1024];
			byte[] sendbuffer = new byte[1024];
			DatagramPacket recvdpkt = new DatagramPacket(receivebuffer, receivebuffer.length);
			serverSocket.receive(recvdpkt);
			InetAddress IP = recvdpkt.getAddress();
			int portno = recvdpkt.getPort();
			String clientdata = new String(recvdpkt.getData());
			System.out.println("\nClient : " + clientdata);
			analisemc(clientdata);

			String mensagem = analiseenviar();

			String serverdata = mensagem;

			sendbuffer = serverdata.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, portno);

			serverSocket.send(sendPacket);

			TimeUnit.SECONDS.sleep(2);
		}
	}

	public static String analiseenviar() throws IOException {
		Persistencia.readcount();
		if (Persistencia.linhaenviar() > GerenciadorTarefa.count) {

			Tarefa tarefa = Persistencia.read("enviar", (Persistencia.linhaenviar() - GerenciadorTarefa.count));
			GerenciadorTarefa.count = GerenciadorTarefa.count + 1;
			Persistencia.save("count");
			return tarefa.getAcao() + "/" + tarefa.getMensagem();

		}

		return "ok2/ok2,";
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

	public static void analisemc(String a) throws IOException {
		String b = limpastring(a);
		if (!b.equals("ok/ok")) {
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
