package test.book.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.cfg.context.Cascadable;



@Entity
public class Bookmark implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*
	 *  If you are using Glassfish then remove the strategy attribute
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;
	
	@Column
	private String description;
	
	@Column
	private String link;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="bookmark",cascade=CascadeType.ALL)
	private List<Author> author;
	
	public Bookmark() {
		super();
	}
	
	public Bookmark(String description, String link) {
		this.description = description;
		this.link = link;
	}
	
	public Bookmark(String description, String link, List<Author> authors) {
		this.description = description;
		this.link = link;
		this.author = authors;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

}
