package com.springboot.dubbo.demo.common.permission;

import com.springboot.dubbo.demo.common.collection.ArrayHashMap;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

@Component
public class PermissionScanner {

    private static ArrayHashMap<String, PermissionGroup> permissionGroupMapList;

    public static List<PermissionGroup> getPermissionGroups() {
        return permissionGroupMapList.getList();
    }

    @PostConstruct
    public void init() throws ClassNotFoundException, IllegalAccessException {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(PermissionType.class));
        permissionGroupMapList = ArrayHashMap.newInstance();
        for (BeanDefinition beanDefinition : scanner.findCandidateComponents("com.bugongbore.**")) {
            Class<?> c = Class.forName(beanDefinition.getBeanClassName());

            Field[] fields = c.getDeclaredFields();

            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers()) || !field.getType().isAssignableFrom(String.class)) {
                    continue;
                }

                String code = (String) field.get(null);

                PermissionGroupDefiner pgd = field.getAnnotation(PermissionGroupDefiner.class);
                if (pgd != null) {
                    permissionGroupMapList.add(code, new PermissionGroup(code, pgd.name()));
                    continue;
                }

                PermissionDefiner pd = field.getAnnotation(PermissionDefiner.class);
                if (pd != null) {
                    PermissionGroup pg = permissionGroupMapList.get(pd.group());
                    if (pg != null) {
                        pg.addPermission(code, new Permission(code, pd.name()));
                    }
                    continue;
                }

                ButtonPermissionDefiner bpd = field.getAnnotation(ButtonPermissionDefiner.class);
                if (bpd != null) {
                    PermissionGroup pg = permissionGroupMapList.get(bpd.group());
                    if (pg == null) {
                        continue;
                    }
                    Permission permission = pg.getPermission(bpd.parentCode());
                    if (permission != null) {
                        permission.addButtonPermission(new ButtonPermission(code, bpd.name()));
                    }
                }

            }
        }
    }
}
