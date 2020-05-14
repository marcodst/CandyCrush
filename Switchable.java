public class Switchable {
    public final Object[][] grid;

    public Switchable(final int size1, final int size2) {
        grid = new Object[size1][size2];
    }

    public void switchTile(int x1, int y1, int x2, int y2) {
        try {
            if (this.canSwitch(x1, y1, x2, y2)){
                Object temp = this.grid[x1][y1];
                this.grid[x1][y1] = this.grid[x2][y2];
                this.grid[x2][y2] = temp;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public boolean canSwitch(final int x1, final int y1, final int x2, final int y2) {
        // if (
        //     (x1 == x2 && (y1 == y2 +1 || y1 == y2 -1)) ||
        //     (y1 == y2 && (x1 == x2 + 1 || x1 == x2 -1))
        // ) {
        //     return true;
        // }
        // return false;
        return
                (x1 == x2 && ((y1 == y2 + 1) || (y1 == y2 - 1))) ||
                        (y1 == y2 && ((x1 == x2 + 1) || (x1 == x2 - 1)));
    }

    public void setValue(final int x, final int y, final Object value) {
        try {
            this.grid[x][y] = value;
        } catch (final Exception ex) {
            System.out.println(ex);
        }
    }

    public Object getValue(final int x, final int y) {
        try {
            return this.grid[x][y];
        } catch (final Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean areIntoGrid(int x, int y, int i, int j) {
        if( ((x < grid.length) && (i < grid.length) && (y < grid[0].length) && (j < grid[0].length))
                && ((x >= 0) && (i >= 0) && (y >= 0) && (j >= 0)) )
            return true;
        return false;
    }

    public String toString() {
        String result = "";
        System.out.println("\n\t\t3\t2\t1\t0\n");
        for (int x = 0; x< this.grid.length; x++) {
            result += x + "\t" + "[";
            for(int y=this.grid[x].length -1; y>=0; y--) {
                final String space = (int) this.grid[x][y] < 10 ? " " : "";
                result += "[" + space + this.grid[x][y] + "]";
            }
            result += "]\n";
        }
        return result;
    }
}
