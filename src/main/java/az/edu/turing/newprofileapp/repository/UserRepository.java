package az.edu.turing.newprofileapp.repository;

import az.edu.turing.newprofileapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    void create_User(UserEntity userEntity);

    void update_User(UserEntity userEntity);
}
