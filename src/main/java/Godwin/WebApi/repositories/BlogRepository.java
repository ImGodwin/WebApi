package Godwin.WebApi.repositories;

import Godwin.WebApi.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Optional<Blog> findByTitle(String title);

}
