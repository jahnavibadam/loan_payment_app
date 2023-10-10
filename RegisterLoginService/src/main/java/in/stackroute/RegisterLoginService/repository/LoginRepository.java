package in.stackroute.RegisterLoginService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.stackroute.RegisterLoginService.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);


}