public final class IntegralControl extends Controller {

    private double zone;
    private double windup;

    private double accumulator = 0;

    public IntegralControl(final double proportionConstant, final double zone,
            final double windup) {
        super(proportionConstant);
        this.zone = zone;
        this.windup = windup;
    }

    public void reset() {
        accumulator = 0;
    }

    private void update(final double error) {
        if (relevant(error))
            accumulator = coerce(accumulator + error);
    }

    private boolean relevant(final double error) {
        return Math.abs(error) >= zone;
    }

    private double coerce(final double x) {
        return Math.min(windup, Math.max(-windup, x));
    }

    @Override
    public double getOutput(final double error) {
        update(error);
        return proportionConstant * accumulator;
    }
}
