

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        /*
        for (int i = 0; i < languages.length; i++) {
            System.out.print(languages[i] + " ");
        }
        */

        int n = (int) (Math.random() * 1_000_000);
        // System.out.println("\n" + n + "\n");
        n *= 3;

        // System.out.println(Integer.parseInt("10101", 2));

        n+=Integer.parseInt("10101", 2);

        n+=Integer.parseInt("FF", 16);
       // System.out.println(Integer.parseInt("FF", 16));

        n *= 6;

        System.out.println(n);
        int sum = 0;
        int copy;
        do {
            while(n!=0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
            copy = sum;
            sum = 0;
        }while(copy>=10);

        // n = copy;
        // System.out.println(n);

        System.out.println("\nWilly-nilly, this semester I will learn " + languages[n]);


    }
}