package com.novare.natflix.repositories;

import com.novare.natflix.models.Documentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentaryRepository extends JpaRepository<Documentary,Long> {

    Documentary findByMediaId(Long mediaId);

}
