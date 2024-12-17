package javaFx;

import javaFx.homePage.HomeTable;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginTable {

    public Scene getLoginTable(Stage stage) {
        StackPane loginPane = new StackPane();

        Label startLabel = new Label("开始使用吧");
        startLabel.setFont(Font.font("黑体",30));
        startLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #FFFFFF");
        Region spacer4 = new Region();
        spacer4.setMinHeight(20);

        // 创建用户名标签和文本框
        Label usernameLabel = new Label("用户名： ");
        usernameLabel.setFont(Font.font("黑体",15));
        usernameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #FFFFFF");
        Region spacer1 = new Region();
        spacer1.setMinWidth(200);
        HBox usernameBox = new HBox();
        usernameBox.setAlignment(Pos.CENTER);
        usernameBox.getChildren().addAll(usernameLabel,spacer1);
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(270);

        // 创建密码标签和密码框
        Label passwordLabel = new Label("密码：     ");
        passwordLabel.setFont(Font.font("黑体",15));
        passwordLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #FFFFFF");
        Region spacer2 = new Region();
        spacer2.setMinWidth(200);
        HBox passwordBox = new HBox();
        passwordBox.setAlignment(Pos.CENTER);
        passwordBox.getChildren().addAll(passwordLabel,spacer2);
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(270);

        Button gotoRegisterButton = new Button("没有账号？去注册一个");
        gotoRegisterButton.setFont(Font.font("宋体",15));
        gotoRegisterButton.setMaxHeight(10);
        gotoRegisterButton.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-text-fill: #007AFF");
        gotoRegisterButton.setOnMouseEntered(e -> {
            gotoRegisterButton.setCursor(Cursor.HAND);
        });
        gotoRegisterButton.setOnMouseExited(e -> {
            gotoRegisterButton.setCursor(Cursor.DEFAULT);
        });
        gotoRegisterButton.setOnAction(e -> {
            gotoRegister(stage);
        });

        Button loginButton = new Button("登录");
        loginButton.setFont(Font.font("黑体",15));
        loginButton.setStyle("-fx-font-weight: bold; " +
                "-fx-text-fill: white; " +
                "-fx-border-width: 1px; " +
                "-fx-border-radius: 2px; " +
                "-fx-border-color: #ABB2BF;" +
                "-fx-background-radius: 2px;" +
                "-fx-background-color: #595F69; ");
        loginButton.setMinHeight(35);
        loginButton.setMinWidth(60);
        loginButton.setOnMouseEntered(e -> {
            loginButton.setCursor(Cursor.HAND);
            loginButton.setStyle("-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 1px; " +
                    "-fx-border-radius: 2px; " +
                    "-fx-border-color: #ABB2BF;" +
                    "-fx-background-color: #007AFF; ");
        });
        loginButton.setOnMouseExited(e -> {
            loginButton.setCursor(Cursor.DEFAULT);
            loginButton.setStyle("-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 1px; " +
                    "-fx-border-radius: 2px; " +
                    "-fx-border-color: #ABB2BF;" +
                    "-fx-background-color: #595F69; ");
        });
        loginButton.setOnAction(e -> {
            String nameInput = usernameField.getText();
            String passwordInput = passwordField.getText();
            pressLoginButton(stage,nameInput,passwordInput);
        });

        Region spacer3 = new Region();
        spacer3.setMinHeight(20);

        VBox loginBox = new VBox(15);
        loginBox.setAlignment(Pos.CENTER);

        loginBox.getChildren().addAll(startLabel,spacer4,
                usernameBox,usernameField,
                passwordBox,passwordField,
                gotoRegisterButton,
                spacer3,loginButton);

        Rectangle loginBackGround = new Rectangle();
        loginBackGround.setHeight(500);
        loginBackGround.setWidth(350);
        loginBackGround.setFill(Color.web("#3B4047"));
        loginBackGround.setArcHeight(7);
        loginBackGround.setArcWidth(7);
        loginBackGround.setStroke(Color.web("#525861"));
        loginBackGround.setStrokeWidth(2);

        loginPane.getChildren().addAll(loginBackGround,loginBox);

        loginPane.setTranslateY(500);

        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.75),loginPane);
        transition.setByY(-500);
        transition.play();

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #25292F; -fx-background-radius: 3; -fx-border-width: 2; -fx-border-color: #616770; -fx-border-radius: 3;");

        Node titlePane = TitlePane.getTitlePane(stage, StartMain.currentWidth, StartMain.currentHeight);
        root.setTop(titlePane);
        root.setCenter(loginPane);

        Scene loginScene = new Scene(root, StartMain.currentWidth, StartMain.currentHeight);
        loginScene.setFill(Color.TRANSPARENT);
        SceneController.makeStageDraggable(stage,loginScene);

        return loginScene;
    }

    public void pressLoginButton(Stage stage,String username, String password) {
        System.out.println(username);
        System.out.println(password);
        if (SceneController.userLogin(stage,username,password))
            gotoHome(stage);
    }

    public void gotoRegister(Stage stage) {
        RegisterTable registerTable = new RegisterTable();
        Scene registerScene = registerTable.getRegisterTable(stage);
        stage.setScene(registerScene);
        StartMain.currentPage = "register";
    }

    public void gotoHome(Stage stage) {
        HomeTable homeTable = new HomeTable();
        Scene homeScene = homeTable.getHomeScene(stage);
        stage.setScene(homeScene);
        StartMain.currentPage = "home";
    }
}
