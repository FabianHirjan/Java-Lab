public class Main {
    public static void main(String[] args) {
    int a,b,k;

    a = Integer.parseInt(args[0]);
    b = Integer.parseInt(args[1]);
    k = Integer.parseInt(args[2]);

       // System.out.println();
        for (int num = a; num <= b; num++) {
            if (isKReductible(num, k)) {
                System.out.println(num + " is " + k + "-reductible.");
            }
        }
    }

    private static boolean isKReductible(int test, int ktest){
        int sum;
        do {
            sum = 0;
            while (test != 0) {
                int digit = test % 10;
                sum += digit * digit;
                test /= 10;
            }
            test = sum;
        } while (sum >= ktest && sum != ktest && sum > 9);

        return sum == ktest;
    }
}


