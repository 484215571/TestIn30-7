package com.example.dao;

import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository                               //类的名字和主键
public interface UserDao extends JpaRepository<User,Long> {

    @Query(value = "select * from user where name like %?1% ",nativeQuery = true)
    Page<User> findNameLike(String name, Pageable pageable);
}
