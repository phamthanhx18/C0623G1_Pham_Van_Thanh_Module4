package com.example.mailbox.controller;

import com.example.mailbox.model.Mailbox;
import com.example.mailbox.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailboxController {
    @Autowired
    private IMailboxService mailboxService;

    @GetMapping("/setting")
    public String showSettings(Model model) {
        model.addAttribute("mailbox",mailboxService.getMailbox());
        return "setting";
    }

    @PostMapping("/save")
    public ModelAndView saveSettings(@ModelAttribute Mailbox mailbox) {
        mailboxService.updateMailbox(mailbox);
        return new ModelAndView("redirect:setting");
    }
}
