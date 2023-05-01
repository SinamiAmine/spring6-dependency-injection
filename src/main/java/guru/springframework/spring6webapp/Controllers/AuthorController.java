package guru.springframework.spring6webapp.Controllers;

import guru.springframework.spring6webapp.Services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public String getAuthors(Model model){
        model.addAttribute("authors",authorService.findAll());
        return "authors";
    }
}
