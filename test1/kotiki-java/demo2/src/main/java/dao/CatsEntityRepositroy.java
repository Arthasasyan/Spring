package dao;

import entity.CatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("catsDao")
public interface CatsEntityRepositroy extends JpaRepository<CatsEntity, Long> {
}
