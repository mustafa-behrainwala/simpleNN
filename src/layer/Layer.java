package layer;

public abstract class Layer {
    public abstract double[] getOutput(double[] input);

    public abstract void backPropagate(double[] error);
}
