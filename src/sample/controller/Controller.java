package sample.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import sample.model.Model;
import sample.model.api.ModelAPI;
import sample.model.api.Updatable;


public class Controller {
    @FXML
    ProgressBar pBar;
    double progress;
    /*Thread myTreadRunnableThread = new Thread(new Runnable() {
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
    });*/

    @FXML
    private Button button;



    //MyThreads progressThread = new MyThreads();

    @FXML
    private void StartProgress() {
        ModelAPI model = new Model();
        model.asyncCalcProgress(10000, new Updatable() {
            @Override
            public void update(double value) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Thread tInner = Thread.currentThread();
                        pBar.setProgress(model.calcProgress(value, 10000));
                    }
                });
            }
        });
    }

}


