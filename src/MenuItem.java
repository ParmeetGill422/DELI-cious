public abstract class MenuItem implements Item {
    protected String name;

    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return name;
    }
}
