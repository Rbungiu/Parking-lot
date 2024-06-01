import java.awt.*;

public class Dreptunghi {
    private Point N;
    private Point S;
    private Point V;
    private Point E;
    public Point getN() {
        return N;
    }
    public Point getS() {
        return S;
    }
    public Point getV() {
        return V;
    }
    public Point getE() {
        return E;
    }
    public void setN(Point N) {
        this.N = N;
    }
    public void setS(Point S) {
        this.S = S;
    }
    public void setV(Point V) {
        this.V = V;
    }
    public void setE(Point E) {
        this.E = E;
    }
    public Dreptunghi(Point N, Point S, Point V, Point E) {
        this.N = N;
        this.S = S;
        this.V = V;
        this.E = E;
    }
    public Point centru(){
        return new Point((V.x+E.x)/2, (N.y+S.y)/2);
    }
    @Override
    public String toString() {
        return "Dreptunghi{" +
                "N=" + N.getY() +
                ", S=" + S.getY() +
                ", V=" + V.getX() +
                ", E=" + E.getX() +
                '}';
    }
}
