package dao;

import entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("humanDao")
public interface HumanEntityRepositroy extends JpaRepository<HumanEntity, Long> {
}
