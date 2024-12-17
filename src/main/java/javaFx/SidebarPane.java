package javaFx;

import javaFx.reportPage.ReportTable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SidebarPane {
    public static Node getSidebarPane(Stage stage,int op) {
        BorderPane sidebarPane = new BorderPane();

        Region spacer1 = new Region();
        spacer1.setMinHeight(0);

        Line line1 = new Line();
        line1.setStartX(80);
        line1.setEndX(80);
        line1.setStartY(11+(op-1)*71.5);
        line1.setEndY(60+(op-1)*71.5);
        line1.setStroke(Color.web("#FFFFFF"));
        line1.setStrokeWidth(2);
        Pane chooseLine = new Pane();
        chooseLine.getChildren().add(line1);

        Button homeButton = ButtonFactory.getHomeButton(stage,70,50);
        Button budgetButton = ButtonFactory.getBudgetButton(stage,70,50);
        Button billButton = ButtonFactory.getBillButton(stage,70,50);
        Button reportButton = ButtonFactory.getReportButton(stage,70,50);

        Line littleLine1 = new Line();
        littleLine1.setStartX(40);
        littleLine1.setEndX(80);
        littleLine1.setStroke(Color.web("#525861"));
        littleLine1.setStrokeWidth(1);
        Line littleLine2 = new Line();
        littleLine2.setStartX(40);
        littleLine2.setEndX(80);
        littleLine2.setStroke(Color.web("#525861"));
        littleLine2.setStrokeWidth(1);
        Line littleLine3 = new Line();
        littleLine3.setStartX(40);
        littleLine3.setEndX(80);
        littleLine3.setStroke(Color.web("#525861"));
        littleLine3.setStrokeWidth(1);

        VBox sidebarBox = new VBox(10);
        sidebarBox.setAlignment(Pos.TOP_CENTER);
        sidebarBox.getChildren().addAll(spacer1,homeButton,
                littleLine1,budgetButton,
                littleLine2,billButton,
                littleLine3,reportButton);

        Region spacer2 = new Region();
        spacer2.setMinWidth(90);

        StackPane sidebarStack = new StackPane();
        sidebarStack.getChildren().addAll(chooseLine,spacer2,sidebarBox);

        Line sideLine = new Line();
        sideLine.setStartX(120);
        sideLine.setEndX(120);
        sideLine.setStartY(50);
        sideLine.setEndY(StartMain.currentHeight - 10);
        sideLine.setStroke(Color.web("#525861"));
        sideLine.setStrokeWidth(1.5);

        sidebarPane.setCenter(sidebarStack);
        sidebarPane.setRight(sideLine);

        return sidebarPane;
    }
}
