package com.springboot.dubbo.demo.provider.impl.jpa;

import com.springboot.dubbo.demo.provider.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by niejiuqian on 2018/8/21.
 */
public interface TeacherRepository extends JpaRepository<TeacherEntity,String>,JpaSpecificationExecutor<TeacherEntity>{
}
