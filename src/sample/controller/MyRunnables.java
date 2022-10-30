package sample.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

class MyRunnables implements Runnable {


    @FXML
    ProgressBar pBar;

    private double progress;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(20);
                progress = i / 1000;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        pBar.setProgress(progress);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}