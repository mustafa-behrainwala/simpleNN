package layer;

import utils.MatrixUtils;

public class ConnectedLayer extends Layer{
    private final double[][] weights;

    private final int numberInps;
    private final int numberOuts;

    public ConnectedLayer(int numberInps, int numberOuts) {
        this.numberInps = numberInps;
        this.numberOuts = numberOuts;

        weights = MatrixUtils.initilizeWeights(numberInps, numberOuts);
    }

    private double[] prevInput;
    private double[] prevOutput;
    @Override
    public double[] getOutput(double[] input) {
        double[] output = new double[numberOuts];

        for(int rows=0; rows<numberInps; rows++) {
            for(int cols=0; cols<numberOuts; cols++) {
                output[cols] += input[rows] * weights[rows][cols];
            }
        }

        prevInput = input;
        prevOutput = new double[numberOuts];

        for(int i=0; i<numberOuts; i++) {
            prevOutput[i] = output[i];
            output[i] = relU(output[i]);
        }

        return output;
    }

    @Override
    public void backPropagate(double[] error){
        for(int rows=0; rows<numberInps; rows++) {
            for(int cols=0; cols<numberOuts; cols++) {
                double cost = error[cols] * dervRelU(prevOutput[cols])*prevInput[rows];
                weights[rows][cols] = weights[rows][cols] - (cost*.1);
            }
        }
    }

    private double relU(double x) {
        return x > 0 ? x : 0;
    }

    private double dervRelU(double x) {
        return x > 0 ? 1 : .01;
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}
