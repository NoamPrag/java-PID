import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class PID extends Controller {

    final private Collection<Controller> controllers;

    private double wantedValue = 0;

    public PID(final Controller... controllers) {
        super(1);
        this.controllers = Arrays.stream(controllers).collect(Collectors.toList());
    }

    public PID(final double k, final Controller... controllers) {
        super(k);
        this.controllers = Arrays.stream(controllers).collect(Collectors.toList());
    }

    public void setWanted(final double wantedValue) {
        this.wantedValue = wantedValue;
    }

    @Override
    public double getOutput(final double currentValue) {
        final double error = wantedValue - currentValue;

        return k * controllers.stream().mapToDouble(c -> c.getOutput(error)).reduce(0,
                (acc, curr) -> acc + curr);
    }
}
