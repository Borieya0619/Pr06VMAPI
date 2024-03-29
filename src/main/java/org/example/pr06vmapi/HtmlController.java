package org.example.pr06vmapi;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.time.LocalDate;
import java.util.Locale;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit-page";
    }

    @GetMapping("/changelocale")
    public String changeLocale(HttpSession session) {
        Locale locale = (Locale) session.getAttribute(
                SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME
        );

        if (Locale.KOREA.equals(locale)) {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                    Locale.ENGLISH);
        } else {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                    Locale.KOREA);
        }

        return "redirect:/";}
}