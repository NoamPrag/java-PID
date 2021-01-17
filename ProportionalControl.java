public class ProportionalControl extends Controller {

    public ProportionalControl(final double k) {
        super(k);
    }

    @Override
    public double getOutput(final double error) {
        return k * error;
    }
}
