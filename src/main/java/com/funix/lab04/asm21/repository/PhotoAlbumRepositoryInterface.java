package com.funix.lab04.asm21.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funix.lab04.asm21.model.PhotoAlbum;

public interface PhotoAlbumRepositoryInterface extends JpaRepository<PhotoAlbum, Integer> {
}
