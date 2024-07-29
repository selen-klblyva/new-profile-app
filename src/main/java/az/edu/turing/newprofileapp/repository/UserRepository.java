package az.edu.turing.newprofileapp.repository;

import az.edu.turing.newprofileapp.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE users u SET u.username = :username, u.age = :age WHERE u.id = :id", nativeQuery = true)
    void updateProfile(@Param("id") Long id, @Param("username") String username, @Param("age") int age);

    @Query(value = "INSERT INTO profile (username, age, created_at, updated_at) VALUES (:username, :age, :createdAt, :updatedAt)", nativeQuery = true)
    int createProfile(@Param("username") String username,
                      @Param("age") int age,
                      @Param("createdAt") LocalDateTime createdAt,
                      @Param("updatedAt") LocalDateTime updatedAt);



}

