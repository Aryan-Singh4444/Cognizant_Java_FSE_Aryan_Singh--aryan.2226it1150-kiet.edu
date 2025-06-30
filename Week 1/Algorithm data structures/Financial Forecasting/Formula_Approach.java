public class FinancialForecast {

    public static double futureValueDirect(double PV, double r, int n) {
        return PV * Math.pow(1 + r, n);
    }

    public static void main(String[] args) {
        double PV = 1000;
        double r = 0.05;
        int n = 10;

        double FV = futureValueDirect(PV, r, n);
        System.out.printf("Future value after %d years (direct formula): %.2f\n", n, FV);
    }
}
