package sienge.services;

import java.util.Optional;

import sienge.models.User;

public interface UserService {
  public User save(User u);

  public Iterable<User> list();

  public Iterable<User> list(Optional<String> query);

  public Optional<User> get(long id);

  public Optional<User> update(long id, User u);

  public boolean delete(long id);
}
