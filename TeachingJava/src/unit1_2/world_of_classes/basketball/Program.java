package unit1_2.world_of_classes.basketball;

public class Program {
    public static void main(String[] args) {
        creatingPlayers();
    }

    private static void creatingPlayers() {
        /* We'll call c'tors to create 2 objects representing 2 different basketball players.

            The generic structure of the command to create objects is:

            ClassName variableName = new ClassName(attribute1, attribute2, ..., attributeN);
         */

        int tempAge = 18;

        // Notice we can break the command over several lines
        BasketballPlayer player1 = new BasketballPlayer("Michael Jordan", 'M', 1.98, tempAge,
                "American", "None", 0, false);

        // Or we can write the command in one long line
        tempAge = 15;
        BasketballPlayer player2 = new BasketballPlayer("Omri Tal", 'M', 1.8, tempAge, "Israeli", "Maccabi Tel-Aviv Juniors", 30, false);

        System.out.println(player1.betterShotThan(player2));
        System.out.println(player2.betterShotThan(player1));
    }
}
