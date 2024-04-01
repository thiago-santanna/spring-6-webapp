package tss.webapp.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tss.webapp.spring6webapp.domain.Author;
import tss.webapp.spring6webapp.domain.Book;
import tss.webapp.spring6webapp.domain.Publisher;
import tss.webapp.spring6webapp.repositories.AuthorRepository;
import tss.webapp.spring6webapp.repositories.BookRepository;
import tss.webapp.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "456");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        Publisher publisher = new Publisher("Publisher Name", "Publisher Address", "City", "State", "Zip");

        Publisher publisherSaved = publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
