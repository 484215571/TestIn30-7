package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public void add(User user){
        userDao.save(user);
    }
    public void update(User user){
        userDao.save(user);
    }
    public void del(Long id){
       userDao.deleteById(id);
    }
    public User findById(Long id){
        //                      如果查找失败，则返回null
        return userDao.findById(id).orElse(null);
    }

    public Page<User> findPage(Integer pageNum,Integer pageSize,String name){
        //  创建排序规则，根据创建事件进行降序排列
        Sort sort = Sort.by(Sort.Direction.DESC,"create_time");
        Pageable pageable = PageRequest.of(pageNum,pageSize,sort);
        return userDao.findNameLike(name,pageable);
    }
}
