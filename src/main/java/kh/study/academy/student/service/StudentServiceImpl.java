package kh.study.academy.student.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.study.academy.student.vo.PaymentVO;
import kh.study.academy.student.vo.StudentVO;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	 @Autowired
	  SqlSessionTemplate sqlSession;
	 
	 @Override
		public String getNextStudentCode() {
		
		 return sqlSession.selectOne("studentMapper.getNextStudentCode");
		}
	 
	 
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertStudent(StudentVO studentVO, PaymentVO paymentVO) {
		
		sqlSession.insert("studentMapper.insertStudent", studentVO);
		sqlSession.insert("studentMapper.insertPayment", paymentVO);
	}

	
	// 학생 리스트 조회
	@Override
	public List<StudentVO> selectStuList() {
		return sqlSession.selectList("studentMapper.selectStuList");
	}

	//학생 선택 삭제
	@Override
	public void deleteCheckedStu(StudentVO studentVO) {
		sqlSession.delete("studentMapper.deleteCheckedStu", studentVO);
	}

	
	//학생 삭제
	@Override
	public void deleteStu(String studentCode) {
		sqlSession.delete("studentMapper.deleteStu", studentCode);
	}

	

	 
	 
	 
	 
}