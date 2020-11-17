package com.funix.lab04.asm21.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.funix.lab04.asm21.model.Guestbook;
import com.funix.lab04.asm21.repository.GuestbookRepositoryInterface;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/guestbook")
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookRepositoryInterface guestBookRepositoryInterface;

    @GetMapping
    public ModelAndView index() {
        final List<Guestbook> guestbookList = guestBookRepositoryInterface.findAll().stream().sorted(
                Comparator.comparing(Guestbook::getCreatedDate).reversed()).collect(Collectors.toList());
        return new ModelAndView("guestbook", "guestbookList", guestbookList);
    }

    @PostMapping("sending-msg")
    public String sendMsg(
            @RequestParam("message") final String message,
            @RequestParam("name") final String name,
            @RequestParam("email") final String email,
            @RequestParam("website") final String website,
            @RequestParam("file") final MultipartFile file
    ) throws IOException {
        final String filePath = file.isEmpty() ? null : String.format("%s-%s", UUID.randomUUID(),
                                                                      file.getOriginalFilename());
        final Guestbook guestBook =
                guestBookRepositoryInterface.save(Guestbook.builder()
                                                           .message(message)
                                                           .name(name)
                                                           .email(email)
                                                           .website(website)
                                                           .imgUrl(filePath)
                                                           .createdDate(LocalDateTime.now())
                                                           .build());

        // write file
        if (!file.isEmpty()) {
            final Path filepath = Paths.get(new ClassPathResource("static/images").getFile().getAbsolutePath(),
                                            guestBook.getImgUrl());
            try (OutputStream os = Files.newOutputStream(filepath)) {
                os.write(file.getBytes());
            }
        }

        return "redirect:/guestbook";
    }

}
