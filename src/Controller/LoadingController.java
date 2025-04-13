package Controller;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LoadingController {

    @FXML
    private Label statusLabel;

    @FXML
    private ProgressIndicator progressIndicator;

    private boolean wasConnected = true;
    private ScheduledExecutorService internetChecker;

    public void initialize() {
        checkInternetConnection();
    }

    private void checkInternetConnection() {
        new Thread(() -> {
            boolean isConnected = isInternetAvailable();
            Platform.runLater(() -> {
                if (isConnected) {
                    statusLabel.setText("اتصال به اینترنت برقرار است. در حال انتقال به صفحه اصلی...");
                    progressIndicator.setVisible(false);

                    PauseTransition delay = new PauseTransition(Duration.millis(200));
                    delay.setOnFinished(event -> {
                        try {
                            goToMainPage();
                        } catch (IOException e) {
                            showErrorAlert("خطا در تغییر صفحه", "خطا در رفتن به صفحه اصلی: " + e.getMessage());
                        }
                    });
                    delay.play();
                } else {
                    statusLabel.setText("اتصال به اینترنت برقرار نیست. لطفا اتصال اینترنت را بررسی کنید.");
                    progressIndicator.setVisible(false);
                    showRetryExitAlert();
                }
            });
        }).start();
    }

    private void startInternetMonitor() {
        internetChecker = Executors.newSingleThreadScheduledExecutor();
        internetChecker.scheduleAtFixedRate(() -> {
            boolean isConnected = isInternetAvailable();

            if (!isConnected && wasConnected) {
                Platform.runLater(this::showInternetLostAlert);
            }

            wasConnected = isConnected;
        }, 10, 10, TimeUnit.SECONDS);
    }

    private boolean isInternetAvailable() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000);
            int responseCode = connection.getResponseCode();
            return (responseCode == 200);
        } catch (IOException e) {
            return false;
        }
    }
    private void goToMainPage() throws IOException {
        // بررسی مسیر فایل login.fxml
        URL fxmlUrl = getClass().getResource("/views/login.fxml");
        if (fxmlUrl == null) {
            showErrorAlert("خطا", "فایل login.fxml پیدا نشد.");
            return;
        }

        // لود کردن صفحه ورود
        Parent root = FXMLLoader.load(fxmlUrl);
        Stage stage = (Stage) statusLabel.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("JAVAD BANK");

        // نمایش صفحه ورود
        stage.show();

        // قرار دادن صفحه لودینگ در وسط صفحه
        stage.setWidth(850); // تنظیم عرض صفحه
        stage.setHeight(650); // تنظیم ارتفاع صفحه

        // تنظیم موقعیت صفحه در وسط نمایشگر
        double screenWidth = javafx.stage.Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = javafx.stage.Screen.getPrimary().getVisualBounds().getHeight();
        double windowWidth = stage.getWidth();
        double windowHeight = stage.getHeight();

        stage.setX((screenWidth - windowWidth) / 2);
        stage.setY((screenHeight - windowHeight) / 2);

        // بستن صفحه لودینگ
        try {
            Stage currentStage = (Stage) statusLabel.getScene().getWindow();
            currentStage.close();
        }
        catch (Exception exception){

        }


        startInternetMonitor();
    }

    private void showInternetLostAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("قطع اتصال اینترنت");
        alert.setHeaderText("اتصال اینترنت شما قطع شده است!");
        alert.setContentText("لطفاً اتصال خود را بررسی کنید.");

        ButtonType retryButton = new ButtonType("تلاش مجدد");
        ButtonType exitButton = new ButtonType("خروج");

        alert.getButtonTypes().setAll(retryButton, exitButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == retryButton) {
                statusLabel.setText("در حال بررسی اتصال به اینترنت...");
                checkInternetConnection();
            } else if (result.get() == exitButton) {
                Platform.exit();
            }
        }
    }

    private void showRetryExitAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("خطا در اتصال");
        alert.setHeaderText(null);
        alert.setContentText("اتصال به اینترنت برقرار نیست. لطفا اینترنت را بررسی کنید.");

        ButtonType retryButton = new ButtonType("تلاش مجدد");
        ButtonType exitButton = new ButtonType("خروج");

        alert.getButtonTypes().setAll(retryButton, exitButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == retryButton) {
                statusLabel.setText("در حال بررسی اتصال به اینترنت...");
                checkInternetConnection();
            } else if (result.get() == exitButton) {
                Platform.exit();
            }
        }
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
