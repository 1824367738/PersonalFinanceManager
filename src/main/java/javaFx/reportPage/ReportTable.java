package javaFx.reportPage;

import javaFx.SceneController;
import javaFx.SidebarPane;
import javaFx.StartMain;
import javaFx.TitlePane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ReportTable {
    public Scene getReportScene(Stage stage) {
        BorderPane reportPane = new BorderPane();
        reportPane.setStyle("-fx-background-color: #25292F; -fx-background-radius: 3; -fx-border-width: 2; -fx-border-color: #616770; -fx-border-radius: 3;");

        Node titlePane = TitlePane.getTitlePane(stage, StartMain.currentWidth,StartMain.currentHeight);
        Node sidebarPane = SidebarPane.getSidebarPane(stage,4);
        ReportCenter reportCenter = new ReportCenter();
        Node center = reportCenter.getReportCenter(stage);

        reportPane.setTop(titlePane);
        reportPane.setLeft(sidebarPane);
        reportPane.setCenter(center);

        Scene reportScene = new Scene(reportPane,StartMain.currentWidth,StartMain.currentHeight);
        reportScene.setFill(Color.TRANSPARENT);
        SceneController.makeStageDraggable(stage,reportScene);
        return reportScene;
    }
}
