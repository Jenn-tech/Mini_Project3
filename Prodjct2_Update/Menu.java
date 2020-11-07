package abc;

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

	private void customercarddata() {
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
			System.out.println("��������������������");
			System.out.println("  menu");
			System.out.println("1. ���콺");
			System.out.println("2. Ű����");
			System.out.println("��������������������");
			System.out.print("��ǰ�Է�> ");
			menu = in.nextInt();

			switch (menu) {
			case 1:
				mouse();
				break;
			case 2:
				keyboard();
				break;

			default:
				System.out.println("1,2�� �Է����ּ���");
				break;		
			}



		}
	}


	public void keyboard() {
		exit:
			while(true) {
				System.out.println("\n");
				System.out.println("��������������������������������������");
				keyboardmap.put("����Ű����", 1000);
				keyboardmap.put("���Ű����", 2000);
				keyboardmap.put("�ʷ�Ű����", 3000);

				int index = 1;
				Iterator<String> keys = keyboardmap.keySet().iterator();

				while (keys.hasNext()) {
					String key = keys.next();
					System.out.println(index +"."+ key + ", ���� : " + keyboardmap.get(key));
					index++;
				}
				System.out.println("4.�ڷΰ���");
				System.out.println("��������������������������������������");
				System.out.print("��ǰ���� >");
				int keyboard = in.nextInt();

				switch (keyboard) {
				case 1:
					product("����Ű����");

					break;
				case 2:
					product("���Ű����");

					break;
				case 3:
					product("�ʷ�Ű����");

					break;
				case 4:
					break exit;

				default:
					System.out.println("1~3���� �Է����ּ���");
					break;
				}
			}
	}

	public void product(String Product) {
		System.out.println(Product+ "�� �����ϼ̽��ϴ�");
		System.out.println("\n");
		System.out.println("��������������������������������������");

		System.out.println("1.��ٱ��Ͽ� �ֱ�");
		System.out.println("2.�����ϱ�");
		System.out.println("3.����ϱ�");
		System.out.println("��������������������������������������");
		System.out.print("�Է� > ");

		int menu1 = in.nextInt();
		switch (menu1) {
		case 1:
			System.out.println("��ٱ��Ͽ� �����ϴ�");
			product.setProductname(Product);
			product.setProductprice(keyboardmap.get(Product));
			productlist.add(product);

			gobasket();
			break;
		case 2:
			pay();
			break;
		case 3:
			System.out.println(Product + "�� ����ϼ̽��ϴ�. ����ȭ������ ���ư��ϴ�");
			input();
			break;

		default:
			System.out.println("1~3���� �Է°����մϴ�");
			break;
		}
	}

	public void gobasket() {
		System.out.println("\n");
		System.out.println("��������������������������������������");
		System.out.println("1.��ٱ��ϰ���");
		System.out.println("2.�޴�����");
		System.out.println("��������������������������������������");
		System.out.print("�Է� >");

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
			System.out.println("��������������������������������������");
			System.out.println("     ��ٱ���");
			System.out.println("�����̸�\t|   ����");
			for (int i = 0; i < productlist.size(); i++) {
				System.out.println(productlist.get(i).productname +"\t|   "+ productlist.get(i).productprice);
			}
			System.out.println("��������������������������������������");
			System.out.println("�� ���� :" + sum);
		}if (productlist.isEmpty()) {
			System.out.println("��ٱ��ϰ� �������");
		}


		System.out.println("1.�����ϱ�");
		System.out.println("2.�����ϱ�");
		System.out.print("�Է� >");

		int menu = in.nextInt();

		if (menu ==1) {
			pay();
		}else if (menu ==2) {
			input();
		}
	}

	public void pay() {//�����޼ҵ�
		paymenu();
		confirm();

	}

	private void paymenu() {
		System.out.println("\n");
		System.out.println("��������������������������");
		System.out.println("�����ϱ�");

	}

	public void confirm() { //��Ȯ�θ޼ҵ�
		System.out.print("���̸��Է� > ");
		String customername = in.next();
		for (int i = 0; i < customer.length; i++) {
			if (customername.equals(customer[i].personname)) {
				customer[i].setPersonproduct(productlist.get(i).productname);
				customer[i].setPersonprice(productlist.get(i).productprice);
				System.out.println("�α��εǾ����ϴ�");
				realpay();
				break;
			}else {
				System.out.println("�ٽ��Է����ּ���");
				confirm();
			}
		}

	}

	public void realpay() {

		int sum =0;
		for (int i = 0; i < productlist.size(); i++) {
			sum += productlist.get(i).getProductprice();
			System.out.println(" ");
			System.out.println("��������������������������������������");
			System.out.println(customer[i].personname+"���� ��ǰ");
		}

		System.out.println("�����̸�\t|   ����");
		for (int i = 0; i < productlist.size(); i++) {
			System.out.println(customer[i].getPersonproduct() +"\t|   "+ customer[i].getPersonprice());
		}
		System.out.println("��������������������������������������");
		System.out.println("�� ���� :" + sum);
		card();
	}

	public void card() {
		System.out.println("������â��");
		exit:
		while(true) {
			System.out.print("ī���ȣ �Է� > ");
			int cardnumber = in.nextInt();
			for (int i = 0; i < card.length; i++) {			
				if (cardnumber==card[i].getCardNumber()) {
						System.out.print("��й�ȣ �Է� > ");
						String cardpass = in.next();
						if (cardpass.equals(card[i].getCardPass())) {
							System.out.println("ī���Է¿Ϸ�");
							payend();
							break exit;
						}else  {
							System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���");
							break;
						}
					}
				
				else if (cardnumber!=card[i].getCardNumber()) {
					System.out.println("ī���ȣ�� Ʋ�Ƚ��ϴ�.�ٽ��Է����ּ���");
					break;
				}
			}}
		}
	

	public void payend() {
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		for (int i = 0; i < productlist.size(); i++) {
			productlist.remove(i);
		}
		System.out.println(productlist);
		run();
	}

	public void customerdata() {
		for (int i = 0; i < customer.length; i++) {
			customer[i] = new Customer();
		}
		customer[0].setPersonname("������");		
		customer[1].setPersonname("�谡��");
		customer[2].setPersonname("�質��");
		customer[3].setPersonname("��ٴ�");
		customer[4].setPersonname("����");
	}

	public void mouse() {
		System.out.println("soudout");

	}
}
