package application;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import regras.Jogo;

public class ControllerAcoes {
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ImageView background;
	@FXML
	private TextArea itens;
	@FXML
	private TextField selecione;
	@FXML
	private Label selecionado;
	@FXML
	private Label avisos;
	@FXML
	private Label movimentos;
	@FXML
	private ImageView objeto;
	@FXML
	private Button examinar;
	@FXML
	private Button OK;
	@FXML
	private Button largar;
	@FXML
	private Button usar;
	@FXML
	private Button pegar;
	@FXML
	private Button abrir;
	@FXML
	private Button ajuda;
	@FXML
	private Button voltar;
	@FXML
	void initialize() throws IOException {
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + "background/opcoes.png";
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		background.setImage(image);
		movimentos.setText(Jogo.movimentos);
		objeto.setOpacity(0);
		
	}
	@FXML
	void onclickexaminar(ActionEvent event) throws IOException {
		String caminho ="";
		 caminho = regras.Arquivo.montarCaminho();
		
		if (Jogo.jogadordavez==1) {
		for (int i=0;i<Jogo.portas.size();i++) {
			if (Jogo.portas.get(i).getLocal().get(0)==Jogo.pj1.get(0)&&Jogo.portas.get(i).getLocal().get(1)==Jogo.pj1.get(1)) {
				caminho = caminho + "icones/p"+Jogo.portas.get(i).getCor()+".png";
				break;
			}
			if (i==Jogo.portas.size()-1) {
				caminho = caminho + "icones/parede.png";
			}
		}
		}
		if (Jogo.jogadordavez==2) {
			for (int i=0;i<Jogo.portas.size();i++) {
				if (Jogo.portas.get(i).getLocal().get(0)==Jogo.pj2.get(0)&&Jogo.portas.get(i).getLocal().get(1)==Jogo.pj2.get(1)) {
					caminho = caminho + "icones/p"+Jogo.portas.get(i).getCor()+".png";
					break;
				}
				if (i==Jogo.portas.size()-1) {
					caminho = caminho + "icones/parede.png";
				}
			}
			}
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		objeto.setImage(image);
	}
	@FXML
	void onclickok(ActionEvent event) throws IOException {
		
	}
	@FXML
	void onclicklargar(ActionEvent event) throws IOException {
		
	}
	@FXML
	void onclickusar(ActionEvent event) throws IOException {
		
	}
	@FXML
	void onclickpegar(ActionEvent event) throws IOException {
		
	}
	@FXML
	void onclickabrir(ActionEvent event) throws IOException {
		
	}
	@FXML
	void onclickajuda(ActionEvent event) throws IOException {
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + "background/controls.png";
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		objeto.setImage(image);
	}
	@FXML
	void onclickvoltar(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Game.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
}
