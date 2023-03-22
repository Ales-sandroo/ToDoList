package it.softwareInside.NoteAppLezione22.Repository;

import org.springframework.data.repository.CrudRepository;

import it.softwareInside.NoteAppLezione22.Models.Note;

public interface NoteRepository extends CrudRepository<Note , Integer> {

}
