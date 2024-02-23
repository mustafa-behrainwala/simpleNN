package network;

import layer.ConnectedLayer;
import layer.Layer;

import java.util.ArrayList;
import java.util.List;

public class NetworkBuilder {
    private final List<Layer> layers = new ArrayList<>();

    private final int numInputs;

    public NetworkBuilder(int numInputs){
        this.numInputs = numInputs;
    }

    public void addConnectedLayer(int numOutputs){
        if(layers.isEmpty()){
            layers.add(new ConnectedLayer(numInputs, numOutputs));
        } else {
            layers.add(new ConnectedLayer(layers.get(layers.size()-1).getNumberOutput(), numOutputs));
        }
    }

    public NeuralNetwork build(){
        return new NeuralNetwork(layers);
    }
}
