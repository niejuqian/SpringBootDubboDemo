package com.springboot.dubbo.demo.multi.datasource.jpa.test;

import com.springboot.dubbo.demo.multi.datasource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Created by laonie on 2018/9/18.
 */
public interface TestUserRepository extends JpaRepository<UserEntity,String>,JpaSpecificationExecutor<UserEntity>,Serializable {
}
