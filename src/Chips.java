public class Chips implements Item {
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getDescription() {
        return "Chips (" + flavor + ")";
    }
}