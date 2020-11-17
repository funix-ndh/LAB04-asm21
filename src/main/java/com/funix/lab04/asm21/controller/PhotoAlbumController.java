package com.funix.lab04.asm21.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.funix.lab04.asm21.model.PhotoAlbum;
import com.funix.lab04.asm21.repository.PhotoAlbumRepositoryInterface;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/photo-album")
@RequiredArgsConstructor
public class PhotoAlbumController {

    private final PhotoAlbumRepositoryInterface photoAlbumRepositoryInterface;

    @GetMapping
    public ModelAndView index() {
        final List<PhotoAlbum> photoAlbumList = photoAlbumRepositoryInterface.findAll();
        return new ModelAndView("photo-album", "photoAlbumList", photoAlbumList);
    }
}
