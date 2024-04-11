package layer;

import utils.MatrixUtils;

import java.util.List;

public class MaxPoolLayer extends Layer{
    private int _stepSize;
    private int _windowSize;

    private int _inRows;
    private int _inCols;

    double[] output;

    public MaxPoolLayer(int _stepSize, int _windowSize, int _inRows, int _inCols) {
        this._stepSize = _stepSize;
        this._windowSize = _windowSize;
        this._inRows = _inRows;
        this._inCols = _inCols;
    }
    @Override
    public double[] getOutput(double[] input) {
        double[][] matrixList = MatrixUtils.vectorToMatrix(input, _inRows, _inCols);
        output = MatrixUtils.matrixToVector(pool(matrixList));

        if(getNextLayer() != null)
            return getNextLayer().getOutput(output);
        else
            return output;
    }

    @Override
    public void backPropagate(double[] error) {

    }

    @Override
    public int getNumberOutput() {
        return getOutputRows() * getOutputCols();
    }

    private double[][] pool(double[][] input){
        double[][] output = new double[getOutputRows()][getOutputCols()];

        return output;
    }

    public int getOutputRows() {return 1;}

    public int getOutputCols() {return 1;}

    public String toString(){
        if(output == null)
            return "No output";

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<getOutputRows(); i++) {
            for (int j = 0; j < getOutputCols(); j++) {
                if(output[i*getOutputRows()+j] != 0) {
                    sb.append(output[i * getOutputRows() + j]).append(", ");
                }
                else
                    sb.append("     "); //only print the rows which are not zero
            }
                sb.append("\n");
        }

        return sb.toString();
    }
}