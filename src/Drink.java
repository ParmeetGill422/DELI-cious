public class Drink extends MenuItem {
    private String size;

    public Drink(String size, String type) {
        super(size + " " + type);
        this.size = size;
    }

    @Override
    public double getPrice() {
        switch (size) {
            case "Small": return 2.00;
            case "Medium": return 2.50;
            case "Large": return 3.00;
            default: return 0;
        }
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }
}
