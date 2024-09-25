package com.example.its.domain.repository.impl;

import com.example.its.domain.model.Users;
import com.example.its.domain.repository.UserRepository;
import com.example.its.infrastructure.dao.UsersDao;
import com.example.its.infrastructure.mapper.UsersMapper;
import lombok.RequiredArgsConstructor;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UsersDao usersDao;
    private final UsersMapper usersMapper;


    @Override
    public Optional<Users> findByUsernameAndDeleteflagFalse(String username) {
        Optional<com.example.its.infrastructure.entity.Users> entity = usersDao.findByUsernameAndDeleteflagFalse(username);
        return entity.map(usersMapper::mapToDomain);
    }

    @Override
    public List<Users> findAll() {
        //UserDaoを呼び出す
        List<com.example.its.infrastructure.entity.Users> entities = usersDao.findAll();
        return entities.stream()
                .map(usersMapper::mapToDomain) // エンティティをドメインオブジェクトにマッピング
                .collect(Collectors.toList());
    }

    @Override
    public Users insert(Users users) {
        try {
            com.example.its.infrastructure.entity.Users entity = usersMapper.mapToEntity(users);
            usersDao.insert(entity);
          return usersMapper.mapToDomain(entity);
        }catch (Exception e) {
            throw new RuntimeException("Insert failed: " + e.getMessage());
        }
    }

    @Override
    public Users updatePassword(Users users) {
        try {
            com.example.its.infrastructure.entity.Users entity = usersMapper.mapToEntity(users);
            usersDao.updatePassword(entity);
            return usersMapper.mapToDomain(entity);
        }catch (Exception e) {
            throw new RuntimeException("Insert failed: " + e.getMessage());
        }
    }

    @Override
    public Result<Users> updateDeleteFlag(Users users) {
        return null;
    }
}
