package kh.study.academy.statistics.service;

import java.util.List;
import java.util.Map;

import kh.study.academy.statistics.vo.QuarterlySubTestAvg;
import kh.study.academy.statistics.vo.StudentCntPerGrade;
import kh.study.academy.statistics.vo.StudentCntPerSubject;
import kh.study.academy.test.vo.TestVO;

public interface StatisticsService {

	
	
	/* ① 학생현황 통계----------------------------------------------------------------------------------------- */
		
		// ⓐ 학년별 학생 수 
		List<StudentCntPerGrade> selectNumByStuYear();
		
		// ⓑ 과목별 학생 수  
		List<Integer> selectNumByStuSubject(String subjectCode);
		
		// ⓒ 전체 학생 수 
		
	
	/* ② 평가관리 분석 통계------------------------------------------------------------------------------------ */
		
		// ⓐ 분기별 과목 테스트 평균 
		List<QuarterlySubTestAvg> selectQuarterlySubTestAvg(TestVO testVO);
		
	
	/* ③ 교사별 수업현황 통계---------------------------------------------------------------------------------- */
		
		// ⓐ 교사별 프로그램 수
		int selectLessonCntByTeacher(String teacherCode);
		
		// ⓑ 교사별 담당 학생 수 
		int selectStudentCntByTeacher(String teacherCode);
		
	
	
}
