package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Questions;
import com.codehard.miscursos.repositories.QuestionsRepository;

@Service("servicioQuestions")
public class QuestionsServiceImp {
	@Autowired
	@Qualifier("questionsRepository")
	private QuestionsRepository questionsRepository;
	
	public Optional<Questions> getQuestionsById(Integer id) {
		return questionsRepository.findById(id);
	}

	public List<Questions> getQuestionsAll() {
		return questionsRepository.findAll();
	}

	public Questions addQuestions(Questions questions) {
		return questionsRepository.saveAndFlush(questions);
	}

	public Questions editQuestions(Questions questions) {
		return questionsRepository.saveAndFlush(questions);
	}

	public void deleteQuestions(Integer id) {
		questionsRepository.deleteById(id);
	}
	
	public Questions getQuestionsByCriteria(Example<Questions> example) {
		Optional<Questions> isNull = questionsRepository.findOne(example);
		return isNull.isPresent() ? isNull.get() : new Questions();
	}
}
