package com.diego.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.bookstore.domain.Categoria;
import com.diego.bookstore.domain.Livro;
import com.diego.bookstore.repositories.CategoriaRepository;
import com.diego.bookstore.repositories.LivroRepository;

@Service

public class DBservice {
	
@Autowired
	
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	
	private LivroRepository livroRepository;

	
	public void InstanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "ti", "livros de programação");
		Categoria cat2 = new Categoria(null, "ti", "livros Biografia");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "java como Programar", "Paul deitel", "Lorem Ipsum", cat1);
		Livro l3 = new Livro(null, "C como programar", " Paul deitel", "Lorem Ipsum", cat1);
		Livro l4 = new Livro(null, "Steve Jobs", "Walter issacson", "Lorem Ipsum", cat2);
		Livro l5 = new Livro(null, "elon Musk", "Ashlee Vance", "Lorem Ipsum", cat2);	
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));

		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l2,l3,l4,l5));
	}

}
