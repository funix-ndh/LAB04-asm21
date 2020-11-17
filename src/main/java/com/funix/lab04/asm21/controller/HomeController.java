package com.funix.lab04.asm21.controller;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.funix.lab04.asm21.model.WeddingBlog;
import com.funix.lab04.asm21.repository.WeddingBlogRepositoryInterface;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {

    private final WeddingBlogRepositoryInterface weddingBlogRepositoryInterface;

    @GetMapping
    public ModelAndView index() {
        final List<WeddingBlog> weddingBlogList = weddingBlogRepositoryInterface.findAll().stream().sorted(
                Comparator.comparing(WeddingBlog::getPublishedDate).reversed()).collect(Collectors.toList());
        return new ModelAndView("home", "weddingBlogList", weddingBlogList);
    }

    @GetMapping("/details/{id}")
    public ModelAndView detail(@PathVariable("id") final Integer id) {
        final Optional<WeddingBlog> weddingBlog = weddingBlogRepositoryInterface.findById(id);
        if (weddingBlog.isPresent()) {
            return new ModelAndView("home-details", "weddingBlog", weddingBlog.get());
        }
        return new ModelAndView("404");
    }

    @GetMapping("/overview")
    public ModelAndView overview() {
        final Map<LocalDate, List<WeddingBlog>> weddingBlogList =
                weddingBlogRepositoryInterface.findAll().stream().collect(Collectors.groupingBy(WeddingBlog::getPublishedDate));
        return new ModelAndView("overview", "weddingBlogList", weddingBlogList);
    }
}
