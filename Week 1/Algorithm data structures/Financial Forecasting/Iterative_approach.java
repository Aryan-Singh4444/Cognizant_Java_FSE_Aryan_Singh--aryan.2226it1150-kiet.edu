public class FinancialForecast {

    public static double futureValueIterative(double PV, double r, int n) {
        double FV = PV;
        for (int i = 0; i < n; i++) {
            FV *= (1 + r);
        }
        return FV;
    }

    public static void main(String[] args) {
        double PV = 1000;
        double r = 0.05;
        int n = 10;

        double FV = futureValueIterative(PV, r, n);
        System.out.printf("Future value after %d years (iterative): %.2f\n", n, FV);
    }
}
