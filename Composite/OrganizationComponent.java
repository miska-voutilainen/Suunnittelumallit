public abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract int getSalary(); 

    public abstract void printXML(String indent);

    public void add(OrganizationComponent component) {
    }

    public void remove(OrganizationComponent component) {
    }
}
