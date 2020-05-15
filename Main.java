public class Main {
    public static void main(String args[]) {
        CandyCrush c = new CandyCrush(5, 5);
        Candy c1 = new Candy("Fortune Cookie", "🥠", 30, 4);
        Candy c2 = new Candy("Fortune Cookie", "🥠", 30, 4);
        Candy c3 = new Candy("Cookie", "\uD83C\uDF6A", 40, 4);
        c.grid[0][0] = c1;
        c.grid[0][1] = c2;
        c.grid[0][2] = c3;
        System.out.println(c);
        if (c.grid[0][0].equals(c.grid[0][1]) && c.grid[0][1].equals(c.grid[0][2])) {
            System.out.println("Sono uguali");
        } else {
            System.out.println("Sono diversi");
        }
        c.checkToDestroy();
        System.out.println(c);
        c.useGravity();
        c.useGravity();
        System.out.println(c);
    }
}
