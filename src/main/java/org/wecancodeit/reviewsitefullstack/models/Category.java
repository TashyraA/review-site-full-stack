package org.wecancodeit.reviewsitefullstack.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;



@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String genre;
    @OneToMany(mappedBy = "category")
    private Collection<Review> reviews;

    public Category() {
//empty constructor for JPA
    }

    public Category(String genre) {
        this.genre = genre;
    }

    public Long getId(){
        return id;
    }

    public String getGenre(){
        return genre;
    }

    public Collection<Review> getReviews(){
        return reviews;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

