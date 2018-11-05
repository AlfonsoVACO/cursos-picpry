package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Questions;

@Repository("questionsRepository")
public interface QuestionsRepository extends JpaRepository<Questions, Integer>{

}
