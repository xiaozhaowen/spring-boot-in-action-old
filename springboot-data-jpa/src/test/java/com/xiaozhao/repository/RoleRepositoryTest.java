package com.xiaozhao.repository;

import com.xiaozhao.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Created by xiaozhao on 2018/10/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(RoleRepositoryTest.class);

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testList() throws Exception {
        List<Role> list = roleRepository.findAll();
        for(Role r :list){
            log.info(r.toString());
        }
    }

    @Test
    public void testOne() throws Exception {
//        Role role = roleRepository.findById(1);
//       log.info(roleRepository.findById(1).toString());
//        log.info(role.toString());
    }
}