package repository;

import java.util.UUID;

public interface BaseRepository<T, R, RL>  {

       R  add(T t);

       T getById(UUID id);
       RL getList();
       boolean edit(UUID id, T t);
       boolean removeById(UUID id);
       boolean removeByObj(T t);
}
