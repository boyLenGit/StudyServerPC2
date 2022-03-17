package len.cloud02.geodata_service.pojo;

public class OneWell {
    private double depth;
    private double twt;

    public OneWell() {
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getTwt() {
        return twt;
    }

    public void setTwt(double twt) {
        this.twt = twt;
    }

    @Override
    public String toString() {
        return "OneWell{" +
                "depth=" + depth +
                ", twt=" + twt +
                '}';
    }
}
