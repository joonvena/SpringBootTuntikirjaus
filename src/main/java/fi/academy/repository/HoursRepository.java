package fi.academy.repository;


import fi.academy.model.Hours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


@Repository
@Transactional
public interface HoursRepository extends JpaRepository<Hours, Integer> {


}
