
public class Edge {
    int x;
    int y;

    Edge(int a, int b){
        x = Main.Min(a, b);
        y = Main.Max(a, b);
    }

    public void Show(){
        System.out.println(x + " " + y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge that = (Edge) o;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
