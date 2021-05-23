package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Question;

@Service
public interface QuestionService {
	List<Question> findQuestionsByExamIdandLevelIdService(int ExamId,int LevelId);
	void addQuestionService(Question qu);
	 void removeQuestionService(int QS_NO);
}
