package DomTest;

public class CompareCountry implements Comparable<CompareCountry>{
	private AnimeSection section;
	@Override
	public int compareTo(CompareCountry arg0) {
		// TODO Auto-generated method stub
		return section.getCountry().compareTo(arg0.getSection().getCountry());
	}
	
	public CompareCountry(AnimeSection s) {
		// TODO Auto-generated constructor stub
		section = s;
	}
	
	public AnimeSection getSection() {
		return section;
	}

	public void setection(AnimeSection section) {
		this.section = section;
	}
}
