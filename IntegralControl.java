public class IntegralControl extends Controller {

    private double zone;
    private double windup;

    private double accumulator = 0;

    public IntegralControl(final double k, final double zone, final double windup) {
        super(k);
        this.zone = zone;
        this.windup = windup;
    }

    public void reset() {
        accumulator = 0;
    }

    private void update(final double error) {
        if (Math.abs(error) <= zone) {
            accumulator += error;

            if (Math.abs(accumulator) > windup) {
                accumulator = windup * Math.signum(accumulator);
            }
        }
    }

    @Override
    public double getOutput(final double error) {
        update(error);
        return k * accumulator;
    }
}
