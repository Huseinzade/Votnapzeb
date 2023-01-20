package com.example.demo.controller;

import com.example.demo.Contact;
import com.example.demo.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class ContactController {
    private ContactService contactService;

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contactObject",new Contact());
        return "contact";
    }

    @PostMapping("/contact")
    public String postContact(@ModelAttribute("contactObject")Contact contact,
                              RedirectAttributes redirectAttributes) {
        contactService.saveContact(contact);
        redirectAttributes.addFlashAttribute("successMessage","Your submission has been sent successfully!");
        return "redirect:/contact";
    }

}
