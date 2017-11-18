package wisely.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wisely.domain.Person;

/**
 * @author yangyueming
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);
}
