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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    void initialize() throws IOException{
		sala.setText(Salas.numeroSala);
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + "background/salaescolhida.png";
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		background.setImage(image);
	}
	@FXML
	void onclickiniciar(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Game.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
	@FXML
	void onclickvoltar(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Sala.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
}
