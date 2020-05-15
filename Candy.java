public class Candy {
    private int value;
    private String emoji;
    private String name;
    private int id;

    public Candy (String name, String emoji, int value, int id) {
        this.name = name;
        this.emoji = emoji;
        this.value = value;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.emoji;
    }

    @Override
    public boolean equals(Object obj) {
        Candy c = (Candy) obj;
        return this.id == c.id;
    }
}
