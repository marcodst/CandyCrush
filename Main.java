import java.util.Scanner;

/*public class Main {
    public static void main(String[] args) {
        Fifteen s = new Fifteen();
        System.out.println(s.toString());
        s.superShuffle();
        System.out.println(s.toString());
    }
}*/
public class Main {
    public static void main(String[] args) {
        /*System.out.println("Vuoi giocare? Premi si per avviare una partita");
        Scanner scan = new Scanner(System.in);
        String myChoice = scan.nextLine();
        if (myChoice.equalsIgnoreCase("si")) {
            Fifteen game = new Fifteen();
            game.superShuffle();
            int x, y, i, j;
            do {
                System.out.println(game.toString());
                System.out.println("\nInserisci la riga della casella da spostare");
                x = scan.nextInt();
                System.out.println("Inserisci la colonna della casella da spostare");
                y = scan.nextInt();
                System.out.println("Inserisci la riga dove spostare la casella");
                i = scan.nextInt();
                System.out.println("Inserisci la colonna dove spostare la casella");
                j = scan.nextInt();
                if(game.canSwitch(x, y, i, j))
                    game.switchTile(x, y, i, j);
                else System.out.println("Coordinate errate, prego riprovare");
                if(game.isWin()) {
                    System.out.println("Bravissimo, hai vinto!");
                    System.out.println(game.toString());
                }
            } while (game.isWin() == false);
        }*/
        System.out.println("Vuoi giocare? Premi si per avviare una partita");
        Scanner scan = new Scanner(System.in);
        String myChoice = scan.nextLine();
        if (myChoice.equalsIgnoreCase("si")) {
            CandyCrash candyGame = new CandyCrash(4, 4);

            int x, y, i, j;
            do {
                candyGame.scanMap();
                System.out.println(candyGame.toString());
                System.out.println("\nInserisci la riga della casella da spostare");
                x = scan.nextInt();
                System.out.println("Inserisci la colonna della casella da spostare");
                y = scan.nextInt();
                System.out.println("Inserisci la riga dove spostare la casella");
                i = scan.nextInt();
                System.out.println("Inserisci la colonna dove spostare la casella");
                j = scan.nextInt();
                if (candyGame.canSwitch(x, y, i, j)) {
                    candyGame.switchTile(x, y, i, j);
                    candyGame.scanMap();
                }
                else System.out.println("Coordinate errate, prego riprovare");
            }while(true);
        }
    }
}
