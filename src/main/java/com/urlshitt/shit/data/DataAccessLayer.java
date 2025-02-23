package com.urlshitt.shit.data;
import com.urlshitt.shit.models.URLPojo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import com.urlshitt.shit.DALResponse;
// import com.urlshitt.shit.models.URLPojo;
import org.springframework.data.jpa.repository.Query;

public interface DataAccessLayer extends JpaRepository<URLPojo, Long> {
  @Query("SELECT COUNT(u) > 0 FROM URLPojo u WHERE LOWER(u.url) = LOWER(:url)")
  boolean existsByUrl(String url);
}
