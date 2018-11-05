package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Quiz;
import com.codehard.miscursos.repositories.QuizRepository;

@Service("servicioQuiz")
public class QuizServiceImp {
	@Autowired
	@Qualifier("quizRepository")
	private QuizRepository quizRepository;
	
	public Optional<Quiz> getQuizById(Integer id) {
		return quizRepository.findById(id);
	}

	public List<Quiz> getQuizAll() {
		return quizRepository.findAll();
	}

	public Quiz addQuiz(Quiz quiz) {
		return quizRepository.saveAndFlush(quiz);
	}

	public Quiz editQuiz(Quiz quiz) {
		return quizRepository.saveAndFlush(quiz);
	}

	public void deleteQuiz(Integer id) {
		quizRepository.deleteById(id);
	}
	
	public Quiz getQuizByCriteria(Example<Quiz> example) {
		Optional<Quiz> isNull = quizRepository.findOne(example);
		return isNull.isPresent() ? isNull.get() : new Quiz();
	}
}
