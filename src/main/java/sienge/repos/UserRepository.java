package sienge.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sienge.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
  @Query(value = "SELECT * FROM users u WHERE u.last_name ~* :query OR u.first_name ~* :query", nativeQuery = true)
  List<User> search(@Param("query") String query);
}
