package javaFx;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    public static double offsetX,offsetY;
    public static void makeStageDraggable(Stage stage, Scene root) {
        root.setOnMousePressed(event -> {
            offsetX = event.getSceneX();  // 记录鼠标相对窗口的X坐标
            offsetY = event.getSceneY();  // 记录鼠标相对窗口的Y坐标
        });

        root.setOnMouseDragged(event -> {
            if (offsetY <= 50) {
                stage.setX(event.getScreenX() - offsetX);  // 更新窗口的X位置
                stage.setY(event.getScreenY() - offsetY);  // 更新窗口的Y位置
            }
        });

    }

    public static boolean userLogin(Stage stage, String username, String password) {
        return true;
    }

    public static double getSumProperty() {
        return 1145.14;
    }

    public static double getWeekIncome() {
        return 520.00;
    }

    public static double getWeekOutcome() {
        return 1314.00;
    }
}
