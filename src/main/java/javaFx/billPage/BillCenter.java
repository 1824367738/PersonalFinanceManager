package javaFx.billPage;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BillCenter {
    public Node getBillCenter(Stage stage) {
        BorderPane billCenterPane = new BorderPane();

        Region spacerLeft = new Region();
        spacerLeft.setMinWidth(20);
        billCenterPane.setLeft(spacerLeft);
        Region spacerTop = new Region();
        spacerTop.setMinHeight(20);
        billCenterPane.setTop(spacerTop);

        VBox context = new VBox(20);

        Label title = new Label("账单 Bill");
        title.setFont(Font.font("黑体",25));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white; ");

        context.getChildren().addAll(title);
        billCenterPane.setCenter(context);
        return billCenterPane;
    }
}
