package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import regras.Jogo;
import regras.codigo;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
 
	@Override
	public void start(Stage primaryStage) {
		try {
			//Pane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Pane root = FXMLLoader.load(getClass().getResource("teste.fxml"));

			Scene scene = new Scene(root, 1900, 950);
			primaryStage.setScene(scene);

			primaryStage.show();
			primaryStage.setTitle("GOTA");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Jogo.iniciarposicoes();
		codigo.criaimageview();
	
		launch(args);
	}
}
