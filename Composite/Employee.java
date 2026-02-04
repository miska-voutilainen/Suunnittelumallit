public class Employee extends OrganizationComponent {
    private int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void printXML(String indent) {
        System.out.println(indent + "<employee name=\"" + name + "\" salary=\"" + salary + "\" />");
    }
}
