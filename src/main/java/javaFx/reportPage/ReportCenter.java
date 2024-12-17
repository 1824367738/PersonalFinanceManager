package javaFx.reportPage;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ReportCenter {
    public Node getReportCenter(Stage stage) {
        BorderPane reportCenterPane = new BorderPane();

        Region spacerLeft = new Region();
        spacerLeft.setMinWidth(20);
        reportCenterPane.setLeft(spacerLeft);
        Region spacerTop = new Region();
        spacerTop.setMinHeight(20);
        reportCenterPane.setTop(spacerTop);

        VBox context = new VBox(20);

        Label title = new Label("报表 Report");
        title.setFont(Font.font("黑体",25));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white; ");

        context.getChildren().addAll(title);
        reportCenterPane.setCenter(context);
        return reportCenterPane;
    }
}
