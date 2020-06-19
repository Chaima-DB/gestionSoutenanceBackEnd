package com.zsmart.gestionDesSoutenances.ws.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zsmart.gestionDesSoutenances.bean.Article;
import com.zsmart.gestionDesSoutenances.service.facade.ArticleService;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;

@Api
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("user/gestionDesSoutenances-api/article")
public class ArticleRest {

	@Autowired
	ArticleService articleService;

	@GetMapping("/")
	public List<Article> findAll() {
		return articleService.findAll();
	}

	@GetMapping("/cne/{cne}")
	public List<Article> findByDoctorantCne(@PathVariable String cne) {
		return articleService.findByDoctorantCne(cne);
	}

	@GetMapping("/cin/{cin}")

	public List<Article> findByDoctorantCin(String cin) {
		return articleService.findByDoctorantCin(cin);
	}

	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return articleService.deleteByReference(reference);
	}

	@PostMapping("/upload")
	public void uploadFile(@PathParam("files") MultipartFile[] files) {
		for (MultipartFile file : files) {
			articleService.uploadFile(file);
		}

	}

	public Article storeFile(MultipartFile file) {
		return articleService.storeFile(file);
	}

	@PostMapping("/uploadFile")
	public Response uploadFile(@RequestParam("file") MultipartFile file) {
		Article fileName = articleService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName.getTitre()).toUriString();

		return new Response((int) file.getSize());
	}
}
