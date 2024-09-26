package com.example.its.domain.repository.impl;

import com.example.its.domain.model.Users;
import com.example.its.domain.repository.UserRepository;
import com.example.its.infrastructure.dao.UsersDao;
import com.example.its.infrastructure.mapper.UsersMapper;
import lombok.RequiredArgsConstructor;
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
    public List<Users> userSearch(String username, String authority) {
        try {
            // 引数を使ってユーザーを検索
            List<com.example.its.infrastructure.entity.Users> entities = usersDao.userSearch(username, authority);
            return entities.stream()
                    .map(usersMapper::mapToDomain) // エンティティをドメインオブジェクトにマッピング
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new RuntimeException("ユーザーの検索中にエラーが発生しました。", e);
        }
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
    public Users updateDeleteFlag(String username) {
        try {
            // SQLを呼び出して削除フラグを更新
            int affectedRows = usersDao.updateDeleteFlag(username);
            if (affectedRows > 0) {
                // 更新後のユーザー情報を取得
                com.example.its.infrastructure.entity.Users entity = usersDao.findByUsername(username);
                // マッピングしてドメインオブジェクトとして返す
                return usersMapper.mapToDomain(entity);
            } else {
                // 更新が行われなかった場合の処理
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());// エラーが発生した場合、適切なエラーハンドリングを行うべき
        }
    }


    public com.example.its.infrastructure.entity.Users deleteUserSearch(String username){
        return usersDao.findByUsername(username);
    }

}
