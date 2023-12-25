package Database;
import java.util.Date;
import java.util.Objects;
import java.util.Vector; 
public class News {
	private String title; 
	private String description; 
	private String  date;
	
	public News(String title, String description, String  date) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String  getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "News [title=" + title + ", description=" + description + ", date=" + date + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, description, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(title, other.title);
	}
	
}
