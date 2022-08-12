package com.edito.fundamentos.repository;

import com.edito.fundamentos.dto.UserDto;
import com.edito.fundamentos.entity.User;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Usando SQL
    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);
    //Usando JPQL
    @Query("Select u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);
    //Usando Query Methods
    List<User> findByName(String name);
    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);
    List<User> findByNameLikeOrderByIdDesc(String name);
    List<User> findByNameContainingOrderByIdDesc(String name);

    //Uso de JPQL con named parameters.
    @Query("SELECT new com.edito.fundamentos.dto.UserDto(u.id, u.name, u.birthDate)" +
    " FROM User u " +
    " WHERE u.birthDate=:parametroFecha " +
    " and u.email=:parametroEmail ")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date,
                                                @Param("parametroEmail") String email);
}
