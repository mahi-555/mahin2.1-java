public class Main {
    public static void main(String[] args) {
        CustomHybridPRNG rng = new CustomHybridPRNG(System.nanoTime());

        System.out.println("5 random longs:");
        for (int i = 0; i < 5; i++) {
            System.out.println(rng.nextLong());
        }

        System.out.println("Random int < 100: " + rng.nextInt(100));
        System.out.println("Random double: " + rng.nextDouble());
    }
}



