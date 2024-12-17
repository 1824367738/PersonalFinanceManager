package javaFx.budgetPage;

import javaFx.SceneController;
import javaFx.SidebarPane;
import javaFx.StartMain;
import javaFx.TitlePane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BudgetTable {
    public Scene getBudgetScene(Stage stage) {
        BorderPane budgetPane = new BorderPane();
        budgetPane.setStyle("-fx-background-color: #25292F; -fx-background-radius: 3; -fx-border-width: 2; -fx-border-color: #616770; -fx-border-radius: 3;");

        Node titlePane = TitlePane.getTitlePane(stage, StartMain.currentWidth,StartMain.currentHeight);
        Node sidebarPane = SidebarPane.getSidebarPane(stage,2);
        BudgetCenter budgetCenter = new BudgetCenter();
        Node center = budgetCenter.getBudgetCenter(stage);

        budgetPane.setTop(titlePane);
        budgetPane.setLeft(sidebarPane);
        budgetPane.setCenter(center);

        Scene budgetScene = new Scene(budgetPane,StartMain.currentWidth,StartMain.currentHeight);
        budgetScene.setFill(Color.TRANSPARENT);
        SceneController.makeStageDraggable(stage,budgetScene);
        return budgetScene;
    }
}
