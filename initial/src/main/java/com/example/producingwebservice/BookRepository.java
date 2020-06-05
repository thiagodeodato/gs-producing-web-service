package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Book;
import io.spring.guides.gs_producing_web_service.Language;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class BookRepository {
    private static final Map<String, Book> books = new HashMap<>();

    @PostConstruct
    public void initData() {
        Book domCasmurro = new Book();
        domCasmurro.setName("Dom Casmurro");
        domCasmurro.setAuthor("Miguel de Cervantes");
        domCasmurro.setLanguage(Language.PTBR);
        domCasmurro.setPrice(10);

        books.put(domCasmurro.getName(), domCasmurro);

        Book oCortico = new Book();
        oCortico.setName("O Cortico");
        oCortico.setAuthor("Aluisio Azevedo");
        oCortico.setLanguage(Language.PTBR);
        oCortico.setPrice(6);

        books.put(oCortico.getName(), oCortico);
    }

    public Book findBook(String name) {
        Assert.notNull(name, "The book's name must not be null");
        return books.get(name);
    }
}