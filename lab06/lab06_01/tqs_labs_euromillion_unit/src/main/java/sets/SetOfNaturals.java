package sets;

import java.util.*;

public class SetOfNaturals implements Iterable<Integer> {

	private ArrayList<Integer> collection = new ArrayList<>();

	public void add(int element) {
		if (this.collection.contains(element)) {
			throw new IllegalArgumentException("duplicate value: " + element);
		}

		if (element <= 0) {
			throw new IllegalArgumentException("Illegal argument: not a natural number");
		}

		collection.add(element);

	}

	public void add(int[] numbers) {
		for (int number : numbers) {
			this.add(number);
		}
	}

	public static SetOfNaturals fromArray(int[] values) {
		SetOfNaturals newSet = new SetOfNaturals();
		for (int n : values) {
			newSet.add(n);
		}
		return newSet;
	}


	public int size() {
		return this.collection.size();
	}


	public boolean intersects(SetOfNaturals subset) {
		Iterator<Integer> it = subset.iterator();
		while(it.hasNext()) {
			if(!this.contains(it.next())) {
				return false;
			}
		}
		return true;
	}

	public boolean contains(Integer element) {
		return collection.contains(element);
	}

	@Override
	public Iterator<Integer> iterator() {
		return collection.iterator();
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.collection);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final SetOfNaturals other = (SetOfNaturals) obj;

		List<Integer> list01 = (List<Integer>) this.collection.clone();
		Collections.sort(list01);
		List<Integer> list02 = (List<Integer>) other.collection.clone();
		Collections.sort(list02);

		return Objects.equals(list01, list02);
	}


}
