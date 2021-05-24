import { Component, OnInit } from '@angular/core';
import { ExamLevel } from 'ExamLevel';
import { Exam } from '../exam-level/Exam';
import { Question } from './Question';
import { QuestionService } from './question.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  

  constructor(private ccs: QuestionService) { }

  ngOnInit(): void {
  }
  ExamId=0;
  LevelId=0;
  tempQuestion: Array<any> | undefined;
  findQuestionsByExamIdLevelId(ExamId: number,LevelId:number){
    alert("I am Called");
    this.ccs.findQuestionsByExamIdLevelIdService(ExamId,LevelId).subscribe((data)=>{
      if(data!=null){
        this.tempQuestion=data;
        alert(this.tempQuestion);
      }
      else{
        alert("unable to fetch data");
      }
    })
  }
  quest: Question = new Question();
  level: ExamLevel = new ExamLevel();
  exam: Exam = new Exam();
  addQuestion(quest:Question){
   this.exam.examId=502;
   this.level.levelId=2;
   quest.exam=this.exam;
   quest.level=this.level;
    this.ccs.addQuestionService(quest).subscribe((data)=>{
      if(data!=null){
        console.log(data);
        alert("adding is successful");
      }},
      (err)=>{
        alert("some thing went wrong");
       console.log(err);
     }
    
    )

 }
}
