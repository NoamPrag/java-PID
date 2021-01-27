public final class ProportionalControl implements Controller {

    private final double proportionConstant;

    public ProportionalControl(final double proportionConstant) {
        this.proportionConstant = proportionConstant;
    }

    @Override
    public double getOutput(final double error) {
        return proportionConstant * error;
    }
}
