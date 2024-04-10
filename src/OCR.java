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


        System.out.println("\n\n***Creating NN***");
        NetworkBuilder networkBuilder = new NetworkBuilder(28*28, 256);
        networkBuilder.addConnectedLayer(700);
        networkBuilder.addConnectedLayer(10);
        NeuralNetwork nn = networkBuilder.build();

        int countCorrect=0;
        for(Image image: imagesTest){
            int ans = nn.getOutput(MatrixUtils.matrixToVector(image.data()));
            if(ans == image.label()){
                countCorrect++;
            }
        }
        System.out.println("\n\n***Accuracy*** -> "+(countCorrect*100.0/imagesTest.size())+"%");

        for(int epoch=0; epoch<3; epoch++) {
            Collections.shuffle(imagesTrain);
            for (Image image : imagesTrain) {
                nn.train(MatrixUtils.matrixToVector(image.data()), image.label());
            }

            countCorrect=0;
            for(Image image: imagesTest){
                int ans = nn.getOutput(MatrixUtils.matrixToVector(image.data()));
                if(ans == image.label()){
                    countCorrect++;
                }
            }
            System.out.println("\n\n***Accuracy after epoch "+epoch+"*** -> "+(countCorrect*100.0/imagesTest.size())+"%");
        }
    }
}