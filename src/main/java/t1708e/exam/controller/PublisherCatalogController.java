package t1708e.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708e.exam.entity.BookDetail;
import t1708e.exam.entity.PublisherCatalog;
import t1708e.exam.repository.BookDetailRepository;
import t1708e.exam.repository.PublisherCatalogRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/catalog")
public class PublisherCatalogController {
    @Autowired
    PublisherCatalogRepository publisherCatalogRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("publisherCatalog", new PublisherCatalog());
        return "catalog/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid PublisherCatalog publisherCatalog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("publisherCatalog", publisherCatalog);
            return "create";
        }
        publisherCatalogRepository.save(publisherCatalog);
        return "redirect:catalog/create";
    }
}
