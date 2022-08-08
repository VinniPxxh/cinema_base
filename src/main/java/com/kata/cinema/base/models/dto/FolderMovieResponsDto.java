package com.kata.cinema.base.models.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FolderMovieResponsDto {



    @Id
    @GeneratedValue
    private Long id;
    private String category; //Category
    private String privacy; //Privacy
    private String name;
    private String description;

    public static FolderMovieResponsDto create(String category, String privacy, String name, String description) {
        FolderMovieResponsDto folderMovieResponsDto = new FolderMovieResponsDto();
        folderMovieResponsDto.setCategory(category);
        folderMovieResponsDto.setPrivacy(privacy);
        folderMovieResponsDto.setName(name);
        folderMovieResponsDto.setDescription(description);
        return folderMovieResponsDto;
    }

    public static void AllFoldersMovies() {
        FolderMovieResponsDto folderMovieResponsDto1 = FolderMovieResponsDto.create("drama", "12+", "1+1", "This movie has taken many hearts. This film tells about a disabled person who has lost the meaning of life. And one black, makes him understand that you need to live beautifully and get high." );
        FolderMovieResponsDto folderMovieResponsDto2 = FolderMovieResponsDto.create("anime", "16+", "Naruto", "Anime about a guy who went through terrible difficulties, did not give up and reached the goal." );
        FolderMovieResponsDto folderMovieResponsDto3 = FolderMovieResponsDto.create("comedy", "16+", "malibu lifeguards", "There is an attack in the city, and the police are not doing anything. The rescuers of Malibu have to cope with the bandits." );
    }

}
