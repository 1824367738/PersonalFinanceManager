package javaFx.budgetPage;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BudgetCenter {
    public Node getBudgetCenter(Stage stage) {
        BorderPane budgetCenterPane = new BorderPane();

        Region spacerLeft = new Region();
        spacerLeft.setMinWidth(20);
        budgetCenterPane.setLeft(spacerLeft);
        Region spacerTop = new Region();
        spacerTop.setMinHeight(20);
        budgetCenterPane.setTop(spacerTop);

        VBox context = new VBox(20);

        Label title = new Label("预算 Budget");
        title.setFont(Font.font("黑体",25));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white; ");

        context.getChildren().addAll(title);
        budgetCenterPane.setCenter(context);
        return budgetCenterPane;
    }
}
