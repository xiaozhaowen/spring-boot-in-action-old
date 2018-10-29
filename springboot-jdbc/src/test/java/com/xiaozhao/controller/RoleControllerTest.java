package com.xiaozhao.controller;

import com.xiaozhao.SpringbootJdbcApplication;
import com.xiaozhao.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Created by xiaozhao on 2018/10/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJdbcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleControllerTest {


    private static final Logger log = LoggerFactory.getLogger(RoleControllerTest.class);

    @Autowired
    private TestRestTemplate template;
    @LocalServerPort
    private int port;

    @Test
    public void queryRoles() throws Exception {
        ResponseEntity<List<Role>> listResponseEntity = template.exchange("http://localhost:" + port + "/role/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Role>>() {
                });
        final List<Role> body = listResponseEntity.getBody();
        log.info("-------遍历开始----------");
        for (Role row : body) {
            log.info(row.toString());
        }
        log.info("-------遍历结束----------");
    }

    @Test
    public void findRole() throws Exception {
        Integer roleId = 1;
        ResponseEntity<Role> entity = template.getForEntity("http://localhost:" + port + "/role/find/{id}", Role.class, roleId);
        log.info("[主键查询] - {}", entity.getBody());
    }

    @Test
    public void addRole() throws Exception {
        Role role = new Role();
        role.setName("Hello");
        template.postForEntity("http://localhost:" + port + "/role/add", role, Integer.class);
    }

    @Test
    public void delUser() throws Exception {
        Integer id = 10;
        template.delete("http://localhost:" + port + "/role/delete/{id}", id);
        log.info("删除用户成功");
    }

    @Test
    public void editUser() throws Exception {
        template.put("http://localhost:" + port + "/role/update", new Role(1, "pass11"));
        log.info("修改用户成功");
    }


}