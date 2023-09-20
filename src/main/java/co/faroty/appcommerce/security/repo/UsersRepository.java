package co.faroty.appcommerce.security.repo;

import co.faroty.appcommerce.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
  Users findByUserName(String userName);
}
