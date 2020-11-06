

import java.util.*;

public class Menu {
	Scanner in = new Scanner(System.in);
	int menu;
	HashMap<String, Integer> keyboardmap = new HashMap<>();
	ArrayList<Product> productlist = new ArrayList<>(); 
	Product product = new Product();

	public Menu() {
		input();
	}

	public void input() {
		while(true) {
			System.out.println("\n");
			System.out.println("――――――――――");
			System.out.println("  menu");
			System.out.println("1. 마우스");
			System.out.println("2. 키보드");
			System.out.println("――――――――――");
			System.out.print("상품입력>");
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
		System.out.print("입력 >");

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

	public void pay() {
		

	}

	public void mouse() {
		System.out.println("soudout");

	}
}
