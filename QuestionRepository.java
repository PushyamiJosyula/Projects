package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Question;

@Repository
public interface QuestionRepository {
	List<Question> findQuestionsByExamIdandLevelId(int ExamId,int LevelId);
	 void addQuestion(Question qu);
	 void removeQuestion(int QS_NO);
}
