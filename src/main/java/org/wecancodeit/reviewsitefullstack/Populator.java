package org.wecancodeit.reviewsitefullstack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviewsitefullstack.models.Category;
import org.wecancodeit.reviewsitefullstack.models.Review;
import org.wecancodeit.reviewsitefullstack.repositories.CategoryRepository;
import org.wecancodeit.reviewsitefullstack.repositories.ReviewRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private CategoryRepository categoryRepo;
    @Resource
    private ReviewRepository reviewRepo;

    @Override
    public void run(String... args) throws Exception {
        Category horror = new Category("Horror");
        Category comedy = new Category("Comedy");
        Category action = new Category("Action");
        categoryRepo.save(horror);
        categoryRepo.save(comedy);
        categoryRepo.save(action);

        Review slenderMan = new Review("SlenderMan", "../images/slenderman.jpg", "Small-town best friends Hallie, Chloe, Wren and Katie go online to try and conjure up the Slender Man -- a tall, thin, horrifying figure whose face has no discernible features.", horror);
        Review sinister = new Review ("Sinister", "../images/sinister.jpg", "True-crime writer Ellison Oswald (Ethan Hawke) is in a slump; he hasn't had a best seller in more than 10 years and is becoming increasingly desperate for a hit. So, when he discovers the existence of a snuff film showing the deaths of a family, he vows to solve the mystery.", horror);
        Review whatMenWant = new Review("What Men Want", "../images/whatMenWant.jpg", "Passed up for a well-deserved promotion, sports agent Ali Davis wonders what else she needs to do to succeed in a man's world.", comedy);
        Review nobodysFool = new Review("Nobody's Fool", "../images/nobodysFool.jpg", "After serving five years in prison, wild child Tanya looks to her buttoned-up, by-the-book sister Danica to help her get back on her feet.", comedy);
        Review constantine = new Review ("Constantine", "../images/constantine.jpg", "As a suicide survivor, demon hunter John Constantine (Keanu Reeves) has literally been to hell and back -- and he knows that when he dies, he's got a one-way ticket to Satan's realm unless he can earn enough goodwill to climb God's stairway to heaven.", action);
        Review theLastDays = new Review("The last days", "../images/lastDays.jpg", "Three months after a cataclysmic event trapped him and his fellow employees in their office building, a man (Quim Gutiérrez) emerges to look for his girlfriend.", action);
        reviewRepo.save(slenderMan);
        reviewRepo.save(sinister);
        reviewRepo.save(whatMenWant);
        reviewRepo.save(nobodysFool);
        reviewRepo.save(constantine);
        reviewRepo.save(theLastDays);

    }
}
