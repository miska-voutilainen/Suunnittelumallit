public class SizeCalculatorVisitor implements FileSystemVisitor {
	private double totalSize = 0;

	@Override
	public void visitFile(File file) {
		totalSize += file.getSize();
	}

	@Override
	public void visitDirectory(Directory directory) {
		for (FileSystemElement child : directory.getChildren()) {
			child.accept(this);
		}
	}

	public double getTotalSize() {
		return totalSize;
	}
}
