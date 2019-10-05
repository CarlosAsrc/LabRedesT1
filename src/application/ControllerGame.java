package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import conexao.Acoes;
import conexao.Estados;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import regras.Arquivo;
import regras.Imagem;
import regras.Jogo;

public class ControllerGame {
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ImageView background;
	@FXML
	private ImageView q_0x0;
	@FXML
	private ImageView q_0x1;
	@FXML
	private ImageView q_0x2;
	@FXML
	private ImageView q_0x3;
	@FXML
	private ImageView q_0x4;
	@FXML
	private ImageView q_0x5;
	@FXML
	private ImageView q_0x6;
	@FXML
	private ImageView q_0x7;
	@FXML
	private ImageView q_1x0;
	@FXML
	private ImageView q_1x1;
	@FXML
	private ImageView q_1x2;
	@FXML
	private ImageView q_1x3;
	@FXML
	private ImageView q_1x4;
	@FXML
	private ImageView q_1x5;
	@FXML
	private ImageView q_1x6;
	@FXML
	private ImageView q_1x7;
	@FXML
	private ImageView q_2x0;
	@FXML
	private ImageView q_2x1;
	@FXML
	private ImageView q_2x2;
	@FXML
	private ImageView q_2x3;
	@FXML
	private ImageView q_2x4;
	@FXML
	private ImageView q_2x5;
	@FXML
	private ImageView q_2x6;
	@FXML
	private ImageView q_2x7;
	@FXML
	private ImageView q_3x0;
	@FXML
	private ImageView q_3x1;
	@FXML
	private ImageView q_3x2;
	@FXML
	private ImageView q_3x3;
	@FXML
	private ImageView q_3x4;
	@FXML
	private ImageView q_3x5;
	@FXML
	private ImageView q_3x6;
	@FXML
	private ImageView q_3x7;
	@FXML
	private ImageView q_4x0;
	@FXML
	private ImageView q_4x1;
	@FXML
	private ImageView q_4x2;
	@FXML
	private ImageView q_4x3;
	@FXML
	private ImageView q_4x4;
	@FXML
	private ImageView q_4x5;
	@FXML
	private ImageView q_4x6;
	@FXML
	private ImageView q_4x7;
	@FXML
	private ImageView q_5x0;
	@FXML
	private ImageView q_5x1;
	@FXML
	private ImageView q_5x2;
	@FXML
	private ImageView q_5x3;
	@FXML
	private ImageView q_5x4;
	@FXML
	private ImageView q_5x5;
	@FXML
	private ImageView q_5x6;
	@FXML
	private ImageView q_5x7;
	@FXML
	private ImageView q_6x0;
	@FXML
	private ImageView q_6x1;
	@FXML
	private ImageView q_6x2;
	@FXML
	private ImageView q_6x3;
	@FXML
	private ImageView q_6x4;
	@FXML
	private ImageView q_6x5;
	@FXML
	private ImageView q_6x6;
	@FXML
	private ImageView q_6x7;
	@FXML
	private ImageView q_7x0;
	@FXML
	private ImageView q_7x1;
	@FXML
	private ImageView q_7x2;
	@FXML
	private ImageView q_7x3;
	@FXML
	private ImageView q_7x4;
	@FXML
	private ImageView q_7x5;
	@FXML
	private ImageView q_7x6;
	@FXML
	private ImageView q_7x7;
	@FXML
	private Label p1;
	@FXML
	private Label p2;
	@FXML
	private Label p3;
	@FXML
	private Label p4;
	@FXML
	private Label p5;
	@FXML
	private Label p6;
	@FXML
	private Label p7;
	@FXML
	private Label p8;
	@FXML
	private Label jogador1;
	@FXML
	private Label jogador2;

	@FXML
	private TextArea chat;
	@FXML
	private TextArea digite;
	@FXML
	private ImageView comandosBackground;
	@FXML
	private Label jogadorVez;
	@FXML
	private Label resultaDado;
	@FXML
	private Button dado;
	@FXML
	private Button norte;
	@FXML
	private Button sul;
	@FXML
	private Button leste;
	@FXML
	private Button oeste;

	@FXML
	private Button acoes;
	@FXML
	private Button enviar;

	boolean jogardado = false;

	ArrayList<String> chatarray = new ArrayList<String>();

	// Matriz
	ArrayList<ArrayList<ImageView>> linhas = new ArrayList<ArrayList<ImageView>>();
	ArrayList<ImageView> coluna0 = new ArrayList<ImageView>();
	ArrayList<ImageView> coluna1 = new ArrayList<ImageView>();
	ArrayList<ImageView> coluna2 = new ArrayList<ImageView>();
	ArrayList<ImageView> coluna3 = new ArrayList<ImageView>();
	ArrayList<ImageView> coluna4 = new ArrayList<ImageView>();
	ArrayList<ImageView> coluna5 = new ArrayList<ImageView>();
	ArrayList<ImageView> coluna6 = new ArrayList<ImageView>();
	ArrayList<ImageView> coluna7 = new ArrayList<ImageView>();

	ArrayList<ArrayList<String>> slinhas = new ArrayList<ArrayList<String>>();
	ArrayList<String> scoluna0 = new ArrayList<String>();
	ArrayList<String> scoluna1 = new ArrayList<String>();
	ArrayList<String> scoluna2 = new ArrayList<String>();
	ArrayList<String> scoluna3 = new ArrayList<String>();
	ArrayList<String> scoluna4 = new ArrayList<String>();
	ArrayList<String> scoluna5 = new ArrayList<String>();
	ArrayList<String> scoluna6 = new ArrayList<String>();
	ArrayList<String> scoluna7 = new ArrayList<String>();

	@FXML
	void initialize() throws IOException {

		background.setImage(Imagem.criaimagem("background/game.png"));
		comandosBackground.setImage(Imagem.criaimagem("background/comando.png"));
		criamatriz();

		if (Jogo.inicio == 0) {

			regras.Sons.tocar("monowar");

			criamatrizs();

			q_0x2.setImage(Imagem.criaimagem("icones/dragao.png"));
			slinhas.get(0).set(2, "icones/dragao.png");

			q_0x5.setImage(Imagem.criaimagem("icones/nk.png"));
			slinhas.get(0).set(5, "icones/nk.png");

			q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
			slinhas.get(7).set(3, "icones/js.png");

			q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
			slinhas.get(7).set(4, "icones/dany.png");

			q_1x0.setImage(Imagem.criaimagem("icones/ppreta.png"));
			slinhas.get(1).set(0, "icones/ppreta.png");

			q_1x7.setImage(Imagem.criaimagem("icones/ppreta.png"));
			slinhas.get(1).set(7, "icones/ppreta.png");

			q_3x0.setImage(Imagem.criaimagem("icones/ppreta.png"));
			slinhas.get(3).set(0, "icones/ppreta.png");

			q_3x7.setImage(Imagem.criaimagem("icones/ppreta.png"));
			slinhas.get(3).set(7, "icones/ppreta.png");

			q_5x0.setImage(Imagem.criaimagem("icones/ppreta.png"));
			slinhas.get(5).set(0, "icones/ppreta.png");

			q_5x7.setImage(Imagem.criaimagem("icones/ppreta.png"));
			slinhas.get(5).set(7, "icones/ppreta.png");

			q_7x0.setImage(Imagem.criaimagem("icones/ppreta.png"));
			slinhas.get(7).set(0, "icones/ppreta.png");

			q_7x7.setImage(Imagem.criaimagem("icones/ppreta.png"));
			slinhas.get(7).set(7, "icones/ppreta.png");

			q_0x0.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(0).set(0, "icones/parede.png");

			q_0x1.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(0).set(1, "icones/parede.png");

			q_0x6.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(0).set(6, "icones/parede.png");

			q_0x7.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(0).set(7, "icones/parede.png");

			q_2x0.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(2).set(0, "icones/parede.png");

			q_2x7.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(2).set(7, "icones/parede.png");

			q_4x0.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(4).set(0, "icones/parede.png");

			q_4x7.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(4).set(7, "icones/parede.png");

			q_6x0.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(6).set(0, "icones/parede.png");

			q_6x7.setImage(Imagem.criaimagem("icones/parede.png"));
			slinhas.get(6).set(7, "icones/parede.png");

			q_0x3.setImage(Imagem.criaimagem("icones/pamarela.png"));
			slinhas.get(0).set(3, "icones/pamarela.png");

			q_0x4.setImage(Imagem.criaimagem("icones/pamarela.png"));
			slinhas.get(0).set(4, "icones/pamarela.png");

			chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
			jogadorVez.setText(Estados.jogadorDaVez);
			Jogo.inicio = 1;
			refresh();
		} else {

			jogardado = Jogo.jogardado;

			chatarray = Jogo.chatarray;

			jogadorVez.setText(Estados.jogadorDaVez);
			// Matriz

			resultaDado.setText(Jogo.movimentos);
			chat.setText(Jogo.criachat(chatarray));
			slinhas = Jogo.slinhas;

			for (int i = 0; i < slinhas.size(); i++) {
				for (int j = 0; j < slinhas.get(i).size(); j++) {
					if (!slinhas.get(i).get(j).equals("nada")) {
						linhas.get(i).get(j).setImage(Imagem.criaimagem(slinhas.get(i).get(j)));
					}
				}
			}
		}
	}

	public void refresh() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				Platform.runLater(() -> {
					System.out.println("Fez a thread");
					// Atualiza jogador da vez
					if (Estados.jogadorDaVeztrocou.equals("sim")) {
						chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
						chat.setText(Jogo.criachat(chatarray));
						jogadorVez.setText(Estados.jogadorDaVez);
						Estados.jogadorDaVeztrocou = "nao";
					}
					// Atualiza movimentos!!
					System.out.println("Jogador da vez: "+Estados.jogadorDaVez);
					System.out.println("Jogador Logado: "+Estados.jogadorLogado);
					if (!Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
						System.out.println("Nao sou o jogador da vez");
						System.out.println("Jogador Moveu? "+Estados.jogadormoveu);
						if (Estados.jogadormoveu.equals("sim")) {
							System.out.println("Entrei no jogador moveu");
							// mova para algum lugar
							System.out.println("minha direcao: "+Estados.direcao);
							if (Estados.direcao.equals("n")) {
							System.out.println("entrei no norte");
								try {
									norte();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							if (Estados.direcao.equals("s")) {
								try {
									sul();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							if (Estados.direcao.equals("l")) {
								try {
									leste();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							if (Estados.direcao.equals("o")) {
								try {
									oeste();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							if (Estados.direcao.equals("dado")) {
								dado();
							}

							Estados.jogadormoveu = "nao";

						}
						
						
						
						
					}
									
		
				});

			}

		};
		long delay = 0; //
		long period = 1000;
		timer.schedule(task, delay, period);
	}

	@FXML
	void onclickdado(ActionEvent event) throws IOException {
		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			dado();
			Acoes.criarAcao("Jogador moveu", "dado");
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}
public void dado() {
	salvar();
	if (jogardado == false) {
		jogardado = true;
		chatarray.add(0, Jogo.criaString("Jogou o dado o " + Estados.jogadorDaVez));
		chat.setText(Jogo.criachat(chatarray));
		Random rnd = new Random();
		int i = rnd.nextInt(6);
		i = i + 1;
		chatarray.add(0, Jogo.criaString("" + i + "!"));
		chat.setText(Jogo.criachat(chatarray));
		resultaDado.setText("" + i);

	} else {
		chatarray.add(0, Jogo.criaString("Comando invalido"));
		chat.setText(Jogo.criachat(chatarray));
	}
}
	@FXML
	void onclicknorte(ActionEvent event) throws IOException {
		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			norte();
			Acoes.criarAcao("Jogador moveu", "n");
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}
public void norte () throws IOException {
	salvar();

	if (jogardado == false) {
		chatarray.add(0, Jogo.criaString("Jogue o dado primeiro!"));
		chat.setText(Jogo.criachat(chatarray));
	} else {
		if (Estados.jogadorDaVez.equals("jogador1")) {
			regras.Sons.tocarsom("kn");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pj1.get(0), Jogo.pj1.get(1), "n")) {
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(0);
				slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pj1.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pj1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), cordaporta);
					}
				}
				Jogo.pj1.set(0, Jogo.pj1.get(0) - 1);
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
				slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "icones/js.png");
				chatarray.add(0, Jogo.criaString("Player 1 foi para o norte"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("jogador2")) {
			regras.Sons.tocarsom("dany");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pj2.get(0), Jogo.pj2.get(1), "n")) {
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(0);
				slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pj2.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pj2.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), cordaporta);
					}
				}
				Jogo.pj2.set(0, Jogo.pj2.get(0) - 1);
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem("icones/dany.png"));
				slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "icones/dany.png");
				chatarray.add(0, Jogo.criaString("Player 2 foi para o norte"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("Dragao")) {
			regras.Sons.tocarsom("tr");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pd1.get(0), Jogo.pd1.get(1), "n")) {
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(0);
				slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pd1.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pd1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), cordaporta);
					}
				}
				Jogo.pd1.set(0, Jogo.pd1.get(0) - 1);
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
						.setImage(Imagem.criaimagem("icones/dragao.png"));
				slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "icones/dragao.png");
				chatarray.add(0, Jogo.criaString("Dragao 1 foi para o norte"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("Nigth King")) {
			regras.Sons.tocarsom("nk");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pd2.get(0), Jogo.pd2.get(1), "n")) {
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(0);
				slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pd2.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pd2.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), cordaporta);
					}
				}
				Jogo.pd2.set(0, Jogo.pd2.get(0) - 1);
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
				slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "icones/nk.png");
				chatarray.add(0, Jogo.criaString("Dragao 2 foi para o norte"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));

				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (resultaDado.getText().equals("0")) {

			jogardado = false;

			Acoes.criarAcao("troca jogador", "troca jogador");
			if (Estados.jogadorDaVez.equals("jogador1")) {
				Estados.jogadorDaVez = "jogador2";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("jogador2")) {
				Estados.jogadorDaVez = "dragao";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("dragao")) {
				Estados.jogadorDaVez = "Night King";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("Night King")) {
				Estados.jogadorDaVez = "jogador1";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			}

		}

	}
}
	@FXML
	void onclicksul(ActionEvent event) throws IOException {
		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			sul();
			Acoes.criarAcao("Jogador moveu", "s");
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}
public void sul () throws IOException {
	salvar();
	if (jogardado == false) {
		chatarray.add(0, Jogo.criaString("Jogue o dado primeiro!"));
		chat.setText(Jogo.criachat(chatarray));
	} else {

		if (Estados.jogadorDaVez.equals("jogador1")) {
			regras.Sons.tocarsom("kn");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pj1.get(0), Jogo.pj1.get(1), "s")) {
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(0);
				slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pj1.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pj1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), cordaporta);
					}
				}
				Jogo.pj1.set(0, Jogo.pj1.get(0) + 1);
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
				slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "icones/js.png");
				chatarray.add(0, Jogo.criaString("Player 1 foi para o sul"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("jogador2")) {
			regras.Sons.tocarsom("dany");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pj2.get(0), Jogo.pj2.get(1), "s")) {
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(0);
				slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pj2.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pj2.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), cordaporta);
					}
				}
				Jogo.pj2.set(0, Jogo.pj2.get(0) + 1);
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem("icones/dany.png"));
				slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "icones/dany.png");
				chatarray.add(0, Jogo.criaString("Player 2 foi para o sul"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("dragao")) {
			regras.Sons.tocarsom("tr");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pd1.get(0), Jogo.pd1.get(1), "s")) {
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(0);
				slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pd1.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pd1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), cordaporta);
					}
				}
				Jogo.pd1.set(0, Jogo.pd1.get(0) + 1);
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
						.setImage(Imagem.criaimagem("icones/dragao.png"));
				slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "icones/dragao.png");
				chatarray.add(0, Jogo.criaString("Dragao 1 foi para o sul"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("Night King")) {
			regras.Sons.tocarsom("nk");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pd2.get(0), Jogo.pd2.get(1), "s")) {
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(0);
				slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pd2.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pd2.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), cordaporta);
					}
				}
				Jogo.pd2.set(0, Jogo.pd2.get(0) + 1);
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
				slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "icones/nk.png");
				chatarray.add(0, Jogo.criaString("Dragao 2 foi para o sul"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));

				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (resultaDado.getText().equals("0")) {

			jogardado = false;

			Acoes.criarAcao("troca jogador", "troca jogador");
			if (Estados.jogadorDaVez.equals("jogador1")) {
				Estados.jogadorDaVez = "jogador2";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("jogador2")) {
				Estados.jogadorDaVez = "dragao";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);

			} else if (Estados.jogadorDaVez.equals("dragao")) {
				Estados.jogadorDaVez = "Night King";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);

			} else if (Estados.jogadorDaVez.equals("Night King")) {
				Estados.jogadorDaVez = "jogador1";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);

			}
		}
	}
}
	@FXML
	void onclickleste(ActionEvent event) throws IOException {
		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			leste();
			Acoes.criarAcao("Jogador moveu", "l");
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}
public void leste() throws IOException {
	salvar();
	if (jogardado == false) {
		chatarray.add(0, Jogo.criaString("Jogue o dado primeiro!"));
		chat.setText(Jogo.criachat(chatarray));
	} else {
		if (Estados.jogadorDaVez.equals("jogador1")) {
			regras.Sons.tocarsom("kn");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pj1.get(0), Jogo.pj1.get(1), "l")) {
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(0);
				slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pj1.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pj1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), cordaporta);
					}
				}
				Jogo.pj1.set(1, Jogo.pj1.get(1) + 1);
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
				slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "icones/js.png");
				chatarray.add(0, Jogo.criaString("Player 1 foi para o leste"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("jogador2")) {
			regras.Sons.tocarsom("dany");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pj2.get(0), Jogo.pj2.get(1), "l")) {
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(0);
				slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pj2.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pj2.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), cordaporta);
					}
				}
				Jogo.pj2.set(1, Jogo.pj2.get(1) + 1);
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem("icones/dany.png"));
				slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "icones/dany.png");
				chatarray.add(0, Jogo.criaString("Player 2 foi para o leste"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("dragao")) {
			regras.Sons.tocarsom("tr");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pd1.get(0), Jogo.pd1.get(1), "l")) {
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(0);
				slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pd1.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pd1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), cordaporta);
					}
				}
				Jogo.pd1.set(1, Jogo.pd1.get(1) + 1);
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
						.setImage(Imagem.criaimagem("icones/dragao.png"));
				slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "icones/dragao.png");
				chatarray.add(0, Jogo.criaString("Dragao 1 foi para o leste"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("Night King")) {
			regras.Sons.tocarsom("nk");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pd2.get(0), Jogo.pd2.get(1), "l")) {
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(0);
				slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pd2.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pd2.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), cordaporta);
					}
				}
				Jogo.pd2.set(1, Jogo.pd2.get(1) + 1);
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
				slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "icones/nk.png");
				chatarray.add(0, Jogo.criaString("Dragao 2 foi para o leste"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));

				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (resultaDado.getText().equals("0")) {

			jogardado = false;
			Acoes.criarAcao("troca jogador", "troca jogador");
			if (Estados.jogadorDaVez.equals("jogador1")) {
				Estados.jogadorDaVez = "jogador2";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("jogador2")) {
				Estados.jogadorDaVez = "dragao";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("dragao")) {
				Estados.jogadorDaVez = "Night King";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("Night King")) {
				Estados.jogadorDaVez = "jogador1";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			}
		}
	}
}
	@FXML
	void onclickoeste(ActionEvent event) throws IOException {
		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			oeste();
			Acoes.criarAcao("Jogador moveu", "s");
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}
public void oeste() throws IOException {
	salvar();
	if (jogardado == false) {
		chatarray.add(0, Jogo.criaString("Jogue o dado primeiro!"));
		chat.setText(Jogo.criachat(chatarray));
	} else {
		if (Estados.jogadorDaVez.equals("jogador1")) {
			regras.Sons.tocarsom("kn");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pj1.get(0), Jogo.pj1.get(1), "o")) {
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(0);
				slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pj1.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pj1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), cordaporta);
					}
				}
				Jogo.pj1.set(1, Jogo.pj1.get(1) - 1);
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
				linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
				slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "icones/js.png");
				chatarray.add(0, Jogo.criaString("Player 1 foi para o oeste"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("jogador2")) {
			regras.Sons.tocarsom("dany");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pj2.get(0), Jogo.pj2.get(1), "o")) {
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(0);
				slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pj2.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pj2.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), cordaporta);
					}
				}
				Jogo.pj2.set(1, Jogo.pj2.get(1) - 1);
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
				linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem("icones/dany.png"));
				slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "icones/dany.png");
				chatarray.add(0, Jogo.criaString("Player 2 foi para o oeste"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("dragao")) {
			regras.Sons.tocarsom("tr");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pd1.get(0), Jogo.pd1.get(1), "o")) {
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(0);
				slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pd1.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pd1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), cordaporta);
					}
				}
				Jogo.pd1.set(1, Jogo.pd1.get(1) - 1);
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
				linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
						.setImage(Imagem.criaimagem("icones/dragao.png"));
				slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "icones/dragao.png");
				chatarray.add(0, Jogo.criaString("Dragao 1 foi para o oeste"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));
				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (Estados.jogadorDaVez.equals("Night King")) {
			regras.Sons.tocarsom("nk");
			String d = resultaDado.getText();
			Integer id = Integer.parseInt(d);
			;
			id = id - 1;
			resultaDado.setText("" + id);
			if (Jogo.validamovimento(Jogo.pd2.get(0), Jogo.pd2.get(1), "o")) {
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(0);
				slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "nada");
				// Pintar portas
				for (int i = 0; i < Jogo.portas.size(); i++) {

					if (Jogo.pd2.get(0) == Jogo.portas.get(i).getLocal().get(0)
							&& Jogo.pd2.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
						String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1))
								.setImage(Imagem.criaimagem(cordaporta));
						slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), cordaporta);
					}
				}
				Jogo.pd2.set(1, Jogo.pd2.get(1) - 1);
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
				linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
				slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "icones/nk.png");
				chatarray.add(0, Jogo.criaString("Dragao 2 foi para o oeste"));
				chat.setText(Jogo.criachat(chatarray));
			} else {
				chatarray.add(0, Jogo.criaString("Movimento invalido"));
				chat.setText(Jogo.criachat(chatarray));

				id = id + 1;
				resultaDado.setText("" + id);
				return;
			}

		}
		if (resultaDado.getText().equals("0")) {
			jogardado = false;
			Acoes.criarAcao("troca jogador", "troca jogador");
			if (Estados.jogadorDaVez.equals("jogador1")) {
				Estados.jogadorDaVez = "jogador2";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("jogador2")) {
				Estados.jogadorDaVez = "dragao";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("dragao")) {
				Estados.jogadorDaVez = "Night King";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			} else if (Estados.jogadorDaVez.equals("Night King")) {
				Estados.jogadorDaVez = "jogador1";
				chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
				chat.setText(Jogo.criachat(chatarray));
				jogadorVez.setText(Estados.jogadorDaVez);
			}
		}
	}
}
	@FXML
	void onclickacoes(ActionEvent event) throws IOException {
		salvar();

		AnchorPane pane = FXMLLoader.load(getClass().getResource("Acoes.fxml"));
		anchorpane.getChildren().setAll(pane);
	}

	@FXML
	void onclickenviar(ActionEvent event) throws IOException {

		chatarray.add(0, Jogo.criaString("Jogador " + Estados.jogadorDaVez + ": " + digite.getText()));
		chat.setText(Jogo.criachat(chatarray));
	}

	void salvar() {
		Jogo.jogardado = jogardado;

		Jogo.chatarray = chatarray;

		// Matriz

		Jogo.movimentos = resultaDado.getText();
		Jogo.slinhas = slinhas;
		Jogo.atualizaproibida();
	}

	void criamatriz() {
		coluna0.add(q_0x0);
		coluna0.add(q_0x1);
		coluna0.add(q_0x2);
		coluna0.add(q_0x3);
		coluna0.add(q_0x4);
		coluna0.add(q_0x5);
		coluna0.add(q_0x6);
		coluna0.add(q_0x7);
		coluna1.add(q_1x0);
		coluna1.add(q_1x1);
		coluna1.add(q_1x2);
		coluna1.add(q_1x3);
		coluna1.add(q_1x4);
		coluna1.add(q_1x5);
		coluna1.add(q_1x6);
		coluna1.add(q_1x7);
		coluna2.add(q_2x0);
		coluna2.add(q_2x1);
		coluna2.add(q_2x2);
		coluna2.add(q_2x3);
		coluna2.add(q_2x4);
		coluna2.add(q_2x5);
		coluna2.add(q_2x6);
		coluna2.add(q_2x7);
		coluna3.add(q_3x0);
		coluna3.add(q_3x1);
		coluna3.add(q_3x2);
		coluna3.add(q_3x3);
		coluna3.add(q_3x4);
		coluna3.add(q_3x5);
		coluna3.add(q_3x6);
		coluna3.add(q_3x7);
		coluna4.add(q_4x0);
		coluna4.add(q_4x1);
		coluna4.add(q_4x2);
		coluna4.add(q_4x3);
		coluna4.add(q_4x4);
		coluna4.add(q_4x5);
		coluna4.add(q_4x6);
		coluna4.add(q_4x7);
		coluna5.add(q_5x0);
		coluna5.add(q_5x1);
		coluna5.add(q_5x2);
		coluna5.add(q_5x3);
		coluna5.add(q_5x4);
		coluna5.add(q_5x5);
		coluna5.add(q_5x6);
		coluna5.add(q_5x7);
		coluna6.add(q_6x0);
		coluna6.add(q_6x1);
		coluna6.add(q_6x2);
		coluna6.add(q_6x3);
		coluna6.add(q_6x4);
		coluna6.add(q_6x5);
		coluna6.add(q_6x6);
		coluna6.add(q_6x7);
		coluna7.add(q_7x0);
		coluna7.add(q_7x1);
		coluna7.add(q_7x2);
		coluna7.add(q_7x3);
		coluna7.add(q_7x4);
		coluna7.add(q_7x5);
		coluna7.add(q_7x6);
		coluna7.add(q_7x7);

		linhas.add(coluna0);
		linhas.add(coluna1);
		linhas.add(coluna2);
		linhas.add(coluna3);
		linhas.add(coluna4);
		linhas.add(coluna5);
		linhas.add(coluna6);
		linhas.add(coluna7);
	}

	void criamatrizs() {
		String nada = "nada";
		scoluna0.add(nada);
		scoluna0.add(nada);
		scoluna0.add(nada);
		scoluna0.add(nada);
		scoluna0.add(nada);
		scoluna0.add(nada);
		scoluna0.add(nada);
		scoluna0.add(nada);
		scoluna1.add(nada);
		scoluna1.add(nada);
		scoluna1.add(nada);
		scoluna1.add(nada);
		scoluna1.add(nada);
		scoluna1.add(nada);
		scoluna1.add(nada);
		scoluna1.add(nada);
		scoluna2.add(nada);
		scoluna2.add(nada);
		scoluna2.add(nada);
		scoluna2.add(nada);
		scoluna2.add(nada);
		scoluna2.add(nada);
		scoluna2.add(nada);
		scoluna2.add(nada);
		scoluna3.add(nada);
		scoluna3.add(nada);
		scoluna3.add(nada);
		scoluna3.add(nada);
		scoluna3.add(nada);
		scoluna3.add(nada);
		scoluna3.add(nada);
		scoluna3.add(nada);
		scoluna4.add(nada);
		scoluna4.add(nada);
		scoluna4.add(nada);
		scoluna4.add(nada);
		scoluna4.add(nada);
		scoluna4.add(nada);
		scoluna4.add(nada);
		scoluna4.add(nada);
		scoluna5.add(nada);
		scoluna5.add(nada);
		scoluna5.add(nada);
		scoluna5.add(nada);
		scoluna5.add(nada);
		scoluna5.add(nada);
		scoluna5.add(nada);
		scoluna5.add(nada);
		scoluna6.add(nada);
		scoluna6.add(nada);
		scoluna6.add(nada);
		scoluna6.add(nada);
		scoluna6.add(nada);
		scoluna6.add(nada);
		scoluna6.add(nada);
		scoluna6.add(nada);
		scoluna7.add(nada);
		scoluna7.add(nada);
		scoluna7.add(nada);
		scoluna7.add(nada);
		scoluna7.add(nada);
		scoluna7.add(nada);
		scoluna7.add(nada);
		scoluna7.add(nada);

		slinhas.add(scoluna0);
		slinhas.add(scoluna1);
		slinhas.add(scoluna2);
		slinhas.add(scoluna3);
		slinhas.add(scoluna4);
		slinhas.add(scoluna5);
		slinhas.add(scoluna6);
		slinhas.add(scoluna7);
	}
}
