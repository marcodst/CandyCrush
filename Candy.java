public class Candy {
    private String emoji;
    private int value;
    private String name;
    public enum Mark {X, O};
    private Mark mark;
    public Candy(String name, String emoji, int value, Mark mark) {
        this.name = name;
        this.emoji = emoji;
        this.value = value;
        this.mark = mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return this.emoji;
    }
}
