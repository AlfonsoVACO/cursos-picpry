package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Quiz;

@Repository("quizRepository")
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

}
