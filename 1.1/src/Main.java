public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
        String[] languages = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int)(Math.random() * 1000000.0);
        n *= 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;
        System.out.println(n);
        int sum = 0;

        while(true) {
            while(n == 0) {
                n = sum;
                int copy = sum;
                sum = 0;
                if (copy < 10) {
                    System.out.println("\nWilly-nilly, this semester I will learn " + languages[n]);
                    return;
                }
            }

            sum += n % 10;
            n /= 10;
        }
    }
}
