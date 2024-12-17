package javaFx;

import javaFx.billPage.BillTable;
import javaFx.budgetPage.BudgetTable;
import javaFx.homePage.HomeTable;
import javaFx.reportPage.ReportTable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TitlePane {
    public static Node getTitlePane(Stage stage,double stageWidth, double stageHeight) {
        Button closeButton = ButtonFactory.getCloseButton(35, 40);
        Button maximizeButton = ButtonFactory.getMaximuzeButton(35,40);
        Button iconifyButton = ButtonFactory.getIconifyButton(35,40);
        iconifyButton.setOnAction(e -> {
            stage.setIconified(true);
        });
        maximizeButton.setOnAction(e -> {
            boolean isMaximized = StartMain.isMaximized;
            if (isMaximized) {
                stage.setX(StartMain.startX);
                stage.setY(StartMain.startY);
                stage.setWidth(StartMain.stageWidth);
                stage.setHeight(StartMain.stageHeight);
                StartMain.currentWidth = StartMain.stageWidth;
                StartMain.currentHeight = StartMain.stageHeight;
                StartMain.isMaximized = false;
            }
            else {
                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                // 设置窗口尺寸为屏幕可视区域大小
                StartMain.startX = stage.getX();
                StartMain.startY = stage.getY();
                stage.setX(screenBounds.getMinX());
                stage.setY(screenBounds.getMinY());
                stage.setWidth(screenBounds.getWidth());
                stage.setHeight(screenBounds.getHeight());
                StartMain.currentWidth = screenBounds.getWidth();
                StartMain.currentHeight = screenBounds.getHeight();
                StartMain.isMaximized = true;
            }
            switch (StartMain.currentPage) {
                case "login" -> {
                    LoginTable loginTable = new LoginTable();
                    Scene loginScene = loginTable.getLoginTable(stage);
                    stage.setScene(loginScene);
                }
                case "register" -> {
                    RegisterTable registerTable = new RegisterTable();
                    Scene registerScene = registerTable.getRegisterTable(stage);
                    stage.setScene(registerScene);
                }
                case "home" -> {
                    HomeTable homeTable = new HomeTable();
                    Scene homeScene = homeTable.getHomeScene(stage);
                    stage.setScene(homeScene);
                }
                case "budget" -> {
                    BudgetTable budgetTable = new BudgetTable();
                    Scene budgetScene = budgetTable.getBudgetScene(stage);
                    stage.setScene(budgetScene);
                }
                case "bill" -> {
                    BillTable billTable = new BillTable();
                    Scene billScene = billTable.getBillScene(stage);
                    stage.setScene(billScene);
                }
                case "report" -> {
                    ReportTable reportTable = new ReportTable();
                    Scene reportScene = reportTable.getReportScene(stage);
                    stage.setScene(reportScene);
                }
            }
        });
        Region spacer = new Region();
        spacer.setMinHeight(35);
        spacer.setMinWidth(120);
        Label titleLabel = new Label("个人财务管理系统");
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setFont(Font.font("黑体",18));
        titleLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #FFFFFF;");
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.TOP_RIGHT);
        topBox.getChildren().addAll(iconifyButton,maximizeButton,closeButton);

        Line topLine = new Line();
        topLine.setStartX(10);
        topLine.setEndX(stageWidth-10);
        topLine.setStartY(50);
        topLine.setEndY(50);
        topLine.setStroke(Color.web("#525861"));
        topLine.setStrokeWidth(1.5);
        Region topLineSpacer = new Region();
        topLineSpacer.setMinHeight(10);
        StackPane linePane = new StackPane();
        linePane.getChildren().addAll(topLineSpacer,topLine);

        BorderPane topTitle = new BorderPane();
        StackPane titlePane = new StackPane();
        titlePane.getChildren().add(titleLabel);
        topTitle.setCenter(titleLabel);
        topTitle.setRight(topBox);
        topTitle.setLeft(spacer);
        topTitle.setBottom(linePane);

        return topTitle;
    }
}
