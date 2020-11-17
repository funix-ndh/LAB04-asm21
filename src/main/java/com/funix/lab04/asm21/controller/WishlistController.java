package com.funix.lab04.asm21.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.funix.lab04.asm21.model.Wishlist;
import com.funix.lab04.asm21.repository.WishlistRepositoryInterface;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistRepositoryInterface wishlistRepositoryInterface;

    @GetMapping
    public ModelAndView index() {
        final Wishlist wishList = Objects.requireNonNull(wishlistRepositoryInterface.findById(1).orElse(null));
        return new ModelAndView("wishlist", "content", wishList.getContent());
    }
}

