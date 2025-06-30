public class FinancialForecast {

    // Recursive method
    public static double futureValue(double PV, double r, int n) {
        if (n == 0) {
            return PV;
        }
        return futureValue(PV, r, n - 1) * (1 + r);
    }

    public static void main(String[] args) {
        double PV = 1000;  // Present Value
        double r = 0.05;   // 5% growth rate
        int n = 10;        // 10 periods

        double FV = futureValue(PV, r, n);
        System.out.printf("Future value after %d years (recursive): %.2f\n", n, FV);
    }
}
