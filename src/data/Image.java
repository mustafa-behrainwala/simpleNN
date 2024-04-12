package data;

public record Image(double[][] data, int label) {
    public Image(double[][] data, int label) {
        this.label = label;

        if (data == null) {
            this.data = null;
            return;
        }

        int length = data.length;
        this.data = new double[length][data[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, data[i].length);
        }
    }

    @Override
    public double[][] data() {
        int length = this.data.length;
        double[][] target = new double[length][this.data[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(this.data[i], 0, target[i], 0, this.data[i].length);
        }
        return target;
    }

    private static final char FULL_BLOCK= '\u2588';
    private static final char LIGHT_SHADE= '\u2591';
    private static final char MEDIUM_SHADE= '\u2592';

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(label);
        sb.append("\n");

        for (double[] datum : data) {
            for (int j = 0; j < data[0].length; j++) {
                if (datum[j] != 0) {
                    if(datum[j] > 196)
                        sb.append(FULL_BLOCK);
                    else if(datum[j] > 100)
                        sb.append(MEDIUM_SHADE);
                    else
                        sb.append(LIGHT_SHADE);
                } else
                    sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}