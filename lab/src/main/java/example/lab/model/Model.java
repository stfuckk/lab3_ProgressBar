package example.lab.model;

import example.lab.model.api.ModelAPI;
import example.lab.model.api.Updatable;

class T implements Runnable{
    private Thread t;
    private double max;
    private Updatable updater;

    public T(String name, double valueInit, Updatable updater){
        t = new Thread(this, name);
        this.max = valueInit;
        this.updater = updater;
        t.start();
    }


    public void run(){
        Thread t = Thread.currentThread();
        for(double i=0; i<max; i++){
            updater.update(i);
            System.out.println("i: " + i);
            try {Thread.sleep(20);} catch (InterruptedException e) { e.printStackTrace();}
        }
    }
}

public class Model implements ModelAPI {
    @Override
    public double calcProgress(double inp, double max){
        double v = inp / max;
        return v;
    }
    @Override
    public void asyncCalcProgress(double valueInit, Updatable updater){
        new T("Parallel", valueInit, updater);
    }
}
