package application;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import conexao.Acoes;
import conexao.Estados;
import conexao.Refresher;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import regras.Salas;

public class ControllerSalaSelecionada {
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ImageView background;
	@FXML
	private Button comecar;
	@FXML
	private Button voltar;
	@FXML
	private Label sala;
	@FXML
	private Label situacao1;
	@FXML
	private Label situacao2;
	@FXML
	private ImageView tapar;
	@FXML
    void initialize() throws IOException{
		sala.setText(Salas.numeroSala);
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + "background/salaescolhida.png";
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		background.setImage(image);
		
		
		String caminho2 = regras.Arquivo.montarCaminho();
		caminho2 = caminho2 + "icones/tapar.png";
		File file2 = new File(caminho2);
		BufferedImage bufferedImage2 = ImageIO.read(file2);
		Image image2 = SwingFXUtils.toFXImage(bufferedImage2, null);
		tapar.setImage(image2);
	
		
		
		if (Estados.jogadorLogado.equals("jogador1")) {
            Acoes.criarAcao("J1 Pronto!", "");
			Estados.jogador1Pronto="Sim";
			situacao1.setText("Pronto");
			situacao1.setTextFill(Color.web("#0ed145"));
			
		}
		if (Estados.jogadorLogado.equals("jogador2")) {
			Acoes.criarAcao("J2 Pronto!", "");
			Estados.jogador2Pronto="Sim";
			situacao2.setText("Pronto");
			situacao2.setTextFill(Color.web("#0ed145"));
			
		}
		
		refresh();
	}
	public boolean comecoPermitido=false;
	
	public  void refresh() {
		Timer timer = new Timer();
	    TimerTask task = new TimerTask() {
	        
	        @Override
	        public void run() {
	if (Estados.jogador1Pronto.equals("Sim")&&Estados.jogador2Pronto.equals("Sim")) {
		tapar.setOpacity(0);
		Platform.runLater(() -> {
			situacao1.setText("Pronto");
			situacao2.setText("Pronto");
		});
		
		situacao1.setTextFill(Color.web("#0ed145"));
		
		situacao2.setTextFill(Color.web("#0ed145"));
		comecoPermitido=true;
	}
	        }
	    };
	    long delay = 0; //
	    long period = 3000;
	    timer.schedule(task, delay, period);
	}
	@FXML
	void onclickiniciar(ActionEvent event) throws IOException {
		System.out.println(comecoPermitido);
		if (comecoPermitido) {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Game.fxml"));
		anchorpane.getChildren().setAll(pane);
		}
	}
	@FXML
	void onclickvoltar(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Sala.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
}
