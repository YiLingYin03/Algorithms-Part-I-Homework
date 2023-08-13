public class EggDrop {

    // Version 0: 1 egg, T tosses
    public static int eggDropVersion0(int n) {
        int T = 1;
        while (T * (T + 1) / 2 < n) {
            T++;
        }
        return T;
    }

    // Version 1: ~1lg(n) eggs and ~1lg(n) tosses
    public static int eggDropVersion1(int n) {
        int T = 0;
        int interval = (int) Math.ceil(Math.sqrt(n));
        while (T * interval < n) {
            T++;
        }
        return T;
    }

    // Version 2: ~lg(T) eggs and ~2lg(T) tosses
    public static int eggDropVersion2(int T) {
        int tosses = 0;
        int interval = (int) Math.ceil(Math.sqrt(T));
        int currentFloor = interval;
        while (currentFloor < T) {
            tosses++;
            currentFloor += interval;
        }
        return tosses;
    }

    // Version 3: 2 eggs and ~2√n tosses
    public static int eggDropVersion3(int n) {
        int tosses = 0;
        int interval = (int) Math.ceil(Math.sqrt(n));
        int currentFloor = interval;
        while (currentFloor < n) {
            tosses++;
            currentFloor += interval;
        }
        return tosses;
    }

    // Version 4: 2 eggs and ≤ c√T tosses for some fixed constant c
    public static int eggDropVersion4(int T, int c) {
        int tosses = 0;
        int interval = (int) Math.ceil(Math.sqrt(T));
        int currentFloor = interval;
        while (currentFloor < T) {
            tosses++;
            currentFloor += interval;
        }
        return Math.min(tosses, c * (int) Math.ceil(Math.sqrt(T)));
    }

    public static void main(String[] args) {
        int n = 200; // Number of floors
        int T = 100; // Value of T
        int c = 2; // Constant c

        System.out.println("Version 0: " + eggDropVersion0(n));
        System.out.println("Version 1: " + eggDropVersion1(n));
        System.out.println("Version 2: " + eggDropVersion2(T));
        System.out.println("Version 3: " + eggDropVersion3(n));
        System.out.println("Version 4: " + eggDropVersion4(T, c));
    }
}
