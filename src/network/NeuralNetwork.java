package network;

import layer.Layer;
import utils.MatrixUtils;

import java.util.List;

public class NeuralNetwork {
    private final List<Layer> layers;

    public NeuralNetwork(List<Layer> layers) {
        this.layers = layers;
        linkLayers();
    }

    private void linkLayers() {
        if(layers.size() < 2)
            return;

        for (int i = 0; i < layers.size()-1; i++) {
            if(i>0)
                layers.get(i).setPrevLayer(layers.get(i-1));

            layers.get(i).setNextLayer(layers.get(i+1));
        }
    }

    public int getOutput(double[] input) {
        return MatrixUtils.getMaxIndex(layers.get(0).getOutput(input));
    }

    public void train(double[] train, int ans) {
        double[] output = layers.get(0).getOutput(train);
        double[] correctResp = new double[output.length];
        correctResp[ans] = -1;
        double[] error = MatrixUtils.addArrays(output, correctResp);

        layers.get(layers.size() - 1).backPropagate(error);
    }
}
