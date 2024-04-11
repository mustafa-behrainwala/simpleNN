import data.DataReader;
import data.Image;
import layer.MaxPoolLayer;
import network.NetworkBuilder;
import network.NeuralNetwork;
import utils.MatrixUtils;

import java.util.Collections;
import java.util.List;

public class OCR {
    public static void main(String[] args) {
        System.out.println("***OCR***");
        System.out.println("\n\n***Starting***\n...loading data...\n");

        List<Image> imagesTest = DataReader.readData("data/mnist_test.csv");
        System.out.println("***Test Data Loaded***");
        System.out.println("Images in test data: "+imagesTest.size());

        List<Image> imagesTrain = DataReader.readData("data/mnist_train.csv");
        System.out.println("***Train Data Loaded***");
        System.out.println("Images in train data: "+imagesTrain.size());

        int testImg=3;
        System.out.println("\n\n***Image***\n\n"+imagesTest.get(testImg)+"\n\n");
        MaxPoolLayer player = new MaxPoolLayer(1, 2, 28, 28);
        player.getOutput(MatrixUtils.matrixToVector(imagesTest.get(testImg).data()));
        System.out.println("\n\n***MaxPoolLayer***\n\n"+player+"\n\n");
    }
}