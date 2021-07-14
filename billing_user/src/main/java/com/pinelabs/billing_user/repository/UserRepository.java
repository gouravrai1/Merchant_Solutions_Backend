package com.pinelabs.billing_user.repository;

import com.pinelabs.billing_user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select * from bl_user b where b.user_id=id",nativeQuery = true)
    User findByName(@Param("user_id") Long id);
}
