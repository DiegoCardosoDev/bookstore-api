package com.diego.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diego.bookstore.domain.Categoria;
import com.diego.bookstore.domain.Livro;
import com.diego.bookstore.repositories.CategoriaRepository;
import com.diego.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication  implements CommandLineRunner {
	
	@Autowired
	
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica", "livros de informatica");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert martin", "Lorem Ipsum", cat1);
		
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
