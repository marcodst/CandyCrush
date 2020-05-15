public class CandyCrush extends Switchable {
    public CandyCrush(int x, int y) {
        super(x, y);
        for (int i = 0; i < super.grid.length; i++) {
            for (int j = 0; j < super.grid[i].length; j++) {
                super.grid[i][j] = this.candyGenerator();
            }
        }
    }

    public String toString() {
        String result = "";
        for (int i = this.grid.length -1; i  >= 0; i--) {
            result +=  "\n" + i + "[";
            for (int j = 0; j < this.grid[i].length; j++) {
                result += "[" + this.grid[i][j] + "]";
            }
            result += "]";
        }
        result += "\n [[ 0][ 1][ 2][ 3][ 4]]  ";
        return result;
    }
    public Candy candyGenerator() {
        double value = Math.random();
        if (value < 0.20) {
            return new Candy("Lollipop", "\uD83C\uDF6D", 10, 1);
        } else if (value < 0.40) {
            return new Candy("Candy", "\uD83C\uDF6C", 20, 2);
        } else if (value < 0.60) {
            return new Candy("Chocolate", "\uD83C\uDF6B", 30, 3);
        } else if (value < 0.80) {
            return new Candy("Cookie2", "🥠", 30, 4);
        } else {
            return new Candy("Cookie", "\uD83C\uDF6A", 40, 4);
        }

    }

    public void destroyX(int row,int startCol,int endCol) {
        for (int i = startCol; i <= endCol; i++) {
            super.grid[row][i] = null;
        }
    }
    public void destroyY(int column,int startRow,int endRow) {
        for (int i = startRow; i <= endRow; i++) {
            super.grid[i][column] = null;
        }
    }

    public void checkToDestroy() {
        this.destroyY(0, 0, 2);
    }

    public void useGravity() {
        boolean condition = false; // finchè non ho elementi sopra il null
        while(condition) {
            for (int i = 0; i < super.grid.length; i++) {
                for (int j = super.grid[i].length-1; j > 0; j--) {
                    if (super.grid[j][i] != null && super.grid[j-1][i] == null) {
                        super.switchTile(j, i, j-1, i);
                    }
                }
            }
        }
    }



    // distruggi (settare a null le caselle che vanno distrute)
    // distruggi X
    // distruggi Y
    // gravità ()
    // ripopola
    // trova combinazioni




}