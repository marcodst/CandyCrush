public class CandyCrash extends Switchable {
    public static final String ANSI_GREEN = "\u001B[32m";
    public CandyCrash(int x, int y) {
        super(x, y);
        candyFiller();
    }

    public Candy candyGenerator() {
        double value = Math.random();
        if (value < 0.25) {
            return new Candy("Lollipop", "\uD83C\uDF6D", 10, Candy.Mark.O);
        } else if (value < 0.50) {
            return new Candy("Candy", "\uD83C\uDF6C", 20, Candy.Mark.O);
        } else if (value < 0.75) {
            return new Candy("Chocolate", "\uD83C\uDF6B", 30, Candy.Mark.O);
        } else {
            return new Candy("Cookie", "\uD83C\uDF6A", 40, Candy.Mark.O);
        }
    }

    public void candyFiller() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = this.candyGenerator();
            }
        }
    }

    public boolean checkVertical(int x, int y) {
        // 2 sopra
        if ((areIntoGrid(x - 1, y, x - 2, y)) && (grid[x - 1][y] == grid[x][y] && grid[x - 2][y] == grid[x][y]))
            return true;
        // 2 sotto
        else if ((areIntoGrid(x + 1, y, x + 2, y)) && (grid[x + 1][y] == grid[x][y] && grid[x + 2][y] == grid[x][y]))
            return true;
        // 1 sopra e 1 sotto
        else if ((areIntoGrid(x + 1, y, x - 1, y)) && (grid[x + 1][y] == grid[x][y] && grid[x - 1][y] == grid[x][y]))
            return true;
        else
            return false;
    }

    public boolean chechHorizontal(int x, int y) {
        // 2 a destra
        if ((areIntoGrid(x, y - 1, x, y - 2)) && (grid[x][y - 1] == grid[x][y] && grid[x][y - 2] == grid[x][y]))
            return true;
            // 2 a sinistra
        else if ((areIntoGrid(x, y + 1, x, y + 2)) && (grid[x][y + 1] == grid[x][y] && grid[x][y + 2] == grid[x][y]))
            return true;
            // 1 a destra e a sinistra
        else if ((areIntoGrid(x, y + 1, x, y - 1)) && (grid[x][y + 1] == grid[x][y] && grid[x][y - 1] == grid[x][y]))
            return true;
        else
            return false;
    }

    @Override
    public boolean canSwitch(int x1, int y1, int x2, int y2) {
        if (super.canSwitch(x1, y1, x2, y2) || chechHorizontal(x2, y2) || checkVertical(x2, y2))
            return true;
        return false;
    }

    public void markLeft(int x, int y) {
        if(grid[x][y - 1] != grid[x][y]) {
            ((Candy)grid[x][y]).setMark(Candy.Mark.O);
            return;
        }
        else {
            ((Candy)grid[x][y]).setMark(Candy.Mark.X);
            markLeft(x, y - 1);
        }
    }

    public void markRight(int x, int y) {
        if(grid[x][y + 1] != grid[x][y]) {
            ((Candy)grid[x][y]).setMark(Candy.Mark.O);
            return;
        }
        else {
            ((Candy)grid[x][y]).setMark(Candy.Mark.X);
            markRight(x, y + 1);
        }
    }

    public void markTop(int x, int y) {
        if(grid[x - 1][y] != grid[x][y]) {
            ((Candy)grid[x][y]).setMark(Candy.Mark.O);
            return;
        }
        else {
            ((Candy)grid[x][y]).setMark(Candy.Mark.X);
            markTop(x - 1, y);
        }
    }

    public void markBottom(int x, int y) {
        if (grid[x + 1][y] != grid[x][y]) {
            ((Candy)grid[x][y]).setMark(Candy.Mark.O);
            return;
        }
        else {
            ((Candy)grid[x][y]).setMark(Candy.Mark.X);
            markBottom(x + 1, y);
        }
    }

    public void marker(int x, int y) {
       //riga
        if (chechHorizontal(x, y)) {
            // sinistra
            if (grid[x][y - 1] == grid[x][y])
                markLeft(x, y - 1);
            // destra
            if (grid[x][y + 1] == grid[x][y])
                markRight(x, y + 1);
        }
        // colonna
        if (checkVertical(x, y)) {
            // sopra
            if (grid[x - 1][y] == grid[x][y])
                markTop(x - 1, y);
            // sotto
            if (grid[x + 1][y] == grid[x][y])
                markBottom(x + 1, y);
        }
        grid[x][y] = null;
    }

    public void scanMap() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (chechHorizontal(x, y) || checkVertical(x, y)) {
                    marker(x, y);
                }
            }
        }
        getExplosion();
    }

    public int setGravity(int y) {
        int rowX = 0;
        for (int x = 5; x >= 0; x--) {
            if (grid[x][y] == null) {
                rowX = x;
            }
        }
        return rowX;
    }

    public int getExplosion() {
        int candyCrashed = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if ( ((Candy)grid[x][y]).getMark().equals(Candy.Mark.X) ) {
                    candyCrashed++;
                    grid[x][y] = null;
                    //setGravity();
                }
            }
        }
        return candyCrashed;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < grid.length ; i++)
        {
            if(i==0)
            {
                result+="\t";
            }
            result+= "   " + i;
            if(i==grid.length-1)
            {
                result+="\n";
            }
        }
        for (int i = 0; i < this.grid.length; i++) {
            result += i + "\t[";
            for (int j = 0; j < this.grid[i].length; j++) {
                result += "[" + this.grid[i][j] + "]";
            }
            result += "]\n";
        }
        return result;
    }
}
