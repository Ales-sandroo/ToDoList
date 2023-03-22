package it.softwareInside.NoteAppLezione22.RestController;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.NoteAppLezione22.Models.Note;
import it.softwareInside.NoteAppLezione22.Service.GeneratePdf;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	it.softwareInside.NoteAppLezione22.Service.Service service;
	@Autowired
	GeneratePdf servicePdf;

	@PostMapping("/crea")
	public boolean addNota(@RequestBody Note nota) {
		return service.addNote(nota);
	}

	@PostMapping("/update")
	public boolean updateNota(@RequestBody Note nota) {
		return service.addNote(nota);
	}

	@DeleteMapping("/delete")
	public Note deleteNota(@RequestParam Integer id) {
		return service.deleteNote(id);
	}

	@GetMapping("/delete-all")
	public boolean deleteAll() {
		return service.deleteAllData(null);
	}

	@RequestMapping(value = "/pdf", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> generaNota(@RequestParam("id") int id) {

		try {

			ByteArrayInputStream bis = servicePdf.generaPDFNota(id);

			var headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=nome.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));

		} catch (Exception e) {
			return null;

		}

	}
}
