package dev.bhargav.productservice.Controller;

import dev.bhargav.productservice.Service.SearchService;
import dev.bhargav.productservice.dtos.SearchRequestdto;
import dev.bhargav.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchRequestdto searchRequestdto)
    {

        return searchService.search(
                searchRequestdto.getQuery(),
                searchRequestdto.getPagenumber(),
                searchRequestdto.getPagesize()
        );

    }
}
