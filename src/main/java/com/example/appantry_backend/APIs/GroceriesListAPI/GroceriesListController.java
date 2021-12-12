package com.example.appantry_backend.APIs.GroceriesListAPI;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GroceriesListController {

    GroceriesListService groceriesListService;

    // Constructor Injection
    public GroceriesListController(GroceriesListService groceriesListService) {
        this.groceriesListService = groceriesListService;
    }

    // GET all products
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<GroceriesList> readGroceriesLists() {
        return groceriesListService.getGroceriesLists();
    }

    // GET specific product
    @RequestMapping(value = "/list/{list_id}", method = RequestMethod.GET)
    public Optional<GroceriesList> readSpecificGroceriesList(@PathVariable(value = "list_id") Long id) {
        return groceriesListService.getSpecificGroceriesList(id);
    }

    // POST (create resource)
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public GroceriesList createProduct(@Valid @RequestBody GroceriesList list) {
        return groceriesListService.createGroceriesList(list);
    }

    /*
    // PUT (update resource)
    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable(value = "product_id") Long id, @RequestBody Product product) {
        return productService.updateProduct(product, id);
    }

     */

    // DELETE
    @RequestMapping(value = "/list/{list_id}", method = RequestMethod.DELETE)
    public void deleteGroceriesList(@PathVariable(value = "list_id") Long id) {
        groceriesListService.deleteGroceriesList(id);
    }
}
