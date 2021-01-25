import java.util.Collection;
import java.util.List;

public final class PID implements Controller {

    private final Collection<Controller> controllers;

    private double wantedValue = 0;

    public PID(final Controller... controllers) {
        this.controllers = List.of(controllers);
    }

    public void addController(final Controller controller) {
        controllers.add(controller);
    }

    public void setWanted(final double wantedValue) {
        this.wantedValue = wantedValue;
    }

    @Override
    public double getOutput(final double currentValue) {
        final double error = wantedValue - currentValue;

        return controllers.stream().mapToDouble(c -> c.getOutput(error)).reduce(0,
                (acc, curr) -> acc + curr);
    }
}
