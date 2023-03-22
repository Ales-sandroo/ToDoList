package it.softwareInside.NoteAppLezione22.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Note {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	@NotNull
	@NotBlank
	private String text;

	@NotBlank
	@NotNull
	private String autore;

	public Note(String autore, String text) {
		setAutore(autore);
		setText(text);
	}
}
