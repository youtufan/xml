package DomTest;

public class CompareForm implements Comparable<CompareForm>{
	private AnimeSection section;
	@Override
	public int compareTo(CompareForm arg0) {
		// TODO Auto-generated method stub
		return section.getForm().compareTo(arg0.getSection().getForm());
	}
	
	public CompareForm(AnimeSection s) {
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
