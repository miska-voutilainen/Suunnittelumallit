public class Main {
	public static void main(String[] args) {
		Directory root = new Directory("projects");

		Directory src = new Directory("src");
		src.add(new File("Main.java", 0.8));
		src.add(new File("Utils.java", 0.3));
		src.add(new File("Config.java", 0.2));

		Directory resources = new Directory("resources");
		resources.add(new File("banner.png", 2.4));
		resources.add(new File("icon.png", 0.6));
		resources.add(new File("strings.xml", 0.1));

		Directory docs = new Directory("docs");
		docs.add(new File("README.md", 0.05));
		docs.add(new File("architecture.md", 0.12));
		docs.add(new File("diagram.png", 1.8));

		Directory build = new Directory("build");
		build.add(new File("app.jar", 15.3));
		build.add(new File("app.log", 4.7));

		root.add(src);
		root.add(resources);
		root.add(docs);
		root.add(build);
		root.add(new File("build.gradle", 0.04));
		root.add(new File("settings.gradle", 0.02));

		SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
		root.accept(sizeCalculator);
		System.out.printf("Total size of '%s': %.2f MB%n", root.getName(), sizeCalculator.getTotalSize());

		System.out.println();

		String[] extensions = {"java", "png", "md"};
		for (String ext : extensions) {
			SearchVisitor search = new SearchVisitor(ext);
			root.accept(search);
			System.out.printf("Files with .%s extension:%n", ext);
			for (File f : search.getResults()) {
				System.out.printf("  %s (%.2f MB)%n", f.getName(), f.getSize());
			}
			System.out.println();
		}
	}
}
