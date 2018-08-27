package com.springboot.dubbo.demo.user.jpa;

import com.springboot.dubbo.demo.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by niejiuqian on 2018/8/21.
 */
public interface UserRepository extends JpaRepository<UserEntity,String>,JpaSpecificationExecutor<UserEntity>{
    UserEntity findFirstByUserName(String userName);
}
