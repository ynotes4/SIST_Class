// 학점을 계산하는 메소드 만들기
// replaceAll("[^가-힣]","")  // 한글만 출력
// [^0-9] // 숫자만     [^A-Za-z]????????? // 영어만
import java.util.Scanner;
public class 메소드활용_2 {
	// 반복이 되기 때문에 (반복을 없애기 위해 만든 메소드)
	static int input(String subject)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(subject+" 점수 입력:");
		return scan.nextInt();
	}
	// 학점을 구하는 메소드 (다음에 다시 사용하기 위해서 만드는거!) : 재사용 목적 / 소스가 변하지는 않음. 메모장에 두고 갖고온다고 생각하면 됨
	static char hakjum(int avg)
	{
		char score='A';
		switch(avg)
		{
		case 10:
		case 9:
			score='A';
			break;
		case 8:
			score='B';
			break;
		case 7:
			score='C';
			break;
		case 6:
			score='D';
		default:
			score='F';
		}
		return score;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor,eng,math;
		char score='A';
		// 사용자가 입력
		/* Scanner scan=new Scanner(System.in);
		System.out.print("국어점수 입력:");
		kor=scan.nextInt();
		System.out.print("영어점수 입력:");
		eng=scan.nextInt();
		System.out.print("수학점수 입력:");
		math=scan.nextInt(); */
		kor=input("국어");
		eng=input("영어");
		math=input("수학");
		
		// 학점
		int avg=(kor+eng+math)/30;   // 앞에 단위를 다 떼어내는것! 이러면 switch 쓰기 쉬워짐
		/* switch(avg)
		{
		case 10:
		case 9:
			score='A';
			break;
		case 8:
			score='B';
			break;
		case 7:
			score='C';
			break;
		case 6:
			score='D';
		default:
			score='F';
		} */  // 이용할 source는 똑같지만 method로 만들기 위해서 위로 뺄거야! 학점 확인할 때마다 쓸 수 있으니까
		score=hakjum(avg);   // 메소드 호출 => 메소드 처음부터 실행 => 결과값을 넘겨주고 다음문장으로 이동
		
		System.out.println("국어:"+kor);
		System.out.println("영어:"+eng);
		System.out.println("수학:"+math);
		System.out.println("총점:"+(kor+eng+math));
		System.out.printf("평균:%.2f\n",(kor+eng+math)/3.0);
		System.out.println("학점:"+score);

	}

}
