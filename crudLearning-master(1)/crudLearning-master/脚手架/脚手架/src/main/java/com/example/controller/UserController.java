package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController  //表示这里的所有方法返回的数据都是json形式
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping//   @RequestBody注释表示将传过来的json数据转化成User对象，相当于前端直接传递一个对象过来了
    public Result add(@RequestBody User user){
        userService.add(user);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        userService.del(id);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return Result.success(user);
    }
    @GetMapping("/page")
    public Result<Page<User>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false) String name){
        pageNum = 1 ;
        pageSize = 10;
        Page page = userService.findPage(pageNum,pageSize,name);
        log.info("访问页面");
        return  Result.success(page);
    }
}
