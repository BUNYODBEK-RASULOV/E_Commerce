package repository;

import response.BaseResponse;

import java.util.UUID;

public interface BaseRepository<T, R, RL>  extends BaseResponse {

       R  add(T t);

       T getById(UUID id);
       RL getList();
       boolean edit(UUID id, T t);
       boolean removeById(UUID id);
       boolean removeByObj(T t);
}
