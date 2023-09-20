package co.faroty.appcommerce.repository;

import co.faroty.appcommerce.entity.UsersTokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersTokenRepository extends JpaRepository<UsersTokens,Long> {
}
