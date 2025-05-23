package View;
import Service.BookingSchedulerService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/FXML/DangNhap/Login.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            BookingSchedulerService.shutdown();
        }));
    }
    public static void main(String[] args) {
        launch(args);
    }
}
