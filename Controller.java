abstract class Controller {

    protected final double proportionConstant;

    public Controller(final double proportionConstant) {
        this.proportionConstant = proportionConstant;
    }

    abstract public double getOutput(final double error);
}
