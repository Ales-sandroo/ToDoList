package it.softwareInside.NoteAppLezione22.Service;


import org.springframework.beans.factory.annotation.Autowired;

import it.softwareInside.NoteAppLezione22.Models.Note;
import it.softwareInside.NoteAppLezione22.Repository.NoteRepository;
import jakarta.validation.Valid;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	NoteRepository noteRepository;

	public boolean addNote(@Valid Note nota) {

		try {
			noteRepository.save(nota);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Note cercaNota(int id) {

		try {
			return noteRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	public boolean update(@Valid Note nota) {
		return addNote(nota);
	}

	public Note deleteNote(Integer id) {
		Note nota = noteRepository.findById(id).get();
		noteRepository.deleteById(id);
		return nota;
	}

	public boolean deleteAllData(String pass) {
		String myPassString = "123456";
		if (!pass.equals(myPassString))
			return false;
		try {
			noteRepository.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
