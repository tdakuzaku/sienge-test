package sienge.repos;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import sienge.models.Transport;

public interface TransportRepository extends JpaRepository<Transport, Long> {
//  @Query(value = "SELECT * FROM transports t WHERE :query", nativeQuery = true)
//  List<Transport> search(@Param("query") String query);
}
