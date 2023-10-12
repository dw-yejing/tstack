package edu.bjtu.springsecurity.security;

import edu.bjtu.springsecurity.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("UserDetailsService")
public class DomainUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据中检索并匹配该用户 认证
        // select * from user where name = #{username}
        // 匹配成功返回一个 org.springframework.security.core.userdetails.User
        UserInfo user = new UserInfo();
        List<String> roleIds = new ArrayList<>();
        Set<String> permissions = new HashSet<>();
        return createSpringSecurityUser(user, roleIds, permissions);
    }

    private SecurityUser createSpringSecurityUser(UserInfo user, List<String> roleIds, Set<String> permissions ) {
        Set<String> authSet = new HashSet<>();
        // 授权
        if (null!=roleIds) {
            // 获取角色
            roleIds.forEach(roleId -> authSet.add("role_"+roleId));
            // 获取资源
            authSet.addAll(permissions);
        }

        Collection<? extends GrantedAuthority> authorities  = AuthorityUtils.createAuthorityList(authSet.toArray(new String[0]));
        return new SecurityUser(user.getId(), user.getAccount(), user.getPassword(),true, true,  authorities);

    }
}
