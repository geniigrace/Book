package org.mega.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    // Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로 Null Point Error 가 발생하지 않는다.
    // List와 비슷

}
