package test.book.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * If you are using Glassfish then remove the strategy attribute
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name="id_bookmark",referencedColumnName="id")
	private Bookmark bookmark;

	public Author() {
		super();
	}

	public Author(String name) {
		this.name = name;
	}
	
	public Author(String name,Bookmark bookmark) {
		this.name = name;
		this.bookmark = bookmark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bookmark getBookmark() {
		return bookmark;
	}

	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
}
