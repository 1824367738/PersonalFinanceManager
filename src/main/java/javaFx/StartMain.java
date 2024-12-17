package javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class StartMain extends Application {
    public static int stageWidth = 1200;
    public static int stageHeight = 800;
    public static double currentWidth = 1200;
    public static double currentHeight = 800;
    public static boolean isMaximized = false;
    public static String currentPage = "login";
    public static double startX;
    public static double startY;

    @Override
    public void start(Stage stage) throws Exception {
        LoginTable loginTable = new LoginTable();
        Scene scene = loginTable.getLoginTable(stage);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
