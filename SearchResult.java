
public class SearchResult {
	public SearchResult(String fileName, int entryIndex) {
		this.fileName = fileName;
		this.entryIndex = entryIndex;
	}
	@Override
	public String toString() {
		return "fileName=" + fileName + ", entryIndex=" + entryIndex;
	}
	String fileName;
	int entryIndex;
}
