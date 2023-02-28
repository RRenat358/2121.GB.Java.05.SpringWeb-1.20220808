package ru.rrenat358.persist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public interface UserRepository {

    List<User> findAll();

    User findById(long id);

    void insert(User user);

    void update(User user);

    void delete(long id);

    long getCount();

}
