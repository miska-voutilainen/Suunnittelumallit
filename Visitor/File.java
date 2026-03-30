public class File implements FileSystemElement {
	private String name;
	private double size;

	public File(String name, double size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public double getSize() {
		return size;
	}

	public String getExtension() {
		int dot = name.lastIndexOf('.');
		return dot >= 0 ? name.substring(dot + 1) : "";
	}

	@Override
	public void accept(FileSystemVisitor visitor) {
		visitor.visitFile(this);
	}
}
