package com.xiaozhao.repository;

import com.xiaozhao.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiaozhao
 * @date 2018/10/29下午3:54
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
