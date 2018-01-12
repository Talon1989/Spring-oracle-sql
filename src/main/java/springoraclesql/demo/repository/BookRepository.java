package springoraclesql.demo.repository;

import org.springframework.data.repository.CrudRepository;
import springoraclesql.demo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
}
