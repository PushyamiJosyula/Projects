package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.Exam;
import com.example.demo.layer2.ExamLevel;
import com.example.demo.layer2.ExamUser;
import com.example.demo.layer2.Question;
import com.example.demo.layer3.LevelRepository;
import com.example.demo.layer3.QuestionRepository;

@SpringBootTest
class OnlineExamProjectApplicationTests {

	@Autowired
	QuestionRepository QuesRepo;

	
	 @Test 
	 public void testFindQuestion() {
		 List<Question> qlist =  QuesRepo.findQuestionsByExamIdandLevelId(501, 1);
	  for(Question q:qlist) {
	 System.out.println(q.getQsNo());
	 System.out.println(q.getQuestion());
	 System.out.println(q.getOpta());
	 System.out.println(q.getOptb());
	 System.out.println(q.getOptc()); 
	 System.out.println(q.getOptd());
	 System.out.println(q.getCrctOpt());
	 } }
	 
		@Test
		void addQuestion() {
			Question qu=new Question();
			Exam e = new Exam();
			ExamLevel lu = new ExamLevel();
			e.setExamId(501);
			lu.setLevelId(1);
			qu.setExam(e);
			qu.setExamLevel(lu);
			qu.setQsNo(11);
			qu.setQuestion( "Is GarbageCollection is a Manual Process");
			qu.setOpta("True");
			qu.setOptb("False");
			qu.setOptc("Both");
			qu.setOptd("None");
			qu.setCrctOpt("False");
			;
			QuesRepo.addQuestion(qu);;
			
	}
		@Test
		void removeQuestion() {
			QuesRepo.removeQuestion(11);
		}

		@Autowired
		LevelRepository levelRepo;
		@Test
		public void testFindAll() {
			List<ExamLevel> deptlist = levelRepo.findlevels();
			for (ExamLevel l: deptlist) {
				System.out.println(l.getLevelId());
				System.out.println(l.getTotalQs());
				System.out.println(l.getDuration());
				System.out.println(l.getCutoffMarks());
				System.out.println("-----------------");
			}
		
		}
		@Test
		public void updatelevelbylevelId() {
			
			ExamLevel level=new ExamLevel();
			level.setLevelId(3);
			level.setTotalQs(9);
			level.setDuration(10);
			level.setCutoffMarks(7);
			levelRepo.modifyExamLevelByLevel_Id(level);
		}
		@Test
		void getLevel() {
			ExamLevel el=levelRepo.getLevelByLevelId(1);
			System.out.println(el.getTotalQs());
			System.out.println(el.getDuration());
			System.out.println(el.getCutoffMarks());
		}
}
