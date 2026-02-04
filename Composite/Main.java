public class Main {
    public static void main(String[] args) {
        Department root = new Department("Company");

        Department it = new Department("IT");
        Department hr = new Department("HR");

        Employee mikko = new Employee("Mikko", 4000);
        Employee anna = new Employee("Anna", 3500);
        Employee jussi = new Employee("Jussi", 3000);

        it.add(mikko);
        it.add(anna);
        hr.add(jussi);

        root.add(it);
        root.add(hr);
        root.add(it);
        root.add(hr);

        System.out.println("Organization structure in XML:");
        root.printXML("");

        System.out.println("\nTotal salary: " + root.getSalary() + " €");
    }
}
