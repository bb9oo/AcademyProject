package kh.study.academy.admin.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.study.academy.admin.service.AdminService;
import kh.study.academy.admin.vo.LessonRoomVO;
import kh.study.academy.admin.vo.SubjectVO;
import kh.study.academy.lesson.vo.LessonVO;
import kh.study.academy.teacher.vo.TeacherVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	
	
	
	//교사리스트 페이지로 이동
	@RequestMapping("/teacherList")
	public String teacherList(@RequestParam Map<String, String> paramMap , Model model) {

		
		
		//System.out.println("이름 : " + paramMap.get("teacherName"));
		
		
		
		
		
		
		//교사리스트
		model.addAttribute("teacherList", adminService.selectTeacherList());
		
		//교사 검색
		model.addAttribute("searchTeacher", adminService.searchTeacher(paramMap));

		return "content/admin/teacherList";

	}
	
	
	//교사 팝업으로 이동 ..
	@RequestMapping("/popup")
	public String pop( String teacherCode, Model model) {
	
		
		System.out.println("@@@@@@@@@@"+teacherCode);
		model.addAttribute("teacherDetail", adminService.selectTeacherDetail(teacherCode));
		

		
		return "content/admin/teacherPopup";
	}
	
	//교사 상태 변경 클릭시
	//수정 중 아직 Ajax 안 만들었음
	@ResponseBody
	@PostMapping("/changeTeacherStatusAjax")
	public void changeTeacherStatus(TeacherVO teacherVO) {
		adminService.changeTeacherStatus(teacherVO);
	}
	
	//통계 페이지로 이동 
	
	@GetMapping("/statistics")
	public String statistics(Model model) {

		


		return "content/admin/statistics";

	}
	
	
	
	
	
/////<과목 등록 관련>//////////////////////////////////////////////////////////// 
	
	
	// 과목 등록 (수학, 과학) 
	@PostMapping("/regSubject")
	public String regSubject(SubjectVO subjectVO) {
		adminService.insertSubject(subjectVO);

		return "redirect:/admin/selectSubject";
	}
	// 내가 등록한 과목들을 조회 (과목등록페이지로 이동)
	@GetMapping("/selectSubject")
		public String selectSubject(Model model){
		
		model.addAttribute("selectSubject", adminService.selectSubject());
		
		return "content/admin/reg_subject";
	}
	
	// 내가 등록한 과목들 체크박스 삭제
	@PostMapping("/deleteSubject")
	public String deleteSubject(String subjectCodes) {
		String[] subjectCodeArr = subjectCodes.split(","); // 배열을 리스트로 변환작업 2줄
		List<String> subjectCodeList = Arrays.asList(subjectCodeArr);
		
		SubjectVO subjectVO = new SubjectVO();
		subjectVO.setSubjectCodeList(subjectCodeList);
		
		adminService.deleteSubject(subjectVO);
		
		return "redirect:/admin/selectSubject";
	}

	
/////<교실 등록 관련>//////////////////////////////////////////////////////////// 	
	
	
	// 교실 정보 등록
	
	 @PostMapping("/regLessonRoom")
	 public String regLessonRoom(LessonRoomVO lessonRoomVO) { 
		 
		 adminService.regLessonRoom(lessonRoomVO); 
		 
		 System.out.println(lessonRoomVO);
		 
		 return "redirect:/admin/selectLessonRoom";
	 }
	 
	// 내가 등록한 교실 정보를 조회 (과목등록페이지로 이동)
		@GetMapping("/selectLessonRoom")
			public String selectLessonRoom(Model model){
			List<LessonVO> lessonRoomList =  adminService.selectLessonRoom();
			model.addAttribute("selectLessonRoom", lessonRoomList);
			
			return "content/admin/lesson_room";
		}
	
		// 내가 등록한 교실들 체크박스 삭제
		@PostMapping("/deleteLessonRoom")
		public String deleteLessonRoom(String lessonRoomCodes) {
			String[] lessonRoomCodeArr = lessonRoomCodes.split(",");  // 배열을 리스트로 변환작업 2줄
			List<String> lessonRoomCodeList = Arrays.asList(lessonRoomCodeArr);

			
			LessonRoomVO lessonRoomVO = new LessonRoomVO();
			lessonRoomVO.setLessonRoomCodeList(lessonRoomCodeList);
			
			adminService.deleteLessonRoom(lessonRoomVO);
			
			return "redirect:/admin/selectLessonRoom";
		}

	
}
