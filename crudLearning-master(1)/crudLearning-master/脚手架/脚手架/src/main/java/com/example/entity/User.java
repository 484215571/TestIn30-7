package com.example.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "user")  //映射数据库里边表的名称
@Entity  //@entity是指这个类映射有数据库表
@Data
public class User {
   @Id     //两个注释，表示id是主键，并且是自增形式
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private Integer age;
   private String sex;
   private String address;
   private String phone;
   @Column(name = "create_time") //将表中的字段映射，也可以用一个配置
   private String createTime;
   public User(){}

   public void setId(Long id) {
      this.id = id;
   }

   public Long getId() {
      return id;
   }
}
