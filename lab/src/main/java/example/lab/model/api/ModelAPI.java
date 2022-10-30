package example.lab.model.api;

public interface ModelAPI {
    double calcProgress(double inp, double max);
    void asyncCalcProgress(double valueInit, Updatable updater);
}
