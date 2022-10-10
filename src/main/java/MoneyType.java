import java.text.NumberFormat;
import java.util.Locale;

public class MoneyType {

    public double minimum;

    public double maximum;

    MoneyType(){

    }

    MoneyType(double minimum, double maximum){
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public double getMinimum() {
        return this.minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return this.maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return  NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                .format(minimum) + " - " + NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                .format(maximum);
    }
}
