import data.DataReader;
import data.Image;

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

        System.out.println("\n\n***1st Image in Test data***");

        if(!imagesTest.isEmpty()){
            for(int i=0; i<10; i++){;
                System.out.println(imagesTest.get(i));
            }
        }
    }
}
