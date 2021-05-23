package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.layer2.Question;
import com.example.demo.layer4.QuestionService;

@RestController
public class QuestionController {

	@Autowired
	QuestionService quesServ;
	
	@GetMapping(path="/getQuestion/{myExamId}/{myLevelId}")
	@ResponseBody
	public List<Question> getQuestionController(@PathVariable("myExamId") int ExamId,@PathVariable("myLevelId") int LevelId) {
		List<Question> quesList=quesServ.findQuestionsByExamIdandLevelIdService(ExamId, LevelId);
		return quesList;
	}
	@PostMapping(path="/addQuestion")
	public void addQuestion(@RequestBody Question qu) {
		quesServ.addQuestionService(qu);;
	}
	 @DeleteMapping(path="/removeQuestion/{myqsNo}")
	 @ResponseBody
	 void removeQuestion(@PathVariable("myqsNo") int QS_NO) {
		 quesServ.removeQuestionService(QS_NO);
	}
}
