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
import regras.Salas;

public class ControllerSala {
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ImageView background;
	@FXML
	private Button sala1;
	@FXML
	private Button sala2;
	@FXML
	private Button sala3;
	@FXML
	private Button sala4;
	@FXML
	private Button sala5;
	@FXML
	private Button voltar;
	@FXML
    void initialize() throws IOException{
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + "background/salas.png";
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		background.setImage(image);
	}
	@FXML
	void onclicksala1(ActionEvent event) throws IOException {
		Salas.numeroSala="I";
		AnchorPane pane = FXMLLoader.load(getClass().getResource("SalaSelecionada.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
	@FXML
	void onclicksala2(ActionEvent event) throws IOException {
		Salas.numeroSala="II";
		AnchorPane pane = FXMLLoader.load(getClass().getResource("SalaSelecionada.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
	@FXML
	void onclicksala3(ActionEvent event) throws IOException {
		Salas.numeroSala="III";
		AnchorPane pane = FXMLLoader.load(getClass().getResource("SalaSelecionada.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
	@FXML
	void onclicksala4(ActionEvent event) throws IOException {
		Salas.numeroSala="IV";
		AnchorPane pane = FXMLLoader.load(getClass().getResource("SalaSelecionada.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
	@FXML
	void onclicksala5(ActionEvent event) throws IOException {
		Salas.numeroSala="V";
		AnchorPane pane = FXMLLoader.load(getClass().getResource("SalaSelecionada.fxml"));
		anchorpane.getChildren().setAll(pane);
		
	}
	@FXML
	void onclickvoltar(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		anchorpane.getChildren().setAll(pane);
	}
	
}
