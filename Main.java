public class Main {

    public static void main(String[] args) {
        //String[] names = {"Plato", "Aristotle", "Cicero", "Confucius", "Eratosthenes"};
        ChopStick[] chop = new ChopStick[5];
        final Philosopher[] philosopher = new Philosopher[5];

        for (int i = 0; i < chop.length; i++) {
            chop[i] = new ChopStick();
        }

        for (int i = 0; i < philosopher.length; i++) {
            ChopStick chop_left = chop[i];
            ChopStick chop_right = chop[(i + 1) % chop.length];

            if (i == philosopher.length - 1) {

                // The last philosopher picks up the right fork first
                philosopher[i] = new Philosopher(chop_right,chop_left);
            } else {
                philosopher[i] = new Philosopher(chop_left,chop_right);
            }
            Thread t
                    = new Thread( philosopher[i],"philosopher" + (i + 1));
            t.start();
        }
    }
}