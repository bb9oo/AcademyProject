function goDelete() {
	const deleteForm = document.querySelector('#deleteStuForm');	// from태그의 id가 deleteStuForm 인 것
	
	
		Swal.fire({
		   title: '정말 삭제하시겠습니까?',
		   icon: 'warning',
		   
		   showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
		   confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
		   cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
		   confirmButtonText: '승인', // confirm 버튼 텍스트 지정
		   cancelButtonText: '취소', // cancel 버튼 텍스트 지정
		   
		   
		}).then(result => {
		   // 만약 Promise리턴을 받으면,
		   if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
		   	
		   	Swal.fire({
				title: '학생 삭제 완료',
				text: '해당 학생 정보가 삭제되었습니다.',
				icon: 'success',

				showCancelButton: false, // cancel버튼 보이기. 기본은 원래 없음
				confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
				cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
				confirmButtonText: '확인', // confirm 버튼 텍스트 지정
				cancelButtonText: '취소', // cancel 버튼 텍스트 지정

				reverseButtons: true, // 버튼 순서 거꾸로
		   	
		   	
		   	}).then(result => {
				// 만약 Promise리턴을 받으면,
				if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면

		   	
				deleteForm.submit();
		 }
		});
		
	}
	});
}
