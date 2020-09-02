package times_1.mypow;

/**
 * @author zhaohongxin
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        // int 最小值取负还是他本身，所以要转换成long
        long m = n;
        if (m < 0) {
            return 1 / pow(x, -m);
        }
        return pow(x, m);
    }

    private double pow(double x, long n) {
        if (n == 1) {
            return x;
        }
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        long a = -2147483648;
        long b = -a;
        System.out.println(b);
        MyPow myPow = new MyPow();
        myPow.myPow(2.00000,-2147483648);
    }
}
