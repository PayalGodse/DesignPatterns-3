package flyweight;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class RunArray {
	private ArrayList<RunElement> array;

	public RunArray() {
		array = new ArrayList<>();
	}

	public ArrayList<RunElement> getArray() {
		return array;
	}

	public void addRun(int start, int end, Font font) {
		if (array.isEmpty())
			array.add(new RunElement(start, end, font));
		else {
			RunElement run = array.get(array.size() - 1);
			if (run.font.equals(font))
				run.update();
			else
				array.add(new RunElement(start, end, font));

		}
		Collections.sort(array);

	}

	public void appendRun(int end, Font font) {
		if (!array.isEmpty()) {
			RunElement run = array.get(array.size() - 1);
			addRun(run.start + run.length, end, font);
		} else
			array.add(new RunElement(0, end, font));
	}

	public Font getFont(int index) {
		Iterator<RunElement> runIterator = array.iterator();
		while (runIterator.hasNext()) {
			RunElement run = runIterator.next();
			Font font = run.getFont(index);
			if (font != null)
				return font;
		}
		return null;

	}

	private class RunElement implements Comparable<RunElement> {

		private int start;
		private int length;
		private Font font;

		public RunElement(int start, int end, Font font) {
			this.start = start;
			this.length = end;
			this.font = font;
		}

		public Font getFont(int index) {
			if ((index >= start) && (index < start + length))
				return font;
			return null;
		}

		public void update() {
			length++;
		}

		@Override
		public int compareTo(RunElement run) {

			int compareStart = ((RunElement) run).start;
			return this.start - compareStart;
		}
	}
}
