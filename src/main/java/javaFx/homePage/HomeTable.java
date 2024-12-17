package javaFx.homePage;

import javaFx.SceneController;
import javaFx.SidebarPane;
import javaFx.StartMain;
import javaFx.TitlePane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomeTable {
    public Scene getHomeScene(Stage stage) {
        BorderPane homePane = new BorderPane();
        homePane.setStyle("-fx-background-color: #25292F; -fx-background-radius: 3; -fx-border-width: 2; -fx-border-color: #616770; -fx-border-radius: 3;");

        Node titlePane = TitlePane.getTitlePane(stage, StartMain.currentWidth,StartMain.currentHeight);
        Node sidebarPane = SidebarPane.getSidebarPane(stage,1);
        HomeCenter homeCenter = new HomeCenter();
        Node center = homeCenter.getHomeCenter(stage);

        homePane.setTop(titlePane);
        homePane.setLeft(sidebarPane);
        homePane.setCenter(center);

        Scene homeScene = new Scene(homePane,StartMain.currentWidth,StartMain.currentHeight);
        homeScene.setFill(Color.TRANSPARENT);
        SceneController.makeStageDraggable(stage,homeScene);
        homeScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        return homeScene;
    }
}
