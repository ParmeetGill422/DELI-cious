public class Side extends MenuItem {
    public Side(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return 0.00;
    }

    @Override
    public String getDescription() {
        return name;
    }
}
