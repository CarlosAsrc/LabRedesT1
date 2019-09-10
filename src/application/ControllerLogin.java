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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ControllerLogin {

	@FXML
	private AnchorPane anchorpane;
	@FXML
	private ImageView background;
	@FXML
	private Label lLogin;
	@FXML
	private Label lSenha;
	@FXML
	private TextField login = new TextField();
	@FXML
	private PasswordField senha = new PasswordField();
	@FXML
	private Button entrar;

	@FXML
	void initialize() throws IOException {
		String caminho = regras.Arquivo.montarCaminho();
		caminho = caminho + "background/login.png";
		File file = new File(caminho);
		BufferedImage bufferedImage = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		background.setImage(image);

	}

	@FXML
	void onclickentrar(ActionEvent event) throws IOException {
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		anchorpane.getChildren().setAll(pane);

	}

}
