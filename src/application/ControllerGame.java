package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

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
	ArrayList<String> jogadores = new ArrayList<String>();
	ArrayList<String> chatarray = new ArrayList<String>();
	int jogadordavez = 1;
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

	
	
	@FXML
	void initialize() throws IOException {
		if (Jogo.inicio==0) {
		regras.Sons.tocar("monowar");

		criamatriz();
		Jogo.sorteiaporta();

		background.setImage(Imagem.criaimagem("background/game.png"));

		comandosBackground.setImage(Imagem.criaimagem("background/comando.png"));

		q_0x2.setImage(Imagem.criaimagem("icones/dragao.png"));
		q_0x5.setImage(Imagem.criaimagem("icones/dragao.png"));
		q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
		q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
		q_1x0.setImage(Imagem.criaimagem("icones/ppreta.png"));
		q_1x7.setImage(Imagem.criaimagem("icones/ppreta.png"));
		q_3x0.setImage(Imagem.criaimagem("icones/ppreta.png"));
		q_3x7.setImage(Imagem.criaimagem("icones/ppreta.png"));
		q_5x0.setImage(Imagem.criaimagem("icones/ppreta.png"));
		q_5x7.setImage(Imagem.criaimagem("icones/ppreta.png"));
		q_7x0.setImage(Imagem.criaimagem("icones/ppreta.png"));
		q_7x7.setImage(Imagem.criaimagem("icones/ppreta.png"));

		q_0x0.setImage(Imagem.criaimagem("icones/parede.png"));
		q_0x1.setImage(Imagem.criaimagem("icones/parede.png"));
		q_0x6.setImage(Imagem.criaimagem("icones/parede.png"));
		q_0x7.setImage(Imagem.criaimagem("icones/parede.png"));
		q_2x0.setImage(Imagem.criaimagem("icones/parede.png"));
		q_2x7.setImage(Imagem.criaimagem("icones/parede.png"));
		q_4x0.setImage(Imagem.criaimagem("icones/parede.png"));
		q_4x7.setImage(Imagem.criaimagem("icones/parede.png"));
		q_6x0.setImage(Imagem.criaimagem("icones/parede.png"));
		q_6x7.setImage(Imagem.criaimagem("icones/parede.png"));

		q_0x3.setImage(Imagem.criaimagem("icones/pamarela.png"));
		q_0x4.setImage(Imagem.criaimagem("icones/pamarela.png"));

		jogadores.add("Player 1");
		jogadores.add("Player 2");
		jogadores.add("Dragao 1");
		jogadores.add("Dragao 2");

		chatarray.add(0, Jogo.criaString("Vez do jogador " + jogadores.get(jogadordavez - 1)));
		chat.setText(Jogo.criachat(chatarray));
		jogadorVez.setText(jogadores.get(jogadordavez - 1));
		Jogo.inicio=1;
		}
	}

	@FXML
	void onclickdado(ActionEvent event) throws IOException {
		if (jogardado == false) {
			jogardado = true;
			chatarray.add(0, Jogo.criaString("Jogou o dado o " + jogadores.get(jogadordavez - 1)));
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
		if (jogardado == false) {
			chatarray.add(0, Jogo.criaString("Jogue o dado primeiro!"));
			chat.setText(Jogo.criachat(chatarray));
		} else {
			if (jogadordavez == 1) {
				String d = resultaDado.getText();
				Integer id = Integer.parseInt(d);
				;
				id = id - 1;
				resultaDado.setText("" + id);
				if (Jogo.validamovimento(Jogo.pj1.get(0), Jogo.pj1.get(1), "n")) {
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(0);

					// Pintar portas
					for (int i = 0; i < Jogo.portas.size(); i++) {
						
						if (Jogo.pj1.get(0) == Jogo.portas.get(i).getLocal().get(0)&&Jogo.pj1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {
							System.out.println("Entrou");
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
							String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem(cordaporta));
						}
					}
					Jogo.pj1.set(0, Jogo.pj1.get(0) - 1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
					chatarray.add(0, Jogo.criaString("Player 1 foi para o norte"));
					chat.setText(Jogo.criachat(chatarray));
				} else {
					chatarray.add(0, Jogo.criaString("Movimento invalido"));
					chat.setText(Jogo.criachat(chatarray));
				}

			}

		}
	}

	@FXML
	void onclicksul(ActionEvent event) throws IOException {
		if (jogardado == false) {
			chatarray.add(0, Jogo.criaString("Jogue o dado primeiro!"));
			chat.setText(Jogo.criachat(chatarray));
		} else {
			if (jogadordavez == 1) {
				String d = resultaDado.getText();
				Integer id = Integer.parseInt(d);
				;
				id = id - 1;
				resultaDado.setText("" + id);
				if (Jogo.validamovimento(Jogo.pj1.get(0), Jogo.pj1.get(1), "s")) {
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(0);

					// Pintar portas
					for (int i = 0; i < Jogo.portas.size(); i++) {
						
						if (Jogo.pj1.get(0) == Jogo.portas.get(i).getLocal().get(0)&&Jogo.pj1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {
							System.out.println("Entrou");
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
							String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem(cordaporta));
						}
					}
					Jogo.pj1.set(0, Jogo.pj1.get(0) + 1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
					chatarray.add(0, Jogo.criaString("Player 1 foi para o sul"));
					chat.setText(Jogo.criachat(chatarray));
				} else {
					chatarray.add(0, Jogo.criaString("Movimento invalido"));
					chat.setText(Jogo.criachat(chatarray));
				}

			}

		}
	}

	@FXML
	void onclickleste(ActionEvent event) throws IOException {
		if (jogardado == false) {
			chatarray.add(0, Jogo.criaString("Jogue o dado primeiro!"));
			chat.setText(Jogo.criachat(chatarray));
		} else {
			if (jogadordavez == 1) {
				String d = resultaDado.getText();
				Integer id = Integer.parseInt(d);
				;
				id = id - 1;
				resultaDado.setText("" + id);
				if (Jogo.validamovimento(Jogo.pj1.get(0), Jogo.pj1.get(1), "l")) {
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(0);

					// Pintar portas
					for (int i = 0; i < Jogo.portas.size(); i++) {
						
						if (Jogo.pj1.get(0) == Jogo.portas.get(i).getLocal().get(0)&&Jogo.pj1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {
System.out.println("Entrou");
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
							String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem(cordaporta));
						}
					}
					Jogo.pj1.set(1, Jogo.pj1.get(1) + 1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
					chatarray.add(0, Jogo.criaString("Player 1 foi para o leste"));
					chat.setText(Jogo.criachat(chatarray));
				} else {
					chatarray.add(0, Jogo.criaString("Movimento invalido"));
					chat.setText(Jogo.criachat(chatarray));
				}

			}

		}
	}

	@FXML
	void onclickoeste(ActionEvent event) throws IOException {
		if (jogardado == false) {
			chatarray.add(0, Jogo.criaString("Jogue o dado primeiro!"));
			chat.setText(Jogo.criachat(chatarray));
		} else {
			if (jogadordavez == 1) {
				String d = resultaDado.getText();
				Integer id = Integer.parseInt(d);
				;
				id = id - 1;
				resultaDado.setText("" + id);
				if (Jogo.validamovimento(Jogo.pj1.get(0), Jogo.pj1.get(1), "o")) {
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(0);

					// Pintar portas
					for (int i = 0; i < Jogo.portas.size(); i++) {
						
						if (Jogo.pj1.get(0) == Jogo.portas.get(i).getLocal().get(0)&&Jogo.pj1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {
							System.out.println("Entrou");
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
							String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem(cordaporta));
						}
					}
					Jogo.pj1.set(1, Jogo.pj1.get(1) - 1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
					chatarray.add(0, Jogo.criaString("Player 1 foi para o oeste"));
					chat.setText(Jogo.criachat(chatarray));
				} else {
					chatarray.add(0, Jogo.criaString("Movimento invalido"));
					chat.setText(Jogo.criachat(chatarray));
				}

			}

		}
	}

	@FXML
	void onclickacoes(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Acoes.fxml"));
		anchorpane.getChildren().setAll(pane);
	}

	@FXML
	void onclickenviar(ActionEvent event) throws IOException {

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
}
