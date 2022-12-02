//////////////////////////변수///////////////////////////////////////////////
/*회원가입 진행여부*/
const isNew = document.querySelector('#isNew');
//const modal = new bootstrap.Modal('#idDouble_Yes');

if(isNew.value=='new'){
	isNew.value='';
	Swal.fire({
         title:'회원가입 완료',
         text: '로그인 화면으로 이동하시겠습니까?',
         icon: 'success',
         
         showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
         confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
         cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
         confirmButtonText: '확인', // confirm 버튼 텍스트 지정
         cancelButtonText: '취소', // cancel 버튼 텍스트 지정
         
         reverseButtons: false, // 버튼 순서 거꾸로
         
      }).then(result => {
         // 만약 Promise리턴을 받으면,
         if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
            
               location.href=`/teacher/loginPage`;
            
         }
      });
      
	//modal.show();
}










//////////////////////////메인페이지에 차트//////////////////////////////////
const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});


/*const cht1 = document.getElementById('mySecondChart').getContext('2d');
const mySecondChart = {
  labels: ['Day 1', 'Day 2', 'Day 3', 'Day 4', 'Day 5', 'Day 6'],
  datasets: [
    {
      label: 'Dataset',
      data: Utils.numbers({count: 6, min: -100, max: 100}),
      borderColor: Utils.CHART_COLORS.red,
      backgroundColor: Utils.transparentize(Utils.CHART_COLORS.red, 0.5),
      pointStyle: 'circle',
      pointRadius: 10,
      pointHoverRadius: 15
    }
  ]
};*/


function potatoChat()
{
   const option='top=100,right=10,width=600,height=700,resizable=0,';
   const url='/potatoChat/pop';
   window.open(url, 'popup', option);
}





/////////////////////////이벤트///////////////////////////////////////////////////////

//스크롤위로
$(document).ready(function(){

    //Check to see if the window is top if not then display button
    $(window).scroll(function(){
        if ($(this).scrollTop() > 100) {
            $('.scrollToTop').fadeIn();
        } else {
            $('.scrollToTop').fadeOut();
        }
    });

    //Click event to scroll to top
    $('.scrollToTop').click(function(){
        $('html, body').animate({scrollTop : 0 , behavior:"smooth"}, 50);
        return false;
    });

});


