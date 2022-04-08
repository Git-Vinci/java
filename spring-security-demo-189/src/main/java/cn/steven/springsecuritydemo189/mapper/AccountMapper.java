package cn.steven.springsecuritydemo189.mapper;

import cn.steven.springsecuritydemo189.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {
    List<Account> queryAccountByUserName(String name);
}
