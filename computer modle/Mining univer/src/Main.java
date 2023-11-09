
public class Main {
    public static void main(String[] args) {
        double[] xi = {15, 14, 12, 10, 9, 8, 7, 5};
        double[] yi = {150, 145, 120, 100, 95, 75, 70, 55};
        double l12 = 0;
        double l13 = 0;
        double l22 = 0;
        double l23 = 0;
        double x = 0;
        double y = 0;
        double sumM = 0;
        double sumyti = 0;
        double xi_x2 = 0;
        double yi_y2 = 0;


// Calculate various sums and means
        for (int i = 0; i < xi.length; i++) {
            l12 += xi[i];
            l13 += yi[i];
            x += (xi[i] / 8);
            y += (yi[i] / 8);
        }

// Calculate sums and products needed for linear regression
        for (int i = 0; i < xi.length; i++) {
            sumM += ((xi[i] - x) * (yi[i] - y));
            xi_x2 += (xi[i] - x) * (xi[i] - x);
            yi_y2 += (yi[i] - y) * (yi[i] - y);
            l22 += (xi[i] * xi[i]);

            l23 += xi[i] * yi[i];
        }

        double l21 = l12;
        double l11 = xi.length;
        double коэффициент = 0;
// Calculate determinants and coefficients of the linear regression model
        double D = l11 * l22 - l21 * l12;
        double D1 = l13 * l22 - l23 * l12;
        double D2 = l11 * l23 - l21 * l13;
        double A1 = D1 / D;
        double A2 = D2 / D;

// Calculate predicted values and the sum of squared residuals
        double[] yti = new double[xi.length];
        for (int i = 0; i < xi.length; i++) {
            yti[i] = A1 + A2 * xi[i];
            sumyti += (yi[i] - yti[i]) * (yi[i] - yti[i]);
            коэффициент += ((xi[i] - x) * (yi[i] - y));
        }
        double Result = коэффициент / (Math.sqrt(xi_x2) * Math.sqrt(yi_y2));
// Calculate the coefficient of determination (R-squared)
        double Result1 = 1 - sumyti / yi_y2;


// Print the results
        System.out.println("Our line is: \n" + "Y = " + A1 + " + " + A2 + " * X \n The result is " + Result1);
        if (Math.round(Result1) == Math.round(Result)) {
            System.out.println("Практически равное единице значение коэффициента детерминации говорит о высокой эффективности модели.\n");
        } else System.out.println("sorry");
    }
}
