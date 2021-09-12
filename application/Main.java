package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("covid19-viewer.fxml"));
		primaryStage.setTitle("오픈API 활용 코로나19(Covid-19) 실시간 통계 모듈");
		primaryStage.getIcons().add(new Image("application/android.png"));
		primaryStage.setScene(new Scene(root, 1200, 800));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
