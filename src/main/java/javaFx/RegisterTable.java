package javaFx;

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

public class RegisterTable {

    public Scene getRegisterTable(Stage stage) {
        StackPane registerPane = new StackPane();

        Label startLabel = new Label("注册你的账户");
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

        // 创建确认密码标签和密码框
        Label confirmLabel = new Label("确认密码： ");
        confirmLabel.setFont(Font.font("黑体",15));
        confirmLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #FFFFFF");
        Region spacer5 = new Region();
        spacer5.setMinWidth(185);
        HBox confirmBox = new HBox();
        confirmBox.setAlignment(Pos.CENTER);
        confirmBox.getChildren().addAll(confirmLabel,spacer5);
        PasswordField confirmField = new PasswordField();
        confirmField.setMaxWidth(270);

        Button gotoLoginButton = new Button("已有账号？去登陆");
        gotoLoginButton.setFont(Font.font("宋体",15));
        gotoLoginButton.setMaxHeight(10);
        gotoLoginButton.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-text-fill: #007AFF");
        gotoLoginButton.setOnMouseEntered(e -> {
            gotoLoginButton.setCursor(Cursor.HAND);
        });
        gotoLoginButton.setOnMouseExited(e -> {
            gotoLoginButton.setCursor(Cursor.DEFAULT);
        });
        gotoLoginButton.setOnAction(e -> {
            gotoLogin(stage);
        });

        Button registerButton = new Button("注册");
        registerButton.setFont(Font.font("黑体",15));
        registerButton.setStyle("-fx-font-weight: bold; " +
                "-fx-text-fill: white; " +
                "-fx-border-width: 1px; " +
                "-fx-border-radius: 2px; " +
                "-fx-border-color: #ABB2BF;" +
                "-fx-background-radius: 2px;" +
                "-fx-background-color: #595F69; ");
        registerButton.setMinHeight(35);
        registerButton.setMinWidth(60);
        registerButton.setOnMouseEntered(e -> {
            registerButton.setCursor(Cursor.HAND);
            registerButton.setStyle("-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 1px; " +
                    "-fx-border-radius: 2px; " +
                    "-fx-border-color: #ABB2BF;" +
                    "-fx-background-color: #007AFF; ");
        });
        registerButton.setOnMouseExited(e -> {
            registerButton.setCursor(Cursor.DEFAULT);
            registerButton.setStyle("-fx-font-weight: bold; " +
                    "-fx-text-fill: white; " +
                    "-fx-border-width: 1px; " +
                    "-fx-border-radius: 2px; " +
                    "-fx-border-color: #ABB2BF;" +
                    "-fx-background-color: #595F69; ");
        });
        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String confirmPw = confirmField.getText();
            pressRegisterButton(stage,username,password,confirmPw);
        });

        Region spacer3 = new Region();
        spacer3.setMinHeight(20);

        VBox registerBox = new VBox(15);
        registerBox.setAlignment(Pos.CENTER);

        registerBox.getChildren().addAll(startLabel,spacer4,
                usernameBox,usernameField,
                passwordBox,passwordField,
                confirmBox,confirmField,
                gotoLoginButton,
                spacer3,registerButton);

        Rectangle registerBackGround = new Rectangle();
        registerBackGround.setHeight(500);
        registerBackGround.setWidth(350);
        registerBackGround.setFill(Color.web("#3B4047"));
        registerBackGround.setArcHeight(7);
        registerBackGround.setArcWidth(7);
        registerBackGround.setStroke(Color.web("#525861"));
        registerBackGround.setStrokeWidth(2);

        registerPane.getChildren().addAll(registerBackGround,registerBox);

        registerPane.setTranslateY(500);

        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.75),registerPane);
        transition.setByY(-500);
        transition.play();

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #25292F; -fx-background-radius: 3; -fx-border-width: 2; -fx-border-color: #616770; -fx-border-radius: 3;");

        Node titlePane = TitlePane.getTitlePane(stage, StartMain.currentWidth, StartMain.currentHeight);
        root.setTop(titlePane);
        root.setCenter(registerPane);

        Scene registerScene = new Scene(root, StartMain.currentWidth, StartMain.currentHeight);
        registerScene.setFill(Color.TRANSPARENT);

        SceneController.makeStageDraggable(stage,registerScene);

        return registerScene;
    }

    public void pressRegisterButton(Stage stage, String username, String password, String confirmPw) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(confirmPw);
    }

    public void gotoLogin(Stage stage) {
        LoginTable loginTable = new LoginTable();
        Scene loginScene = loginTable.getLoginTable(stage);
        stage.setScene(loginScene);
        StartMain.currentPage = "login";
    }
}
