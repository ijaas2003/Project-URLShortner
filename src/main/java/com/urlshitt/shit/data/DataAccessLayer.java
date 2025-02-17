package com.urlshitt.shit.data;
import com.urlshitt.shit.models.URLPojo;

import org.springframework.data.jpa.repository.JpaRepository;
// import com.urlshitt.shit.DALResponse;
// import com.urlshitt.shit.models.URLPojo;

public interface DataAccessLayer extends JpaRepository<URLPojo, Long> {
}
