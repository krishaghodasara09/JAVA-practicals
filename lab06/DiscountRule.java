package lab06;

@FunctionalInterface
public interface DiscountRule {
    double apply(double price);
}

