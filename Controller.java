abstract class Controller {

    protected final double k;

    public Controller(final double k) {
        this.k = k;
    }

    abstract public double getOutput(final double error);
}
