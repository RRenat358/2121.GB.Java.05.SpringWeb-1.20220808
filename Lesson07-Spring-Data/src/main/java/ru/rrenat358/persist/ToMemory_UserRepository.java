package ru.rrenat358.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ToMemory_UserRepository /*implements UserRepository*/{

    private final Map<Long, User> userMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new User("User 1"));
        this.insert(new User("User 2"));
        this.insert(new User("User 3"));
        this.insert(new User("User 4"));
        this.insert(new User("User 5"));
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public Optional<User> userById(long id) {
        return Optional.ofNullable(userMap.get(id));
    }

    public void insert(User user) {
        long id = identity.incrementAndGet();
        user.setId(id);
        userMap.put(id, user);
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(identity.incrementAndGet());
        }
        userMap.put(user.getId(), user);
        return user;
    }

    public void deleteById(long id) {
        userMap.remove(id);
    }

}
