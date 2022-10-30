package example.lab.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import example.lab.model.Model;
import example.lab.model.api.ModelAPI;
import example.lab.model.api.Updatable;

public class HelloController {
    @FXML
    ProgressBar pBar;
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

    //MyThreads progressThread = new MyThreads();


    @FXML
    private void StartProgress(){
        /*boolean a = false;
        while (!a){
            pBar.setProgress(pBar.getProgress() + 1);
        }*/

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