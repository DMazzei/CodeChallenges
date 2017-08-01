package dmz.codeChallenges;

public class AppStarter {
    public static void main(String[] args) {
        MultiplicationTable app = new MultiplicationTable();

        if (args.length > 0) {
            int input;
            try {
                input = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.out.print("Argument was not a valid number, using default: 10\n");
                input = 10;
            }
            app.run(input);
        } else {
            app.run(10);
        }
    }
}
