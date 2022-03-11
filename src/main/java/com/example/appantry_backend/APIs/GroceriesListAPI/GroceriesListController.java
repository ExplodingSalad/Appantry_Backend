package com.example.appantry_backend.APIs.GroceriesListAPI;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GroceriesListController {

    final GroceriesListService groceriesListService;
    final ModelMapper modelMapper;

    // Constructor Injection
    public GroceriesListController(GroceriesListService groceriesListService, ModelMapper modelMapper) {
        this.groceriesListService = groceriesListService;
        this.modelMapper = modelMapper;
    }

    // GET all lists
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<GroceriesListDto> readGroceriesLists() {
        return groceriesListService.getGroceriesLists().stream()
                .map(groceriesList -> modelMapper.map(groceriesList, GroceriesListDto.class))
                .collect(Collectors.toList());
    }

    // GET specific list
    @RequestMapping(value = "/list/{list_id}", method = RequestMethod.GET)
    public GroceriesListDto readSpecificGroceriesList(@PathVariable(value = "list_id") Long id) {
        return groceriesListService.getSpecificGroceriesList(id)
                .map(groceriesList -> modelMapper.map(groceriesList, GroceriesListDto.class))
                .orElseThrow(NoSuchElementException::new);
    }

    // POST (create resource)
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<String> createProduct(@Valid @RequestBody GroceriesListDto groceriesListDto) {
        // convert input DTO to Entity
        GroceriesList groceriesListRequest = modelMapper.map(groceriesListDto, GroceriesList.class);

        GroceriesList groceriesList = groceriesListService.createGroceriesList(groceriesListRequest);

        // convert Entity to DTO
        GroceriesListDto groceriesListResponse = modelMapper.map(groceriesList, GroceriesListDto.class);

        return new ResponseEntity<String>("Item added: " + groceriesListResponse, HttpStatus.OK);
    }

    // TODO: PUT method for lists
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

    /**
    // ADD specific product to specific list -> PUT
    @RequestMapping(value = "list/{list_id}", method = RequestMethod.PUT)
    public GroceriesList addProductToList(@PathVariable(value = "list_id") Long id, @RequestBody Set<Product> product) {
        return groceriesListService.addProductToList(product, id);
    }
    */
}
