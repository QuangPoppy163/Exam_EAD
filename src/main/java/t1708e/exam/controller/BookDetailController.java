package t1708e.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookDetailController {

    @Autowired
    BookDetailRepository bookDetailRepository;

    @Autowired
    PublisherCatalogRepository publisherCatalogRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        List<PublisherCatalog> publisherCatalogs = publisherCatalogRepository.findAll();
        model.addAttribute("book", new BookDetail());
        model.addAttribute("publisherCatalogs", publisherCatalogs);
        return "book/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid BookDetail bookDetail, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", bookDetail);
            return "create";
        }
        bookDetailRepository.save(bookDetail);
        return "redirect:/search";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String search() {
        return "book/search";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/search")
//    public String detail(@Param("name") String name, @Param("author") String author, @Param("genre") String genre, Model model) {
//        List<BookDetail> bookDetails = bookDetailRepository.searchBook(name, genre, author);
//        if (bookDetails == null) {
//            return "error/404";
//        }
//        model.addAttribute("bookDetails", bookDetails);
//        return "book/detail";
//    }
}
