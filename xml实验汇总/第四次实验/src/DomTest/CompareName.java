package DomTest;
/*
 * 重载比较函数
 */
public class CompareName implements Comparable<CompareName>{
	private AnimeSection section;
	@Override
	public int compareTo(CompareName arg0) {
		// TODO Auto-generated method stub
		return section.getAnimename().compareTo(arg0.getSection().getAnimename());
	}
	
	public CompareName(AnimeSection s) {
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
