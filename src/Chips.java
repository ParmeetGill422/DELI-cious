public class Chips extends MenuItem {
    public Chips(String type) {
        super("Chips: " + type);
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }
}
