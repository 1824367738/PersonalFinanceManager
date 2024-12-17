package javaFx;

import javaFx.billPage.BillTable;
import javaFx.budgetPage.BudgetTable;
import javaFx.homePage.HomeTable;
import javaFx.reportPage.ReportTable;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonFactory {
    public static Button getCloseButton(int Height, int Width) {
        Image closeImg = new Image("close.png");
        ImageView closeImgView = new ImageView(closeImg);

        closeImgView.setFitHeight(12);
        closeImgView.setFitWidth(12);

        Button closeButton = new Button(null,closeImgView);
        closeButton.setStyle("-fx-background-color: #25292F; " +
                "-fx-border-width: 0px; " +
                "-fx-border-radius: 5; " +
                "-fx-background-radius: 5px;");
        closeButton.setMinHeight(Height);
        closeButton.setMinWidth(Width);
        closeButton.setOnAction(e -> {
            Platform.exit();
        });
        closeButton.setOnMouseEntered(e -> {
            closeButton.setStyle("-fx-background-color: #DB5C5C ");
        });
        closeButton.setOnMouseExited(e -> {
            closeButton.setStyle("-fx-background-color: #25292F ");
        });
        return closeButton;
    }

    public static Button getIconifyButton(int Height, int Width) {
        Image iconifyImg = new Image("iconify.png");
        ImageView iconifyImgView = new ImageView(iconifyImg);

        iconifyImgView.setFitHeight(12);
        iconifyImgView.setFitWidth(12);

        Button iconifyButton = new Button(null,iconifyImgView);
        iconifyButton.setStyle("-fx-background-color: #25292F; " +
                "-fx-border-width: 0px; " +
                "-fx-border-radius: 0; " +
                "-fx-background-radius: 0px;");
        iconifyButton.setMinHeight(Height);
        iconifyButton.setMinWidth(Width);
        iconifyButton.setOnMouseEntered(e -> {
            iconifyButton.setStyle("-fx-background-color: #595F69 ");
        });
        iconifyButton.setOnMouseExited(e -> {
            iconifyButton.setStyle("-fx-background-color: #25292F ");
        });
        return iconifyButton;
    }

    public static Button getMaximuzeButton(int Height, int Width) {
        Image maximizeImg;
        if(StartMain.isMaximized) {
            maximizeImg = new Image("reset-window-size.png");
        }
        else {
            maximizeImg = new Image("maximize.png");
        }

        ImageView maximizeImgView = new ImageView(maximizeImg);
        maximizeImgView.setFitHeight(12);
        maximizeImgView.setFitWidth(12);

        Button maximizeButton = new Button(null,maximizeImgView);
        maximizeButton.setStyle("-fx-background-color: #25292F; " +
                "-fx-border-width: 0px; " +
                "-fx-border-radius: 0; " +
                "-fx-background-radius: 0px;");
        maximizeButton.setMinHeight(Height);
        maximizeButton.setMinWidth(Width);
        maximizeButton.setOnMouseEntered(e -> {
            maximizeButton.setStyle("-fx-background-color: #595F69 ");
        });
        maximizeButton.setOnMouseExited(e -> {
            maximizeButton.setStyle("-fx-background-color: #25292F ");
        });
        return maximizeButton;
    }

    public static Button getHomeButton(Stage stage,int width,int height) {
        Button button = new Button(" 主页\nHome");
        button.setMinWidth(width);
        button.setMinHeight(height);

        button.setFont(Font.font("黑体",14));
        button.setStyle("-fx-font-weight: bold; " +
                "-fx-text-fill: white; " +
                "-fx-border-width: 0px; " +
                "-fx-background-color: transparent");

        button.setOnMouseEntered(e -> {
            button.setCursor(Cursor.HAND);
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnMouseExited(e -> {
            button.setCursor(Cursor.DEFAULT);
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: transparent");
        });
        button.setOnMousePressed(e -> {
            button.setStyle("-fx-font-size: 13px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnMouseReleased(e -> {
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnAction(e -> {
            System.out.println("Change to Home");
            HomeTable homeTable = new HomeTable();
            Scene homeScene = homeTable.getHomeScene(stage);
            stage.setScene(homeScene);
            StartMain.currentPage = "home";
        });

        return button;
    }
    public static Button getBudgetButton(Stage stage,int width,int height) {
        Button button = new Button("  预算\nBudget");
        button.setMinWidth(width);
        button.setMinHeight(height);

        button.setFont(Font.font("黑体",14));
        button.setStyle("-fx-font-weight: bold; " +
                "-fx-text-fill: white; " +
                "-fx-border-width: 0px; " +
                "-fx-background-color: transparent");

        button.setOnMouseEntered(e -> {
            button.setCursor(Cursor.HAND);
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnMouseExited(e -> {
            button.setCursor(Cursor.DEFAULT);
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: transparent");
        });
        button.setOnMousePressed(e -> {
            button.setStyle("-fx-font-size: 13px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnMouseReleased(e -> {
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnAction(e -> {
            System.out.println("Change to Budget");
            BudgetTable budgetTable = new BudgetTable();
            Scene budgetScene = budgetTable.getBudgetScene(stage);
            stage.setScene(budgetScene);
            StartMain.currentPage = "budget";
        });

        return button;
    }
    public static Button getBillButton(Stage stage,int width,int height) {
        Button button = new Button("账单\nBill");
        button.setMinWidth(width);
        button.setMinHeight(height);

        button.setFont(Font.font("黑体",14));
        button.setStyle("-fx-font-weight: bold; " +
                "-fx-text-fill: white; " +
                "-fx-border-width: 0px; " +
                "-fx-background-color: transparent");

        button.setOnMouseEntered(e -> {
            button.setCursor(Cursor.HAND);
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnMouseExited(e -> {
            button.setCursor(Cursor.DEFAULT);
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: transparent");
        });
        button.setOnMousePressed(e -> {
            button.setStyle("-fx-font-size: 13px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnMouseReleased(e -> {
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnAction(e -> {
            System.out.println("Change to Bill");
            BillTable billTable = new BillTable();
            Scene billScene = billTable.getBillScene(stage);
            stage.setScene(billScene);
            StartMain.currentPage = "bill";
        });

        return button;
    }
    public static Button getReportButton(Stage stage,int width,int height) {
        Button button = new Button("  报表\nReport");
        button.setMinWidth(width);
        button.setMinHeight(height);

        button.setFont(Font.font("黑体",14));
        button.setStyle("-fx-font-weight: bold; " +
                "-fx-text-fill: white; " +
                "-fx-border-width: 0px; " +
                "-fx-background-color: transparent");

        button.setOnMouseEntered(e -> {
            button.setCursor(Cursor.HAND);
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnMouseExited(e -> {
            button.setCursor(Cursor.DEFAULT);
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: transparent");
        });
        button.setOnMousePressed(e -> {
            button.setStyle("-fx-font-size: 13px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnMouseReleased(e -> {
            button.setStyle("-fx-font-size: 14px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 0px; " +
                    "-fx-background-radius: 0; " +
                    "-fx-background-color: #595F69");
        });
        button.setOnAction(e -> {
            System.out.println("Change to Report");
            ReportTable reportTable = new ReportTable();
            Scene reportScene = reportTable.getReportScene(stage);
            stage.setScene(reportScene);
            StartMain.currentPage = "report";
        });

        return button;
    }
}
