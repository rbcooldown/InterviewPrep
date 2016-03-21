package vmturbo;

public class DecorationSorter {
	ScannerAndSorter sorter;

	public DecorationSorter(ScannerAndSorter sorter) {
		this.sorter = sorter;
	}

	// Sort the decorations that 'sorter' reads
	void sort() {
		while (sorter.nextItem()) {
			double rp = sorter.redPercentage();
			double gp = sorter.greenPercentage();
			if (rp > 0.35 && gp > 0.3)
				sorter.reject();
			else if (rp > 0.35)
				sorter.sendToRed();
			else if (gp > 0.3)
				sorter.sendToGreen();
		}
	}
}
