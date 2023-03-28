import java.util.ArrayList;
import java.util.Random;

public class Neuron {
    /**
     * Neuronas lineales o dendritas
     */
    private ArrayList<Double> dendrites = null;
    /**
     * Pesos de las dendritas
     */
    private ArrayList<Double> weights = null;

    private double alpha;

    private int t;

    private int size;

    private double s;

    @Override
    public String toString() {
        return "Neuron{" +
                "dendrites=" + dendrites +
                ", weights=" + weights +
                ", alpha=" + alpha +
                ", t=" + t +
                ", size=" + size +
                ", s=" + s +
                '}';
    }

    /**
     * tipo mde dato para la entrada(dendritas)
     */

    public Neuron(int size) {
        Random generador = new Random((long) 1.45);
        this.size = size;
        this.dendrites = new ArrayList<Double>();
        this.weights = new ArrayList<Double>();
        for (int i=0; i<this.size; i++) {
            this.weights.add(generador.nextDouble() * 2 - 1); // valores entre -1 y 1
        }
        this.setAlpha(0.3);
        this.setT(0);
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public ArrayList<Double> getWeights() {
        return weights;
    }

    public void setWeights(ArrayList<Double> weights) {
        this.weights = weights;
    }

    public ArrayList<Double> getDendrites() {
        return dendrites;
    }

    public void setDendrites(ArrayList<Double> dendrites) {
        this.dendrites = dendrites;
    }

    /**
     * Sumatoria ponderada
     * @return
     */
    public double computeWeightedSum(){
        double result = 0.0;
        for ( int i = 0; i < this.size; i++){
            result += this.dendrites.get(i) * this.weights.get(i) ;
        }
        return result;
    }

    /**
     * Funcion de activacion de la neurona
     * @return
     */
    public int funcActivate(double xnet){
        if (xnet<0) {
            return -1;
        }
        return 1;
    }

    /**
     * retorna la suma de la salida
     * @param dendrites
     * @return
     */
    public double getOutput(ArrayList<Double> dendrites){
        this.setDendrites(dendrites);
        return this.s = this.funcActivate(this.computeWeightedSum());
    }

    public double getOutput(){
        return this.funcActivate(this.computeWeightedSum());
    }
    /**
     * Funcion de entrenamiento
     * @param dendrites
     * @param y
     * @return
     */
    public int train(ArrayList<Double> dendrites, double y ) {
        double s = this.getOutput(dendrites);
        double error = y - s;
        double sum = 0.0;
        if( error != 0){
            for (int i=0; i<this.size; i++) {
                sum = this.weights.get(i) + this.alpha * error * dendrites.get(i);
                this.weights.set(i, sum);
            }
            return 1;
        }
        return 0;
    }
}
