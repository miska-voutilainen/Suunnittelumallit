import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private List<OrganizationComponent> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public int getSalary() {
        int total = 0;
        for (OrganizationComponent child : children) {
            total += child.getSalary();
        }
        return total;
    }

    @Override
    public void printXML(String indent) {
        System.out.println(indent + "<department name=\"" + name + "\">");
        for (OrganizationComponent child : children) {
            child.printXML(indent + "  ");
        }
        System.out.println(indent + "</department>");
    }

    @Override
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }
}
