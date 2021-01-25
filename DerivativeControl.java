public final class DerivativeControl extends Controller {

    private double prevError = 0;
    private double prevTime;

    private boolean firstCall = true;

    public DerivativeControl(final double proportionConstant) {
        super(proportionConstant);

        prevTime = System.currentTimeMillis();
    }

    @Override
    public double getOutput(final double error) {
        final double currentTime = System.currentTimeMillis();

        final double dError = error - prevError;
        final double dt = currentTime - prevTime;

        final double output = proportionConstant * dError / dt;

        prevError = error;
        prevTime = currentTime;

        if (firstCall) {
            firstCall = false;
            return 0;
        }

        if (currentTime == prevTime)
            return 0;

        return output;
    }
}
