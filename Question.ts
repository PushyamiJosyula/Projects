import { ExamLevel } from "ExamLevel";
import { Exam } from "../exam-level/Exam";


export class Question{

	 qsNo: number |undefined;
	
	crctOpt: string|undefined;

	 opta: string|undefined;

	 optb: string|undefined;

	 optc: string|undefined;

	 optd: string|undefined;

	 question: string|undefined;
	 level: ExamLevel |undefined;
	 exam: Exam |undefined;
}