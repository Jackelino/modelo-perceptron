import java.util.ArrayList;

public class Network {

    private ArrayList<Neuron> neurons = null;

    public Network(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }

    public ArrayList<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }
}
