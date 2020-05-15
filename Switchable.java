public class Switchable {
    public Object[][] grid;
    public Switchable(int size1,int size2) {
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
    public String toString() {
        String result = "";
        for (int x = 0; x< this.grid.length; x++) {
            result += "[";
            for(int y=this.grid[x].length -1; y>=0; y--) {
                final String space = (int) this.grid[x][y] < 10 ? " " : "";
                result += "[" + space + this.grid[x][y] + "]";
            }
            result += "]\n";
        }
        return result;
    }
}