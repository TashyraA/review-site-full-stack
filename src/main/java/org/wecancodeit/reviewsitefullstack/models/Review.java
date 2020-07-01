package org.wecancodeit.reviewsitefullstack.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String imageUrl;
    private String content;
    @ManyToOne
    private Category category;

    public Review(){

    }



    public Review(String title, String imageUrl, String content, Category category) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.content = content;
        this.category = category;
    }




    public Long getId(){

        return id;
    }

    public String getTitle(){
        return title;

    }

    public String getImageUrl(){
        return imageUrl;

    }

    public String getContent(){
        return content;

    }

    public Category getCategory(){
        return category;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
