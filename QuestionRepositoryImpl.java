package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Question;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
	@PersistenceContext
	 EntityManager entityManager;
	
	@Transactional
	public List<Question> findQuestionsByExamIdandLevelId(int Exam_Id,int Level_Id){
		Query query=entityManager.createQuery("select q from Question q where exam_id=:ExamId and level_id=:LevelId",Question.class);
		query.setParameter("ExamId",Exam_Id);
		query.setParameter("LevelId",Level_Id);
	   @SuppressWarnings("unchecked")
	   List<Question>quesList=query.getResultList();
	   return quesList;
	
	}
	@Transactional
	public void addQuestion(Question qu) {
		entityManager.persist(qu);
	}
	@Transactional
	public void removeQuestion(int QS_NO) {
		Question question= entityManager.find(Question.class, QS_NO);
		entityManager.remove(question);
	}
}


