package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

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
import regras.IA;
import regras.Imagem;
import regras.Jogo;
import regras.Porta;

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
	@FXML
	private Button abrirpegar;
	@FXML
	private Button fechar;
	@FXML
	private ImageView acoesIV;
	@FXML
	private ImageView abrirpegarIV;

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

		refresh();

	}

	public void refresh() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				Platform.runLater(() -> {
					// Chat
					if (Estados.nmchat.equals("sim")) {
						String a = "";
						if (Estados.jogadorLogado.equals("jogador2")) {
							a = "jogador 1";
						}
						if (Estados.jogadorLogado.equals("jogador1")) {
							a = "jogador 2";
						}
						chatarray.add(0, Jogo.criaString("Jogador " + a + ": " + Estados.mensagem));
						chat.setText(Jogo.criachat(chatarray));

						Estados.nmchat = "nao";
					}

					// Atualiza movimentos!!

					if (!Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {

						if (Estados.jogadormoveu.equals("sim")) {

							// mova para algum lugar

							if (Estados.direcao.equals("n")) {

								try {
									norte();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (InterruptedException e) {
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
								} catch (InterruptedException e) {
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
								} catch (InterruptedException e) {
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
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

							Estados.jogadormoveu = "nao";

						}

						// Atualiza jogador da vez
						if (Estados.jogadorDaVeztrocou.equals("sim")) {
							chatarray.add(0, Jogo.criaString("Vez do jogador " + Estados.jogadorDaVez));
							chat.setText(Jogo.criachat(chatarray));
							jogadorVez.setText(Estados.jogadorDaVez);
							Estados.jogadorDaVeztrocou = "nao";
						}

						// Dado
						if (Estados.jogoudado.equals("sim")) {
							resultaDado.setText(Estados.jogoudadovalor);
							jogardado = true;
							Estados.jogoudado = "nao";
						}

						// Vez do IA
						if (Estados.jogadorDaVez.equals("dragao") || Estados.jogadorDaVez.equals("Night King")) {
							if (Estados.jogadorLogado.equals("jogador2")) {
								if (jogardado == false) {

									try {

										dado();
										String a = resultaDado.getText();
										criaracao("Dado", a);

									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									jogardado = true;
								}
							} else if (Integer.parseInt(resultaDado.getText()) > 0) {
								Integer xia = 0;
								Integer yia = 0;
								Integer x1 = 0;
								Integer y1 = 0;
								Integer x2 = 0;
								Integer y2 = 0;
								boolean v1 = true;
								boolean v2 = true;
								if (Estados.jogadorDaVez.equals("dragao")) {
									xia = Jogo.pd1.get(0);
									yia = Jogo.pd1.get(1);
								}
								if (Estados.jogadorDaVez.equals("Night King")) {
									xia = Jogo.pd2.get(0);
									yia = Jogo.pd2.get(1);
								}
								x1 = Jogo.pj1.get(0);
								y1 = Jogo.pj1.get(1);
								x2 = Jogo.pj2.get(0);
								y2 = Jogo.pj2.get(1);

								for (int i = 0; i < Jogo.piportas().size(); i++) {
									if (x1 == Jogo.piportas().get(i).get(0) && y1 == Jogo.piportas().get(i).get(1)) {
										v1 = false;
										break;
									}
									if (x2 == Jogo.piportas().get(i).get(0) && y2 == Jogo.piportas().get(i).get(1)) {
										v2 = false;
										break;
									}
								}

								if (x1 == 7 && y1 == 3) {
									v1 = false;
								}
								if (x1 == 7 && y1 == 4) {
									v1 = false;
								}
								if (x2 == 7 && y2 == 3) {
									v2 = false;
								}
								if (x2 == 7 && y2 == 4) {
									v2 = false;
								}

								String movimento = IA.direcionar(xia, yia, x1, y1, x2, y2, v1, v2);

								if (movimento.equals("n")) {
									try {
										norte();
										criaracao("Jogador moveu", "n");
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								if (movimento.equals("s")) {
									try {
										sul();
										criaracao("Jogador moveu", "s");
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}
								if (movimento.equals("l")) {
									try {
										leste();
										criaracao("Jogador moveu", "l");
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								if (movimento.equals("o")) {
									try {
										oeste();
										criaracao("Jogador moveu", "o");
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}

						}

					}

				});

			}

		};
		long delay = 0; //
		long period = 500;
		timer.schedule(task, delay, period);
	}

	public static void criaracao(String a, String b) throws IOException {

		Acoes.criarAcao(a, b);
	}

	@FXML
	void onclickdado(ActionEvent event) throws IOException, InterruptedException {
		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			dado();
			String a = resultaDado.getText();
			criaracao("Dado", a);
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}

	public void dado() throws InterruptedException {

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
			//Facilitador Temporario
			if (Estados.jogadorDaVez.equals("dragao")||Estados.jogadorDaVez.equals("Night King")) {
				resultaDado.setText("1");
			}else {
				resultaDado.setText("10");
			}

		} else {
			chatarray.add(0, Jogo.criaString("Comando invalido"));
			chat.setText(Jogo.criachat(chatarray));
		}
	}

	Label portaatual = null;

	public boolean verificaporta(int x, int y) {
		for (int i = 0; i < Jogo.portas.size(); i++) {
			if (Jogo.portas.get(i).getLocal().get(0) == x && Jogo.portas.get(i).getLocal().get(1) == y) {
				if (x == 1 && y == 0) {
					p1.setText(Jogo.portas.get(i).getChave());
					portaatual = p1;
				}
				;
				if (x == 3 && y == 0) {
					p2.setText(Jogo.portas.get(i).getChave());
					portaatual = p1;
				}
				;
				if (x == 5 && y == 0) {
					p3.setText(Jogo.portas.get(i).getChave());
					portaatual = p1;
				}
				;
				if (x == 7 && y == 0) {
					p4.setText(Jogo.portas.get(i).getChave());
					portaatual = p1;
				}
				;
				if (x == 1 && y == 7) {
					p5.setText(Jogo.portas.get(i).getChave());
					portaatual = p1;
				}
				;
				if (x == 3 && y == 7) {
					p6.setText(Jogo.portas.get(i).getChave());
					portaatual = p1;
				}
				;
				if (x == 5 && y == 7) {
					p7.setText(Jogo.portas.get(i).getChave());
					portaatual = p1;
				}
				;
				if (x == 7 && y == 7) {
					p8.setText(Jogo.portas.get(i).getChave());
					portaatual = p1;
				}
				
				

				return true;
			}

		}

		return false;

	}

	public Porta procuraporta(String a) {
		for (int i = 0; i < Jogo.portas.size(); i++) {
			if (Jogo.portas.get(i).getChave().equals(a)) {
				return Jogo.portas.get(i);
			}
		}
		return null;
	}

	@FXML
	void onclickabrirpegar(ActionEvent event) throws IOException, InterruptedException {
		int x = 0;
		int y = 0;
		if (Estados.jogadorDaVez.equals("jogador1")) {
			x = Jogo.pj1.get(0);
			y = Jogo.pj1.get(1);
		}
		if (Estados.jogadorDaVez.equals("jogador2")) {
			x = Jogo.pj2.get(0);
			y = Jogo.pj2.get(1);
		}
		if (verificaporta(x, y)) {
			abrirpegarIV.setOpacity(1);
			if (portaatual.getText().equals("F1-Branca 1") || portaatual.getText().equals("F2-Branca 1")) {
				abrirpegarIV.setImage(Imagem.criaimagem("icones/pbranca.png"));
			}
			if (portaatual.getText().equals("F1-Verde 2") || portaatual.getText().equals("F2-Verde 2")) {
				abrirpegarIV.setImage(Imagem.criaimagem("icones/pverde.png"));
			}
			if (portaatual.getText().equals("F1-Azul 3") || portaatual.getText().equals("F2-Azul 3")) {
				abrirpegarIV.setImage(Imagem.criaimagem("icones/pazul.png"));
			}
			if (portaatual.getText().equals("F1-Roxa 4") || portaatual.getText().equals("F2-Roxa 4")) {
				abrirpegarIV.setImage(Imagem.criaimagem("icones/proxa.png"));
			}
			if (x==0&&y==3) {
				abrirpegarIV.setImage(Imagem.criaimagem("icones/pamarela.png"));
			}
			if (x==0&&y==4) {
				abrirpegarIV.setImage(Imagem.criaimagem("icones/pamarela.png"));
			}
			if (Estados.jogadorDaVez.equals("jogador1")) {
				if (portaatual.getText().equals("F1-Branca 1")) {
					procuraporta("F1-Branca 1").setSituacao("aberta");
					linhas.get(x).get(y).setImage(Imagem.criaimagem("icones/paberta.png"));
					chatarray.add(0,
							Jogo.criaString("O jogador 1 abriu a primeira porta e ganhou a chave para a segunda!"));
					chat.setText(Jogo.criachat(chatarray));
					abrirpegarIV.setImage(Imagem.criaimagem("icones/paberta.png"));
				} else if (portaatual.getText().equals("F1-Verde 2")) {
					if (procuraporta("F1-Branca 1").getSituacao().equals("aberta")) {
						procuraporta("F1-Verde 2").setSituacao("aberta");
						linhas.get(x).get(y).setImage(Imagem.criaimagem("icones/paberta.png"));
						chatarray.add(0,
								Jogo.criaString("O jogador 1 abriu a segunda porta e ganhou a chave para a terceira!"));
						chat.setText(Jogo.criachat(chatarray));
						abrirpegarIV.setImage(Imagem.criaimagem("icones/paberta.png"));
					} else {
						chatarray.add(0, Jogo.criaString("Voce ainda nao possui a chave dessa porta!"));
						chat.setText(Jogo.criachat(chatarray));
					}

				} else if (portaatual.getText().equals("F1-Azul 3")) {
					if (procuraporta("F1-Verde 2").getSituacao().equals("aberta")) {
						procuraporta("F1-Azul 3").setSituacao("aberta");
						linhas.get(x).get(y).setImage(Imagem.criaimagem("icones/paberta.png"));
						chatarray.add(0,
								Jogo.criaString("O jogador 1 abriu a terceira porta e ganhou a chave para a quarta!"));
						chat.setText(Jogo.criachat(chatarray));
						abrirpegarIV.setImage(Imagem.criaimagem("icones/paberta.png"));

					} else {
						chatarray.add(0, Jogo.criaString("Voce ainda nao possui a chave dessa porta!"));
						chat.setText(Jogo.criachat(chatarray));
					}

				} else if (portaatual.getText().equals("F1-Roxa 4")) {
					if (procuraporta("F1-Azul 3").getSituacao().equals("aberta")) {
						procuraporta("F1-Roxa 4").setSituacao("aberta");
						linhas.get(x).get(y).setImage(Imagem.criaimagem("icones/paberta.png"));
						chatarray.add(0, Jogo
								.criaString("O jogador 1 abriu a quarta porta e ganhou a chave para a porta final!!!"));
						chat.setText(Jogo.criachat(chatarray));
						abrirpegarIV.setImage(Imagem.criaimagem("icones/paberta.png"));

					} else {
						chatarray.add(0, Jogo.criaString("Voce ainda nao possui a chave dessa porta!"));
						chat.setText(Jogo.criachat(chatarray));
					}

				} else if (x == 0 && y == 3) {
					if (procuraporta("F1-Roxa 4").getSituacao().equals("aberta")) {
						// FINAL DO JOGO AQUI!

						chatarray.add(0, Jogo.criaString("O jogador 1 GANHOUU!!!!!!!!!"));
						chat.setText(Jogo.criachat(chatarray));

					} else {
						chatarray.add(0, Jogo.criaString("Voce ainda nao possui a chave dessa porta!"));
						chat.setText(Jogo.criachat(chatarray));
					}

				}

			} else {
				if (portaatual.getText().equals("F2-Branca 1")) {
					procuraporta("F2-Branca 1").setSituacao("aberta");
					linhas.get(x).get(y).setImage(Imagem.criaimagem("icones/paberta.png"));
					chatarray.add(0,
							Jogo.criaString("O jogador 2 abriu a primeira porta e ganhou a chave para a segunda!"));
					chat.setText(Jogo.criachat(chatarray));
				} else if (portaatual.getText().equals("F2-Verde 2")) {
					if (procuraporta("F2-Branca 1").getSituacao().equals("aberta")) {
						procuraporta("F2-Verde 2").setSituacao("aberta");
						linhas.get(x).get(y).setImage(Imagem.criaimagem("icones/paberta.png"));
						chatarray.add(0,
								Jogo.criaString("O jogador 2 abriu a segunda porta e ganhou a chave para a terceira!"));
						chat.setText(Jogo.criachat(chatarray));
						abrirpegarIV.setImage(Imagem.criaimagem("icones/paberta.png"));

					} else {
						chatarray.add(0, Jogo.criaString("Voce ainda nao possui a chave dessa porta!"));
						chat.setText(Jogo.criachat(chatarray));
					}

				} else if (portaatual.getText().equals("F2-Azul 3")) {
					if (procuraporta("F2-Verde 2").getSituacao().equals("aberta")) {
						procuraporta("F2-Azul 3").setSituacao("aberta");
						linhas.get(x).get(y).setImage(Imagem.criaimagem("icones/paberta.png"));
						chatarray.add(0,
								Jogo.criaString("O jogador 2 abriu a terceira porta e ganhou a chave para a quarta!"));
						chat.setText(Jogo.criachat(chatarray));
						abrirpegarIV.setImage(Imagem.criaimagem("icones/paberta.png"));

					} else {
						chatarray.add(0, Jogo.criaString("Voce ainda nao possui a chave dessa porta!"));
						chat.setText(Jogo.criachat(chatarray));
					}

				} else if (portaatual.getText().equals("F2-Roxa 4")) {
					if (procuraporta("F2-Azul 3").getSituacao().equals("aberta")) {
						procuraporta("F2-Roxa 4").setSituacao("aberta");
						linhas.get(x).get(y).setImage(Imagem.criaimagem("icones/paberta.png"));
						chatarray.add(0, Jogo
								.criaString("O jogador 2 abriu a quarta porta e ganhou a chave para a porta final!!!"));
						chat.setText(Jogo.criachat(chatarray));
						abrirpegarIV.setImage(Imagem.criaimagem("icones/paberta.png"));

					} else {
						chatarray.add(0, Jogo.criaString("Voce ainda nao possui a chave dessa porta!"));
						chat.setText(Jogo.criachat(chatarray));
					}

				} else if (x == 0 && y == 4) {
					if (procuraporta("F2-Roxa 4").getSituacao().equals("aberta")) {
						// FINAL DO JOGO AQUI!

						chatarray.add(0, Jogo.criaString("O jogador 2 GANHOUU!!!!!!!!!"));
						chat.setText(Jogo.criachat(chatarray));

					} else {
						chatarray.add(0, Jogo.criaString("Voce ainda nao possui a chave dessa porta!"));
						chat.setText(Jogo.criachat(chatarray));
					}

				}
			}

		} else {
			chatarray.add(0, Jogo.criaString("Voce nao esta em uma porta!"));
			chat.setText(Jogo.criachat(chatarray));
		}

	}

	@FXML
	void onclickfechar(ActionEvent event) throws IOException, InterruptedException {
		acoesIV.setOpacity(0);
	}

	@FXML
	void onclicknorte(ActionEvent event) throws IOException, InterruptedException {
		abrirpegarIV.setOpacity(0);
		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			norte();
			criaracao("Jogador moveu", "n");
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}

	public void norte() throws IOException, InterruptedException {

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
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), cordaporta);
						}
					}
					Jogo.pj1.set(0, Jogo.pj1.get(0) - 1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
					slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "icones/js.png");
					chatarray.add(0, Jogo.criaString("Player 1 foi para o norte"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj1.get(0) && Jogo.pd1.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem("icones/dragao.png"));
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);

					}
					if (Jogo.pd2.get(0) == Jogo.pj1.get(0) && Jogo.pd2.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					}
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
							linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), cordaporta);
						}
					}
					Jogo.pj2.set(0, Jogo.pj2.get(0) - 1);
					linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
					linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem("icones/dany.png"));
					slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "icones/dany.png");
					chatarray.add(0, Jogo.criaString("Player 2 foi para o norte"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj2.get(0) && Jogo.pd1.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem("icones/dragao.png"));
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);

					}
					if (Jogo.pd2.get(0) == Jogo.pj2.get(0) && Jogo.pd2.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					}
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
				if (Jogo.validamovimento(Jogo.pd1.get(0), Jogo.pd1.get(1), "n")) {
					linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(0);
					slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "nada");
					// Pintar portas
					for (int i = 0; i < Jogo.portas.size(); i++) {

						if (Jogo.pd1.get(0) == Jogo.portas.get(i).getLocal().get(0)
								&& Jogo.pd1.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

							linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
							String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
							linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), cordaporta);
						}
					}
					Jogo.pd1.set(0, Jogo.pd1.get(0) - 1);
					linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
					linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setImage(Imagem.criaimagem("icones/dragao.png"));
					slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "icones/dragao.png");
					chatarray.add(0, Jogo.criaString("dragao foi para o norte"));
					chat.setText(Jogo.criachat(chatarray));

					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj1.get(0) && Jogo.pd1.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
					}
					if (Jogo.pd1.get(0) == Jogo.pj2.get(0) && Jogo.pd1.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
					}

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
				if (Jogo.validamovimento(Jogo.pd2.get(0), Jogo.pd2.get(1), "n")) {
					linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(0);
					slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "nada");
					// Pintar portas
					for (int i = 0; i < Jogo.portas.size(); i++) {

						if (Jogo.pd2.get(0) == Jogo.portas.get(i).getLocal().get(0)
								&& Jogo.pd2.get(1) == Jogo.portas.get(i).getLocal().get(1)) {

							linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
							String cordaporta = "icones/" + Jogo.corporta(Jogo.portas.get(i).getCor()) + ".png";
							linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), cordaporta);
						}
					}
					Jogo.pd2.set(0, Jogo.pd2.get(0) - 1);
					linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
					slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "icones/nk.png");
					chatarray.add(0, Jogo.criaString("Night King foi para o norte"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd2.get(0) == Jogo.pj1.get(0) && Jogo.pd2.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
					}
					if (Jogo.pd2.get(0) == Jogo.pj2.get(0) && Jogo.pd2.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
					}
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
	void onclicksul(ActionEvent event) throws IOException, InterruptedException {
		abrirpegarIV.setOpacity(0);
		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			sul();
			criaracao("Jogador moveu", "s");
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}

	public void sul() throws IOException, InterruptedException {

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
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), cordaporta);
						}
					}
					Jogo.pj1.set(0, Jogo.pj1.get(0) + 1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
					slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "icones/js.png");
					chatarray.add(0, Jogo.criaString("Player 1 foi para o sul"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj1.get(0) && Jogo.pd1.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem("icones/dragao.png"));
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);

					}
					if (Jogo.pd2.get(0) == Jogo.pj1.get(0) && Jogo.pd2.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					}
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
							linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), cordaporta);
						}
					}
					Jogo.pj2.set(0, Jogo.pj2.get(0) + 1);
					linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
					linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem("icones/dany.png"));
					slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "icones/dany.png");
					chatarray.add(0, Jogo.criaString("Player 2 foi para o sul"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj2.get(0) && Jogo.pd1.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem("icones/dragao.png"));
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);

					}
					if (Jogo.pd2.get(0) == Jogo.pj2.get(0) && Jogo.pd2.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					}
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
							linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), cordaporta);
						}
					}
					Jogo.pd1.set(0, Jogo.pd1.get(0) + 1);
					linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
					linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setImage(Imagem.criaimagem("icones/dragao.png"));
					slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "icones/dragao.png");
					chatarray.add(0, Jogo.criaString("dragao foi para o sul"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj1.get(0) && Jogo.pd1.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
					}
					if (Jogo.pd1.get(0) == Jogo.pj2.get(0) && Jogo.pd1.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
					}
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
							linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), cordaporta);
						}
					}
					Jogo.pd2.set(0, Jogo.pd2.get(0) + 1);
					linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
					slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "icones/nk.png");
					chatarray.add(0, Jogo.criaString("Night King foi para o sul"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd2.get(0) == Jogo.pj1.get(0) && Jogo.pd2.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
					}
					if (Jogo.pd2.get(0) == Jogo.pj2.get(0) && Jogo.pd2.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
					}
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
	void onclickleste(ActionEvent event) throws IOException, InterruptedException {
		abrirpegarIV.setOpacity(0);

		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			leste();
			criaracao("Jogador moveu", "l");
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}

	public void leste() throws IOException, InterruptedException {

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
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), cordaporta);
						}
					}
					Jogo.pj1.set(1, Jogo.pj1.get(1) + 1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
					slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "icones/js.png");
					chatarray.add(0, Jogo.criaString("Player 1 foi para o leste"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj1.get(0) && Jogo.pd1.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem("icones/dragao.png"));
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);

					}
					if (Jogo.pd2.get(0) == Jogo.pj1.get(0) && Jogo.pd2.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					}
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
							linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), cordaporta);
						}
					}
					Jogo.pj2.set(1, Jogo.pj2.get(1) + 1);
					linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
					linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem("icones/dany.png"));
					slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "icones/dany.png");
					chatarray.add(0, Jogo.criaString("Player 2 foi para o leste"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj2.get(0) && Jogo.pd1.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem("icones/dragao.png"));
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);

					}
					if (Jogo.pd2.get(0) == Jogo.pj2.get(0) && Jogo.pd2.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					}
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
							linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), cordaporta);
						}
					}
					Jogo.pd1.set(1, Jogo.pd1.get(1) + 1);
					linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
					linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setImage(Imagem.criaimagem("icones/dragao.png"));
					slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "icones/dragao.png");
					chatarray.add(0, Jogo.criaString("dragao foi para o leste"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj1.get(0) && Jogo.pd1.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
					}
					if (Jogo.pd1.get(0) == Jogo.pj2.get(0) && Jogo.pd1.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
					}

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
							linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), cordaporta);
						}
					}
					Jogo.pd2.set(1, Jogo.pd2.get(1) + 1);
					linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
					slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "icones/nk.png");
					chatarray.add(0, Jogo.criaString("Night King foi para o leste"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd2.get(0) == Jogo.pj1.get(0) && Jogo.pd2.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
					}
					if (Jogo.pd2.get(0) == Jogo.pj2.get(0) && Jogo.pd2.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
					}
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
	void onclickoeste(ActionEvent event) throws IOException, InterruptedException {
		abrirpegarIV.setOpacity(0);
		if (Estados.jogadorDaVez.equals(Estados.jogadorLogado)) {
			oeste();
			criaracao("Jogador moveu", "o");
		} else {
			chatarray.add(0, Jogo.criaString("Espere sua vez! Agora esta jogando o " + Estados.jogadorDaVez));
			chat.setText(Jogo.criachat(chatarray));
		}
	}

	public void oeste() throws IOException, InterruptedException {

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
							linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), cordaporta);
						}
					}
					Jogo.pj1.set(1, Jogo.pj1.get(1) - 1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setOpacity(1);
					linhas.get(Jogo.pj1.get(0)).get(Jogo.pj1.get(1)).setImage(Imagem.criaimagem("icones/js.png"));
					slinhas.get(Jogo.pj1.get(0)).set(Jogo.pj1.get(1), "icones/js.png");
					chatarray.add(0, Jogo.criaString("Player 1 foi para o oeste"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj1.get(0) && Jogo.pd1.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem("icones/dragao.png"));
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);

					}
					if (Jogo.pd2.get(0) == Jogo.pj1.get(0) && Jogo.pd2.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					}
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
							linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), cordaporta);
						}
					}
					Jogo.pj2.set(1, Jogo.pj2.get(1) - 1);
					linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setOpacity(1);
					linhas.get(Jogo.pj2.get(0)).get(Jogo.pj2.get(1)).setImage(Imagem.criaimagem("icones/dany.png"));
					slinhas.get(Jogo.pj2.get(0)).set(Jogo.pj2.get(1), "icones/dany.png");
					chatarray.add(0, Jogo.criaString("Player 2 foi para o oeste"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj2.get(0) && Jogo.pd1.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1))
								.setImage(Imagem.criaimagem("icones/dragao.png"));
						linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);

					}
					if (Jogo.pd2.get(0) == Jogo.pj2.get(0) && Jogo.pd2.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
						linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					}
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
							linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), cordaporta);
						}
					}
					Jogo.pd1.set(1, Jogo.pd1.get(1) - 1);
					linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setOpacity(1);
					linhas.get(Jogo.pd1.get(0)).get(Jogo.pd1.get(1)).setImage(Imagem.criaimagem("icones/dragao.png"));
					slinhas.get(Jogo.pd1.get(0)).set(Jogo.pd1.get(1), "icones/dragao.png");
					chatarray.add(0, Jogo.criaString("dragao foi para o oeste"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd1.get(0) == Jogo.pj1.get(0) && Jogo.pd1.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
					}
					if (Jogo.pd1.get(0) == Jogo.pj2.get(0) && Jogo.pd1.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
					}
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
							linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem(cordaporta));
							slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), cordaporta);
						}
					}
					Jogo.pd2.set(1, Jogo.pd2.get(1) - 1);
					linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setOpacity(1);
					linhas.get(Jogo.pd2.get(0)).get(Jogo.pd2.get(1)).setImage(Imagem.criaimagem("icones/nk.png"));
					slinhas.get(Jogo.pd2.get(0)).set(Jogo.pd2.get(1), "icones/nk.png");
					chatarray.add(0, Jogo.criaString("Night King foi para o oeste"));
					chat.setText(Jogo.criachat(chatarray));
					// Matou jogador
					if (Jogo.pd2.get(0) == Jogo.pj1.get(0) && Jogo.pd2.get(1) == Jogo.pj1.get(1)) {
						Jogo.pj1.set(0, 7);
						Jogo.pj1.set(1, 3);
						q_7x3.setImage(Imagem.criaimagem("icones/js.png"));
						q_7x3.setOpacity(1);
					}
					if (Jogo.pd2.get(0) == Jogo.pj2.get(0) && Jogo.pd2.get(1) == Jogo.pj2.get(1)) {
						Jogo.pj2.set(0, 7);
						Jogo.pj2.set(1, 4);
						q_7x4.setImage(Imagem.criaimagem("icones/dany.png"));
						q_7x4.setOpacity(1);
					}
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
		acoesIV.setImage(Imagem.criaimagem("background/controls.png"));
		acoesIV.setOpacity(1);

	}

	@FXML
	void onclickenviar(ActionEvent event) throws IOException {

		chatarray.add(0, Jogo.criaString("Jogador " + Estados.jogadorLogado + ": " + digite.getText()));
		chat.setText(Jogo.criachat(chatarray));

		Acoes.criarAcao("chat", digite.getText());

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
