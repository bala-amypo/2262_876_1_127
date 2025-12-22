package org.springframework.security.crypto.password;

public interface PasswordEncoder {

    default String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    default boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
