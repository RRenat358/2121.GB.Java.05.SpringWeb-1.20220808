package ru.rrenat358.persist;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository("first")
public class UserRepositoryImpl implements UserRepository {

    private final Map<Long, User> userMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public User findById(long id) {
        return userMap.get(id);
    }

    public void insert(User user) {
        long id = identity.incrementAndGet();
        user.setId(id);
        userMap.put(id, user);
    }

    public void update(User user) {
        userMap.put(user.getId(), user);
    }

    public void delete(long id) {
        userMap.remove(id);
    }

    @Override
    public long getCount() {
        return userMap.size();
    }

}
