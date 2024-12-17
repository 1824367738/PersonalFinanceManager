package javaFx.billPage;

import javaFx.SceneController;
import javaFx.SidebarPane;
import javaFx.StartMain;
import javaFx.TitlePane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BillTable {
    public Scene getBillScene(Stage stage) {
        BorderPane billPane = new BorderPane();
        billPane.setStyle("-fx-background-color: #25292F; -fx-background-radius: 3; -fx-border-width: 2; -fx-border-color: #616770; -fx-border-radius: 3;");

        Node titlePane = TitlePane.getTitlePane(stage, StartMain.currentWidth,StartMain.currentHeight);
        Node sidebarPane = SidebarPane.getSidebarPane(stage,3);
        BillCenter billCenter = new BillCenter();
        Node center = billCenter.getBillCenter(stage);

        billPane.setTop(titlePane);
        billPane.setLeft(sidebarPane);
        billPane.setCenter(center);

        Scene billScene = new Scene(billPane,StartMain.currentWidth,StartMain.currentHeight);
        billScene.setFill(Color.TRANSPARENT);
        SceneController.makeStageDraggable(stage,billScene);
        return billScene;
    }
}
