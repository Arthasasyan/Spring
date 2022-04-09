package dao;

import entity.FriendshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("friendshipDao")
public interface FriendshipEntityRepository extends JpaRepository<FriendshipEntity, Long> {
}