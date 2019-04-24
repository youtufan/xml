package DomTest;
/*
 * 自定义的类，用于保存每个section信息，其中一些因为没有使用到被舍去
 */
import java.util.ArrayList;
import java.util.List;

public class AnimeSection {
	private String id;
	private String country;
	private String anime_name;
	private String anime_content;
	private String producer;
	private String form;
	private String author_name;
	private String plot_classifier;
	private String frames_classifier;
	private List<Role>roletable;
	
	public AnimeSection(String i) {
		setId(i);
		roletable = new ArrayList<Role>();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getAnimename() {
		return anime_name;
	}
	public void setAnimename(String name) {
		this.anime_name = name;
	}
	
	public String getAnimecontent() {
		return anime_content;
	}
	public void setAnimecontent(String content) {
		this.anime_content = content;
	}
	
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String name) {
		this.author_name = name;
	}
	
	public String getPlot() {
		return plot_classifier;
	}
	public void setPlot(String plot) {
		this.plot_classifier = plot;
	}
	
	public String getFrames() {
		return frames_classifier;
	}
	public void setFrames(String frames) {
		this.frames_classifier = frames;
	}
	
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public List<Role> getRoletable() {
		return roletable;
	}
	public void addRole(Role role) {
		this.roletable.add(role);
	}
	
}
