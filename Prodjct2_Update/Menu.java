package Prodjct2_Update;

import java.util.*;

public class Menu {
	Scanner in = new Scanner(System.in);
	int menu;
	HashMap<String, Integer> keyboardmap = new HashMap<>();
	ArrayList<Product> productlist = new ArrayList<>(); 
	Product product = new Product();
	Customer[] customer= new Customer[5];
	Card[] card = new Card[4];

	public Menu() {
		run();

	}

	private void run() {
		customerdata();
		customercarddata();
		input();

	}

	private void customerdata() {
		for (int i = 0; i < customer.length; i++) {
			customer[i] = new Customer();
		}
		customer[0].setPersonname("김재현");		
		customer[1].setPersonname("김가가");
		customer[2].setPersonname("김나나");
		customer[3].setPersonname("김다다");
		customer[4].setPersonname("김라라");
	}



	private void customercarddata() {//카드번호데이터
		for (int i = 0; i < card.length; i++) {
			card[i] = new Card();
		}
		card[0].setCardNumber(1111);
		card[0].setCardPass("aaaa");
		card[1].setCardNumber(2222);
		card[1].setCardPass("bbbb");
		card[2].setCardNumber(3333);
		card[2].setCardPass("cccc");
		card[3].setCardNumber(4444);
		card[3].setCardPass("dddd");
	}

	public void input() {
		while(true) {
			System.out.println("\n");
			System.out.println("――――――――――");
			System.out.println("  menu");
			System.out.println("1. 마우스");
			System.out.println("2. 키보드");
			System.out.println("――――――――――");
			System.out.print("상품입력> ");
			menu = in.nextInt();

			switch (menu) {
			case 1:
				mouse();
				break;
			case 2:
				keyboard();
				break;

			default:
				System.out.println("1,2로 입력해주세요");
				break;		
			}



		}
	}


	public void keyboard() {
		exit:
			while(true) {
				System.out.println("\n");
				System.out.println("―――――――――――――――――――");
				keyboardmap.put("빨간키보드", 1000);
				keyboardmap.put("노란키보드", 2000);
				keyboardmap.put("초록키보드", 3000);

				int index = 1;
				Iterator<String> keys = keyboardmap.keySet().iterator();

				while (keys.hasNext()) {
					String key = keys.next();
					System.out.println(index +"."+ key + ", 가격 : " + keyboardmap.get(key));
					index++;
				}
				System.out.println("4.뒤로가기");
				System.out.println("―――――――――――――――――――");
				System.out.print("상품선택 >");
				int keyboard = in.nextInt();

				switch (keyboard) {
				case 1:
					product("빨간키보드");

					break;
				case 2:
					product("노란키보드");

					break;
				case 3:
					product("초록키보드");

					break;
				case 4:
					break exit;

				default:
					System.out.println("1~3까지 입력해주세요");
					break;
				}
			}
	}

	public void product(String Product) {
		System.out.println(Product+ "를 선택하셨습니다");
		System.out.println("\n");
		System.out.println("―――――――――――――――――――");

		System.out.println("1.장바구니에 넣기");
		System.out.println("2.결제하기");
		System.out.println("3.취소하기");
		System.out.println("―――――――――――――――――――");
		System.out.print("입력 > ");

		int menu1 = in.nextInt();
		switch (menu1) {
		case 1:
			System.out.println("장바구니에 담겼습니다");
			product.setProductname(Product);
			product.setProductprice(keyboardmap.get(Product));
			productlist.add(product);

			gobasket();
			break;
		case 2:
			product.setProductname(Product);
			product.setProductprice(keyboardmap.get(Product));
			productlist.add(product);
			pay();
			break;
		case 3:
			System.out.println(Product + "를 취소하셨습니다. 메인화면으로 돌아갑니다");
			input();
			break;

		default:
			System.out.println("1~3까지 입력가능합니다");
			break;
		}
	}

	public void gobasket() {
		System.out.println("\n");
		System.out.println("―――――――――――――――――――");
		System.out.println("1.장바구니가기");
		System.out.println("2.메뉴가기");
		System.out.println("―――――――――――――――――――");
		System.out.print("입력 >");

		int menu2 = in.nextInt();
		if (menu2 ==1) {
			basket();
		}else if (menu ==2) {
			input();
		}		
	}

	public void basket() {
		int sum =0;
		for (int i = 0; i < productlist.size(); i++) {
			sum += productlist.get(i).getProductprice();
		}
		if (!productlist.isEmpty()) {
			System.out.println(" ");
			System.out.println("―――――――――――――――――――");
			System.out.println("     장바구니");
			System.out.println("물건이름\t|   가격");
			for (int i = 0; i < productlist.size(); i++) {
				System.out.println(productlist.get(i).productname +"\t|   "+ productlist.get(i).productprice);
			}
			System.out.println("―――――――――――――――――――");
			System.out.println("총 가격 :" + sum);
		}if (productlist.isEmpty()) {
			System.out.println("장바구니가 비어있음");
		}


		System.out.println("1.결제하기");
		System.out.println("2.쇼핑하기");
		System.out.print("입력 >");

		int menu = in.nextInt();

		if (menu ==1) {
			pay();
		}else if (menu ==2) {
			input();
		}
	}

	public void pay() {//결제메소드
		paymenu();
		confirm();

	}

	private void paymenu() {
		System.out.println("\n");
		System.out.println("―――――――――――――");
		System.out.println("결제하기");

	}

	public void confirm() { //고객확인메소드
		int check = 0;
		while(true) {
			System.out.print("고객이름입력 > ");

			String customername = in.next();
			for (int i = 0; i < customer.length; i++) {
				if (customername.equals(customer[i].personname)) {
					System.out.println(productlist.get(0).productname);
					customer[i].setPersonproduct(productlist.get(0).productname); //오류

					customer[i].setPersonprice(productlist.get(0).productprice);
					System.out.println("로그인되었습니다");
					check = 1;
					realpay(customername);
					continue;
				}
			}if(check ==1){
				check = 0;
				break;
			}else if(check == 0) {
				System.out.println("회원이아닙니다 다시입력해주세요");
			}
		}
	}



	public void realpay(String customername) {

		int sum =0;
		for (int i = 0; i < productlist.size(); i++) {
			sum += productlist.get(i).getProductprice();
			System.out.println(" ");
			System.out.println("―――――――――――――――――――");
			System.out.println(customername+"님의 상품");
		}

		System.out.println("물건이름\t|   가격");
		System.out.println(productlist.get(0).productname +"\t|   "+ productlist.get(0).productprice);
		System.out.println("―――――――――――――――――――");
		System.out.println("총 가격 :" + sum);
		card();
	}

	public void card() {
		int cardnumber;

		System.out.println("\n▶결제창◀");

		int check = 0;
		while(check ==0) {

			try {
				System.out.print("카드번호 입력 > ");
				cardnumber = in.nextInt();

				
//				System.out.println(card.length);
				for (int i = 0; i < card.length; i++) {		
					if (cardnumber==card[i].getCardNumber()) {	

						System.out.print("비밀번호 입력 > ");
						String cardpass = in.next();

						if (cardpass.equals(card[i].getCardPass())) {
							System.out.println("카드입력완료");
							check = 1;
							payend();
						}else if (!cardpass.equals(card[i].getCardPass()))  {
							check = 0;
						}

					}

				}
				if(check ==1){
					check = 0;
					break;
				}else if(check == 0) {
					System.out.println("카드번호가 틀렸습니다 다시입력해주세요");
				}else if (check == 0) {
					System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요");
				}
			}
			catch (InputMismatchException e) {
				in = new Scanner(System.in);
				System.out.println("카드번호는 숫자로만 입력해주세요");
			}
		}

		//while(true)

	}


	public void payend() {
		System.out.println("결제가 완료되었습니다.");
		for (int i = 0; i < productlist.size(); i++) {
			productlist.remove(i);
		}
		//		System.out.println(productlist);
		run();
	}


	public void mouse() {
		System.out.println("soudout");

	}
}
