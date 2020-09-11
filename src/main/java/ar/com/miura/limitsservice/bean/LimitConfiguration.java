package ar.com.miura.limitsservice.bean;

public class LimitConfiguration {

    private int max;

    private int min;

    public LimitConfiguration(int min, int max) {
        super();
        this.min = min;
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
