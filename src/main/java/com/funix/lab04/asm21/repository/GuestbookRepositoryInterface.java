package com.funix.lab04.asm21.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funix.lab04.asm21.model.Guestbook;

public interface GuestbookRepositoryInterface extends JpaRepository<Guestbook, Integer> {
}
