package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Question;
import com.example.demo.layer3.QuestionRepositoryImpl;

@Service
public class QuestionServiceImpl implements QuestionService{
	 @Autowired
	 QuestionRepositoryImpl quesRepo;
	@Override
	public List<Question> findQuestionsByExamIdandLevelIdService(int ExamId, int LevelId) {
		List<Question>quesList=quesRepo.findQuestionsByExamIdandLevelId(501, 1);
		   return quesList;
	}
	@Override
	public void addQuestionService(Question qu) {
		quesRepo.addQuestion(qu);
		
	}
	@Override
	public void removeQuestionService(int QS_NO) {
	    quesRepo.removeQuestion(QS_NO);
		
	}

}
