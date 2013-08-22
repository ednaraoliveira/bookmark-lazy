package test.book.business;

import java.util.ArrayList;
import java.util.List;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import test.book.domain.Author;
import test.book.domain.Bookmark;
import test.book.persistence.BookmarkDAO;

@BusinessController
public class BookmarkBC extends DelegateCrud<Bookmark, Long, BookmarkDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			
			Bookmark bookmark = new Bookmark("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br");
			insert(bookmark);
			
			List<Author> authors = new ArrayList<Author>();
			authors.add( new Author("teste1",bookmark));
			authors.add( new Author("teste2",bookmark));
			bookmark.setAuthor(authors);
			
			bookmark = new Bookmark("Portal", "http://www.frameworkdemoiselle.gov.br");
			insert(bookmark);

			authors = new ArrayList<Author>();
			authors.add( new Author("teste3",bookmark));
			authors.add( new Author("teste4",bookmark));
			bookmark.setAuthor(authors);
		}
	}
}
