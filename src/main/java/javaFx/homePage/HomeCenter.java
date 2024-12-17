package javaFx.homePage;

import javaFx.SceneController;
import javaFx.StartMain;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

public class HomeCenter {
    private double translateY = 0;
    public Node getHomeCenter(Stage stage) {
        BorderPane homeCenterPane = new BorderPane();

        Region spacerLeft = new Region();
        spacerLeft.setMinWidth(20);
        homeCenterPane.setLeft(spacerLeft);
        Region spacerTop = new Region();
        spacerTop.setMinHeight(20);
        homeCenterPane.setTop(spacerTop);

        VBox context = new VBox(15);

        Label title = new Label("今天你理财了吗？");
        title.setFont(Font.font("黑体",25));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white; ");

        Line topLine = new Line();
        topLine.setStartX(120+5);
        topLine.setEndX(StartMain.currentWidth-5);
        topLine.setStroke(Color.web("#525861"));
        topLine.setStrokeWidth(1);

        VBox contextVBox = new VBox(10);
        contextVBox.setStyle("-fx-background-color: #25292F");  //transparent
        //总述
        //总资产 近一周总收入 总支出
        HBox sumPropertyBox = new HBox(10);
        sumPropertyBox.setAlignment(Pos.BOTTOM_LEFT);
        Label sumPropertyLabel = new Label("你的总资产：");
        sumPropertyLabel.setFont(Font.font("黑体", FontWeight.BOLD,25));
        sumPropertyLabel.setTextFill(Color.WHITE);
        double sumProperty = SceneController.getSumProperty();
        Label sumPropertyShow = new Label("￥" + Double.toString(sumProperty));
        sumPropertyShow.setStyle("-fx-font-family: \"黑体\"; -fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");
        sumPropertyBox.getChildren().addAll(sumPropertyLabel,sumPropertyShow);

        HBox sumIOHbox = new HBox(30);
        Label inOneWeekLabel = new Label("在近一周内 ");
        inOneWeekLabel.setFont(Font.font("黑体",FontWeight.BOLD,20));
        inOneWeekLabel.setTextFill(Color.WHITE);
        Label weekIncomeLabel = new Label("总收入：" + SceneController.getWeekIncome());
        weekIncomeLabel.setFont(Font.font("黑体",20));
        weekIncomeLabel.setTextFill(Color.web("#599E5E"));
        Label weekOutcomeLabel = new Label("总支出：" + SceneController.getWeekOutcome());
        weekOutcomeLabel.setFont(Font.font("黑体",20));
        weekOutcomeLabel.setTextFill(Color.web("#C94F4F"));
        sumIOHbox.getChildren().addAll(inOneWeekLabel,weekIncomeLabel,weekOutcomeLabel);

        HBox summaryBlock = getSummaryBlock();
        //近一周收支曲线

        //预算|剩余

        contextVBox.getChildren().addAll(sumPropertyBox,sumIOHbox, summaryBlock);

        BorderPane contextBorder = new BorderPane();
        //contextBorder.setStyle("-fx-background-color: #25292F");
        Region spacerContext = new Region();
        spacerContext.setMinWidth(10);
        contextBorder.setLeft(spacerContext);
        contextBorder.setCenter(contextVBox);

        ScrollPane scrollPane = new ScrollPane(contextVBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPannable(false);  //不可以拖动
        //scrollPane.setMinHeight(StartMain.currentHeight-100-75);

        context.getChildren().addAll(title,topLine,scrollPane);
        homeCenterPane.setCenter(context);
        return homeCenterPane;
    }

    private HBox getSummaryBlock() {    // HBox includes: SumProperty, PeriodInOut, BudgetLast
        HBox summaryBlockBox = new HBox(50);
        summaryBlockBox.setStyle("-fx-padding: 20;"); // 添加内边距
        summaryBlockBox.setAlignment(Pos.CENTER);

        double blockWidth = StartMain.currentWidth - 300;

        //SumProperty
        StackPane SumPropertyBlock = new StackPane();

        Rectangle SPRectangle = new Rectangle(blockWidth / 3, 100);
        SPRectangle.getStyleClass().add("rounded-rectangle");
        SPRectangle.setStyle("-fx-fill: #0FCDFB; -fx-stroke: #1E5C6F;");


        //PeriodInOut
        Rectangle PIORectangle = new Rectangle(blockWidth / 3, 100);
        PIORectangle.setStrokeWidth(0);
        PIORectangle.setFill(Color.web("#60D6D6"));

        //BudgetLast
        Rectangle BLRectangle = new Rectangle(blockWidth / 3, 100);
        BLRectangle.setStrokeWidth(0);
        BLRectangle.setFill(Color.web("#0087D9"));

        summaryBlockBox.getChildren().addAll(SPRectangle, PIORectangle, BLRectangle);
        return summaryBlockBox;
    }
}