public class Main {

    public static void main(final String... args) {
        final Controller p = new ProportionalControl(0);
        final Controller i = new IntegralControl(0, 0, 0);
        final Controller d = new DerivativeControl(0);

        final PID pid = new PID(p, i, d);


        pid.setWanted(0);
        pid.getOutput(0);
    }
}
