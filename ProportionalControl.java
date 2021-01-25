public final class ProportionalControl extends Controller {

    public ProportionalControl(final double proportionConstant) {
        super(proportionConstant);
    }

    @Override
    public double getOutput(final double error) {
        return proportionConstant * error;
    }
}
