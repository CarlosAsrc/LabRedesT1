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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ControllerMenu {
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ImageView background;
	@FXML
	private ImageView comandostela;
	
	@FXML
	private Button iniciar;
	@FXML
	private Button comandos;
	@FXML
	private Button sair;
	@FXML
    void initialize() throws IOException{
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + "background/menu.png";
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		background.setImage(image);
	}
	@FXML
	void onclickiniciar(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Sala.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
	@FXML
	void onclickcomandos(ActionEvent event) throws IOException {
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + "background/controls.png";
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		comandostela.setImage(image);
		comandostela.setOpacity(1);
	}
	@FXML
	void onclicksair(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
}
